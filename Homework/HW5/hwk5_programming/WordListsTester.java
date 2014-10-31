import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

// WordListsTester

public class WordListsTester{

    public static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args){

        boolean keepPlaying = true;

        while(keepPlaying){

            WordLists word = new WordLists("dictionary.txt");
            boolean validInput = true; // tests if the input is valid or not
            int s = 0;

            // This is the menu
            
            do{
                validInput = true;
                System.out.println("Welcome to Scrabble Helper. What would you like help on?");
                System.out.println("Here are your options: (enter integer values)");
                System.out.println("1. Length n: returns words of length n.");
                System.out.println("2. Starts with: returns words of length n beginning with the letter.");
                System.out.println("3. Contains letter: returns words of length n containg the letter, but not beginning with it.");
                System.out.println("4. Vowel heavy: returns words of length n containing at least m vowels.");
                System.out.println("5. Multi letter: returns words with at least m occurences of the letter.");

                String selection = input.nextLine(); // tests to see if their input is an integer 
                try{
                    s = Integer.parseInt(selection);
                    if(s<1 || s>5){
                        validInput = false;
                        System.out.println("Not valid input. Please enter an integer 1-5.");
                    }
                }catch(NumberFormatException e){
                    validInput = false;
                    System.out.println("Not valid input.");
                }
            } while(!validInput);

            if(s == 1){
                System.out.println("Please enter an integer for the length of the word: ");
                int selection = getNumber();
                String[] wordsN = word.lengthN(selection);
                output(wordsN, "lengthN.txt");
            }

            if(s == 2){
                System.out.println("Please enter an integer for the length of the word: ");
                int selection = getNumber();
                System.out.println("Please enter a letter: ");
                char letter = getLetter(); 
                String[] wordsL = word.startsWith(selection, letter);
                output(wordsL, "startsWith.txt");
            }

            if(s == 3){
                System.out.println("Please enter an integer for the length of the word: ");
                int selection = getNumber();             
                System.out.println("Please enter a letter: ");
                char letter2 = getLetter();
                String[] wordsC = word.containsLetter(selection, letter2);
                output(wordsC, "containsLetter.txt");
            }
            
            if(s == 4){
                System.out.println("Please enter an integer for the length of the word: ");
                int selection = getNumber();             
                System.out.println("Please enter a minimum number of vowels: ");
                int vowels = getNumber();
                String[] wordsV = word.vowelHeavy(selection, vowels);
                output(wordsV, "vowelHeavy.txt");
            }
            
            if(s == 5){          
                System.out.println("Please enter a letter: ");
                char letter3 = getLetter();
                System.out.println("Please enter the minimum occurences: ");
                int selection = getNumber();   
                String[] wordsM = word.multiLetter(selection, letter3);
                output(wordsM, "multiLetter.txt");
            }

            System.out.println("Would you like more help? (y/n): ");
            String cont = input.nextLine();
            if(cont.equals("y")){
                keepPlaying = true;
            } else {
                keepPlaying = false;
            }
        }   
        
        input.close();

    }

    public static int getNumber(){
        boolean validInput = true;
        int i = 0;
        do{
            String response = input.nextLine();
            validInput = true; //resets the loop
            if(response.length() == 0){
                validInput = false;
                System.out.println("Please enter an integer:");
                continue;
            }
            try{
                i = Integer.parseInt(response);
                if(i<0){
                    validInput = false;
                    System.out.println("Please enter a valid number at least 0. Try again.");
                }
            }catch(NumberFormatException e){
                validInput = false;
                System.out.println("Please enter a valid number greater than 0. Try again.");
            }
        }
        while(!validInput);
        return i;

    }

    public static char getLetter(){ // allows you to test if the input is a valid letter
        boolean validInput = true;
        char c = 'a';
        do{
            validInput = true;
            String response = input.nextLine();

            if(response.length() == 0){
                validInput = false;
                System.out.println("Please enter a letter:");
                continue;
            }
            c = response.charAt(0);

            if(!Character.isLetter(c)){ // if c is not a letter
                System.out.println("Please enter a valid letter:");
                validInput = false;
                continue;
            }
        }while(!validInput);
        return c;
    }

    public static void output(String[] words, String fileName){
        try {
            PrintWriter out = new PrintWriter(fileName);
            if(words.length==0){
                System.out.println("There are no words that match your criteria. Sorry :(");
            }
            for(int i = 0; i < words.length; i++){
                out.println(words[i]);
            }
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Invalid file name.");
        } 
    }





}// end of class
