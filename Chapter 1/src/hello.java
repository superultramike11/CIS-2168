import java.util.Scanner;

/*
public class hello {  
	public static int SENTINEL = -1;
	public static void main(String[] args) {  
		
		double sumScores=0;
		int numScores=0;
		double cur=0;
		String prompt = "Enter an exam score or " + SENTINEL + " to quit ";
		
		Scanner kbd = new Scanner(System.in);
		
		System.out.println(prompt);
		cur = kbd.nextDouble();
		
		while (cur != SENTINEL) {
			sumScores += cur;
			numScores++;
			
			System.out.println(prompt);
			cur = kbd.nextDouble();
		}
		
		if(numScores > 0) {
			System.out.println("The average is "+ sumScores/numScores);
		}
	}
}  
*/
public class hello {
	public static void main(String[] args) {
		int numScores = 0;
		int sumScores = 0;
		int high = -1;
		int low = 100;
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter score or neg to quit");
		int cur = in.nextInt();
		while (cur >= 0) {
			numScores++;
			sumScores += cur;
			
			if (cur > high) {
				high = cur;
			}
			else if (cur > low) {
				low = cur;
			}
		}
		if (numScores == 0) {
			System.out.println("no scores entered");
		}
		else {
			System.out.println("High = "  + high + ", low = " + low + ", avg = " + (double)sumScores / numScores);
		}
	}
}