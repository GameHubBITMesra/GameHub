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
public class NotificationMessage {
    
    String gameName;
    String ip;
    Integer circleId;
    
    public NotificationMessage(Integer circleId, String gameName, String ip){
        this.gameName = gameName;
        this.ip = ip;
        this.circleId = circleId;
    }
}
