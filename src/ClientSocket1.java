import java.net.*;
import java.util.*;
import java.io.*;

public class ClientSocket1 {
	
	private static final int PORT = 3030;

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		String keyBoardInput = "";
		
		System.out.print("Enter server IP Address: ");
		keyBoardInput = scanner.nextLine();
		
		System.out.println();
		
		if (keyBoardInput.equals(""))
			return;
		
		Socket clientSocket = new Socket(keyBoardInput, PORT);
		
		keyBoardInput = "";
		
		BufferedReader inputFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		PrintWriter outputToServer = new PrintWriter(clientSocket.getOutputStream(), true);
		
		System.out.println("KeyboardInput before while loop = " + keyBoardInput);
		
		while(!keyBoardInput.equals("7")) {
			
			System.out.println("KeyboardInput in while loop = " + keyBoardInput);
			
			keyBoardInput = scanner.nextLine();
			
			System.out.println("KeyboardInput sending to server = " + keyBoardInput);
			outputToServer.println(keyBoardInput);
			
			String responseFromServer = inputFromServer.readLine();
			System.out.println("Server says: " + responseFromServer);
			
		}
		
		System.out.println("Goodbye :).");
		
		clientSocket.close();
		System.exit(0);
		
	} // main
	
} // class
