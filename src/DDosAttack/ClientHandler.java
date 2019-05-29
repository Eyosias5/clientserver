/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DDosAttack;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author eyosias
 */
public class ClientHandler extends Thread {
    DateFormat fordate = new SimpleDateFormat("yyyy/MM/dd");
    DateFormat fortime = new SimpleDateFormat ("hh:mm:ss");
    
    final DataInputStream dis;
    final DataOutputStream dos;
    final Socket s;
    
    public ClientHandler(Socket s, DataInputStream dis ,DataOutputStream dos){
        this.s = s;
        this.dis = dis;
        this.dos = dos;
    }
    
    public void run (){
    String received;
    String toreturn;
    
    while(true){
        try{
            dos.writeUTF("Returining whatever it is you just said back to you ");
            received = dis.readUTF();
           
            if((received.equals("Stop"))){
            
                System.out.println("Client "+ this.s + "Requested an exit ..");
                System.out.println("COnnection closing ..");
                this.s.close();
                System.out.println("Connection closed");
                break;
                        
            }
            
             dos.writeUTF("Client "+ this.s + " says "+received);
             
             
             
             
             
             
             
             
        Thread.sleep(10000);
        }catch(Exception e){
            e.printStackTrace();
        }
    
    
    
    }
    }
 
    
}
