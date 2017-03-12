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
public class CircleMessage {
    Integer userId;
    Integer circleId;
    TimeStamp timestamp = new TimeStamp();
    String message;
    
    public CircleMessage(Integer userId, Integer circleId, TimeStamp timestamp, String message, boolean pub){
        this.userId = userId;
        this.circleId = circleId;
        this.timestamp = timestamp;
        this.message = message;
    }
    
}
