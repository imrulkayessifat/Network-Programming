/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author imrul
 */
public class Ping {
    public static void main(String[] args) {
        try{
            String hostAddress = "www.facebook.com";
            Process p = Runtime.getRuntime().exec("ping "+hostAddress);
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String commandOutput = "";
            boolean isReachable = true;
            while((commandOutput = inputStream.readLine())!=null){
                //System.out.println(commandOutput);
                if(commandOutput.contains("Destination host unreachable"))
                {
                    isReachable = false;
                    break;
                }
            }
            if(isReachable){
                System.out.println("Host is reachable");
            }else{
                System.out.println("Host is not reachable");
            }
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
}
