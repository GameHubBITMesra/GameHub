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
public class CreateServer implements Serializable{
    protected static final long serialVersionUID = 3L;

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

    public Integer getCircleId() {
        return circleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getGameId() {
        return gameId;
    }

    public Integer getPort() {
        return port;
    }

    public String getMessage() {
        return message;
    }

    public void setCircleId(Integer circleId) {
        this.circleId = circleId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
}
