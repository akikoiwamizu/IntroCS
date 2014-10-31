// ********************************
// MontyTester.java
//
// by Akiko Iwamizu (UNI: ami2119)
//
// ********************************

import java.util.Random; 
public class MontyTester{

    public static void main(String[] args)
	{
	    int winSwitchRate;
		int winStayRate;
	
		
		Monty game;
	    game = new Monty();
		winSwitchRate = game.getWinSwitchRate();
		winStayRate = game.getWinStayRate();
		
	    System.out.println("Wins by switching: " + winSwitchRate + ".");
		System.out.println();
		System.out.println("Wins by staying: " + winStayRate + ".");
		
	}
	
}
