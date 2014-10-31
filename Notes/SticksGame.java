import java.util.Scanner;

/* This is the 'Game' class that mediates the Game between the player and the 'Oracle'
 * - which in this case is the SticksStrategy class. Note that this class doesn't really know
 * much about the background of the game being played!! (and it doesn't make any moves, etc.)
 * It simply takes input and prints information to the user about the state of the game, 
 * while SticksStrategy does all the work.
 */
public class SticksGame {
	
	private int wins;
	private int games;
	// Why does the Game need an object of strategy as an instance variable?
	private SticksStrategy strategy;
	public SticksGame()
	{
		wins = 0;
		games = 0;
		strategy = new SticksStrategy();
	}
	
	public void play()
	{
		Scanner in = new Scanner(System.in);
		boolean again = true;
		while(again)
		{
			games++;
			System.out.println("Welcome to 21 Sticks!");
			while(strategy.hasSticksLeft())
			{
				System.out.println("There are "+ strategy.getSticks()+" sticks left.");
				System.out.println("How many sticks do you want to pick? You can only pick 1 or 2.");
				int choice = Integer.parseInt(in.nextLine());
				
				strategy.playerTurn(choice);
				// If there are no more sticks after the player's turn, they lost!
				if(!strategy.hasSticksLeft()) 
					System.out.println("You lost! :(");
				else
				{
					//The computer plays its turn
					int computerChoice = strategy.computerTurn();
					//Display the number of sticks the computer chose
					System.out.println("The computer chose "+computerChoice+" stick(s).");
					//If the computer picked the last stick, the player won!
					if(!strategy.hasSticksLeft())
					{
						wins++;
						System.out.println("You won!:)");
					}
				}
			}
			
			System.out.println("Would you like to play again? (Y/N)");
			String ch = in.nextLine();
			if(ch.equals("Y"))
			{
				again = true;
				strategy.reset(); //Why do we need this here?
				//You could also just create a new object of SticksStrategy here instead
			}
			else
				again = false;
			
		}
		
		System.out.println("Your stats:");
		System.out.println("Total number of games played: "+games);
		System.out.println("% of games won: "+ (double)wins/games);
	}
}
