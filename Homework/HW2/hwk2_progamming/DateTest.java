// ********************************
// DateTest.java
//
// by Akiko Iwamizu (UNI: ami2119)
//
// ********************************

import java.util.Scanner;

public class DateTest{
	
    public static void main(String[] args)
     {
        Scanner input = new Scanner(System.in);
        boolean cont = false;
        String in = "y";
        while(in.equals("y"))
          {
          cont = true;

          // Obtain month from user:
          System.out.println();
          System.out.println("Please enter a valid integer representing a month (1-12): ");
          int month;
          month = input.nextInt();

          // Obtain a date value from user:
          System.out.println();
          System.out.println("Please enter a valid integer representing a date: "); 
          int date;
          date = input.nextInt();
          System.out.println();

          // Print season result:
          String season;
          Date myDate;
          myDate = new Date(month, date);
          season = myDate.getSeason();
          System.out.println("The season is: " + season);

          // Continue?
          System.out.println();
          System.out.println("Do you wish to continue? Choose y or n");
          in = input.next();
          } // End of while loop

        System.out.println();
        System.out.println("Thanks for playing!");

     } // End of main method

} // End of class


