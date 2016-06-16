/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tcpclient;
import java.io.*;
import java.net.*;
class TCPClient
{
	public static void main(String argv[]) throws Exception
	{
		String sentence;
		String fromServer;
                String firstMsg;

		BufferedReader inFromUser=new BufferedReader(new InputStreamReader(System.in));

		InetAddress inetAddress=InetAddress.getLocalHost();
		//System.out.println(inetAddress);
                Socket clientSocket = new Socket(inetAddress,6789);
                
                BufferedReader firstMsgFromServer= new  BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                firstMsg = firstMsgFromServer.readLine();
                System.out.println(firstMsg);
		
		DataOutputStream outToServer= new  DataOutputStream(clientSocket.getOutputStream());
                BufferedReader inFromServer= new  BufferedReader(new InputStreamReader(clientSocket.getInputStream()));


		sentence=inFromUser.readLine();
		outToServer.writeBytes(sentence+'\n');

		fromServer=inFromServer.readLine();
		System.out.println(fromServer);
		clientSocket.close();
	}
}
