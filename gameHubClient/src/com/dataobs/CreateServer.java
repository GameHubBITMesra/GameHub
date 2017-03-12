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
public class CreateServer{
    Integer circleId;
    Integer userId;
    Integer gameId;
    Integer port;
    String message;
    public CreateServer(Integer circleId, Integer userId, Integer gameId, Integer port, String message){
        this.circleId = circleId;
        this.userId = userId;
        this.gameId = gameId;
        this.port = port;
        this.message = message;
    }
}
