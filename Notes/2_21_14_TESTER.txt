// 2_21_14_TESTER
/*
 * Akiko Iwamizu
 * ami2119
 * Tests the Person class
 * */
 
import java.util.Scanner

public class PersonTester
{
    public static void main(String[] args) 
	{
	    Scanner in = new Scanner(System.in);
		System.out.print("Enter a name: ");
		String name = in.nextLine();
		System.out.print("Enter age: ");
		int age = Integer.parseInt(in.nextLine());
		System.out.print("Did you take 1004? (y/n) ");
		boolean took1004 = false;
		String input = in.nextLine();
		System.out.println();
		if(input.equals("y"))
		    took1004 = true;
    
		// Create a new object of Person with the input we just got from the user(this refers to the constructor WITH parameters):
	
	    Person you = new Person(name, age, took1004);
		
	    // Create a generic object of Person using the default constructor which corresponds to the constructor with no parameters
		
		Person joe = new Person();
		
		System.out.println("Hi," + you.getName() + "!"
		if(you.knowsJava())
		    System.out.println("Yay, you know Java!");
		else
		    System.out.println(" :( You should take 1004!");
		System.out.println();
		
		if(joe.knowsJava())
		    System.out.println(joe.getName() + " knows Java!");
		else
		    System.out.println("Oops, " +joe.getName()+ "should take 1004!");
	}
}
		