
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author imrul
 */
public class DataStreams {
    public static void main(String[] args) throws IOException {
        //DataInputStream - read Java primitives
        //DataOutputStream -write Java primitives
        File file = new File("example3.txt");
        if(file.exists())
        {
            System.out.println("file already exits! "+file.getName());
        }
        else
        {
            try{
                if(file.createNewFile())
                {
                    System.out.println("File was created!");
                    System.out.println("file path: "+file.getAbsolutePath());
                }
                else
                {
                    System.out.println("cannot create file");
                }
            }catch(Exception e)
            {
                System.out.println(e.toString());
            }
        }
        try {
            DataOutputStream out = new DataOutputStream(new FileOutputStream(file.getName()));
            DataInputStream in = new DataInputStream(new FileInputStream(file.getName()));
            
            out.writeInt(72);
            out.writeDouble(123.23);
            out.writeFloat(12.2F);
            
            int var1 = in.readInt();
            double var2 = in.readDouble();
            float var3 = in.readFloat();
            
            System.out.println("Integer value: "+var1);
            System.out.println("Double value: "+var2);
            System.out.println("Float value: "+var3);
            
            out.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataStreams.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
