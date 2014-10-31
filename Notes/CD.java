//********************************************************************
//  CD.java       Author: Lewis/Loftus   (modified by cannon)
//
//  Represents a compact disc.
//********************************************************************

import java.text.NumberFormat;
import java.util.Locale;

public class CD implements Comparable<CD>
{
   private String title, artist;
   private double cost;
   private int tracks;

   //-----------------------------------------------------------------
   //  Creates a new CD with the specified information.
   //-----------------------------------------------------------------
   public CD (String name, String singer, double price, int numTracks)
   {
      title = name;
      artist = singer;
      cost = price;
      tracks = numTracks;
   }

   //-----------------------------------------------------------------
   //  Returns a string description of this CD.
   //-----------------------------------------------------------------  

   public String toString()
   {
      NumberFormat fmt = NumberFormat.getCurrencyInstance(Locale.US);

      String description;

      description = fmt.format(cost) + "\t" + tracks + "\t";
      description += title + "\t" + artist;

      return description;
   }


     public int compareTo(CD other) 
     {
  
    //if we want to compare by price use this:  
    int answer=0;
    if (this.cost-other.cost <0)
      answer=-1;
    if (this.cost-other.cost >0)
      answer=1;
    return answer;


      
    //if we want to compare by title use this:
//    return this.title.compareTo(other.title); // because there are two objects of type cd, you use "this" 
     } 

}