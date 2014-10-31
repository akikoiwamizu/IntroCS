// **********************************
// readMe.txt
//
// by Akiko Iwamizu (UNI: ami2119)
//
// **********************************

- For each problem separate class and tester files were created.
- References used were class notes and the BankAccount files on Courseworks.
- In this file I will explain instructions for using the software, and how and why I chose to design the code the way I did. 
- The main program that I used to write the code was NotePad++.

_____________________________________________________________________

Problem 1: Date.java and DateTest.java
- Compile the DateTest.java file to run the software.
- This program takes a month and date input from the user, translates those integers into a season, and then prints the season.
- After printing the first season, the program prompts the user if he/she would like to continue (I used this in order to easily verify that I received the expected results from my test cases).
_____________________________________________________________________

Problem 2: Monty.java and MontyTester.java
- Compile the MontyTester.java file to run the software.
- This program simulates the Monty Hall Paradox.
- After running the program, the result is two numbers: the amount of wins by switching doors and the amount of wins by staying with the original door chosen.
- Each count is tallied by incrementing the software 1000 times in order to see which of the two strategies is better.
- In theory, the probability of wins by switching should be about 2/3 and the probability of wins by staying should be about 1/3.
- My constructor was left empty because, from the advice of a TA, I did not need to declare variables which would be declared later in my "playGame" method. When running the program in MontyTester.java, when the Monty class is called upon, it will automatically look for the variables in the playGame method. 
- I decided to put the bulk of my code in the Monty.java file, so that my main method in the tester file was simple and short and would only need to examine the Monty class and print the results.

 







