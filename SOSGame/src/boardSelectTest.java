import static org.junit.jupiter.api.Assertions.*;
import javax.swing.JTextField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//Class to test the board select class
public class boardSelectTest {
	//Initializing the board select class
    private boardSelect boardSelect;
    
    //Test to see if the set up of the board select class works
    @BeforeEach
    public void setUp() {
        boardSelect = new boardSelect();
    }
    
    //Test to see if a mock simple game selection would work
    @Test
    public void testBoardSelectMenu() {
        boolean ifSimple = true;
        boardSelect.boardSelectMenu(ifSimple);
        assertTrue(boardSelect.checkGame); 
    }
    
    //Test to see if a valid integer works
    @Test
    public void testValidIntegerInput() {
    	boardSelect.boardSelectMenu(true);
    	//Getting the integer user input
    	JTextField userInput = new JTextField(5);
        userInput.setText("12345");
        //Throwing out if the input is valid
        assertDoesNotThrow(() -> {
            int boardSize = Integer.parseInt(userInput.getText());
            assertTrue(true, "Input is a valid integer.");
        });
    }
    
    //Test to see if an invalid integer works
    @Test
    public void testInvalidIntegerInput() {
    	boardSelect.boardSelectMenu(true);
    	//Getting a character user input
    	JTextField userInput = new JTextField(5);
        userInput.setText("abcde"); 
        //Throwing out if the input is invalid
        assertThrows(NumberFormatException.class, () -> {
            int boardSize = Integer.parseInt(userInput.getText());
        });
    }
    
    //Test to see if an no integer works
    @Test
    public void testNoInput() {
    	boardSelect.boardSelectMenu(true);
    	//Getting a character user input
    	JTextField userInput = new JTextField(5);
        userInput.setText(""); 
        //Throwing out if the input is invalid
        assertThrows(NumberFormatException.class, () -> {
            int boardSize = Integer.parseInt(userInput.getText());
        });
    }
}
