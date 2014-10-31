// **********************************
// readMe.txt
//
// by Akiko Iwamizu (UNI: AMI2119)
//
// **********************************

- For this problem, I used the files provided on CourseWorks.
- References used were class notes and files from Anusha's review 
section on Friday.
- In this file I will explain instructions for using the software, 
and how and why I chose to design the code the way I did. 
- The program that I used to write the code was Oracle.

_____________________________________________________________________

Game Logistics:
- Compile the BullsandCows.java file to run the software.
- This program simulates a game similar to Mastermind.
- After running the program, the computer guess a "random" number and 
does not reveal it to the player.
- The player is then prompted to input a 4 digit number (0-9999) to 
try and guess the computer's number.
- When the player's guess has a digit in the SAME position, a bull is
 returned.
- When the player's guess has a digit that is the in any one of the
 positions of the computer's guess, a cow is returned.
- The player wins the game when all 4 digits (or bulls) are the same
 as the computer's guess.
- The player is asked if they would like to continue or not, and is 
given the statistics of their play once the session has ended.

______________________________________________________________________

Code Explanation:
** BullsandCows Code:
- The BullsandCows file was left unchanged as instructed.

**Oracle Class Code:
- This is the code which will determine the computer's "random" guess,
and determine how many bulls and cows should be printed when the 
player inputs their guess.
- The Oracle method contains the initialization of variable "n", and
calls upon the method compGuess to run.
- The reset method will be called upon from the Game class to tell the
computer to guess another "random" number when the player wins and 
wants to play another round.
- For the compGuess method, I decided to break the four digit number
up into four individual "random" integers and concatenate them.
- In order to make sure the computer did not guess repeating digits,
I used a while loop to continue guessing a "random" number until
the integer was different from the other guessed digits.
- The getBulls method determines how many bulls to print when the 
player makes their guess. I created a variable called tempData, so
that if the player inputs a four digit number with repeating value,
then the repeating digit becomes a character instead of an integer.
This ensures that repeating digits only count once where bulls count
before cows. The tempData makes a duplicate of the computer's guess
in order to manipulate the duplicate with effecting the actual
stored computer guess. The StringBuilder class allows this to happen 
because it is designed to replace a mutable sequence with characters 
at the specified point. Thus this specified point is determined in 
the for loop, which uses a charAt to compare the indexes of the 
player's guess to the computer's guess. 
- The getCows method works in a similar way as getBulls. A for loop 
is used to determine if the one of the digits of the player's guess 
is in the computer's guess. toString takes the duplicate of the
computer's guess and returns a string object representing the value
of this integer. temp.indexOf(target) is then used to determine if
any of the digits of the player's guess exist in the computer's 
guess.

**Game Class Code:
- The Game Class allows the player to input their guess, prints out
the results of the game, and asks the player if they would like to
play again. 
- in the Game method, I initialized my variables. turnsBest was set
to equal Integer.MAX_VALUE because if it were set to 0, then the
player will never be able to beat that score since even once 
guess will count as 1 turn. Thus, we can assume, that the player's
turns will be less than the max value for an integer in java, and 
thus it will accurately keep a tab on the least amount of turns that
it takes the player to win.
- The first while loop in the play method is used as a condition 
to allow the player to choose to play again after they win the first
round. 
- The second while loop continues as long as the player's guess
does not equal to four bulls (as long as they haven't won).
- The printStats method was arranged similar to my notes from 
Anusha's review session example.



