/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DDosAttack;

import static com.oracle.jrockit.jfr.ContentType.Address;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author eyosias
 */
public class Client {
    
    public static void main(String[] args){
        try{
            Scanner scn = new Scanner(System.in);
            //getting the ip address
            
            InetAddress ip = InetAddress.getByName("localhost");
           
            Socket s = new Socket (ip,5056);
          
            DataOutputStream  dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());
         
            while(true){
                System.out.println(dis.readUTF());
                String tosend = scn.nextLine();
                dos.writeUTF(tosend);
                
                if(tosend.equals("Stop")){
                    System.out.println("Closing the connection : " + s);
                    s.close();
                    System.out.println("Connection closed");
                    break;
                
                }
                String received = dis.readUTF();
                System.out.println(received);
            
            }
            scn.close();
            dis.close();
            dos.close();
        
        }catch(Exception e){System.out.println(e);}
    
    }
    
}
