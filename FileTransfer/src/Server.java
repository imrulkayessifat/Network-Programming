/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.net.*;
/**
 *
 * @author imrul
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try
        {
            ServerSocket serverSocket = new ServerSocket(9090);
            boolean isStopped = false;
            while(!isStopped)
            {
                Socket clientSocket = serverSocket.accept();
                ClientThread clientThread = new ClientThread(clientSocket);
                clientThread.start();
            }
        }
        catch(IOException e)
        {
            System.out.println("Port 9090 is already open!Please try another port.");
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
        
    }
    
}
