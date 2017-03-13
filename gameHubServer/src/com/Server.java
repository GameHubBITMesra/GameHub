/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import com.database.DBFactory;
import com.dataobs.Circles;
import com.dataobs.Games;
import com.dataobs.NewUser;
import com.dataobs.UserAuthentication;
import com.dataobs.UserLogin;
import com.dataobs.Users;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Sanatt
 */
public class Server {
    private static int uniqueId = 0;
    private ArrayList<ClientThread> clients;
    private SimpleDateFormat sdf;
    private int port;
    private boolean keepGoing;
    private DBFactory factory;
    String ip;
    
    public Server(int port) {
        this.port = port;
        sdf = new SimpleDateFormat("HH:mm:ss");
        clients = new ArrayList();
        factory = new DBFactory();
    }
    
    public void start() {
        keepGoing = true;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            // keep waiting for clients to connect
            while(keepGoing) {
                System.out.println("Waiting for clients on port " + port);
                
                Socket socket = serverSocket.accept();
                
                if(!keepGoing)
                    break;
                ClientThread t = new ClientThread(socket);
                clients.add(t);
                t.start();
            }
            // I was asked to stop
            try {
                serverSocket.close();
                for(ClientThread t : clients){
                    try {
                        t.cInput.close();
                        t.cOutput.close();
                        t.socket.close();
                    } catch (Exception e) {
                    
                    }
                }
            } catch (Exception e) {
                System.out.println("Exception on closing the server or client thread");
            }
        } catch (Exception e) {
            String msg = sdf.format(new Date()) + "Exception on new ServerSocket: " + e + "\n";
                System.out.println(""+msg);
        }
    }
    
    protected void stop() {
        keepGoing = false;
        try {
            new Socket("localhost", port);
        } catch (Exception e) {
        }
    }
    
    public static void main(String[] args) {
        int defaultPort = 1500;
        Server server = new Server(defaultPort);
        server.start();
    }
    
    synchronized void removeClient(int id) {
        int i=0;
        for(ClientThread t : clients){
            i++;
            if(t.connectionId == id) {
                clients.remove(i);
                return;
            }
        }
    }
    
    //ClientThread part here
    
    class ClientThread extends Thread {
        Socket socket;
        ObjectInputStream cInput;
        ObjectOutputStream cOutput;
        
        int connectionId;
        String date;
        
        ClientThread(Socket socket) {
            //add func to set userId
            connectionId = ++uniqueId;
            this.socket = socket;
            System.out.println("Thread trying to create Object Input/Output Streams");
            try {
                cOutput = new ObjectOutputStream(socket.getOutputStream());
                cInput = new ObjectInputStream(socket.getInputStream());
            } catch (Exception e) {
                System.out.println("Error creating streams");
            }
        }
        
        public void run() {
            boolean keepGoing = true;
            while(true) {
                //read from streams
                try {
                    Object obj = cInput.readObject();
                    //TODO obj operations
                    String objType = obj.getClass().getSimpleName();
                    System.out.println(""+objType);
                    switch(objType){
                        case "UserLogin" : userAuthenticate(obj, this);
                            break;
                        case "NewUser" : addNewUser(obj, this);
                            break;
                        case "CircleMessage" : newIncomingMessage(obj, this);    
                            break;
                        case "CreateServer" : newIncomingServer(obj, this);
                            break;
                        default : continue;    
                    }
                    
                } catch (Exception e) {
                    System.out.println("Error reading object from client " + connectionId);
                    e.printStackTrace();
                }
            }
        }
        
        private void close() {
            try {
                if(cOutput != null)
                    cOutput.close();
                if(cInput != null)
                    cInput.close();
                if(socket != null)
                    socket.close();
            } catch (Exception e) {
            }
        }
        public boolean sendObject(Object obj) {
            try {
                if(!socket.isConnected()) {
                    close();
                    return false;
                }
                
                cOutput.writeObject(obj);
                System.out.println("Object sent succesfully");
            } catch (Exception e) {
                System.out.println("Error sending object to client " + connectionId);
                e.printStackTrace();
            }
            return true;
        }
    }
        
    //Start server methods here    
    public void userAuthenticate(Object obj, ClientThread t) {
        UserLogin ul = (UserLogin) obj;
        System.out.println("Trying to authenticate user " + ul.getNick());
        //check login
        Users user = factory.getUserFromNick(ul.getNick());
        System.out.println(user.getName());
        //generate authentication packet
        if(user.getPassword().equalsIgnoreCase(ul.getPassword())){
            //password matched
            System.out.println("Pass matched");
            ArrayList<Circles> circleIds = factory.getCircleList(user.getUid());
            ArrayList<Circles> adminIds = factory.getAdminList(user.getUid());
            ArrayList<Games> gameIds = factory.getGameIdList(user.getUid());
            
            Session session = new Session(user.getUid(), circleIds, gameIds, adminIds, user.getNick(), this.ip, this.port);
            
            UserAuthentication ua = new UserAuthentication(true, session, user.getName());
            t.sendObject(ua);
        }
        
        else{
            UserAuthentication ua = new UserAuthentication(false, null, null);
            t.sendObject(ua);
        }
        
    }
    
    public void addNewUser(Object obj, ClientThread t){
        NewUser user = (NewUser) obj;
        Boolean check = factory.createNewUser(user);
        t.sendObject(check);
    }
    
    public void newIncomingMessage(Object obj, ClientThread t) {
        //broadcast to everyone
        System.out.println("Broadcast.......");
        for(ClientThread ct : clients){
            ct.sendObject(obj);
        }
    }
    
    public void newIncomingServer(Object obj, ClientThread t){
        for(ClientThread ct : clients){
            ct.sendObject(obj);
        }
    }
}
    
    
