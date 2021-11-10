import java.nio.file.Files;
import java.nio.file.Paths;

public class CompareDistinctCategoryHands {
   public static void main(String[] args) {
      int p1wins = 0;
      try {
         for (String line : Files.readAllLines(Paths.get("distinctHandPairs.txt"))) {
            Hand hand1 = new Hand(line.substring(0, 14));
            Hand hand2 = new Hand(line.substring(14, 29).trim());

            // if player 1 has a better hand
            if (hand1.getHandValue() > hand2.getHandValue()) {
               System.out.println("Player 1: " + hand1 + "  (" + Hand.nameMap.get(hand1.getHandValue()) +
                     ")\nPlayer 2: " + hand2 +  "  (" + Hand.nameMap.get(hand2.getHandValue()) +
                     ")\n\t\t\t    Player 1 wins.\n");
               p1wins++;
            }

            // if player 2 has a better hand
            else if (hand1.getHandValue() < hand2.getHandValue()) {
               System.out.println("Player 1: " + hand1 + "  (" + Hand.nameMap.get(hand1.getHandValue()) +
                       ")\nPlayer 2: " + hand2 + "  (" + Hand.nameMap.get(hand2.getHandValue()) +
                       ")\n\t\t\t    Player 2 wins.\n");
            }

            // But if two ranks tie,
            // for example, both players have a pair of queens, then highest cards in each hand are compared
            // if the highest cards tie then the next highest cards are compared, and so on.
            else if (hand1.getHandValue() == hand2.getHandValue()) {

            }


            else {
               System.out.println("Player 1: " + hand1 + "  (" + Hand.nameMap.get(hand1.getHandValue()) +
                     ")\nPlayer 2: " + hand2 +  "  (" + Hand.nameMap.get(hand2.getHandValue()) +
                     ")\n\t\t\t\t Tie.\n");
            }
         }
         System.out.println("Number of hands won by player 1: " + p1wins);
      } catch (Exception e) {
         System.out.println(e);
      }
   }

}
