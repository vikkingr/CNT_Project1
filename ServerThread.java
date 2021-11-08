import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread {
	
	private final Socket clientSocket;
	
	public ServerThread (Socket clientSocket) {
		
		this.clientSocket = clientSocket;
		
	}
	
	@Override
	public void run() { 
		
		try {
			
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
				outputToClient.println("ServerDone");
				
				System.out.println("Client says: " + clientMessage);
			}
			
			clientMessage = "";
			
			outputToClient.println("Goodbye!");
			
			System.out.println("[S E R V E R]:");
			System.out.println("Responded to client.");
			
			inputToClient.close();
			outputToClient.close();
			clientSocket.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
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

}
