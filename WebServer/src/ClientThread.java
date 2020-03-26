/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.net.*;
import java.util.Date;
/**
 *
 * @author imrul
 */
public class ClientThread extends Thread{
    
    private Socket socket;
    private boolean isStop;
    private BufferedReader in;
    private PrintWriter out;
    private File file;
    final static String CRLF = "\r\n";
    
    public ClientThread(Socket clientSocket)
    {
        this.socket = clientSocket;
        this.isStop = false;
    }
    
    public void run()
    {
        try
        {
            while(!isStop)
            {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
                String line;
                String httpHeader ="";
                String htmlFile ="";
                while(true)
                {
                    line = in.readLine();
                    if(line.equals(CRLF) || line.equals(""))
                    {
                        break;
                    }
                    httpHeader = httpHeader + line +"\n";
                    if(line.contains("GET"))
                    {
                        int beginIndex = line.indexOf("/");
                        int endIndex = line.indexOf(" HTTP");
                        htmlFile = line.substring(beginIndex+1, endIndex);
                    }
                }
                processRequest(htmlFile);
                closeConnection();
            }
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
    
    public void processRequest(String htmlFile) throws Exception
    {
        File file = new File(htmlFile);
        if(file.exists())
        {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            
            out.print("HTTP/1.0 200 OK"+CRLF);
            Date date = new Date();
            out.print("Date: "+date.toString()+CRLF);
            out.print("Server: java tiny web server"+CRLF);
            out.print("Content-Type: text/html"+CRLF);
            out.print("Content-Length: "+file.length()+CRLF);
            out.println("Content-Type: text/html;charset=iso-8859-1"+CRLF);
            
            String line = "";
            while((line = reader.readLine())!=null)
            {
                out.println(line);
            }
        }
        else
        {
            out.print("HTTP/1.1 404 Not Found"+CRLF);
            Date date = new Date();
            out.print("Date: "+date.toString()+CRLF);
            out.print("Server: java tiny web server"+CRLF);
            out.print("Connection: close"+CRLF);
            out.println("Content-Type: text/html;charset=iso-8859-1"+CRLF);
            
            out.println("<html></html>");
            out.println("<title>404 Not Found</title>");
            out.println("<head></head>");
            out.println("<h1>Not Found</h1>");
            out.println("<p>The requested URL /"+htmlFile+" was not found on this server.</p>");
            out.println("<body></body>");
            out.println(CRLF);
        }
    }
    
    private void closeConnection()
    {
        try
        {
            out.close();
            in.close();
            socket.close();
            isStop = true;
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
}
