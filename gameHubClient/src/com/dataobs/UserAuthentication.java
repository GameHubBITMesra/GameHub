/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dataobs;

/**
 *
 * @author paritosh
 */
public class UserAuthentication {
    boolean success;
    Integer userId;
    String userName;
    String userNick;
    Integer[] circleIds;
    Integer[] gameIds;
    Integer[] adminPriveledges;
    public UserAuthentication(boolean success, Integer userId, String userName,String userNick,Integer[] circleIds,Integer[] gameIds){
        this.success = success;
        this.userId = userId;
        this.userName = userName;
        this.userNick  = userNick;
        this.circleIds = circleIds;
        this.gameIds = gameIds;
   }
}