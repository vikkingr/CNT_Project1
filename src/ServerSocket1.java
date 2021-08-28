import java.net.*;
import java.util.Date;
import java.io.*;

public class ServerSocket1 {

	private static final int PORT = 9090;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		ServerSocket server1 = new ServerSocket(PORT);
		
		System.out.println("[S E R V E R]:");
		System.out.println("Online!");
		System.out.println("Awaiting client connection.");
		
		Socket client1 = server1.accept();
		System.out.println("[S E R V E R]:");
		System.out.println("Client connected!");

		PrintWriter output = new PrintWriter(client1.getOutputStream(), true);
		output.println((new Date()).toString());
		
		System.out.println("[S E R V E R]:");
		System.out.println("Closing connections.");
		client1.close();
		server1.close();
		
	}

}
