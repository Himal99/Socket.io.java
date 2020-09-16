/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.app.socket.loader;

import com.cibt.app.socket.DAO.UserDAO;
import com.cibt.app.socket.Entity.User;

/**
 *
 * @author user
 */
public class UserDataLoader {
    
    public static void loadData(UserDAO userDAO){
        userDAO.insert(new User(1, "himal", "admin123", "himal@gmail.com", true));
         userDAO.insert(new User(1, "sagar", "admin123", "sagar@gmail.com", true));
    }
}
