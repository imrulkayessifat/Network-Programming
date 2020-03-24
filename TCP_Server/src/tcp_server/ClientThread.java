/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author imrul
 */
public class ClientThread extends Thread{
    private Socket socket = null;
    public ClientThread(Socket socket)
    {
        this.socket=socket;
    }
    public void run()
    {
        try{
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            out.println("Hello client!");
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String clientInput = input.readLine();
            System.out.println(clientInput);
            input.close();
            out.close();
            socket.close();
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
}
