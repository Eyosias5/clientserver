/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DDosAttack;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.net.InetAddress;
import java.net.Socket;

/**
 *
 * @author eyosias
 */
public class Attacker2 {
       public static void main(String[] args){
       String attackfile = "C:\\Users\\eyosias\\Documents\\NetBeansProjects\\DDosAttack\\src\\DDosAttack\\attackfile.txt";
       String line = null;
       
          try{
              
            InetAddress ip = InetAddress.getByName("localhost");
           
            Socket s = new Socket (ip,5056);
          
            DataOutputStream  dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());
              
            FileReader fileReader = new FileReader(attackfile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            while((line = bufferedReader.readLine()) != null ){
                dos.writeUTF(line);
                String received = dis.readUTF();
                System.out.println(received);
            }
            bufferedReader.close();
            //getting the ip address
            
         
         
      
     
        
        }catch(Exception e){System.out.println(e);}
    
    }
    
}
