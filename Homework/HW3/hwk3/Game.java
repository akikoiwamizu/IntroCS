//***************************************
// By: AKIKO IWAMIZU (AMI2119)
//
// This is the Game class for the 
// Bulls and Cows assignment
//
//
//****************************************

import java.util.Scanner;

public class Game {

    private Oracle computer;
    private Scanner input;
    private boolean playAgain;
    private int turns;
    private int games;
    private int turnsBest;
    private int turnsWorst;
    private int turnsTotal;

    
    public Game() {
        turnsBest = Integer.MAX_VALUE;
        turnsWorst = 0;
        turnsTotal = 0;
        turns = 0;
        games = 0;
        computer = new Oracle();
        playAgain = true;
    }


    public void play() {
        while(playAgain) 
        {
            System.out.print("Welcome to Bulls and Cows! ");
            int numBulls = 0;
            
            while(numBulls != 4) 
            {
                System.out.println("Please enter a 4 digit number: ");
                input = new Scanner(System.in);
                String userInput = input.nextLine();
                numBulls = computer.getBulls(userInput);          
                int numCows = computer.getCows(userInput);
                System.out.println("Bulls: " + numBulls + " & " + "Cows: " + numCows);
                turns++;
            } // End of this while loop
            
            games++;
            turnsTotal += turns;
            if (turns < turnsBest)
                turnsBest = turns;
            if (turns > turnsWorst)
                turnsWorst = turns;
            System.out.println("You Win! Amount of turns: " + turns +". Would you like to play again? (y/n): ");
            turns = 0;
            String cont = input.nextLine();
            if(cont.equals("y")) {
                playAgain = true;
                computer.reset(); 
            } else
                playAgain = false;
            
        } // End of while loop
        
        printStats(); // Prints player's statistics before closing the game
        
    } // End of play method

    
    public void printStats()
    {
        System.out.println("Your Overall Stats:");
        System.out.println("Total number of games played: "+games);
        System.out.println("Average turns it took to win: "+ (double)turnsTotal/games);
        System.out.println("Best game: " + turnsBest + " turns");
        System.out.println("Worst game: " + turnsWorst + " turns");
    }


} // End of Game class
