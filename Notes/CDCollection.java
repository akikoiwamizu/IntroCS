//********************************************************************
//  CDCollection.java       Author: Lewis/Loftus (modified by cannon)
//
//  Represents a collection of compact discs.
//********************************************************************

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Arrays;
public class CDCollection
{
    private CD[] collection;
    private int count;
    private double totalCost;

    //-----------------------------------------------------------------
    //  Constructor: Creates an initially empty collection.
    //-----------------------------------------------------------------
    public CDCollection ()
    {
        collection = new CD[100];
        count = 0;
        totalCost = 0.0;
    }

    //-----------------------------------------------------------------
    //  Adds a CD to the collection, increasing the size of the
    //  collection if necessary.
    //-----------------------------------------------------------------
    public void addCD (String title, String artist, double cost,
            int tracks) throws BadMusicException
    {
        if (artist.equals("Nickelback")){
            BadMusicException e = new BadMusicException("that music sucks");
            throw e;}
        if (count == collection.length)
            increaseSize();

        collection[count] = new CD (title, artist, cost, tracks);
        totalCost += cost;
        count++;
    }


    //-----------------------------------------------------------------
    //  Returns a report describing the CD collection.
    //-----------------------------------------------------------------
    public String toString()
    {
        NumberFormat fmt = NumberFormat.getCurrencyInstance(Locale.US);

        String report = "~~~~~~~~~~~~~~Wow Cool~~~~~~~~~~~~~~~~~~~~~~~\n";
        report += "My CD Collection\n\n";

        report += "Number of CDs: " + count + "\n";
        report += "Total cost: " + fmt.format(totalCost) + "\n";
        report += "Average cost: " + fmt.format(totalCost/count);

        report += "\n\nCD List:\n\n";

        for (int cd = 0; cd < count; cd++)
            report += collection[cd].toString() + "\n";

        return report;
    }



    public void sort() // we can use Arrays.sort to sort 
    {
        CD[] temp = new CD[count];
        for(int i=0;i<count;i++)
            temp[i]=collection[i];

        Arrays.sort(temp); // a class Arrays that sorts temp

        for(int i=0; i<count;i++)
            collection[i]=temp[i];

    } 


    /*
   public void sort() // We can implement selection sort
   {
        int min;
        CD temp;

        for(int i=0; i<count-1;i++)
        {
           min=i;
           for(int j=i+1;j<count;j++)
           {
              if(collection[j].compareTo(collection[min])<0)
                min=j;
           } // end inner for loop
           temp=collection[min]; // ex. if a[i] < a[min] then set a[min] = temp, where temp = a[i]
           collection[min]=collection[i]; //exchange in selection sort with a dummy "temp"
           collection[i]=temp;
        } // end outer for loop
   } //end method
     */







    //-----------------------------------------------------------------
    //  Increases the capacity of the collection by creating a
    //  larger array and copying the existing collection into it.
    //-----------------------------------------------------------------
    private void increaseSize ()
    {
        CD[] temp = new CD[collection.length + 100];

        for (int cd = 0; cd < collection.length; cd++)
            temp[cd] = collection[cd];

        collection = temp;
    }



}