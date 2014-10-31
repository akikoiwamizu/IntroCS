import java.util.Scanner;
import java.io.*;

public class Example
{

  public static void main(String[] args) throws IOException
  {
    File inFile = new File(args[0]);
    Scanner input = new Scanner(inFile);
    String word;
    PrintWriter output = new PrintWriter(args[1]);
    while(input.hasNext())
    {
      word=input.next();
      output.println(word); // It's not printing anything here. It puts it in a buffer for the mean time unless you close the file.
    }
      output.close(); // You must close the output stream! If you put the print statement inside the code, it will take TIME.
  }
}