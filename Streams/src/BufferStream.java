
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author imrul
 */
public class BufferStream {
    public static void main(String[] args) {
        //for send receive large file;
        try
        {
//declare buffer size   BufferedReader reader = new BufferedReader(new FileReader("example6.txt"),1024);
            BufferedReader reader = new BufferedReader(new FileReader("example6.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("example7.txt"));
            
            String line = null;
            
            while((line = reader.readLine())!=null)
            {
                writer.write(line);
                writer.newLine();
            }
            writer.close();
            reader.close();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
}
