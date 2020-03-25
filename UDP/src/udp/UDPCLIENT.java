/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author imrul
 */
public class UDPCLIENT {
    public static void main(String[] args) {
        try
        {
            DatagramSocket clientSocket = new DatagramSocket(0);
            
            byte[] sendData = new byte[1024];//store outgoing data
            byte[] receiveData = new byte[1024];//store incoming data
            
            InetAddress serverAddress = InetAddress.getByName("localhost");
            
            clientSocket.setSoTimeout(3000);
            
            String stringSendData = "Hello Server!";
            sendData = stringSendData.getBytes();
            
            DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,serverAddress,9090);
            
            clientSocket.send(sendPacket);
            
            DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
            clientSocket.receive(receivePacket);
            receiveData = receivePacket.getData();
            String stringReceiveData = new String(receiveData);
            System.out.println("From Server: "+stringReceiveData);
            
            clientSocket.close();
            
            
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
}
