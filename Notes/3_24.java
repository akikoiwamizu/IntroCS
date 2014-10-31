// 3_24 Notes
//Simple program for demonstrating integer arrays

public class IntegerArray{
    publis static void main(String[] args){
	
	
	    int[] numbers = new int[20] //indexing for the array #s is 0-19
		for (int i=0; i<numbers.length; i++) //fills array, length is not a method because it doesn't have "()", thus it is a public instance variable
		    numbers[i]=2*i;     
	    
	    numbers[11] = 10000001;
	    
	    for (int i=0; i<numbers.length; i++)
	        System.out.println(numbers[i]);