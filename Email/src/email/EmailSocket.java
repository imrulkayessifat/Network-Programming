/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package email;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author imrul
 */



/////////////  you need to setup local smtp server first.




public class EmailSocket {
    private static Socket smtpSocket;
    private static PrintWriter out;
    private static BufferedReader in;
    
    public static void main(String[] args) throws IOException {
        try
        {
            smtpSocket = new Socket("localhost",25);
            in = new BufferedReader(new InputStreamReader(smtpSocket.getInputStream()));
            out = new PrintWriter(smtpSocket.getOutputStream(),true);
        }
        catch(UnknownHostException e)
        {
            System.out.println("Don't know about host: hostname");
        }
        catch(IOException e)
        {
            System.out.println("Couldn't get I/O for the connection to: hostname");
        }
        
        if(smtpSocket !=null && out !=null && in !=null)
        {
            try
            {
                String responseLine;
                while((responseLine = in.readLine()) != null)
                {
                    System.out.println("Server: "+responseLine);
                    if(responseLine.indexOf("220") !=-1)
                    {
                        break;
                    }
                }
                
                out.println("HELLO "+InetAddress.getLocalHost().getHostAddress());
                System.out.println("HELLO "+InetAddress.getLocalHost().getHostAddress());
                while((responseLine = in.readLine()) != null)
                {
                    System.out.println("Server: "+responseLine);
                    if(responseLine.indexOf("250") !=-1)
                    {
                        break;
                    }
                }
                
                out.println("MAIL From:kayesaurbow@gmail.com");
                while((responseLine = in.readLine()) != null)
                {
                    System.out.println("Server: "+responseLine);
                    if(responseLine.indexOf("250") !=-1)
                    {
                        break;
                    }
                }
                
                out.println("REPT TO: kayesimrul224@ggg.com");
                while((responseLine = in.readLine()) != null)
                {
                    System.out.println("Server: "+responseLine);
                    if(responseLine.indexOf("250") !=-1)
                    {
                        break;
                    }
                }
                
                out.println("DATA");
                while((responseLine = in.readLine()) != null)
                {
                    System.out.println("Server: "+responseLine);
                    if(responseLine.indexOf("354") !=-1)
                    {
                        break;
                    }
                }
                
                out.println("From:kayesaurbow@gmail.com");
                out.println("To:kayesimrul224@gmail.com");
                out.println("Subject:TEST EMAIL");
                out.println();
                out.println("Subject: TEST EMAIL");
                out.println("This is a test message");
                out.println("Thanks,");
                out.println("Java Network Programming course");
                out.println();
                out.println(".");
                
                while((responseLine = in.readLine()) != null)
                {
                    System.out.println("Server: "+responseLine);
                    if(responseLine.indexOf("250") !=-1)
                    {
                        break;
                    }
                }
                
                out.println("QUIT");
                while((responseLine = in.readLine()) != null)
                {
                    System.out.println("Server: "+responseLine);
                    if(responseLine.indexOf("221") !=-1)
                    {
                        break;
                    }
                }
                
                System.out.println("Email successfully sent!");
                out.close();
                in.close();
                smtpSocket.close();
            }
            catch(Exception e)
            {
                System.out.println(e.toString());
            }
        }
    }
    
}
