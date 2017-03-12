/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import com.gui.login.LogInForm;
import com.gui.login.MainForm;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
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
    
    private Session session;
    private int port;
    private String serverIp;
    
    public Client() {
    
    }
    
    public Client(Session session) {
        this.session = session;
        this.port = this.session.port;
        this.serverIp = this.session.serverIp;
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
        try {
            cOutput.writeObject(session.userId);
	} catch (IOException eIO) {
            disconnect();
            return false;
	}
        return true;
    }
    
    private void disconnect() {
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
            cOutput.writeObject(obj);
        } catch(Exception e){
            System.out.println("Error sending object " + e);
        }
    }
    
    class ListenFromServer extends Thread {
        public void run() {
            while(true) {
                try {
                    Object obj = cInput.readObject();
                    String objType = obj.getClass().getName();
                    System.out.println(""+objType);
                    switch(objType){
                        case "com.dataobs.UserAuthentication" : System.out.println("UserAuthenticationClass");
                            break;
                            
                    }
                } catch(Exception e){
                
                }
                
            }
        }
    }
}    

