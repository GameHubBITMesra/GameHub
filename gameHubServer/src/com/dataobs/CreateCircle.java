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
public class CreateCircle implements Serializable{
    protected static final long serialVersionUID = 2L;

    String name;
    Integer userId;
    Integer gameId;
    
    public CreateCircle(String name, Integer userId, Integer gameId){
        this.name = name;
        this.userId = userId;
        this.gameId = gameId;
    }

    public String getName() {
        return name;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    
}
