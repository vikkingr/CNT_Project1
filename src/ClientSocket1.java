import java.net.*;
import java.io.*;

public class ClientSocket1 {
	
	private static final String SERVER_IP = "127.0.0.1";
	private static final int PORT = 9090;

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub

		Socket client = new Socket(SERVER_IP, PORT);
		
		BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
		
		String serverResponse = input.readLine();
		
		System.out.println("Today is: " + serverResponse);
		
		client.close();
		System.exit(0);
		
	}

}
