/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.List;

/**
 *
 * @author imrul
 */
public class NetworkInterfaceExample {
    public static void main(String[] args) {
        try
        {
            InetAddress address = InetAddress.getByName("192.168.31.89");
            //getByInetAddress()
            //getByName()
            //getNetworkInterfaces()
            //NetworkInterface networkInterface = NetworkInterface.getByInetAddress(address);
            //NetworkInterface networkInterface = NetworkInterface.geByName("wlo1");
            Enumeration<NetworkInterface>networkInterfaces=NetworkInterface.getNetworkInterfaces();
            while(networkInterfaces.hasMoreElements())
            {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                if(networkInterface != null)
                {
                    System.out.println("NIC name: "+networkInterface.getName());
                    System.out.println("NIC dispaly name: "+networkInterface.getDisplayName());
                    System.out.println("NIC get hardware address(MAC): "+convertByteToString(networkInterface.getHardwareAddress()));
                    System.out.println("MTU: "+networkInterface.getMTU());
                    System.out.println("Index: "+networkInterface.getIndex());
                    NetworkInterface parentInterface = networkInterface.getParent();
                    if(parentInterface !=null)
                    {
                        System.out.println("Parent interface: "+parentInterface.getDisplayName());
                    }
                    else
                    {
                        System.out.println("No Parent interface");
                    }
                    System.out.println("Is Loopback? "+networkInterface.isLoopback());
                    System.out.println("Is up "+networkInterface.isUp());
                    System.out.println("Is virtual "+networkInterface.isVirtual());
                    System.out.println("Support multicast? "+networkInterface.supportsMulticast());
                    List<InterfaceAddress>list = networkInterface.getInterfaceAddresses();
                    for(int i=0;i<list.size();i++)
                    {
                        System.out.println("Ip address: "+(list.get(i)).getAddress().getHostAddress());
                    }
                    System.out.println("");
                    System.out.println("________________________________________");
                    System.out.println("");
                }

                else
                {
                    System.out.println("Interface not found!");
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
    public static String convertByteToString(byte[] mac)
    {
        if(mac == null)
            return null;
        StringBuilder sb = new StringBuilder(18);
        for(byte b : mac)
        {
            if(sb.length()>0)
            {
                sb.append(':');
            }
            sb.append(String.format("%02x", b));
                    
        }
        return sb.toString();
    }
}
