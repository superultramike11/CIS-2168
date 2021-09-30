import java.io.*;
import java.util.*;

public class examFiles1 {

	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<String> list = new ArrayList<String>();
		File filename = new File("filename.txt");
		Scanner scnr = new Scanner(filename);
		
		while(scnr.hasNext()) {
			String word = scnr.next();
			list.add(word);
		}
		
		System.out.println(list.get(0));
	}
}
