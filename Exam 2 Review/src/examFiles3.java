/*
	Write a method which is passed the name of a text file. 
	The method returns the length of the longest word found in the file.
*/
import java.io.*;
import java.util.*;

public class examFiles3 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner name = new Scanner(new File("filename.txt"));
		String longest_word = "";
		String current;
		while(name.hasNextLine()) {
			current = name.next();
			if(current.length() > longest_word.length()) {
				longest_word = current;
			}
		}
		System.out.println(longest_word);
	}
}
