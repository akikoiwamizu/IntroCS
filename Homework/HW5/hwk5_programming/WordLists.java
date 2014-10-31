//Word List
//WordLists(String fileName):  a constructor that takes the name of the dictionary file as the only parameter.
//ctrl A + ctrl I = formats code

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class WordLists{

    ArrayList<String> dictionary = new ArrayList<String>();    

    public WordLists(String fileName){        
        readDictionary(fileName);

    }

    public void readDictionary(String fileName){
        File file = new File(fileName);
        try { // try catch block to check for a dictionary file
            Scanner sc = new Scanner(file);
            while(sc.hasNext()){ // reads in dictionary until there are no lines left
                String line = sc.nextLine();
                dictionary.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File" + " " + fileName + " " + "does not exist. Program terminated");

        }

    }

    //lengthN(int n):  returns an array of words of length n.

    public String[] lengthN(int n){
        ArrayList<String> temp = new ArrayList<String>();
        for(int i=0; i<dictionary.size(); i++){
            String word = dictionary.get(i);
            if (word.length() == n) //checking length of the words in the dictionary
                temp.add(word); //adding it into the list
        }
        return temp.toArray(new String[0]); //converts the arraylist into an array

    }

    //startsWith(int n, char firstLetter):  returns an array of words of length n beginning with the letter firstLetter

    public String[] startsWith(int n, char firstLetter){
        String[] temp = lengthN(n); //calls on the method lengthN and makes a list of words of length n
        ArrayList<String> match = new ArrayList<String>();
        for(int i=0; i<temp.length; i++){
            String word = temp[i];
            char c = word.charAt(0);
            if(c == firstLetter) //matches the user's first letter to the word
                match.add(word);
        }
        return match.toArray(new String[0]);
    }

    //containsLetter(int n, char included):  returns an array of words of length n containing the letter included but not beginning with it.

    public String[] containsLetter(int n, char included){
        String[] temp = lengthN(n);
        ArrayList<String> matches = new ArrayList<String>();
        for(int i=0; i<temp.length; i++){
            String word = temp[i];
            char c = word.charAt(0);
            if(c != included){ // if c is not contained in the first letter of a word
                if(word.contains("" + included)) // use "" + to cast the c to a String in order to find if c is contained in a word
                    matches.add(word);
            }
        }
        return matches.toArray(new String[0]);
    }

    // vowelHeavy(int n, int m):  returns an array of words of length n containing at least m vowels.
    
    public String[] vowelHeavy(int n, int m){
        String[] temp = lengthN(n);
        ArrayList<String> matches = new ArrayList<String>();
        for(int i=0; i<temp.length; i++){
            int counter = 0;
            String word = temp[i]; // this word is to look at how many vowels are contained in it
            for(int j=0; j<word.length(); j++){
                char c = word.charAt(j);
                if (c == 'a' || c == 'e' || c == 'i' || c== 'o' || c== 'u')
                    counter++;
            }

            if(counter >= m)
                matches.add(word);
        }
        return matches.toArray(new String[0]);
    }

    //multiLetter(int m, char included):  returns an array of words with at least m occurrences of the letter included.
   
    public String[] multiLetter(int m, char included){
        ArrayList<String> matches = new ArrayList<String>();
        for(int i=0; i<dictionary.size(); i++){
            String word = dictionary.get(i);
            int counter = 0;
            for(int j=0; j<word.length(); j++){
                char c = word.charAt(j);
                if(c == included)
                    counter++;
            }
            if(counter >= m)
                matches.add(word);
        }
        return matches.toArray(new String[0]);
    }



}// end of class