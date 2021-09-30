import java.io.*;
import java.util.*;

/*
	Write a method which is passed the name of a text file 
	which contains grades in a course that's in the following format:
	
	Stan 99 87 100
	Dipper 100 100 97 100
	Mabel 100 100
	Seuss 72 85 65
	
	the method returns the average of the student with the highest semester average.
*/
public class examFiles4 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner name = new Scanner(new File("filename.txt"));
		int x = 10;
		//x = getAvg(x);
		double highScore = getAvg(name.nextLine());
		double current = 0;
		while (name.hasNextLine()) {
			double cur = getAvg(name.nextLine());
			if (current > highScore) {
				highScore = current;
			}
		}
		System.out.println(x);
	}
	
	private static double getAvg(String nextLine) {
		
		return 0;
	}
}
