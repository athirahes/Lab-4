import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTextCounterApp {

	public static void main(String[] args) throws Exception {
		// Launch the server frame
		ServerTextCounterFrame serverFrame = new ServerTextCounterFrame();
		serverFrame.setVisible(true);

		// Binding to a port or any other port no you are fancy of
		int portNo = 4228;
		ServerSocket serverSocket = new ServerSocket(portNo);

		TextGenerator textGenerator = new TextGenerator();
		// ServerWordCount serverWordCount = new ServerWordCount();

		// Counter to keep track the number of requested connection
		int totalRequest = 0;

		// Server needs to be alive forever
		while (true) {

			// Message to indicate server is alive
			serverFrame.updateServerStatus(false);

			// Accept client request for connection
			Socket clientSocket = serverSocket.accept();

			// Generate current text
			String currentText = textGenerator.getCurrentText();

			// Generate wordcount
			String wordCount = String.valueOf(ServerWordCounter.wordcount(currentText));

			// Create stream to write data on the network
			DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());

			DataOutputStream outputStream2 = new DataOutputStream(clientSocket.getOutputStream());

			// Send current date back to the client
			outputStream.writeBytes(currentText + "\n");
			outputStream2.writeBytes(wordCount);

			// Close the socket
			clientSocket.close();

			// Update the request status
			serverFrame.updateRequestStatus("Data sent to the client: " + currentText);
			serverFrame.updateRequestStatus("Accepted connection to from the client. Total request = " + ++totalRequest);
			serverFrame.updateRequestStatus("Number of words: " + wordCount);

		}
	}
}