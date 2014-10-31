public class Card implements Comparable<Card>{
	
    // set the generic terms for suits to integers
    public final static int Clubs = 1;
    public final static int Diamonds = 2;
    public final static int Hearts = 3;
    public final static int Spades = 4;
    public final static String[] suits = {"dummy", "Clubs", "Diamonds", "Hearts", "Spades"}; // use a dummy variable for the index 0
    
    // set the generic terms for royal cards to integers
    public final static int Aces = 1;
    public final static int Jack = 11;
    public final static int Queen = 12;
    public final static int King = 13;
    public final static String[] values = {"dummy", "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"}; // use a dummy variable for the index 0
    
    
	private int suit; // use integers 1-4 to encode the suit
	private int value; // use integers 1-13 to encode the value
	
	public Card(int s, int v){
		//make a card with suit s and value v
	    suit = s;
	    value = v;
	}
	
	public int compareTo(Card c){
		// use this method to compare cards so they can be easily sorted
	    // this is why we converted the generic terms for certain cards to integers
	    // because it establishes a ranking among the cards that is useful for sorting them
	    c.getValue();
	    if (value < c.getValue()) 
	        return -1;
	    if (value > c.getValue())
	        return 1;
	    else {
	        if (suit < c.getSuit())
	            return -1;
	        if (suit > c.getSuit())
	            return 1;
	        return 0;
	    }
	        
	}
	
	public int getValue(){
	    return value;
	}
	
	public int getSuit(){
	    return suit;
	}
	
	public String toString(){
		// use this method to easily print a Card object
	    // for example, this translates the suit of "1" to print out "Clubs"
	    return values[value] + " of " + suits[suit];
	}
	

} 
