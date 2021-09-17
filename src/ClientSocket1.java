import java.net.*;
import java.util.*;
import java.io.*;

public class ClientSocket1 {
	
	private static final int PORT = 3031;
//	public boolean isServerDone = false;

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		//String keyBoardInput = "";
		String ipAddress = "";
		String menuOption = "";
		String numOfThreads = "0";
		
		System.out.print("Enter server IP Address: ");
		ipAddress = scanner.nextLine();
		
		if (!ipAddress.equals("192.168.101.100")) {
			scanner.close();
			
			System.out.println("No IP address found.");
			return;
		}
		
		System.out.print("How many threads? ");
		numOfThreads = scanner.nextLine();
		
		if (Integer.parseInt(numOfThreads) <= 0) {
			scanner.close();
			
			System.out.println("You didn't want any threads.");
			return;
		}
		
		while(!menuOption.equals("7")) {
			
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
			
			menuOption = scanner.nextLine();
			
			ArrayList<ClientThread> clientThreadList = new ArrayList<ClientThread>();
			
			for (int i = 0; i < Integer.parseInt(numOfThreads); i++) {
				
				ClientThread clientThread = new ClientThread();
				clientThread.ipAddress = ipAddress;
				clientThread.portNumber = PORT;
				clientThread.menuOption = menuOption;
				
				clientThreadList.add(clientThread);
			}
			
			for (int i = 0; i < Integer.parseInt(numOfThreads); i++) {
				System.out.println("Thread # " + (i + 1));
				clientThreadList.get(i).run();
			}
			
			for (int i = 0; i < Integer.parseInt(numOfThreads); i++) {
				 
				try {
					 clientThreadList.get(i).join();
				 } catch (InterruptedException e) {
                     e.printStackTrace();
				 }// end try catch statement
				
			}
			
			if (menuOption.equals("7")) {
				break;
			}
			
			menuOption = "";
			
		}
		
		System.out.println("Goodbye :).");
		scanner.close();
		System.exit(0);
		
	} // main
	
} // class
