import java.net.*;
import java.io.*;

public class ServerSocket1 {

	private static final int PORT = 3031;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		ServerSocket serverSocket = new ServerSocket(PORT);
		
		System.out.print("SERVER: ");
		System.out.println("Online!");
		System.out.println("Awaiting client connection.");
		
		while (true) {
			
			Socket clientSocket = serverSocket.accept();
			
			PrintWriter outputToClient = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader inputToClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			String clientMessage = "";
			
			System.out.println("[S E R V E R]:");
			System.out.println("Client connected!");
				
				clientMessage = inputToClient.readLine();
				
				if (clientMessage.equals("1")) {
					callCurrentDateAndTime(outputToClient);

					System.out.println("Client says: " + clientMessage);
				}
				if (clientMessage.equals("2")) {
					callUptime(outputToClient);
					
					System.out.println("Client says: " + clientMessage);
				}
				if (clientMessage.equals("3")) {
					callMemoryUse(outputToClient);

					System.out.println("Client says: " + clientMessage);
				}
				if (clientMessage.equals("4")) {
					callNetstat(outputToClient);

					System.out.println("Client says: " + clientMessage);
				}
				if (clientMessage.equals("5")) {
					callCurrentUsers(outputToClient);

					System.out.println("Client says: " + clientMessage);
				}
				if (clientMessage.equals("6")) {
					callRunningProcesses(outputToClient);

					System.out.println("Client says: " + clientMessage);
				}
				if (clientMessage.equals("7")) {
					System.out.println("Client says: " + clientMessage);
					break;
				}
				
				clientMessage = "";
			
			outputToClient.println("Goodbye!");
			
			System.out.println("[S E R V E R]:");
			System.out.println("Closing connections.");
			
			inputToClient.close();
			outputToClient.close();
			clientSocket.close();
			
		}
		
		
		
	}// main
	
	private static void callCurrentDateAndTime (PrintWriter outputToClient) {
	
		try {
			
			Process process = Runtime.getRuntime().exec("date");
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			
			String message = "";
			String parsedLine = null;
			
			while ((parsedLine = bufferedReader.readLine()) != null)
				message += parsedLine + "\n";
			
			message += "endOfLine";
			
			outputToClient.println(message);
			
			return;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void callUptime (PrintWriter outputToClient) {
	
		try {
			
			Process process = Runtime.getRuntime().exec("uptime");
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			
			String message = "";
			String parsedLine = null;
			
			while ((parsedLine = bufferedReader.readLine()) != null)
				message += parsedLine + "\n";
			
			message += "endOfLine";
			
			outputToClient.println(message);
			
			return;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void callMemoryUse (PrintWriter outputToClient) {
	
		try {
			
			Process process = Runtime.getRuntime().exec("free");
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			
			String message = "";
			String parsedLine = null;
			
			while ((parsedLine = bufferedReader.readLine()) != null)
				message += parsedLine + "\n";
			
			message += "endOfLine";
			
			outputToClient.println(message);
			
			return;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void callNetstat (PrintWriter outputToClient) {
	
		try {
			
			Process process = Runtime.getRuntime().exec("netstat");
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			
			String message = "";
			String parsedLine = null;
			
			while ((parsedLine = bufferedReader.readLine()) != null)
				message += parsedLine + "\n";
			
			message += "endOfLine";
			
			outputToClient.println(message);
			
			return;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void callCurrentUsers (PrintWriter outputToClient) {
	
		try {
			
			Process process = Runtime.getRuntime().exec("who");
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			
			String message = "";
			String parsedLine = null;
			
			while ((parsedLine = bufferedReader.readLine()) != null)
				message += parsedLine + "\n";
			
			message += "endOfLine";
			
			outputToClient.println(message);
			
			return;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void callRunningProcesses (PrintWriter outputToClient) {
	
		try {
			
			Process process = Runtime.getRuntime().exec("ps -e");
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			
			String message = "";
			String parsedLine = null;
			
			while ((parsedLine = bufferedReader.readLine()) != null)
				message += parsedLine + "\n";
			
			message += "endOfLine";
			
			outputToClient.println(message);
			
			return;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}// class
