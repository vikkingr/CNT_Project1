import java.net.*;
import java.io.*;
import java.util.*;

public class ServerSocket1 {

	private static final int PORT = 3031;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		ServerSocket serverSocket = new ServerSocket(PORT);
		
		System.out.print("SERVER: ");
		System.out.println("Online!");
		System.out.println("Awaiting client connection.");
		
		int clientCount = 0;
		
		while (true) {
			
			Socket clientSocket = serverSocket.accept();
			
			ServerThread serverThread = new ServerThread(clientSocket);
			clientCount++;
			
			System.out.println("Client number: " + clientCount);
			
			serverThread.run();
			
		}
		
	}// main

}// class
