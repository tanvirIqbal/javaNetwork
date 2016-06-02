package com.company;
import java.io.*;
import java.net.*;

public class Main {

    public static void main(String[] args) throws Exception {
        String clientSentence;
        String capitalizedSentence;
        String message;
        int vowel = 0, cons = 0;

        ServerSocket welcomeSocket = new ServerSocket(6789); //Attempts to create a server socket bound to the specified port.

        while(true)
        {
            Socket connectionSocket=welcomeSocket.accept(); //Waits for an incoming client.
            BufferedReader inFromClient=
                    new BufferedReader(new InputStreamReader(
                            connectionSocket.getInputStream()));
            DataOutputStream outToClient=
                    new DataOutputStream(
                            connectionSocket.getOutputStream());
            clientSentence=inFromClient.readLine();
            for(int i = 0; i <clientSentence.length();i++)
            {
                if(clientSentence.charAt(i) == 'a' || clientSentence.charAt(i) == 'e' || clientSentence.charAt(i) == 'i' || clientSentence.charAt(i) == 'o' || clientSentence.charAt(i) == 'u')
                {
                    vowel++;
                }
                else
                {
                    cons++;
                }
            }
            message = "Vowel = " +vowel+ " and Consonent = " +cons +'\n';
//            System.out.println("From Client: "+clientSentence);
//            capitalizedSentence=
//                    clientSentence.toUpperCase()+'\n';

//            outToClient.writeBytes(capitalizedSentence);
            outToClient.writeBytes(message);
        }
    }
}
