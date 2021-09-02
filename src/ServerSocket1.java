import java.net.*;
import java.io.*;

public class ServerSocket1 {

	private static final int PORT = 3030;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		ServerSocket serverSocket = new ServerSocket(PORT);
		
		System.out.println("[S E R V E R]:");
		System.out.println("Online!");
		System.out.println("Awaiting client connection.");
		

		Socket clientSocket = serverSocket.accept();
		
		PrintWriter outputToClient = new PrintWriter(clientSocket.getOutputStream(), true);
		BufferedReader inputToClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		String clientMessage = "";
		
		System.out.println("[S E R V E R]:");
		System.out.println("Client connected!");

		while (!clientMessage.equals("7")) {
			
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
			
		}
		
		outputToClient.println("Goodbye!");
		
		System.out.println("[S E R V E R]:");
		System.out.println("Closing connections.");
		
		inputToClient.close();
		outputToClient.close();
		clientSocket.close();
		serverSocket.close();
		
	}// main
	
	private static void callCurrentDateAndTime (PrintWriter outputToClient) {
	
		try {
			
			Process process = Runtime.getRuntime().exec("date");
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			
			String message = "";
			
			while ((message = bufferedReader.readLine()) != null)
                outputToClient.println(message);
			
            try {
				process.waitFor();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
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
			
			while ((message = bufferedReader.readLine()) != null)
                outputToClient.println(message);
			
            try {
				process.waitFor();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
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
			
			while ((message = bufferedReader.readLine()) != null)
                outputToClient.println(message);
			
            try {
				process.waitFor();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
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
			
			while ((message = bufferedReader.readLine()) != null)
                outputToClient.println(message);
			
            try {
				process.waitFor();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void callCurrentUsers (PrintWriter outputToClient) {
	
		outputToClient.println("YOU SAID 5");
		
	}
	
	private static void callRunningProcesses (PrintWriter outputToClient) {
	
		outputToClient.println("YOU SAID 6");
		
	}

}// class
