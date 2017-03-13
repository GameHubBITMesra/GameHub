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
public class NotificationMessage implements Serializable{
    protected static final long serialVersionUID = 5L;

    String gameName;
    String ip;
    Integer circleId;
    
    public NotificationMessage(Integer circleId, String gameName, String ip){
        this.gameName = gameName;
        this.ip = ip;
        this.circleId = circleId;
    }

    public String getGameName() {
        return gameName;
    }

    public String getIp() {
        return ip;
    }

    public Integer getCircleId() {
        return circleId;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setCircleId(Integer circleId) {
        this.circleId = circleId;
    }
    
    
}
