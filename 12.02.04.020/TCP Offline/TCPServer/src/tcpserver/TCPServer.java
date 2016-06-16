/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tcpserver;


import java.io.*;
import java.net.*;
import java.util.concurrent.ThreadLocalRandom;

class TCPServer
{
        private static final String[] WORDS_DATABASE = new String[] {

        "superman","batman","deadpool","spiderman","flash","aquaman"

        };
	public static void main(String argv[]) throws Exception
	{
		ServerSocket welcomeSocket= new ServerSocket(6789); 
		while (true)
		{
			Socket connectionSocket=welcomeSocket.accept(); 
			BufferedReader inFromClient=new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			DataOutputStream firstMsgToClient=new DataOutputStream(connectionSocket.getOutputStream());
                        DataOutputStream outToClient=new DataOutputStream(connectionSocket.getOutputStream());
			
                        
                        String original = selectRandomWord();
                        String shuffled = getShuffledWord(original);

                        boolean gameOn = true;

                        while(gameOn) {

                            firstMsgToClient.writeBytes(shuffled+'\n');


                            String userGuess = inFromClient.readLine();

                            if(original.equalsIgnoreCase(userGuess)) {
                                outToClient.writeBytes("Congratulations! You found the word"+'\n');
                                gameOn = false;

                            }else {
                                outToClient.writeBytes("Sorry, Wrong answer"+'\n');

                            }

                        }
       
		}
		
	}

        public static String selectRandomWord() {

            int rPos = ThreadLocalRandom.current().nextInt(0, WORDS_DATABASE.length);

            return WORDS_DATABASE[rPos];

        }


        public static String getShuffledWord(String original) {

            String shuffledWord = original; 

            int wordSize = original.length();

            int shuffleCount = 10; 

            for(int i=0;i<shuffleCount;i++) {

                int position1 = ThreadLocalRandom.current().nextInt(0, wordSize);

                int position2 = ThreadLocalRandom.current().nextInt(0, wordSize);

                shuffledWord = swapCharacters(shuffledWord,position1,position2);

            }

            return shuffledWord;

        }




        private static String swapCharacters(String shuffledWord, int position1, int position2) {

            char[] charArray = shuffledWord.toCharArray();

            char temp = charArray[position1];

            charArray[position1] = charArray[position2];

            charArray[position2] = temp;

            return new String(charArray);

        }
	
}
