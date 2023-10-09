import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class startMenuTest {
	//Initializing the start menu class
    private startMenu startMenu;
    
    //Test to see if the start menu class would start up
    @BeforeEach
    public void setUp() {
        startMenu = new startMenu();
    }

    //Test the GUI was created correctly
    @Test
    public void testStartMenuGui() {
        startMenu.startMenuGui();
        assertEquals("Game Mode Selection", startMenu.testWindow.getTitle());
        assertEquals(350, startMenu.testWindow.getWidth());
        assertEquals(350, startMenu.testWindow.getHeight());
    }
    
    //Test to see if the simple game was selected
    @Test
    public void testSimpleGameSelected() {
        startMenu.startMenuGui();
        //Checking to see if the simple game was chosen
        startMenu.simpleCheck.setSelected(true);
    }
    
    //Test to see if the general game was selected
    @Test
    public void testGeneralGameSelected() {
        startMenu.startMenuGui();
        //Checking to see if the general game was chosen
        startMenu.generalCheck.setSelected(true);
    }
}
