/* Anusha Balakrishnan
 * UNI: ab3596
 * Review Session 3/7
 * This is analogous to the Oracle in Bulls and Cows - this is the main class 
 * that contains the logic to propel the game forward!
 * 
 * Design question: Why can't all of this just be in the game class?
 */
public class SticksStrategy {
	public static final int STICKS_TOTAL = 21;
	private int sticks;
	public SticksStrategy()
	{
		sticks = STICKS_TOTAL;
	}
	
	public boolean hasSticksLeft()
	{
		// This can also be written as a single return statement! Any ideas?
		if(sticks > 0)
			return true;
		else
			return false;
	}
	
	public int getSticks()
	{
		return sticks;
	}
	/* Returns true if the player picks a number of sticks and loses the game; false otherwise */
	public void playerTurn(int choice)
	{
		sticks -= choice;
	}
	
	
	/* Here, the computer makes a move. This method returns the number of sticks that the computer
	 * chooses.
	 * The basic strategy here is:
	 * - If 1 stick is left, the computer automatically loses.
	 * - If there are 2 left, the computer must pick one.
	 * - If taking 2 would leave a number of sticks divisible by 3, what happens?
	 * 		- the player will be able to choose two sticks, causing the computer to lose
	 * - So, if taking 2 leaves an odd number of sticks, take 1
	 * - In all other cases, take 2
	 * 
	 * Design question: Why isn't this in the Game class?
	 */
	public int computerTurn()
	{
		if(sticks == 1)
		{
			sticks --; //computer is forced to pick the last stick
			return 1;
		}
		
		if(sticks==2) //force the player to pick the last stick!
		{
			sticks--;
			return 1;
		}
		
		if((sticks-2)%3==0)
		{
			sticks--;
			return 1;
		}
		else
		{
			sticks -= 2;
			return 2;
		}
	}
	
	public void reset()
	{
		sticks = STICKS_TOTAL;
	}
}
