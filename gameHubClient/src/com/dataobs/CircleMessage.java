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
public class CircleMessage implements Serializable{
    protected static final long serialVersionUID = 1L;

    Integer userId;
    Integer circleId;
    String message;
    
    public CircleMessage(Integer userId, Integer circleId, String message, boolean pub){
        this.userId = userId;
        this.circleId = circleId;
        this.message = message;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getCircleId() {
        return circleId;
    }

 
    public String getMessage() {
        return message;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setCircleId(Integer circleId) {
        this.circleId = circleId;
    }

    
    public void setMessage(String message) {
        this.message = message;
    }
    
    
    
}
