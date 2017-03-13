/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dataobs;

import com.Session;
import java.io.Serializable;

/**
 *
 * @author paritosh
 */
public class UserAuthentication implements Serializable{
    protected static final long serialVersionUID = 7L;

    boolean success;
    Session session;
    String userName;
    public UserAuthentication(boolean success, Session session, String userName){
        this.success = success;
        this.session = session;
        this.userName = userName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public boolean isSuccess() {
        return success;
    }

    public Session getSession() {
        return session;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

   
}