/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.app.socket.Handler;

import com.cibt.app.socket.DAO.UserDAO;
import com.cibt.app.socket.Entity.User;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author user
 */
public class ClientListner extends Thread {
    
    private UserDAO userDAO;
    private Client client;
    private ClientHandler handler;
    private Socket socket;
    PrintStream out;
    BufferedReader reader;
    
    public ClientListner(Socket socket) throws IOException {
        this.socket = socket;
        System.out.println("connected from" + socket.getInetAddress().getHostAddress());
        out = new PrintStream(socket.getOutputStream());
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }
    
    public void init(UserDAO userDAO, ClientHandler handler) {
        this.handler = handler;
        this.userDAO = userDAO;
    }
    
    @Override
    public void run() {
        try {
            
            login();
            while (true) {                
                out.println("[me] :");
                String line = reader.readLine();
                
                String tokens[] = line.split(" ");
                switch (tokens[0].toLowerCase()) {
                    case "list":
                        out.println("list of active user ("+handler.size()+")\n");
                        StringBuilder activeuser=new StringBuilder();
                        for(Client c:handler.getClient()){
                            if(c.equals(client)){
                                activeuser.append(c.getUser().
                                        getUsername()).append("(me)").append("\r\n");
                                
                                
                            }else{
                                activeuser.append(c.getUser().
                                        getUsername()).append("\r\n");
                            }
                        }
                        
                        out.println(activeuser.toString());
                        
                        break;
                    case "exit": {
                        handler.removeclient(client);
                          messagebroadcaster(client.getUser().getUsername() + " has left the chart room");
                        socket.close();
                        
                    }
                    
                }
                messagebroadcaster(client.getUser().getUsername() + " Says:>" + line);
                
                
            }
            
        } catch (IOException e) {
            e.getMessage();
        }
    }
    
    public void login() throws IOException {
        while (true) {            
            out.println("enter your username");
            String username = reader.readLine();
            out.println("enter your password");
            String password = reader.readLine();
            System.out.println("Username" + username + " password" + password);
            
            User user = userDAO.login(username, password);
            if (user != null) {
                
                client = new Client(user, socket);
                
                handler.addclient(client);
                messagebroadcaster(client.getUser().getUsername() + " Has entered to chart group..");
                
                break;
            } else {
                out.println("user and password are wrong..");
            }
            
        }
    }
    
    public void messagebroadcaster(String message) throws IOException {
       
        for (Client c : handler.getClient()) {
            if(!c.equals(client)){
                 PrintStream ps = new PrintStream(
                    c.getSocket().
                            getOutputStream());
            ps.println(message);
            }
           
            
        }
        
    }
    
    public void setUser(UserDAO userDAO) {
        this.userDAO = userDAO;
        
    }

    public void sethandler(ClientHandler handler) {
        this.handler = handler;
    }
    
}
