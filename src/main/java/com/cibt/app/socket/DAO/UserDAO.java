/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.app.socket.DAO;

import com.cibt.app.socket.Entity.User;
import java.util.List;

/**
 *
 * @author user
 */
public interface UserDAO {
    List<User> getall();
    void insert(User user);
    User login(String username, String password);
    User getById(int id);
    User getByUsername(String username);
    boolean changepassword(String username, String password);
    
    
}
