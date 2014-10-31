/* Guest Lecturer 3/5/2014

Make your problem as small as humanly possible
Accept the boundaries of your current knowledge

*/ 

/*
import java.util.Scanner;

public class Guest {

    public static void main(String[] args){
	    System.out.println("Hello");
		Game g = new Game();
		g.play();
	
	}
	
}
*/

public class Game {
   
    public Game(){
	    String word = "living";
		
		// I always need a constructor
		public Game(){
		    print("Constructing Game object");
		}
		
		// And I need a play method
		public void play(){
	        P.print("Constructing Game object");
		}
	
	   
	    // and I need a play method
	    public void play(){
	        P.print("Play!");
	
	    }
	}    
	    
}



// Print Class
public class P{

    public static void print(String s){
	    System.out.println(s);
	}
	
	public static void print(int num){
	    System.out.println(num);
	}
}



// Scaffold Analyzer class
public class ScaffoldAnalyzer {
    
	private String secretWord;
	// private char[] guessedCharacters;
	
	
    public ScaffoldAnalyzer(String word){
	    secretWord = word;
		P.print("Word in scaffold analyzer:" + word);	
		Integer.parseInt("1234");
		// 1234
		String digits = "1234";
		char first = digits.charAt(0);
	}
	
	public int getCows(String secret, String guess){
	    return 1;
	}
	
	
	public int getWordLength(){
	    return secretWord.length();
	}
	
	public void print(CurrentScaffold){
	    for(int i = 0; i < getWordLength(); I++){
            System.out.print("_ ");		
	}
	// printCurrentScaffold()
	// print dashes whenever the characters in that place
	// haven't been guessed yet
	
	// without arrays you need to keep track of all of the characters
	// 1. create a class that is responsible for the digits, then create a tester class
	// 2. create getCows method: keeps track of how many cows are not in the right position. Does this string include this digit?
	// Do i need to count the bulls first or the cows first?
	
	// analyzeNewGuess()
}



// Scaffold Analyzer class tester
public class ScaffoldAnalyzerTest{

    public static void main(String[] args){
	    ScaffoldAnalyzer analyzer = new ScaffoldAnalyzer("cannon");
		P.print("WORD LENGTH: " + analyzer.getWordLength());
		//System.out.println(analyzer.getWordLength());
		analyzer.printCurrentScaffold();
	}
}



// to submit the homework in eclipse you need to delete the "package hwk4" in every file
// to compile everything in that file use " javac *.java "


