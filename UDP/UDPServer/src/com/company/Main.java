package com.company;
import java.net.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {

        //Create server socket
        DatagramSocket serverSocket = new DatagramSocket(9878);

        //Variable that used to send to and receive from client
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];

        // For always opened server
        while (true)
        {
            // Receive packet from client
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);

            //bytes to string
            String sentence = new String(receivePacket.getData());

            //IP address and port number from client
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();

            //Action
            String capitalizedSentence = sentence.toUpperCase();

            //String to bytes
            sendData = capitalizedSentence.getBytes();

            //Send data to client
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendPacket);
        }
    }
}
