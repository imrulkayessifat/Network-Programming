
import java.net.ServerSocket;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author imrul
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try
        {
            ServerSocket serverSocket = new ServerSocket(801);
            boolean isStop = false;
            
            while(!isStop)
            {
                Socket clientSocket= serverSocket.accept();
                System.out.println("Client "+clientSocket.getInetAddress().getHostAddress()+" is connected");
                ClientThread clientThread = new ClientThread(clientSocket);
                clientThread.start();
            }
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
    
}
