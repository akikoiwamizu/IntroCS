import java.util.Scanner;
import java.io.*;

public class Tunes4
{

  public static void main(String[] args) throws IOException
  {
    File inFile = new File(args[0]);
    Scanner input = new Scanner(inFile);
    PrintWriter output = new PrintWriter(args[1]);
    
    CDCollection music = new CDCollection();

    String title;
    String artist;
    double cost;
    int tracks;

    try{
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
    }
    catch(BadMusicException e){
    System.out.println(e+"you can't add that crap");
    }  
        music.sort();
        output.print(music);
        output.close();
  }// end main
}//end class