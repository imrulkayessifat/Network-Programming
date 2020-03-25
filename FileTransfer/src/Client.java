/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.net.*;
//import org.apache.commons.validator.routines.InetAddressValidator;

/**
 *
 * @author imrul
 */
public class Client {
    public static void main(String[] args) {
        try
        {
            InputStreamReader in = new InputStreamReader(System.in);
            BufferedReader reader = new BufferedReader(in);
            
            String ipAddress ="";
            String fileName = "";
            boolean isValid = false;
            
            while(!isValid)
            {
                System.out.println("Please enter a valid Server Ip address: ");
                ipAddress = reader.readLine();
//                InetAddressValidator validator = new InetAddressValidator();
//                isValid = validator.isValid(ipAddress);
                  isValid = true;
            }
            System.out.println("Please enter a file name: ");
            fileName = reader.readLine();
            
            Socket socket = new Socket(ipAddress,9090);
            InputStream inputByte = socket.getInputStream();
            BufferedInputStream input = new BufferedInputStream(inputByte);
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            
            out.println(fileName);
            int code = input.read();
            if(code == 1)
            {
                BufferedOutputStream outputFile = new BufferedOutputStream(new FileOutputStream("/home/imrul/Desktop/"+fileName));
                byte[] buffer = new byte[1024];
                int bytesRead = 0;
                while((bytesRead = input.read(buffer))!=-1)
                {
                    System.out.print(".");
                    outputFile.write(buffer,0,bytesRead);
                    outputFile.flush();
                }
                System.out.println();
                System.out.println("File: "+fileName+" was successfully download!");
            }
            else{
                System.out.println("File is not present on the server");
            }
            
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
}
