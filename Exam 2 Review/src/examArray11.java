/*
	Write a method which is passed an array of String and modifies it so that all the Strings in the array are reversed. 
	For example, if we pass the array: {"apple", "banana", "racecar", "abc"} the method transforms it to: {"elppa", "ananab", "racecar", "cba"}
*/
import java.io.*;
import java.util.*;

public class examArray11 {
	public static void main(String[] args) {
		String S[] = {"apple", "banana", "racecar", "abc"};
		reverse(S);
	}
	
	public static String[] reverse(String[] S) {	
	    String output = "";

	    for (int i = S.length - 1; i >= 0; i--) {
	        output = output + S.length;
	    }

	    System.out.println(Arrays.toString(S));
	    return (String[]) S;
	}
}
