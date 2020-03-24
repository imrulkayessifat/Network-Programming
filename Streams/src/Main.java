/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
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
        try{
            FileInputStream inputStream = new FileInputStream("example.txt");
            int data = inputStream.read();
            while(data != -1)
            {
                System.out.print((char)data);
                data=inputStream.read();
            }
            inputStream.close();
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
    
}
