package com.company;
import java.io.*;
import java.net.*;

public class Main {

    public static void main(String[] args) throws Exception {
        String sentence;
        String modifiedSentence;

        BufferedReader inFromUser=
                new BufferedReader(new InputStreamReader(System.in));

        InetAddress inetAddress=InetAddress.getLocalHost();
        //.getByName(String hostname); "CL11"
        System.out.println(inetAddress);

        Socket clientSocket = new Socket(inetAddress,6789);
        DataOutputStream outToServer=
                new  DataOutputStream(clientSocket.getOutputStream());

        BufferedReader inFromServer=
                new  BufferedReader(new InputStreamReader
                        (clientSocket.getInputStream()));


        sentence=inFromUser.readLine();
        outToServer.writeBytes(sentence+'\n');

        modifiedSentence=inFromServer.readLine();
        System.out.println("From Server: "+modifiedSentence );
        clientSocket.close();
    }
}
