/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author imrul
 */
public class MultiThreadedServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9090);
        boolean stop = false;
        while(!stop)
        {
            System.out.println("waiting for clients!");
            Socket clientSocket = serverSocket.accept();
            System.out.println("client is connected.");
            ClientThread clientThread = new ClientThread(clientSocket);
            clientThread.start();
        }
    }
}
