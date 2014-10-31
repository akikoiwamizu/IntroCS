// *************************************
// Date.java
//
// by Akiko Iwamizu (UNI: ami2119)
//
// *************************************

public class Date 
{
    private String season;
    private int date;
    private int month;
    
    public Date(int mon, int day)
    {
        month = mon;
        date = day;
    }

    public void checkSeason()
    {

	// Now do calculations

        if(month==1 || month==2)
	    season="Winter";

        else if (month==4 || month==5)
	    season ="Spring";
	
        else if (month==7 || month==8)
	    season ="Summer";
	
        else if (month==10 || month==11)
	    season ="Fall";

        else if (month==3 && date<21)
	    season ="Winter";
	
        else if (month==3 && date>=21)
	    season ="Spring";
	
        else if (month==6 && date<21)
	    season ="Spring";
	
        else if (month==6 && date>=21)
	    season ="Summer";
	
        else if (month==9 && date<21)
	    season ="Summer";
	
        else if (month==9 && date>=21)
	    season ="Fall";
	
        else if (month==12 && date<21)
	    season ="Fall";

        else if (month==12 && date>=21)
	    season ="Winter";
	    

     } // End of checkSeason method


    public String getSeason()
     {
       checkSeason(); 
       return season;

     } // End of getSeason method


} // End of the class
