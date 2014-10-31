// **********************************
// readMe.txt
//
// by Akiko Iwamizu (UNI: AMI2119)
//
// **********************************

** Please refer to the comments that are in the code **

How to interact with code:
After compiling, a menu will prompt the user for what kind of 
Scabble help they need. Enter an integer to choose a menu option 
and follow the instructions. Depending on your choice, a txt file 
will be created with the results calculated from your input. After 
the first "round" the user will be prompted to get more help or not.
If you would like to continue, then follow the prompt's instructions.
_____________________________________________________________________
Code Explanation:

** WordLists.java:
- Reads in the dictionary file as an ArrayList that takes in 
a String argument because it is easier to collect and read the 
information this way. I will convert the output into an array later.
- A try/catch block was used to check if a dictionary file exists
or not.
- for loops are used in the following methods in order to add words
to the list of results for that method. 
- The "return temp.toArray" converts the ArrayList back to an array.


** WordListsTester.java:
- This is where the bulk of the try/catch blocks and exceptions are
written.
- Most of these try/catch blocks test if the user gave valid input
or not. If the user gives invalid input, then the user will be
prompted to enter another value to continue. This code tests if 
the user gave a valid integer and if they gave a symbol/character
when they shouldn't have.
- A boolean was used in order to allow the user to continue use 
the code more than once in a session. 
- Reads in the specific "dictionary.txt" file that was provided. 
- The getNumber and getLetter methods test if the user
input is valid or not.
- The output method uses a PrintWriter to give the user's results in
a text file format. It uses a for loop to collect the words from the
array and print them out into the appropriate text files that are
created in the main method.  