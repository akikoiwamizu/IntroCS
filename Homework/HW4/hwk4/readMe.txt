// **********************************
// readMe.txt
//
// by Akiko Iwamizu (UNI: AMI2119)
//
// **********************************

** Please refer to the comments that are in the code **
_____________________________________________________________________
Code Explanation:
** PokerTest Code:
- The PokerTest file was left unchanged as instructed.

** Game Class Code:
- As stated in the homework prompt, there are two versions of the game:
one where the user can put in command line argument in the form of a 
hand, which is useful for testing the code;another, where the player
is dealt a random hand and can choose to add or remove cards, and 
place bets or "tokens" in order to build up a score
- For the testHand, I used a switch statement and charAt in order to 
translate the user input, so that my code could easily evaluate the hand
they inputted

** Deck Class Code:
- The Deck Class creates the 52 cards where 4 suits have 13 distinct 
values
- The shuffle method uses the idea of random swapping of indexes that we
discussed in class
- The deal method deals the top card in the deck and throws an error when
there are no cards remaining in the deck 

** Card Class Code:
- This is where I created cards of the deck
- I set generic terms for suits and royal cards to integers in order to
make ranking the cards easier when the sortHand method is called
- The compareTo method is used to compare the ranking of cards in order
to sort them easily
- The toString prints a Card object in a nice format for the player

** Player Class Code:
- This class creates a hand of cards that is represented by an ArrayList
- Here is where I created getter and setter methods for the player's score
that will be calculated when calling the checkHand method in the Game class
- The methods addCard and removeCard are called when the player can input
and index and change their hand using the alterHand method in Game class
- The reset method removes all of the cards from the player's hand when
the round is over and when they choose to play another game
