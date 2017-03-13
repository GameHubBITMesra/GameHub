/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.database;

import com.dataobs.Circles;
import com.dataobs.Games;
import com.dataobs.NewUser;
import com.dataobs.Users;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Sanatt
 */
public class DBFactory {
    Connection con;
    Statement stm;
    static String URL = "jdbc:mysql://localhost/gamehub";
    static String USERNAME = "root";
    static String PASSWORD = "sanatt";
    
    public DBFactory(){
        try {
            Class.forName("java.sql.Driver");
            con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            this.stm = con.createStatement();
        } catch (Exception e) {
            System.out.println("Error connecting database");
        }
    }
    
    public Users getUserFromNick(String nick){
        try {
            Class.forName("java.sql.Driver");
            con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            stm = con.createStatement();
            String query = "SELECT * from users;";
            ResultSet rs = stm.executeQuery(query);
            Users user;
            while(rs.next()){
                if(rs.getString(3).equalsIgnoreCase(nick)){
                    
                    user = new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                    rs.close();
                    stm.close();
                    con.close();
                    return user;
                }
            }
            rs.close();
            stm.close();
            con.close();
                    
            rs.close();
            return null;
        } catch (Exception e) {
        }
        return null;
    }
    
    public ArrayList<Circles> getCircleList(Integer uid){
        try {
            Class.forName("java.sql.Driver");
            con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            stm = con.createStatement();
            
            String query = "SELECT circles.cid, circles.gid, circles.name from circles, cir_mem where cir_mem.cid = circles.cid and cir_mem.uid =" + uid + ";";
            ResultSet rs = stm.executeQuery(query);
            ArrayList<Circles> circleList = new ArrayList();
            while(rs.next()){
                circleList.add(new Circles(rs.getInt(1), rs.getInt(2), rs.getString(3)));
            }
            rs.close();
            stm.close();
            con.close();
            
            return circleList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<Games> getGameIdList(Integer uid){
        try {
            Class.forName("java.sql.Driver");
            con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            stm = con.createStatement();
            
            String query = "SELECT games.gid, games.gname from usr_prefs, games where games.gid = usr_prefs.gid and usr_prefs.uid =" + uid + ";";
            ResultSet rs = stm.executeQuery(query);
            ArrayList<Games> gameIds = new ArrayList();
            while(rs.next()){
                System.out.println(""+rs.getString(2));
                gameIds.add(new Games(rs.getInt(1), rs.getString(2)));
            }
            rs.close();
            stm.close();
            con.close();
            
            return gameIds;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<Circles> getAdminList(Integer uid){
        try {
            Class.forName("java.sql.Driver");
            con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            stm = con.createStatement();
            
            String query = "SELECT circles.cid, circles.gid, circles.name from cir_admin,circles where circles.cid = cir_admin.cid and cir_admin.uid =" + uid + ";";
            ResultSet rs = stm.executeQuery(query);
            ArrayList<Circles> adminIds = new ArrayList();
            while(rs.next()){
                adminIds.add(new Circles(rs.getInt(1), rs.getInt(2), rs.getString(3)));
            }
            rs.close();
            stm.close();
            con.close();
            
            return adminIds;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean createNewUser(NewUser user){
        try {
            Class.forName("java.sql.Driver");
            con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            stm = con.createStatement();
            
            String query = "INSERT into users(name, nick, password) values ('"+user.getName()+"','"+user.getNick()+"','"+user.getPassword()+"');";
            System.out.println(""+query);
            boolean res = stm.execute(query);
            stm.close();
            con.close();
            return res;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
