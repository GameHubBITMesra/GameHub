/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.util.ArrayList;

/**
 *
 * @author Sanatt
 */
public class Session {
    int userId;
    ArrayList<Integer> circleIds;
    ArrayList<Integer> gameIds;
    ArrayList<Integer> adminPriveleges;
    String userNick;
    String serverIp;
    int port;
    
    public Session(int userId, int[] circleIds, int[] gameIds, int[] adminPriveleges, String userNick, String serverIp, int port) {
        this.userId = userId;
        this.circleIds = new ArrayList();
        this.adminPriveleges = new ArrayList();
        this.gameIds = new ArrayList();
        this.userNick = userNick;
        for(int i=0; i<circleIds.length; i++)
            this.circleIds.add(new Integer(circleIds[i]));
        for(int i=0; i<gameIds.length; i++)
            this.gameIds.add(new Integer(gameIds[i]));
        for(int i=0; i<adminPriveleges.length; i++)
            this.adminPriveleges.add(new Integer(adminPriveleges[i]));
        this.serverIp = serverIp;
        this.port = port;
    }
    
}
