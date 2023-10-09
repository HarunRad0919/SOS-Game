import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

//Class for all the SOS Games and their methods
public class SOSGame implements ActionListener{
	//Initializing all variables for GUI and components for some methods 
	JFrame gameFrame = new JFrame();
	JPanel playerOnePanel = new JPanel();
	JPanel playerTwoPanel = new JPanel();
	JPanel button_panel = new JPanel();
	JPanel title_panel = new JPanel();
	ButtonGroup buttonGroupie1, buttonGroupie2;
	JLabel firstPlayer, secondPlayer, gameTitle;
	JLabel announcer = new JLabel();
	JRadioButton SSelection1, OSelection1, SSelection2, OSelection2;
	Random random = new Random();
	boolean playerOneTurn;
	boolean gameOver = false;
	JButton[][] buttons;
	
	//Simple Game Method
	public void simpleGame(boolean ifSimple, int boardSize) {
		//Creating the components for the simple game GUI
		gameFrame = new JFrame("SOS Simple Game");
		buttons = new JButton [boardSize][boardSize];
		button_panel.setLayout(new GridLayout(boardSize,boardSize));
		gameFrame.setLayout(null);
		announcer = new JLabel("Tic-Tac-Toe");
		announcer.setFont(new Font("Ink Free", Font.BOLD, 75));
		title_panel.setBounds(0,0,2000,100);
		title_panel.add(announcer);
		gameFrame.add(title_panel);
		
		//Creating the components for player one (Being able to choose between S or O)
		firstPlayer = new JLabel("Player 1");
		SSelection1 = new JRadioButton("S");
		OSelection1 = new JRadioButton("O");
		buttonGroupie1 = new ButtonGroup();
		buttonGroupie1.add(SSelection1);
		buttonGroupie1.add(OSelection1);
		playerOnePanel.setBounds(200, 350, 200, 200);
		playerOnePanel.add(firstPlayer);
		playerOnePanel.add(SSelection1);
		playerOnePanel.add(OSelection1);
		
		//Creating the components for player two (Being able to choose between S or O)
		secondPlayer = new JLabel("Player 2");
		SSelection2 = new JRadioButton("S");
		OSelection2 = new JRadioButton("O");
		buttonGroupie2 = new ButtonGroup();
		buttonGroupie2.add(SSelection2);
		buttonGroupie2.add(OSelection2);
		playerTwoPanel.setBounds(1500, 350, 200, 200);
		playerTwoPanel.add(secondPlayer);
		playerTwoPanel.add(SSelection2);
		playerTwoPanel.add(OSelection2);
		gameFrame.add(playerOnePanel);
		gameFrame.add(playerTwoPanel);
		
		gameFrame.setVisible(true);
		//Method to create the buttons for the boards
		initializeBoard(buttons, boardSize);
		
		//Method to decide who gets the first turn
		firstTurn();
	}
	
	//General Game Method
	public void generalGame(boolean ifSimple, int boardSize) {
		//Creating the components for the general game GUI
		gameFrame = new JFrame("SOS General Game");
		buttons = new JButton [boardSize][boardSize];
		button_panel.setLayout(new GridLayout(boardSize,boardSize));
		gameFrame.setLayout(null);
		announcer = new JLabel("Tic-Tac-Toe");
		announcer.setFont(new Font("Ink Free", Font.BOLD, 75));
		title_panel.setBounds(0,0,2000,100);
		title_panel.add(announcer);
		gameFrame.add(title_panel);
		
		//Creating the components for player one (Being able to choose between S or O)
		firstPlayer = new JLabel("Player 1");
		SSelection1 = new JRadioButton("S");
		OSelection1 = new JRadioButton("O");
		buttonGroupie1 = new ButtonGroup();
		buttonGroupie1.add(SSelection1);
		buttonGroupie1.add(OSelection1);
		playerOnePanel.setBounds(200, 350, 200, 200);
		playerOnePanel.add(firstPlayer);
		playerOnePanel.add(SSelection1);
		playerOnePanel.add(OSelection1);
		
		//Creating the components for player two (Being able to choose between S or O)
		secondPlayer = new JLabel("Player 2");
		SSelection2 = new JRadioButton("S");
		OSelection2 = new JRadioButton("O");
		buttonGroupie2 = new ButtonGroup();
		buttonGroupie2.add(SSelection2);
		buttonGroupie2.add(OSelection2);
		playerTwoPanel.setBounds(1500, 350, 200, 200);
		playerTwoPanel.add(secondPlayer);
		playerTwoPanel.add(SSelection2);
		playerTwoPanel.add(OSelection2);
		gameFrame.add(playerOnePanel);
		gameFrame.add(playerTwoPanel);
		
		gameFrame.setVisible(true);
		//Method to create the buttons for the boards
		initializeBoard(buttons, boardSize);
		
		//Method to decide who gets the first turn
		firstTurn();
	}
	
	//Method for creating the board with buttons
	public void initializeBoard(JButton[][] buttons, int boardSize) {
		//For loop to go through each array of buttons and add functionality and design to them
		for (int i = 0; i < buttons.length; i++) {
			for (int k = 0; k < buttons[i].length; k++) {
				buttons[i][k] = new JButton("");
				buttons[i][k].setBackground(Color.white);
				buttons[i][k].setFocusable(false);
				buttons[i][k].addActionListener(this);
				button_panel.add(buttons[i][k]);
			}
		}
		//Adding the buttons onto the game GUI
		button_panel.setBounds(600, 100, 750, 750);
		gameFrame.add(button_panel);
	}

	//Method for adding an action to whenever a player clicks the board
	public void actionPerformed(ActionEvent e) {
		//For loop to go through each array of buttons
		for (int i = 0; i < buttons.length; i++) {
			for (int k = 0; k < buttons[i].length; k++) {
				//If statement to check if the button was clicked
				if (e.getSource() == buttons[i][k]) {
					//If statement to see if it is player ones turn
					if (playerOneTurn) {
						//If statement to see if the place on the board is taken
						if (buttons[i][k].getText() == "") {
							//If S is selected then the spot on the board will added with an S
							if (SSelection1.isSelected()) {
								buttons[i][k].setText("S");
								playerOneTurn = false;
								announcer.setText("Player Two Turn");
							}
							//If O is selected then the spot on the board will added with an O
							if (OSelection1.isSelected()) {
								buttons[i][k].setText("O");
								playerOneTurn = false;
								announcer.setText("Player Two Turn");
							}
						}
					}
					//Else statement for if it wasn't player ones turn
					else {
						//If statement to see if the place on the board is taken
						if (buttons[i][k].getText() == "") {
							//If S is selected then the spot on the board will added with an S
							if (SSelection2.isSelected()) {
								buttons[i][k].setText("S");
								playerOneTurn = true;
								announcer.setText("Player One Turn");
							}
							//If O is selected then the spot on the board will added with an O
							if (OSelection2.isSelected()) {
								buttons[i][k].setText("O");
								playerOneTurn = true;
								announcer.setText("Player One Turn");
							}
						}
					}
				}
			}
		}
	}
	
	//Method to check who gets the first turn
	public void firstTurn() {
		//If else statements with a random number generator to decided if it is player one or two's turn
		if (random.nextInt(2) == 0) {
			playerOneTurn = true;
			announcer.setText("Player One Turn");
		}
		else {
			playerOneTurn = false;
			announcer.setText("Player Two Turn");
		}
	}
	
	//Method to check for a simple game win
	public void winSimpleGame() {
		
	}
	
	//Method to check for a general game win
	public void winGeneralGame() {
		
	}
	
}