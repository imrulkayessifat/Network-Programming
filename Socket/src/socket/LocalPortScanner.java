/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author imrul
 */
public class LocalPortScanner {
    public static void main(String[] args) {
        int port = 1;
        while(port<=65535)
        {
            try {
                ServerSocket server = new ServerSocket(port);
                System.out.println(port+" port is closed!");
            } catch (IOException ex) {
                System.out.println(port+" port is open!");
            }
            port++;
        }
        
    }
}
