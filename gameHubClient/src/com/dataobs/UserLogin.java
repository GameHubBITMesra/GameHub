/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dataobs;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Sanatt
 */
public class UserLogin {
    String nick;
    String password;
    Date date;
    Time time;
    
    public UserLogin(String nick, String password, Date date, Time time) {
        this.nick = nick;
        this.password = password;
        this.date = date;
        this.nick = nick;
    }
}
