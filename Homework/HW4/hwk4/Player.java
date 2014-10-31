import java.util.ArrayList;
import java.util.Collections;

public class Player {
	
	private int score;
	private ArrayList<Card> hand; // the player's cards
		
	public Player(){		
		// create a player here
	    hand = new ArrayList<Card>();
	}

	public void addCard(Card c){
		// add the card c to the player's hand
	    hand.add(c);
	}

	public void removeCard(Card c){
		// remove the card c from the player's hand
	    hand.remove(c);
	}
	
	public void reset(ArrayList<Card> discard){
	    // resets the hand when the player wants to play a new round
	    hand.removeAll(discard);
	}

	public void sortHand(){
	    // sorts the player's cards
	    Collections.sort(hand);
 	}
	
	public ArrayList<Card> getHand(){
	    // shows the player's cards
	    return hand;
	}
	
	public void setScore(int s){
	    // updates the player's score depending on the winning or losing of tokens per game
	    score = s;
	}
	
	public int getScore(){
	    return score;
	}
}


