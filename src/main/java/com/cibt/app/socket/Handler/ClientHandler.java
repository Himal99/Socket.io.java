/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.app.socket.Handler;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class ClientHandler {
    List<Client> clientlist=new ArrayList<>();
    
    public void addclient(Client client){
        clientlist.add(client);
    }
    
    public boolean removeclient(Client client){
        return clientlist.remove(client);
    }
    
    public List<Client> getClient(){
        return clientlist;
    }
    
    public int size(){
        return clientlist.size();
    }
    
    public Client getByClientUsername(String username){
        for(Client c:clientlist){
            if(c.getUser().getUsername().equals(username)){
                return c;
            }
        }
        return null;
    }
    
    
}
