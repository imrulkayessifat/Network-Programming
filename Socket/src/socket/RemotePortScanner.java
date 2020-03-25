/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author imrul
 */
public class RemotePortScanner {
    public static void main(String[] args) {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        
        String targetIp = "";
        int fromPort = 0;
        int toPort = 0;
        System.out.print("Please enter the target ip address: ");
        try
        {
            targetIp=reader.readLine();
        }
        catch(Exception e)
        {
            System.out.print("Cannot read the ip address: "+e.toString());
        }
        boolean isValid = false;
        while(!isValid)
        {
            try
            {
                System.out.print("Please enter the first port: ");
                String portString = reader.readLine();
                fromPort = Integer.parseInt(portString);
                if(fromPort >=0 && fromPort<=65536)
                {
                    isValid = true;
                }
                else
                {
                    System.out.print("Invalid port! Port range is 0 - 65536");
                }
            }
            catch(NumberFormatException e1)
            {
                System.out.println("Please insert a number!");
            }
            catch(Exception e)
            {
                System.out.println("Cannot read the first port number! "+e.toString());
            }
        }
        isValid = false;
        while(!isValid)
        {
            try
            {
                System.out.print("Please enter the last port: ");
                String portString = reader.readLine();
                toPort = Integer.parseInt(portString);
                if(toPort >=0 && toPort<=65536)
                {
                    if(toPort>=fromPort)
                    {
                        isValid = true;
                    }
                    
                }
                else
                {
                    System.out.println("Invalid port! Port range is 0 - 65536");
                }
            }
            catch(NumberFormatException e1)
            {
                System.out.println("Please insert a number!");
            }
            catch(Exception e)
            {
                System.out.println("Cannot read the last port number! "+e.toString());
            }
        }
        int port = fromPort;
        while(port>=fromPort && port<=toPort)
        {
            try {
                Socket socket = new Socket(targetIp,port);
                System.out.println("Port "+port+" is in listening state!");
                socket.close();
            }catch(UnknownHostException e1){
                System.out.println("Unknown host exception "+e1.toString());
            }catch (IOException e2) {
                System.out.println("Port "+e2+" is not opened!");
            }catch(Exception e)
            {
                System.out.println(e.toString());
            }
            port++;
        }
    }
}
