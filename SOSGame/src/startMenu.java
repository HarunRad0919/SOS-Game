import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

//Class for the starting menu 
public class startMenu {
	//Initializing variables for the starting menu
	JFrame testWindow = new JFrame();
	JPanel testPanel = new JPanel();
	JFrame popupWindow = new JFrame();
	JPanel popupPanel = new JPanel();
	final int WINDOW_WIDTH = 350;
	final int WINDOW_HEIGHT = 350;
	JButton testButton;
	ButtonGroup buttons;
	JRadioButton simpleCheck, generalCheck;
	boolean ifSimple;
	
	//Method for creating the start menu GUI
	public void startMenuGui() {
		//Adding functionality and design to the starting menu GUI 
		testWindow.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		testWindow.setTitle("Game Mode Selection");
    	testButton = new JButton("Enter");
    	ButtonListener buttonAction = new ButtonListener();
    	testButton.addActionListener(buttonAction);
    	simpleCheck = new JRadioButton("Simple Game");
    	generalCheck = new JRadioButton("General Game");
    	buttons = new ButtonGroup();
    	buttons.add(simpleCheck);
    	buttons.add(generalCheck);
    	testPanel.add(testButton);
    	testPanel.add(simpleCheck);
    	testPanel.add(generalCheck);
    	testWindow.add(testPanel);
    	testWindow.setVisible(true);
	}
	
	//Adding functionality to whenever the button is clicked
	class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String actionCommand = e.getActionCommand();
			//If statement for whenever a simple game is chosen and the user clicked enter
			if (actionCommand.equals("Enter") && simpleCheck.isSelected()) {
				//Creates the board select menu and closes the starting menu and passes along that the simple game was chosen.
				ifSimple = true;
				boardSelect popupGui = new boardSelect(); 
				popupGui.boardSelectMenu(ifSimple);
				testWindow.dispose();
			}
			//If statement for whenever a general game is chosen and the user clicked enter
			if (actionCommand.equals("Enter") && generalCheck.isSelected()) {
				//Creates the board select menu and closes the starting menu and passes along that the general game was chosen.
				ifSimple = false;
				boardSelect popupGui = new boardSelect(); 
				popupGui.boardSelectMenu(ifSimple);
				testWindow.dispose();
			}
		}
    }
}