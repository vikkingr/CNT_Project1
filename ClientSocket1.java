import java.net.*;
import java.util.*;
import java.io.*;

public class ClientSocket1 {
	
	private static final int PORT = 3031;

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		String keyBoardInput = "";
		
		System.out.print("Enter server IP Address: ");
		keyBoardInput = scanner.nextLine();
		
		if (!keyBoardInput.equals("192.168.101.100")) {
			scanner.close();
			return;
		}
		
		Socket clientSocket = new Socket(keyBoardInput, PORT);
		
		keyBoardInput = "";
		
		while(!keyBoardInput.equals("7")) {
			
			System.out.println();
			
			System.out.println(
					"1. Date"
					+ "\n"
					+ "2. Uptime"
					+ "\n"
					+ "3. Memory Use"
					+ "\n"
					+ "4. Netstat"
					+ "\n"
					+ "5. Current Users"
					+ "\n"
					+ "6. Running Processes"
					+ "\n"
					+ "7. Close");
			
			keyBoardInput = scanner.nextLine();
			
			if (keyBoardInput.equals("7")) {
				break;
			}
			
			BufferedReader inputFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintWriter outputToServer = new PrintWriter(clientSocket.getOutputStream(), true);
			
			outputToServer.println(keyBoardInput);
			
			while (true) {

				String responseFromServer = inputFromServer.readLine();
				
				if (responseFromServer.contains("endOfLine"))
					break;
				
				System.out.println(responseFromServer);
				
			}
			
			keyBoardInput = "";
			
		}
		
		System.out.println("Goodbye :).");
		
		clientSocket.close();
		scanner.close();
		System.exit(0);
		
	} // main
	
} // class
