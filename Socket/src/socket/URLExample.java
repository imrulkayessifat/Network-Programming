/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author imrul
 */
public class URLExample {
    public static void main(String[] args) throws MalformedURLException, IOException {
        URL url = new URL("https://finance.yahoo.com/quote/ORCL?ltr=1");
        URLConnection myURL = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(myURL.getInputStream()));
        String inputLine;
        while(( inputLine= in.readLine())!=null)
        {
            System.out.println(inputLine);
        }
        
        
    }
}
