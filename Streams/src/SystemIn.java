
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author imrul
 */
public class SystemIn {
    public static void main(String[] args) {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        boolean isValid = false;
        int port = 0;
        while(!isValid)
        {
            try
            {
                String portString = reader.readLine();
                port = Integer.parseInt(portString);
                System.out.println("Port is accepted");
                isValid = true;
            }catch(Exception e){
                System.out.println(e.toString());
            }
        }
        String ipAddress="";
        try
        {
            ipAddress = reader.readLine();
        }catch(Exception e){
            System.out.println(e.toString());
        }
        
        System.out.println("ip address: "+ipAddress+" port number: "+port);
    }
}
