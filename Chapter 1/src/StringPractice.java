import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StringPractice {
	public static void main(String[] args) { 
        Scanner input = new Scanner(System.in);
		
        String s = input.next();
		lastFirst(s);
    } 
	
	// returns true if c is one of the characters typically used to represent a "face card" in a standard deck of playing cards.
	public static boolean isFace(char c) {
		if (c == 'J' || c == 'j' || c == 'Q' || c == 'q' || c == 'K' || c == 'k' || c == 'A' || c == 'a') {
			return true;
		} 
		else {
			return false;
		}
	}
	
	// returns the index of the first face-card letter in s or -1 if s contains no face-card letters
	public static int indexOfFirstFace(String s) {
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (isFace(c) == true) {
				return i;
			}
		}
		return -1;
	}

	/*
	* returns the index of the first occurrence of a face-card letter in s starting from index
	* startPosition or -1 if there are none at index startPosition or later. 
	* 
	* Notice that this method has the same name as the previous one, but that it takes a different number of arguments. This
	* is perfectly legal in Java. It's called "method overloading"
	*/
	public static int indexOfFirstFace(String s, int startPosition) {
		// instead of int i=0 -> i=start position
		for (int i = startPosition; i < s.length(); i++) {
			char c = s.charAt(i);
			if (isFace(c) == true) {
				return i;
			}
		}
		return -1;
	}
  
	// returns the index of the last occurrence of a face-card letter in s or -1 if s contains none
	public static int indexOfLastFace(String s) {
		// i = 0 -> i = s.length()-1; i >= 0; i--
		for (int i = s.length()-1; i >= 0; i--) {
			char c = s.charAt(i);
			if (isFace(c) == true) {
				return i;
			}
		}
		return -1;
	}
  
	// returns s in reverse. For example, if s is "Apple", the method returns the String "elppA"
	public static String reversed(String s) {
		if (s == null) {
	        return s;
	    }

	    String output = "";

	    for (int i = s.length() - 1; i >= 0; i--) {
	        output = output + s.charAt(i);
	    }

	    return output;
	}
  
	// returns the number of times that n occurs in h. For example, if h is "Mississippi" and n is "ss" the method returns 2.
	public static int numOccurrences(String h, String n) {
		int index = h.indexOf(n);
		int count = 0;
		while (index != -1) {
		    count++;
		    h = h.substring(index + 1);
		    index = h.indexOf(n);
		}
		return count;
	}
  
	// returns true if s is the same backwards and forwards and false otherwise
	public static boolean sameInReverse(String s) {
		if(s.equals(reversed(s))) {
			return true;
		}
		else {
			return false;
		}
	}
  
	// returns a new String which is the same as s, but with all of the face-card letters removed.
	public static String withoutFaces(String s) {
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			if (c == 'j' || c == 'q' || c == 'k' || c == 'a' || c == 'J' || c == 'Q' || c == 'K' || c == 'A') {
				System.out.println(s.replaceAll("([j,q,k,a,J,Q,K,A])", ""));
				return s.replaceAll("([j,q,k,a,J,Q,K,A])", "");
			}
		}
		return s.replaceAll("([j,q,k,a,J,Q,K,A])", "");
	}
  
	// returns true if s contains no face-card letters or false otherwise
	public static boolean containsNoFaces(String s) {
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			//System.out.println(s.charAt(i));
			
			if (c == 'j' || c == 'q' || c == 'k' || c == 'a' || c == 'J' || c == 'Q' || c == 'K' || c == 'A') {
				//System.out.println("There are faces FALSE");
				return false;
			}
			else {
				//System.out.println("There are no faces TRUE");
			}
		}
		return true;
	}
  
	// returns true if s consists only of face-card letters or false otherwise
	public static boolean containsOnlyFaces(String s) {
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			//System.out.println(s.charAt(i));
			
			if (c == 'b' || c == 'c' || c == 'd' || c == 'e' || c == 'f' || c == 'g' || c == 'h' ||
				c == 'i' || c == 'l' || c == 'm' || c == 'n' || c == 'o' || c == 'p' ||
				c == 'r' || c == 's' || c == 't' || c == 'u' || c == 'v' || c == 'w' || c == 'x' || c == 'y' || c == 'z') {
				//System.out.println("false");
				return false;
			}
			
			else {
				//System.out.println("true");
				return true;
			}
			
		}
		return true;
	}  
	
	/*
	* Passed a reference to a person's name in the form FIRST_NAME LAST_NAME. The method returns a
	* reference to a new String in the form LAST_NAME, FIRST_NAME.
	*
	* For example, if we were passed "Spongebob Squarepants", we'd return "Squarepants, Spongebob".
	* You may assume that the method is passed exactly two words separated by a single space.
	*/
	public static String lastFirst(String s) {
		//String str = "Spongebob Squarepants";

		String[] parts = s.split(" ", 5);
		String string1 = parts[0];
		String string2 = parts[1];
		String string3 = parts[1] + ", " + parts[0];

		System.out.println(string3);  // prints name2, name3, name4 
		return string3;
	}
}