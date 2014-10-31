public class Deck {
	
	Card[] theDeck;
	private static int top; // the index of the top of the deck
	public static final int cardsInDeck = 52;
	public static final int numberOfCardsPerSuit = 13;
	public static final int numberOfSuits = 4;
	
	public Deck(){
		// make an unshuffled 52 card deck here
	    theDeck = new Card[cardsInDeck];
	    top = 0;
        int amountCards = 0;
        for(int suit=1; suit<=4; suit++){
           for(int value=1; value<=13; value++){
               theDeck[amountCards] = new Card(suit,value);
               amountCards++;
           }
       }
    
       shuffle(); // calls the shuffle method to "randomly" shuffle the deck
    }
   
	public void shuffle(){
		// shuffles the deck using the method of swapping discussed in lecture
	    for (int i=0; i< theDeck.length; i++)
	    {
	       int r = (int)(Math.random()*52);
	       Card temp1 = theDeck[i];
	       Card temp2 = theDeck[r];
	       theDeck[i] = temp2;
	       theDeck[r] = temp1;
	    }
	}
	
	public Card deal(){
		// this method deals the top card in the deck and throws an error when there are no cards left in the deck
	    if (cardsRemaining()==0){
	        System.out.print("No more cards.");
	        return null;
	    }
	    Card dealTop = theDeck[top];
	    top++; // increments top since the index of the top of the Deck array changes every time a card is dealt into the player's hand
	    return dealTop;
	}
	
	public static int cardsRemaining(){
	    // keeps track of how many cards are left as more are dealt
	    // this calculates the cards remaining by subtracting 52 by the index "top"
	    return cardsInDeck - top;
	}

}
