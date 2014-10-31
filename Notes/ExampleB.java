import java.util.Scanner;
import java.io.*; // import to use PrintWriter

public class ExampleB
{

  public static void main(String[] args) 
  {
    try{  // A TRY BLOCK
      File inFile = new File(args[0]); // if file does not exist, then IOException(file not found exception) is thrown
      Scanner input = new Scanner(inFile);
      String word;
      PrintWriter output = new PrintWriter(args[1]); // if no command line args given, then ArrayIndexOutOfBounds is thrown
      while(input.hasNext()){
        word=input.nextLine(); // copies an entire line
        output.println(word); 
      }
      output.close(); // must have this to print!
    } // end of the try block!
    
    // after try block , you write catch statements!
    // exception hierarchies- importance of exceptions listed in order
    //exceptions: giving responses to problems created by the user
    catch(IOException e){  // file not found exception
      System.out.println("Please try again with correct input file name");
    }
    catch(ArrayIndexOutOfBoundsException e){ // array out of bounds exception
      System.out.println("At least two command line arguments ");
    }

  }
}