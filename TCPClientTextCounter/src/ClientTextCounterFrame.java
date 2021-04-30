import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ClientTextCounterFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	// Private frame components
	private JLabel lblServerText;
	private JLabel lblStatusValue;
	private JLabel lblServerWordCount;

	// Private attributes for frame size
	private int width = 800;
	private int height = 200;

	public ClientTextCounterFrame() {

		// Default frame setting
		this.setLayout(new BorderLayout());
		this.setTitle("TCP Text Counter Application: Client Side");
		this.setSize(width, height);

		// Center the frame on the screen
		this.setLocationRelativeTo(null);

		// Initialize default value for label
		lblServerText = new JLabel("-");
		lblStatusValue = new JLabel("-");
		lblServerWordCount = new JLabel("-]");

		// Must close on X
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Organize components
		loadComponent();

	}

	public void updateConnectionStatus(boolean connStatus) {

		// Default status. Assuming for the worst case scenario.
		String status = "No connection to server.";

		// Validate status of connection
		if (connStatus)
			status = "Connection has established.";

		// Update the status on frame
		this.lblStatusValue.setText(status);

	}

	private JPanel getConnectionStatusPanel(Font font) {

		// Create component
		JPanel panel = new JPanel();
		JLabel lblConnStatus = new JLabel("Connection status: ");

		// Style the component
		lblConnStatus.setFont(font);
		lblStatusValue.setFont(font);
		lblConnStatus.setBackground(Color.WHITE);
		lblConnStatus.setOpaque(true);
		lblStatusValue.setBackground(Color.WHITE);
		lblStatusValue.setOpaque(true);

		// Organize components into panel
		panel.add(lblConnStatus);
		panel.add(lblStatusValue);

		return panel;

	}

	public void updateServerText(String serverText) {
		this.lblServerText.setText(serverText);
	}

	private JPanel getServerTextPanel(Font font) {

		// Create component to display date retrieve from the server
		JPanel panel = new JPanel();
		JLabel lblTextPanel = new JLabel("Text: ");

		// Style the component
		lblTextPanel.setFont(font);
		lblTextPanel.setBackground(Color.WHITE);
		lblTextPanel.setOpaque(true);

		lblServerText.setFont(font);
		lblServerText.setBackground(Color.WHITE);
		lblServerText.setOpaque(true);

		// Organize components into panel
		panel.add(lblTextPanel);
		panel.add(lblServerText);

		return panel;
	}

	public void updateServerWordCount(String wordCount) {
		this.lblServerWordCount.setText(String.valueOf(wordCount) + "]");
	}

	private JPanel getServerWordCounterPanel(Font font) {

		// Create component to display date retrieve from the server
		JPanel panel = new JPanel();
		JLabel lblWordCountPanel = new JLabel("[Word Count: ");

		// Style the component
		lblWordCountPanel.setFont(font);
		lblServerWordCount.setFont(font);

		// Organize components into panel
		panel.add(lblWordCountPanel);
		panel.add(lblServerWordCount);

		return panel;
	}

	private void loadComponent() {

		// Get font
		Font font = this.getFontStyle();

		// Get server status's panel and add to frame
		JPanel northPanel = this.getConnectionStatusPanel(font);
		this.add(northPanel, BorderLayout.NORTH);

		// Get server text's panel and add to frame
		JPanel lineStart = getServerTextPanel(font);
		this.add(lineStart, BorderLayout.LINE_START);

		// Get server word count's panel and add to frame
		JPanel pageEnd = getServerWordCounterPanel(font);
		this.add(pageEnd, BorderLayout.CENTER);

	}

	private Font getFontStyle() {

		Font font = new Font("Lucida Sans Typewriter", Font.PLAIN, 15);

		return font;

	}

}