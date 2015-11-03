import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Strings{

    /* 
   Author: Dustin Hu
   Date: 09-10-2014
   Purpose: To let you change strings
   
   Fields:
       None

   Methods:
       permuted: Checks if a given string is a permutation
       replaceAll: Replaces all instances of a given string
     */


    public static void main(String[] args) {
	// AUthor: Dustin Hu
	// Date: 09-10-2014
	// Purpose: To be the m/ain 
	// Input: None
	// OUtput: None
	
	String old = "Hello there, my name is Dustin Hu, hello";

	System.out.println("The original string is " + old);
	System.out.println("After replacing all the e\'s with b\'s, we have the following:");
	System.out.println(replaceAll(old, " ", "  "));

	System.out.println("And now the question is, is that a permutation of the original string?");
	System.out.print("It\'s ");
	System.out.println(permuted(old, replaceAll(old, "e", "she")));

    }

    public static boolean permuted (String input, String checkAgainst){
	// AUthor: Dustin Hu
	// Date: 10-10-2014
	// Purpose: To check if an input string is a permutation of checkAgainst
	// Input: The input string and the string to check againts
	// Output: True if input is a permutatino of checkAgaints
	boolean permutated = true;
	boolean loop = true;

	
	String check;
	String inputLeft = input;
	String checkLeft = checkAgainst;
	
	if (input.length() != checkAgainst.length()){
	    permutated = false;
	}
	else{
	    while (loop){
		if (inputLeft.length() != 0 && checkLeft.length() != 0){
		    check = inputLeft.substring(0, 1);
		    if (checkLeft.indexOf(check) != -1){
			inputLeft = inputLeft.substring(1);
			checkLeft = checkLeft.substring(0, checkLeft.indexOf(check)) + 
			    checkLeft.substring(checkLeft.indexOf(check) + 1);

		    }
		    else{
			loop = false;
			permutated = false;
		    }
		}
		else{
		    loop = false;
		    permutated = true;
		}
	    }
	}
	return permutated;
    }

    public static String replaceAll(String input, String target, String replacement ){
	// AUthor: Dustin Hu
	// Date: 09-10-2014
	// Purpose: To replace all instances of a given target in string s
	// Input: The string from which you want things to be replaced, the target string to replace, and its replacement
	// Output: THe new string.
	String output = "";
	String backPart;
	int positionOfTarget = input.indexOf(target);

	while (positionOfTarget != -1){
	    output = output + input.substring(0, positionOfTarget) + replacement;
	    input = input.substring(positionOfTarget + target.length());
	    positionOfTarget = input.indexOf(target);
	}
	output = output + input;
	return output;

    }
}

