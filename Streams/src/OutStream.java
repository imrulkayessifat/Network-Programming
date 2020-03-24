
import java.io.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author imrul
 */
public class OutStream {
    public static void main(String[] args) {
        try{
            FileOutputStream fileOutput = new FileOutputStream("example2.txt");
  // turning on append mode  
//        FileOutputStream fileOutput = new FileOutputStream("example2.txt",true);
            char H = 'H';
            fileOutput.write((char)H);
            String string = "Hello java network program";
            fileOutput.write(string.getBytes());
            fileOutput.close();
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
}
