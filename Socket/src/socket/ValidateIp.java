/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

/**
 *
 * @author imrul
 */
public class ValidateIp {
    public static void main(String[] args) {
        String ipAddress = "127.0.0.255";
        String[] numbers = ipAddress.split("\\.");
        if(numbers.length !=4)
        {
            System.out.println(ipAddress+" is not valid!");
     
        }
        else
        {
            int k =0;
            for(String str:numbers){
                int i = Integer.parseInt(str);
                if((i<0) || (i>255)){
                     k++;
                }
            }
            if(k==0){
                 System.out.println(ipAddress+" is  valid!");
            }else{
                 System.out.println(ipAddress+" is not valid!");
            }
        }
    }
}
