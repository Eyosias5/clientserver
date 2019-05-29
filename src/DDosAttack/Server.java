/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DDosAttack;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Server {
    
    public static void main(String [] args) throws IOException{
        ServerSocket ss = new ServerSocket (5056);
        
        while (true){
            Socket s = null;
            
            try
            {
                s = ss.accept();
                System.out.println("A new client has been connected : " + s);
                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                
                System.out.println("Assigning new thread for client");
                
                Thread t = new ClientHandler(s,dis,dos);
                t.start();
                
            }catch(Exception e){
                s.close();
                e.printStackTrace();
                 
            }
        
        }
    
    }
    
}

