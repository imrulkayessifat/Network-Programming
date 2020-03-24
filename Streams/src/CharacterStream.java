
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author imrul
 */
public class CharacterStream {
    public static void main(String[] args) {
        try
        {
            //Using different charset;
            // OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("example4.txt","ASCII"));
            OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("example4.txt"));
            InputStreamReader in = new InputStreamReader(new FileInputStream("example4.txt"));
            
            System.out.println(out.getEncoding());
            
            out.write("aabcdefghijklmnopqrstubwxyz!");
            //out.flush(); //don't close() the stream;
            out.close();// call the flush() method and close the stream;
            
            //every char ascii code show;
            int data = in.read();
            while(data!=-1)
            {
                System.out.println((char)data);
                data=in.read();
            }
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
}
