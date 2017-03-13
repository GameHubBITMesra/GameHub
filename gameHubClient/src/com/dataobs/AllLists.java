/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dataobs;

import java.util.ArrayList;

/**
 *
 * @author Sanatt
 */
public class AllLists {
    ArrayList<Circles> circles;
    ArrayList<Games> games;
    protected static final long serialVersionUID = 15L;

    public AllLists(ArrayList<Circles> circles, ArrayList<Games> games) {
        this.circles = circles;
        this.games = games;
    }

    public ArrayList<Circles> getCircles() {
        return circles;
    }

    public ArrayList<Games> getGames() {
        return games;
    }

    public void setCircles(ArrayList<Circles> circles) {
        this.circles = circles;
    }

    public void setGames(ArrayList<Games> games) {
        this.games = games;
    }
    
    
}
