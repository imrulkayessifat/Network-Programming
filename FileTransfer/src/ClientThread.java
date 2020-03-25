/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.net.*;
/**
 *
 * @author imrul
 */
public class ClientThread extends Thread{
    private Socket socket;
    private BufferedReader reader;
    private BufferedOutputStream out;
    private BufferedInputStream fileReader;
    
    public ClientThread(Socket socket)
    {
        this.socket=socket;
    }
    public void run()
    {
        try
        {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedOutputStream(socket.getOutputStream());
            String fileName = reader.readLine();
            System.out.println("file name: "+fileName+" has been requested by "+socket.getInetAddress().getHostAddress());
            File file = new File(fileName);
            //String rootDirector = "D://rootDirectory";
            //File file = new File(rootDirector+""+file);
            if(!file.exists())
            {
                byte code = (byte)0;
                out.write(code);
                closeConnection();
            }
            else
            {
                out.write((byte)1);
                fileReader = new BufferedInputStream(new FileInputStream(file));
                byte[] buffer = new byte[1024];
                int bytesRead = 0;
                while((bytesRead = fileReader.read(buffer))!=-1)
                {
                    out.write(buffer,0,bytesRead);
                    out.flush();
                }
                closeConnection();
            }
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
    public void closeConnection()
    {
        try
        {
            if(out!=null)
            {
                out.close();
            }
            if(reader!=null)
            {
                reader.close();
            }
            if(fileReader!=null)
            {
                fileReader.close();
            }
            if(socket!=null)
            {
                socket.close();
            }
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
}
