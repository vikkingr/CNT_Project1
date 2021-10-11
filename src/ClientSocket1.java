import java.net.*;
import java.util.*;
import java.io.*;

public class ClientSocket1 {
	
	private static final int PORT = 3031;
//	public boolean isServerDone = false;
	public static ArrayList<Double> arrayResponseTimes = new ArrayList<Double>();
	
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
			
			if (menuOption.length() != 1)
			{
				System.out.println("Invalid input.");
				continue;
			}
			else
			{
				switch (menuOption.charAt(0))
				{
					case '1':
						break;
					case '2':
						break;
					case '3':
						break;
					case '4':
						break;
					case '5':
						break;
					case '6':
						break;
					case '7':
						break;
					default:
						System.out.println("Invalid input.");
						continue;
				}
			}
			
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
			
			if (!arrayResponseTimes.isEmpty()) {
				Double sumResponseTimes = 0.0;
				
				for (Double element : arrayResponseTimes) {
					sumResponseTimes += element;
				}
				
				System.out.println("Response time: " + sumResponseTimes);
			}
			
			if (menuOption.equals("7")) {
				break;
			}
			
			menuOption = "";
			arrayResponseTimes.clear();
			
		}
		
		System.out.println("Goodbye :).");
		scanner.close();
		System.exit(0);
		
	} // main
	
} // class
