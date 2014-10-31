//****************************************
//  This class models a n-sided die
//
//
//****************************************


public class Die {
    
    private int n;
    private int side;

// Signature is the formal parameter types and their order
// When you have 2 constructors with the same name in the class = overloading

    public Die(int shape){ // Explicit parameters inside the parathenses Implicit parameters are to the left of the period
	n=shape; 
	roll();
    }

    public Die(){
	n=6;
        roll(); // Initializing roll
    }

    public void roll() {
	side = (int) (Math.random() * n + 1); // Random number between 1 and n including n
    }

    public int getSide() { // An accessor method for returning the die
	return side;
    }


} //end class