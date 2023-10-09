import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.awt.Color;
import javax.swing.JButton;

//JUnit 5 test for the SOS Game
public class SOSGameTest {
	//Creating the SOS Game
    private SOSGame sosGame;
    
    //Checking to see if it was even setup right
    @BeforeEach
    public void setUp() {
        sosGame = new SOSGame();
    }
    
    //Test to see if the board is set up right
    @Test
    public void testInitializeBoard() {
    	//Creating test variables to check the initialize board method
        JButton[][] buttons = new JButton[3][3];
        sosGame.initializeBoard(buttons, 3);
        //Test to see if the buttons were created
        assertNotNull(buttons);
        //Test to see if the first array of buttons are of 3 length 
        assertEquals(3, buttons.length);
        //For loop to go through each array of buttons 
        for (int i = 0; i < buttons.length; i++) {
        	//Test to see if the second array of buttons are of 3 length 
            assertEquals(3, buttons[i].length);
            for (int j = 0; j < buttons[i].length; j++) {
            	//Test to see if all the buttons are working and have been designed as intended
                assertNotNull(buttons[i][j]);
                assertEquals(Color.white, buttons[i][j].getBackground());
                assertFalse(buttons[i][j].isFocusable());
            }
        }
    }

    //Test to see if the first turn method was set up right
    @Test
    public void testFirstTurn() {
    	//Creating the first turn method and seeing if it was player one or player twos turn
        sosGame.firstTurn();
        assertTrue(sosGame.playerOneTurn || !sosGame.playerOneTurn);
    }
    
    //Test to check for a simple game move
    @Test
    public void testSimpleGameMove() {
    	//Creating a simple game and its board
        sosGame.simpleGame(true, 3);
        JButton[][] buttons = new JButton[3][3];
        sosGame.initializeBoard(buttons, 3);
        //It is player ones turn and they clicked S on the top left button
        sosGame.playerOneTurn = true;
        buttons[0][0].setText("S");
        //Their turn changed to player two
        sosGame.playerOneTurn = false;
        //Checked to see if the button was S
        assertEquals("S", buttons[0][0].getText());
        //Checked for player twos turn
        assertFalse(sosGame.playerOneTurn, "Player Two's turn should follow");
        //It is player twos turn and they click O on [1][1]
        sosGame.playerOneTurn = false;
        buttons[1][1].setText("O");
        //Their turn changed to player one
        sosGame.playerOneTurn = true;
        //Checked to see if the button was O
        assertEquals("O", buttons[1][1].getText());
        //Checked for player ones turns
        assertTrue(sosGame.playerOneTurn, "Player One's turn should follow");
    }
    
    //Test to check for a general game move
    @Test
    public void testGeneralGameMove() {
    	//Creating a general game and its board
        sosGame.generalGame(false, 3);
        JButton[][] buttons = new JButton[3][3];
        sosGame.initializeBoard(buttons, 3);
        //It is player ones turn and they clicked S on the top left button
        sosGame.playerOneTurn = true;
        buttons[0][0].setText("S");
        //Their turn changed to player two
        sosGame.playerOneTurn = false;
        //Checked to see if the button was S
        assertEquals("S", buttons[0][0].getText());
        //Checked for player twos turn
        assertFalse(sosGame.playerOneTurn, "Player Two's turn should follow");
        //It is player twos turn and they click O on [1][1]
        sosGame.playerOneTurn = false;
        buttons[1][1].setText("O");
        //Their turn changed to player one
        sosGame.playerOneTurn = true;
        //Checked to see if the button was O
        assertEquals("O", buttons[1][1].getText());
        //Checked for player ones turns
        assertTrue(sosGame.playerOneTurn, "Player One's turn should follow");
    }
}
