package com.company;
import java.net.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws Exception {

        //Get input from the user
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        //Create a UDP socket
        DatagramSocket clientSocket = new DatagramSocket();

        //Get localhost IP address
        InetAddress IPAddress = InetAddress.getLocalHost();

        //Two variable to send and receive packet from server
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];

        //Get input from the user
        String sentence = inFromUser.readLine();

        //Convert string data to bytes data
        sendData = sentence.getBytes();

        //send data to the server
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9878);
        clientSocket.send(sendPacket);

        //receive data from the server
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);

        //Convert bytes data to string
        String modifiedSentence = new String(receivePacket.getData());

        //Print
        System.out.println("From Server: "+modifiedSentence);

        //Closing socket
        clientSocket.close();
    }
}
