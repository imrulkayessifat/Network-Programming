/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_client;

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
public class client {
    public static void main(String[] args) throws UnknownHostException, IOException {
        InetAddress serverAddress = InetAddress.getByName("localhost");
        System.out.println("server ip address "+ serverAddress.getHostAddress());
        Socket socket = new Socket(serverAddress,9090);
        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println("Hello Server!");
        input.close();
        out.close();
        socket.close();
    }
}
