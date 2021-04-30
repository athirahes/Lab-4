import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientTextCounterApp {

	public static void main(String[] args) throws UnknownHostException, IOException {

		// Launch client-side frame
		ClientTextCounterFrame clientTextCounterFrame = new ClientTextCounterFrame();
		clientTextCounterFrame.setVisible(true);

		// Connect to the server @ localhost, port 4228
		Socket socket = new Socket(InetAddress.getLocalHost(), 4228);

		// Update the status of the connection
		clientTextCounterFrame.updateConnectionStatus(socket.isConnected());

		// Read from network
		BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		// Display the current text
		clientTextCounterFrame.updateServerText(String.valueOf(bf.readLine()));		
		clientTextCounterFrame.updateServerWordCount(String.valueOf(bf.readLine()));

		// Close everything
		bf.close();
		socket.close();

	}
}
