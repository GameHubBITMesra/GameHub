/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import com.dataobs.Cir_admin;
import com.dataobs.Circles;
import com.dataobs.Games;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Sanatt
 */
public class Session implements Serializable{
    protected static final long serialVersionUID = 1112122200L;

    
    int userId;
    ArrayList<Circles> circleIds;
    ArrayList<Games> gameIds;
    ArrayList<Circles> adminPriveleges;
    String userNick;
    String serverIp;
    int port;
    
    public Session(int userId, ArrayList<Circles> circleIds, ArrayList<Games> gameIds, ArrayList<Circles> adminPriveleges, String userNick, String serverIp, int port) {
        this.userId = userId;
        this.circleIds = circleIds;
        this.adminPriveleges = adminPriveleges;
        this.gameIds = gameIds;
        this.userNick = userNick;
        this.serverIp = serverIp;
        this.port = port;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getUserId() {
        return userId;
    }

    public ArrayList<Circles> getCircleIds() {
        return circleIds;
    }

    public ArrayList<Games> getGameIds() {
        return gameIds;
    }

    public ArrayList<Circles> getAdminPriveleges() {
        return adminPriveleges;
    }

    public String getUserNick() {
        return userNick;
    }

    public String getServerIp() {
        return serverIp;
    }

    public int getPort() {
        return port;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setCircleIds(ArrayList<Circles> circleIds) {
        this.circleIds = circleIds;
    }

    public void setGameIds(ArrayList<Games> gameIds) {
        this.gameIds = gameIds;
    }

    public void setAdminPriveleges(ArrayList<Circles> adminPriveleges) {
        this.adminPriveleges = adminPriveleges;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public void setPort(int port) {
        this.port = port;
    }
    
    
}
