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
public class Games implements Serializable{
    private static final long serialVersionUID = 21L;
    Integer gid;
    String gname;
    public Games(Integer gid, String gname){
        this.gid = gid;
        this.gname = gname;
    }

 

    public Integer getGid() {
        return gid;
    }

    public String getGname() {
        return gname;
    }
    
}
