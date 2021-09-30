/*
	Write a method which is passed a String and returns the String in reverse.
*/
import java.io.*;
import java.util.*;

public class examArray10 {
	public static void main(String[] args) {
		String s = "gay";
		reverse(s);
	}
	
	public static String reverse(String s) {	
	    String output = "";

	    for (int i = s.length() - 1; i >= 0; i--) {
	        output = output + s.charAt(i);
	    }

	    System.out.println(output);
	    return output;
	}
}
