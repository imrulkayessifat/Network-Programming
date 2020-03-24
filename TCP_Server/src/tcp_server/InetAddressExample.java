/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author imrul
 */
public class InetAddressExample {
    public static void main(String[] args) throws UnknownHostException, IOException {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address.getHostAddress());
        System.out.println(address.getHostName());
        
        InetAddress address2 = InetAddress.getByName("www.sust.edu");
        System.out.println(address2.getHostAddress());
        System.out.println(address2.getHostName());
        
        Socket socket = new Socket(address,9090);
    }
}
