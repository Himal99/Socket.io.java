package com.cibt.app.socket.controller;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;



public class maincontroller {
  public static void main(String[] args) {
        
    try {
       
        int port=9000;
        ServerSocket server=new ServerSocket(port);

        while(true){
            Socket socket=server.accept();
            System.out.println("from :"+socket.getInetAddress().getHostAddress());
            Thread thread=new Thread(new ClientListner(socket));
           
            thread.start();

        }
        

    } catch (Exception e) {
       e.printStackTrace();
    }
  }
}