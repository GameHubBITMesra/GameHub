/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dataobs;

import java.io.Serializable;

/**
 *
 * @author paritosh
 */
public class Users implements Serializable{
    Integer uid;
    String  name;
    String nick;
    String password;
    
    public Users(Integer uid, String name, String nick, String password){
        this.uid = uid;
        this.name = name;
        this.nick = nick;
        this.password = password;
    }

    public Users() {
        
    }

    public Integer getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public String getNick() {
        return nick;
    }

    public String getPassword() {
        return password;
    }

    
    
            
}
