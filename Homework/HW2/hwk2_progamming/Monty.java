// **********************************
// Monty.java
//
// by Akiko Iwamizu (UNI: ami2119)
//
// **********************************
import java.util.Random;

public class Monty 
{
    private int winSwitchRate = 0;	
	private int winStayRate = 0;
	private final int TRIES = 1000;	
	private static Random generator = new Random();
	private int doors;
	
	public Monty()
	{

	}
	
	public void playGame()
	{
		int winStay = 0;
		int winSwitch = 0;	    
		for(int i = 1; i <= TRIES; i++)
		{
		    // Create and initialize an array called "doors": 
			int [] doors = {0,0,0}; // 0 is a goat, 1 is a car
			doors[generator.nextInt(3)] = 1; // Put a 1 in a random door
			int pick = generator.nextInt(3); // Pick a door at random
			int car = generator.nextInt(3);; // Random place for the car
			if ( car != pick)
			// Car is in the other door and you win by switching
			{
			    winSwitch++;
			}
            // If you stay and win			
			else {
			    winStay++;
			
			}
			
	    } // End of for loop
		
		winSwitchRate = winSwitch;
		winStayRate = winStay;
		
	} // End of playGame
	
	public int getWinSwitchRate()
	{
	    playGame();
		return winSwitchRate;
	} // End of getWinSwitch method
	
	public int getWinStayRate()
	{
	    playGame();
		return winStayRate;
	} // End of getWinStay method
	
	
} // End of Monty class
		


