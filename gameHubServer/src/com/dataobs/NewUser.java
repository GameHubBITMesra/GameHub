/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dataobs;

import java.io.Serializable;

/**
 *
 * @author Sanatt
 */
public class NewUser implements Serializable{
    protected static final long serialVersionUID = 4L;

    String name;
    String nick;
    String password;
    TimeStamp timestamp;
    
    public NewUser(String name, String nick, String password, TimeStamp timestamp) {
        this.name = name;
        this.nick = nick;
        this.password = password;
        this.timestamp = timestamp;
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

    public TimeStamp getTimestamp() {
        return timestamp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTimestamp(TimeStamp timestamp) {
        this.timestamp = timestamp;
    }
    
    
}
