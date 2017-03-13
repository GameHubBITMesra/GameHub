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
public class Circles implements Serializable{
    protected static final long serialVersionUID = 122200L;
    public Integer cid;
    public Integer gid;
    public String name;
    public Circles(Integer cid, Integer gid, String name){
        this.cid = cid;
        this.gid = gid;
        this.name = name;
    }
}
