import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
	
	public int numThreads = 0;
	public int portNumber = 0;
	public String ipAddress = "";
	public String menuOption = "";
	
	@Override
	public void run() {
		
		double timeStart;

        double timeEnd;
		
		Socket clientSocket;
		
		try {
			
			timeStart = System.currentTimeMillis();
			clientSocket = new Socket(ipAddress, portNumber);
			
			BufferedReader inputFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintWriter outputToServer = new PrintWriter(clientSocket.getOutputStream(), true);
			
			outputToServer.println(menuOption);
			
			while (true) {

				String responseFromServer = inputFromServer.readLine();
				
				if (responseFromServer.contains("endOfLine"))
					break;
				
				if (responseFromServer.equals("ServerDone")) {
					System.out.println("Closing Connection.");
					return;
				}
				
				System.out.println(responseFromServer);
				
			}
			
			timeEnd = System.currentTimeMillis();
			
			//System.out.println("Response time = " + (timeEnd - timeStart));
			ClientSocket1.arrayResponseTimes.add(timeEnd - timeStart);
			
			clientSocket.close();
			outputToServer.close();
			inputFromServer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
