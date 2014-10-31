//***************************************
// By: AKIKO IWAMIZU (AMI2119)
//
// This is the Oracle class for the 
// Bulls and Cows assignment
//
//
//****************************************

public class Oracle {
    
    private String solution;
    private StringBuilder tempData; 
    private int n;
    private int digit1;
    private int digit2;
    private int digit3;
    private int digit4;


    public Oracle() {
        n=10;
        compGuess();
    }
    
    
    public void reset() {
        compGuess();
    } // End of reset method

    
    public void compGuess() {
        digit1 = (int) (Math.random() * n);

        digit2 = (int) (Math.random() * n);
            while(digit2==digit1) {
                digit2 = (int) (Math.random() * n);
            }
   
        digit3 = (int) (Math.random() * n);
            while(digit3==digit2 || digit3==digit1 ) {
                digit3 = (int) (Math.random() * n);
            }
            
        digit4 = (int) (Math.random() * n);
            while(digit4==digit3 || digit4==digit2 || digit4==digit1) {
                digit4 = (int) (Math.random() * n);
            }
            
        solution = "";
        solution += digit1;
        solution += digit2;
        solution += digit3;
        solution += digit4;
        // System.out.println(solution); --> This was used for testing the program
        
    } // End of compGuess method

    public int getBulls(String guess) {
        tempData = new StringBuilder(solution);
        int countBulls = 0;
        for(int i = 0; i < guess.length(); i++)
        {
            char ch = guess.charAt(i);
            if (ch == solution.charAt(i))
            {
                countBulls++;
                tempData.setCharAt(i,'A');
            }
        }
        
        return countBulls;
        
    } // End of getBulls method
    
    public int getCows(String guess) {
        int countCows = 0;
        for(int i = 0; i < guess.length(); i++)
        {
            char target = guess.charAt(i);
            String temp = tempData.toString();
            int exists = temp.indexOf(target);
            if(exists >= 0)
            {
                countCows++;
                tempData.setCharAt(exists,'A');
            }
        }
        
        return countCows;

    } // End of getCows method
    
} // End of Oracle class
