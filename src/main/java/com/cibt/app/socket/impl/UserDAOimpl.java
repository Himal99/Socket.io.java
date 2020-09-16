/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.app.socket.impl;

import com.cibt.app.socket.DAO.UserDAO;
import com.cibt.app.socket.Entity.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class UserDAOimpl implements UserDAO{

    List<User> userlist=new ArrayList<>();
    
    @Override
    public List<User> getall() {
        return  userlist;
        }

    @Override
    public void insert(User user) {
        userlist.add(user);
        }

    @Override
    public User login(String username, String password) {
    for(User u:userlist){
        if(u.getUsername().equals(username) && u.getPassword().equals(password)){
            return  u;
        }
       
    }    
     return null;
    }

    @Override
    public User getById(int id) {
    for(User u:userlist){
        if(u.getId()==id){
            return u;
        }
    }   
    return  null;
    }

    @Override
    public boolean changepassword(String username, String password) {
    
        User u=getByUsername(username);
        if(u!=null){
            u.setPassword(password);
            return true;
        }
        return false;
    }

    @Override
    public User getByUsername(String username) {
    
        for(User u:userlist){
            if(u.getUsername().equals(username)){
                return u;
            }
        }
        return null;
    }
   
    
}
