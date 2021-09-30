//Write a method which is passed the name of a text file. 
//The method returns the number of words found in the file.
import java.io.*;
import java.util.*;

public class examFiles2 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner name = new Scanner(new File("filename.txt"));
		int words = 0;
		while(name.hasNextLine()) {
			name.next();
			words++;
		}
		System.out.println(words);
	}
}
