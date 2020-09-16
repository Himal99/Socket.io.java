package com.cibt.app.socket.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ClientListner implements Runnable{

    private Socket socket;
    private PrintStream writer;
    private BufferedReader reader;
    
    public ClientListner(Socket socket)throws IOException{
        this.socket=socket;
        writer=new PrintStream(this.socket.getOutputStream());
        reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run() {
      try {
        writer.println("hello from server");
        writer.println("plsease enter your username");
        String username=reader.readLine();
        writer.println("plsease enter your password");
        String password=reader.readLine();

        System.out.println("ok"+username);

        writer.println("welcome :"+username);
        

      } catch (Exception e) {
          e.printStackTrace();
      }


    }
    
}