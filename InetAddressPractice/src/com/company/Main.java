package com.company;
import java.net.*;

public class Main {

    public static void main(String[] args) throws Exception{
	    InetAddress x = InetAddress.getByName("www.tanviriqbal.com");
        System.out.println(x);
        InetAddress myLocalIP = InetAddress.getLocalHost();
        System.out.println(myLocalIP);
        InetAddress[] addresses = InetAddress.getAllByName("www.microsoft.com");
        for (int i = 0; i < addresses.length; i++)
        { System.out.println(addresses[i]); }
    }
}
