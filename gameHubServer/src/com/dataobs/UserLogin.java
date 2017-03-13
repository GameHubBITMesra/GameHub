/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dataobs;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Sanatt
 */
public class UserLogin implements Serializable{
    protected static final long serialVersionUID = 8L;

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
    
    public String getNick(){
        return this.nick;
    }

    public String getPassword() {
        return password;
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTime(Time time) {
        this.time = time;
    }
    
}
