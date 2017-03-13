/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import com.dataobs.CircleMessage;
import com.dataobs.Circles;
import com.dataobs.CreateServer;
import com.dataobs.Games;
import com.dataobs.UserAuthentication;
import com.gui.login.LogInForm;
import com.gui.login.MainForm;
import java.awt.Window;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.JOptionPane;

/**
 *
 * @author Sanatt
 */
public class Client {
    private ObjectInputStream cInput;		
    private ObjectOutputStream cOutput;		
    private Socket socket;
    

    private LogInForm logInForm;
    private MainForm mainForm;

    public Session getSession() {
        return session;
    }
    
    private Session session;
    private int port;
    private String serverIp;
    boolean authenticated;

    public boolean isAuthenticated() {
        return authenticated;
    }
    
    public Client() {
    
    }
    
    public Client(Session session) {
        this.session = session;
        this.port = this.session.port;
        this.serverIp = this.session.serverIp;
        this.authenticated = false;
    }
    
    public boolean startConnection() {
        try {
            socket = new Socket(serverIp, port);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Error connceting to server");
            return false;
        }
        
        String msg = "Conncetion accepted " + socket.getInetAddress() + " : " + socket.getPort();
        System.out.println(""+msg);
        
        /* Creating both Data Stream */
        try {
            cInput  = new ObjectInputStream(socket.getInputStream());
            cOutput = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException eIO) {
            System.out.println("Exception creating new Input/output Streams: " + eIO);
            return false;
	}
        
        new ListenFromServer().start();
        
        return true;
    }
    
    public void disconnect() {
        try { 
            if(cInput != null) cInput.close();
        } catch(Exception e) {} // not much else I can do
        try {
            if(cOutput != null) cOutput.close();
        } catch(Exception e) {} // not much else I can do
        try {
            if(socket != null) socket.close();
        } catch(Exception e) {}	
    }
    
    public void sendObject(Object obj) {
        try {
            System.out.println("Sending object" + obj.toString());
            cOutput.writeObject(obj);
        } catch(Exception e){
            System.out.println("Error sending object " + e);
        }
    }
    
    public void checkLogIn(Object obj){
        UserAuthentication uAuth = (UserAuthentication) obj;
        if(uAuth.isSuccess()){
            this.authenticated = true;
            for(Window w: Window.getWindows())
                if(w.isShowing())
                    w.setVisible(false);
               
            JOptionPane.showMessageDialog(null,"Successfully logged in");
            //update session
            this.session = uAuth.getSession();
            mainForm = new MainForm(this, uAuth.getUserName());
            mainForm.setLocationRelativeTo(null);
            mainForm.setVisible(true);
        }
        else{
            System.out.println("here");
            JOptionPane.showMessageDialog(null,"Wrong password");
        }        
    }
    
    public void checkNewUserCreation(Object obj){
        Boolean res = (Boolean) obj;
        if(res)
            JOptionPane.showMessageDialog(null,"User successfully created");
        else
            JOptionPane.showMessageDialog(null, "Error creating new user");
    }
    
    public void newIncomingMessage(Object obj){
        CircleMessage cm = (CircleMessage) obj;
        ArrayList<Circles> circles = this.getSession().getCircleIds();
        
        for(Circles c : circles){
            System.out.println("hello2");
            if(Objects.equals(c.cid, cm.getCircleId())){
                mainForm.appendChatMessage(cm);
                System.out.println("Recieved message "+cm.getMessage());
                break;
            }
        }
    }
    public String getGameName(int gid){
        ArrayList<Games> games = this.session.getGameIds();
        for(Games G : games){
            if(G.getGid() == gid){
                return G.getGname();
            }
        }
        return null;
    }
    
    public void newIncomingServer(Object obj){
        System.out.println("hollaa");
        CreateServer cs = (CreateServer) obj;
        ArrayList<Circles> circles = this.getSession().getCircleIds();
        
        for(Circles c : circles){
            if(Objects.equals(c.cid, cs.getCircleId())){
                mainForm.newNotification(getGameName(cs.getGameId()),  cs.getMessage());
            }
        }
        
    }
    class ListenFromServer extends Thread {
        public void run() {
            while(true) {
                try {
                    Object obj = cInput.readObject();
                    String objType = obj.getClass().getSimpleName();
                    System.out.println(""+objType);
                    switch(objType){
                        case "UserAuthentication" : checkLogIn(obj);
                            break;    
                        case "Boolean" : checkNewUserCreation(obj);
                            break;
                        case "CircleMessage" : newIncomingMessage(obj);
                            break;
                        case "CreateServer" : newIncomingServer(obj);
                            break;
                    }
                } catch(Exception e){
                    e.printStackTrace();
                }
                
            }
        }
    }
}    

