import java.util.Scanner;
import java.io.*;

public class Tunes3
{

  public static void main(String[] args) throws IOException, 
BadMusicException
  {
    File inFile = new File(args[0]);
    Scanner input = new Scanner(inFile);
    PrintWriter output = new PrintWriter(args[1]);
    
    CDCollection music = new CDCollection();

    String title;
    String artist;
    double cost;
    int tracks;


    while(input.hasNext())
    {
        title=input.nextLine();
        artist=input.nextLine();
        cost=input.nextDouble();
        tracks=input.nextInt();
        music.addCD(title,artist,cost,tracks);
        if(input.hasNext())
            input.nextLine();
        if(input.hasNext())
            input.nextLine();
    }
      
        music.sort();
        output.print(music);
        output.close();
  }// end main
}//end class