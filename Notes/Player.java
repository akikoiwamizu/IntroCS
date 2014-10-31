//******************************
//	models a Player in Pig
//
//
//******************************


import java.util.Scanner;

public class Player {

    private boolean isHuman;
    private int score;
    private Die myDie;
    private Scanner input;

    public Player(int human){
	if (human>0)
	  isHuman=true;
	else
	  isHuman=false;

	myDie=new Die(6);
	score=0;
	input = new Scanner(System.in);
	
    }


    public void play() {
	if(isHuman)
	  playHuman();
	else
	  playComp();
    }


    private void playHuman() {
	int current=0;
	int runningTotal=0;
	int again=1;

	while(again==1 && score+runningTotal<100) {
	  myDie.roll();
	  current=myDie.getSide();
	  System.out.println("You rolled a " + current);
	  if (current == 1) {
	    again=0; 
	    runningTotal=0;
	  }
	  else {
	    runningTotal=runningTotal+current;
	    System.out.println("Your round total is now " + runningTotal);
	    System.out.println("Roll again? (1-yes, 0-no)");
	    again=input.nextInt();
	  }

	}//end while
	score=score+runningTotal;
	System.out.println("Your total score is: " + score);
    }//end method
    
    private void playComp() {
	int current=0;
	int runningTotal=0;

	while(runningTotal<22 && current != 1 && score+runningTotal<100) 
	{
	  myDie.roll();
	  current=myDie.getSide();
	  System.out.println("Computer rolled a " + current);
	  if (current == 1) {
	    runningTotal = 0;
	  }
	  else {
	    runningTotal = current+runningTotal; 	 
	  }

	  }//end while
	score=score+runningTotal;
	System.out.println("Computer is done");
	System.out.println("Computer total score is: " + score);
    } //end playComp


    public int getScore() {
	return score;
    }

} // end class  