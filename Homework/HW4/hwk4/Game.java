import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Game {
    
    private Player p;
    private Deck cards;
    private boolean testMode; 
    private boolean keepPlaying;
    private Deck deck = new Deck();
    
    public Game(String[] testHand){
        // this constructor is for testing the hands
        System.out.println("Welcome to Akiko's Poker written in Java!");
        System.out.println();
        testMode = true;
        p = new Player();
        cards = new Deck();
        
        if(testHand.length != 5)
        {
            System.out.print("Error");
            System.exit(0);
        }
        
        for (int i=0; i<testHand.length; i++)
        {
            String s = testHand[i];
            char c = s.charAt(0);
            int suit=0;
            switch(c)
            {
            case 'c':
                suit=1;
                break;
            case 'd':
                suit=2;
                break;
            case 'h':
                suit=3;
                break;
            case 's':
                suit=4;
                break;
            }
            
            String value1 = s.substring(1);
            int value = Integer.parseInt(value1);
            Card cardInHand = new Card(suit, value); 
            p.addCard(cardInHand);
        }
        
    }
    
    public Game(){
        // This constructor is to actually play a normal game
        System.out.println("Welcome to Akiko's Poker written in Java!");
        System.out.println();
        p = new Player();
        p.setScore(50);
        play();
        keepPlaying = true;
    }

    public void play(){
        // this method should play the game 
        if(testMode){
            p.sortHand();
            System.out.println(p.getHand());
            checkHand(p.getHand());
            System.exit(0);
        }
        
        while(keepPlaying)
        {
            cards = deck;
            for (int i=0; i<5; i++)
            {
                Card cardInHand = cards.deal();
                p.addCard(cardInHand); 
            }
            p.sortHand();
            System.out.println(p.getHand());
            
            // after printing out the player's had, call a method so that they can remove and add cards to their hand
            alterHand();
            checkHand(p.getHand());
            
            // calculates and updates the player's score depending on the hand 
            int score = p.getScore();
            p.setScore(score-1);
            calculateScore();
            
            // asks the player if they would like to play another round. If yes, then their current hand is discarded
            // and they are given a new hand. If no, then their game results are printed via the printStats() method
            System.out.println("Would you like to play again? (y/n): ");
            Scanner in = new Scanner(System.in);
            String cont = in.nextLine();
            if(cont.equals("y")){
                keepPlaying = true;
                p.reset(p.getHand());
            } else {
                keepPlaying = false;
                printStats();
            }
            
            // the game will end if the player loses all of their tokens, or if the deck runs out of cards
            if(score == 0){
                System.out.println();
                System.out.println("I'm sorry, but you lost all of your tokens.");
                System.out.println();
                System.out.print("~Thanks for playing~");  
                printStats();
                System.out.println();
                System.exit(0);
            }

        } // end of while loop
    } // end of play method
    
    
    

    public void printStats(){
        // prints the total amount of tokens after the end of the game
        System.out.println("Your Overall Stats: ");
        if(p.getScore() == 50)
            System.out.println("Nice! You didn't lose any tokens! So, like, you have 50 tokens still...duh!");
        if(p.getScore() > 50)
            System.out.println("Congrats! You won: " + (p.getScore()-50) + " token(s)! For a total of: " + p.getScore() + " tokens.");
        if(p.getScore() < 50)
            System.out.println("Bummer! You lost: " + (50-p.getScore()) + " token(s). For a total of: " + p.getScore() + " tokens.");
    }

    

    public String checkHand(ArrayList<Card> hand){
        // this method should take an ArrayList of cards as input and 
        // then determine what evaluates to and return that as a String
        if(royalFlush(hand) == true){
            System.out.print("Your hand is a royal flush!");
                p.setScore(p.getScore() + 250);
        }
        else if(straightFlush(hand) == true){
            System.out.print("Your hand is a straight flush!");
            if(keepPlaying==true)
                p.setScore(p.getScore() + 50);

        }
        else if(fourOfAKind(hand) == true){
            System.out.print("Your hand is a 4 of a kind!");
            if(keepPlaying==true)
                p.setScore(p.getScore() + 25);
        }
        else if(isFullHouse(hand) == true){
            System.out.print("Your hand is a full house!");
            if(keepPlaying==true)
                p.setScore(p.getScore() + 6);
        }
        else if(isFlush(hand) == true){
            System.out.print("Your hand is a flush!");
            if(keepPlaying==true)
                p.setScore(p.getScore() + 5);
        }
        else if(isStraight(hand) == true){
            System.out.print("Your hand is a straight!");
            if(keepPlaying==true)
                p.setScore(p.getScore() + 4);
        }
        else if(threeOfAKind(hand) == true){
            System.out.print("Your hand is a 3 of a kind!");
            if(keepPlaying==true)
                p.setScore(p.getScore() + 3);
        }
        else if(twoPairs(hand) == true){
            System.out.print("Your hand is a two pair!");
            if(keepPlaying==true)
                p.setScore(p.getScore() + 2);
        }
        else if(onePair() == true){
            System.out.print("Your hand is a one pair!");
            if(keepPlaying==true)
                p.setScore(p.getScore() + 1);
        }
        else 
            System.out.print("Your hand is really bad...dang");

        return "Nothing";  
        
    }
    
    
    public void calculateScore(){
        // evaluates the amount of tokens the player should receive depending on the hand
        // add points to player's score
        // prints out after each hand
        System.out.println();
        System.out.println("Total points:" + p.getScore());
    }
    
    public void alterHand(){
        // asks the player which cards they would like to remove from their hand (if any) and converts the index input into a string
        // I used the StringTokenizer to get rid of the delimiters and remove the individual cards at each of the indexes 
        // called by the player
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the index of the card you want to remove (ie. 0 1 2 3 4), but if you don't want to remove any then just press enter): ");
        String index = input.nextLine();
        StringTokenizer individual = new StringTokenizer(index); 
        ArrayList<Integer> numbers = new ArrayList<Integer>(); // creates an array list of ints
        
        while(individual.hasMoreTokens()){
            String token = individual.nextToken(); 
            int position = Integer.parseInt(token);// takes out the individual "tokens" and makes them into ints
            numbers.add(position); // adding numbers to the array list
            
        }
        Collections.sort(numbers);
        Collections.reverse(numbers);
        
        for(int i=0; i<numbers.size(); i++){
            // removes the cards my index in the array list
            p.removeCard(p.getHand().get(numbers.get(i)));
        }
        
        for(int i=0; i<numbers.size(); i++){
            // deals cards to the player's hand in order to replace the cards that were removed
            Card c = cards.deal();
            p.addCard(c);
            p.sortHand();
        }
            
            System.out.println("Your updated hand:" + p.getHand());
        
        
    }
    
    // the following methods are the set rules for different hands of poker
    
    public boolean onePair(){
        return countKinds(p.getHand(), 2);
    }
   
    public boolean twoPairs(ArrayList<Card> hand){
        int counter = 0;
        for (int i=0; i < hand.size(); i++){ 
            int temp1 = hand.get(i).getValue();
            for(int j=0; j < hand.size(); j++){
                int temp2 = hand.get(j).getValue();
                if(i != j) //don't check the card against itself
                    if(temp1 == temp2)
                        counter++;
                if(counter == 4 && !fourOfAKind(hand))
                    return true;
            }
        }
        return false;
    }
    
    
    public boolean isStraight(ArrayList<Card> hand){
        int start = 1;
        if (hand.get(0).getValue() == 1 && hand.get(1).getValue() == 10) //allows for ace to count as a high card when royal flush is calls this method
            start = 2;
        int value = hand.get(start-1).getValue();
        for (int i=start; i < hand.size(); i++){
            if (hand.get(i).getValue() != value + 1)
                return false;
            value++;
                    
        }
        return true;
    }
    
    public boolean isFlush(ArrayList<Card> hand){
        int suit = hand.get(0).getSuit();
        for (int i=0; i < hand.size(); i++){
            if (hand.get(i).getSuit() != suit)
                    return false;
        }
        return true;

    }
   
    public boolean isFullHouse(ArrayList<Card> hand){
       if(threeOfAKind(hand) == true && onePair() == true ){
           return true;
       }
       return false;
   }
   
    public boolean countKinds(ArrayList<Card> hand, int numKind){
        for(int kind=0; kind<=Deck.numberOfCardsPerSuit; kind++){
            int kindCounter = 0;
            for (int i=0; i < hand.size(); i++){
                int value = hand.get(i).getValue();
                if (value == kind)
                    kindCounter++;
            }
            if (kindCounter==numKind)
                return true;
            }
        return false; 
       }

    public boolean fourOfAKind(ArrayList<Card> hand){
        int count = 0;
        for(int i = 0; count<3 && i<hand.size(); i++ ){
            count = 0;
            for(int j=i+1; j<hand.size(); j++)
                if(hand.get(i).getValue()==hand.get(j).getValue())
                    count++;
        }
        return count==3;
    }
    
    public boolean threeOfAKind(ArrayList<Card> hand){
        int count = 0;
        for(int i = 0; count<2 && i<hand.size(); i++ ){
            count = 0;
            for(int j=i+1; j<hand.size(); j++)
                if(hand.get(i).getValue()==hand.get(j).getValue())
                    count++;
        }
        return count==2;
    }
    
    public boolean straightFlush(ArrayList<Card> hand){
        if(isFlush(hand) && isStraight(hand)){
            return true;
        }
        return false;
    }
   
    public boolean royalFlush(ArrayList<Card> hand){
        if (!straightFlush(hand))
            return false;
        if (hand.get(0).getValue() == 1 && hand.get(1).getValue() == 10) //Allows for the ace to count as a high card
            return true;
        else
            return false;
    }
    

}

