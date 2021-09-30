/*
	
*/
import java.util.*;
import java.io.*;

public class examFiles5 {
	public static void main(String[] args) throws IOException {
		//Scanner name = new Scanner(new File("filename.txt"));
		final BufferedReader br = new BufferedReader(new StringReader("hello\n\nworld\n"));
		String line;
		int empty = 0;
		while ((line = br.readLine()) != null) {
		  if (line.trim().isEmpty()) {
		    empty++;
		  }
		}
		System.out.println(empty);
	}
}
