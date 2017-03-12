/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dataobs;

/**
 *
 * @author Sanatt
 */
public class NewUser {
    String name;
    String nick;
    String password;
    TimeStamp timestamp = new TimeStamp();
    
    public NewUser(String name, String nick, String password, TimeStamp timestamp) {
        this.name = name;
        this.nick = nick;
        this.password = password;
        this.timestamp = timestamp;
    }
}
