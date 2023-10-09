import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JTextField;

//Public class for the board select method and its variables
public class boardSelect {
	//Initializing variables for board select GUI and functionality
	JFrame popupWindow = new JFrame("Board Selection");
	JPanel popupPanel = new JPanel();
	final int WINDOW_WIDTH = 350;
	final int WINDOW_HEIGHT = 350;
	JTextField userInput;
	JLabel enterSize;
	JButton submitButton;
	boolean checkGame;
	
	//Board Select Menu GUI method
	public void boardSelectMenu(boolean ifSimple) {
		//Creating the design for the GUI and all the variables
		popupWindow.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    	submitButton = new JButton("Enter");
    	JTextField userInput = new JTextField(5);
    	JLabel enterSize = new JLabel("Enter the size of your board");
    	popupPanel.add(enterSize);
    	popupPanel.add(userInput);
    	popupPanel.add(submitButton);
    	popupWindow.add(popupPanel);
    	popupWindow.setVisible(true);
    	checkGame = ifSimple;
    	
    	//Adding functionality to the button to decide if the enter button is clicked
    	submitButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			String actionCommand = e.getActionCommand();
    			//If statement to see if the enter button was clicked
    			if (actionCommand.equals("Enter")) {
    				//Variables to create the SOS Game
    				int boardSize = Integer.parseInt(userInput.getText());
    				SOSGame game = new SOSGame();
    				popupWindow.dispose();
    				//If statements to see if it is a simple or general game to see which one it should create
    				if (ifSimple == true) {
        				game.simpleGame(ifSimple, boardSize);
    				}
    				if (ifSimple != true) {
        				game.generalGame(ifSimple, boardSize);
    				}
    			}
    		}
    	});
	}
}