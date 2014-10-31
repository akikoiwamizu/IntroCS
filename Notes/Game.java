//******************************
//	Game class for Pig
//
//
//******************************


import java.util.Scanner;

public class Game {

    private Player p1;  //human player 
    private Player p2;  //computer player
    

    public Game(){
	p1=new Player(1);
	p2=new Player(0);
    }	


    public void play() {

	while(p1.getScore()<100 && p2.getScore()<100) {
	  p1.play();
	  if(p1.getScore()<100)
	    p2.play();
	}
	if(p1.getScore()>100)
		System.out.println("You win!");
	else
		System.out.println("You lose!");

    } // end of play method


   
} // end class  