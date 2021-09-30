import java.util.*;

public class Game {
	public static int roundCount = 0; // make public
	public static int user_score = 0; // make public
	public static int comp_score = 0; // make public
	
	public static void main(String[] args) {
		instructions();
		round();
	}
	
	// Prints rules and presents to the user if they want to play or not
	public static void instructions() {
		System.out.println("During each round, players choose a move, which may be either "
						 + "Kvalfjord, Bjorksnas, Hauga, Nordli, or Slakt. The rules are:");
		System.out.printf("- Slakt beats Hauga and Kvalfjord\n"
						+ "- Hauga beats Bjorksnas and Nordli\n"
						+ "- Bjorksnas beats Slakt and Kvalfjord\n"
						+ "- Kvalfjord beats Nordli and Hauga\n"
						+ "- Nordli beats Slakt and Bjorksnas\n\n");
	}
	
	public static void round() {
		while(roundYesOrNo()) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter a move: ");
			String move = scan.next();
			
			String cm = RandomMove(); // generate the computer move;
			
			System.out.println("YOUR move was: " + move);
			System.out.println("The COMPUTER's move was: " + cm);
			gameExec(move, cm); // GameExec(move, RandomMove());
			
			roundCount++;
		}
	}
	
	public static boolean roundYesOrNo() {
		Scanner yesOrNo = new Scanner(System.in);
		
		System.out.println("Would you like to play a round? y/n: ");
		String choice = yesOrNo.next();
		
		if(choice.equals("y")) {
			return true;
		}
		else if(choice.equals("n")) {
			System.out.println("YOU played " + roundCount + " rounds, YOU won "+user_score+" rounds, The COMPUTER won "+comp_score+" rounds");
			return false;
		}
		else {
			System.out.println("Invalid Selection");
			return false;
		}
	}
	
	public static void gameExec(String move, String cm) {
		if( (move.equals("Slakt") && (cm.equals("Hauga") || cm.equals("Kvalfjord"))) || 
			(move.equals("Hauga") && (cm.equals("Bjorksnas") || cm.equals("Nordli"))) || 
			(move.equals("Bjorksnas") && (cm.equals("Slakt") || cm.equals("Kvalfjord"))) ||
			(move.equals("Kvalfjord") && (cm.equals("Nordli") || cm.equals("Hauga"))) || 
			(move.equals("Nordli") && (cm.equals("Slakt") || cm.equals("Bjorksnas")))) {
			System.out.println("YOU won this round!");
			user_score++;
		}
		
		if( (cm.equals("Slakt") && (move.equals("Hauga") || move.equals("Kvalfjord"))) || 
			(cm.equals("Hauga") && (move.equals("Bjorksnas") || move.equals("Nordli"))) || 
			(cm.equals("Bjorksnas") && (move.equals("Slakt") || move.equals("Kvalfjord"))) ||
			(cm.equals("Kvalfjord") && (move.equals("Nordli") || move.equals("Hauga"))) || 
			(cm.equals("Nordli") && (move.equals("Slakt") || move.equals("Bjorksnas")))) {
			System.out.println("The COMPUTER won this round");
			comp_score++;
		}
	}
	
	public static String RandomMove() { // return the random move name
		Random rand = new Random();
		int computer_move = rand.nextInt(5); // random between integer 0 to 4 both inclusive
		String[] move = {"Kvalfjord", "Bjorksnas", "Hauga", "Nordli", "Slakt"};
		return move[computer_move];
	}
}