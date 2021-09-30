import java.io.*;
import java.util.*; // random

public class Hangman {
	private static final int RAND_MAX = 10;
	private static final int RAND_MIN = 0;
	
	// store all possible dictionary words
	ArrayList<String> dictionary = new ArrayList<>();
	// store status: ("_", "_", "_", "_", "o", "_")
	ArrayList<String> status = new ArrayList<>();
	// store user input history: ("a","e","i","o","u")
	ArrayList<String> history = new ArrayList<>();
	
	Random rand = new Random();
	int randLength = rand.nextInt(RAND_MAX-RAND_MIN)+RAND_MIN;
	
	public Hangman(Scanner scnr) {
		while(scnr.hasNext()) {
			String word = scnr.next();
			dictionary.add(word);
		}
		
		for (int i=0; i<dictionary.size(); i++) {
	        if(dictionary.get(i).length() != randLength) {
	        	dictionary.remove(i); 
	            i--; 
	        }
	    }
		System.out.println("All words are " + randLength + " letter/s");
		/*
	    for(String word: dictionary) {
	    	System.out.println(word);
	    }
	    */
	}
	
	public String printAnswerSpace(String choice) {
		String questionSpace = "";
		for(int i=0; i<choice.length(); i++) {
			questionSpace += "_";
		}
		return questionSpace;
	}
	
	public void play() {
		int remainingRound = randLength;
		boolean winStatus = false;
		while(roundYesOrNo()) {
			System.out.println("Remaining guesses: " + (remainingRound));
			System.out.println("History of used words: " + history);
			
			System.out.println("Current Line-up status: " + status);
			
			Scanner scan = new Scanner(System.in);
			System.out.println("Please enter a character or a full word: ");
			String choice = scan.next();
			history.add(choice);
			
			cheat(choice, remainingRound);
			System.out.println("Dictionary after cheating: " + dictionary);
			System.out.println("Remaining guesses: " + (remainingRound));
		}
	}
	
	public static boolean roundYesOrNo() {
		Scanner yesOrNo = new Scanner(System.in);
		
		System.out.println("Would you like to play Hangman? y/n: ");
		String choice = yesOrNo.next();
		
		if(choice.equals("y")) {
			return true;
		}
		else if(choice.equals("n")) {
			System.out.println("Bye!");
			return false;
		}
		else {
			System.out.println("Invalid Selection");
			return false;
		}
	}
	
	public int cheat(String choice, int remainingRound) {
		for (int i=0; i<dictionary.size(); i++) {
			String s = dictionary.get(i);
			char c = s.charAt(i);
			for(int j=0; j < s.length(); j++) {
				if(dictionary.get(i).equals(choice)) {
		        	dictionary.remove(i); 
		            i--; 
		        }
			}  
	    }
		return remainingRound--;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		File filename = new File("filename.txt");
		Scanner scnr = new Scanner(filename);
		Hangman game = new Hangman(scnr);
		game.play();
	}
}