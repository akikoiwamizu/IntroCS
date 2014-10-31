// 2_21 TA OH Friday notes
/* * 
* Akiko Iwamizu
* UNI: ami2119
* A class that defines a Person,and relevant instance variables and methods
* */

public class Person { 
    /* Instance variables are always private; they concern information that is 'private' 
	    * and can only be accessed if it is "asked for"
		* */
	private String name; 
	private int age;
	private boolean took1004;
	
	// There are two ways of making a constructor (all variables must be initialized)
	// No parameters: (same name as the class) (you don't need to declare these variables because they already are in the "private" area)
	public Person()
	{
	    name = "Joe Lion";
		age = 260;
		took1004 = false;	
	}
	
	// With parameters:
	public Person(String n, int a, boolean t)
	{
	    name = n;
		age = a;
		took1004 = t;
	}
	
	// Can also use 'setter' methods to set/change variable's value
	// 'void' because it doesn't 'return' a value (this method is basically just changing the instance variable so it doesn't return anything)
	// This is called the method "signature" (what kind of method it is; this is public so you can access it outside of this class)
	
	public void setTook1004(boolean t) 
    {
	    took1004 = t;
	}
	
	// Can access values using 'getter' methods
	// NOTE RETURN TYPE - it's the same as the type of the instance variable!
	
	public String getName() // Because name is a 'String' you must also tell the method that it will return a 'String'
	{
	    return name;
    }
	
	// This is a method where you actually use the instance variables of the object to return a result.
	// This result is used in the tester.
	
	public boolean knowsJava()
	{ 
	    if(took1004)
		    return true;
		else
		    return false;
	}
	
}


	
	
	
	
	
	