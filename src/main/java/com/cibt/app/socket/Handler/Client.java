/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.app.socket.Handler;

import com.cibt.app.socket.Entity.User;
import java.net.Socket;

/**
 *
 * @author user
 */
public class Client {
    private User user;
    private Socket socket;

    public Client() {
    }

    public Client(User user, Socket socket) {
        this.user = user;
        this.socket = socket;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

   
    
    
    
}
