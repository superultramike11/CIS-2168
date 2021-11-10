import java.nio.file.Files;
import java.nio.file.Paths;

public class CompareDistinctCategoryHands {
   public static void main(String[] args) {
      int p1wins = 0;
      try {
         for (String line : Files.readAllLines(Paths.get("poker.txt"))) {
            Hand hand1 = new Hand(line.substring(0, 14));
            Hand hand2 = new Hand(line.substring(14, 29).trim());

            // If player 1 has a better hand
            if (hand1.getHandValue() > hand2.getHandValue()) {
               System.out.println("Player 1: " + hand1 + "  (" + Hand.nameMap.get(hand1.getHandValue()) +
                     ")\nPlayer 2: " + hand2 +  "  (" + Hand.nameMap.get(hand2.getHandValue()) +
                     ")\n\t\t\t    Player 1 wins.\n");
               p1wins++;
            }

            // If player 2 has a better hand
            else if (hand1.getHandValue() < hand2.getHandValue()) {
               System.out.println("Player 1: " + hand1 + "  (" + Hand.nameMap.get(hand1.getHandValue()) +
                       ")\nPlayer 2: " + hand2 + "  (" + Hand.nameMap.get(hand2.getHandValue()) +
                       ")\n\t\t\t    Player 2 wins.\n");
            }

            // If players tie then it calculates who has the highest card
            else {
               //playerWithHigherCards(hand1, hand2, p1wins);
            }
         }
         System.out.println("Number of hands won by player 1: " + p1wins);
      } catch (Exception e) {
         System.out.println(e);
      }
   }

   // use isStraight format as a way to compare each of the ranks available
   /*
   public static void playerWithHigherCards(Hand hand1, Hand hand2, int p1wins) {

      insertionSort(hand1);
      int[] hand1Eval = Hand.nameMap.get(hand1.getHandValue());

      insertionSort(hand2);
      int[] hand2Eval = Hand.nameMap.get(hand2.getHandValue());

      if(hand1Eval[0] == hand2Eval[0]){

         // compare hand values
         if(hand1Eval[1] == hand2Eval[1]){
            for(int i=4;i<0;i--) {
               if(cardValuesMap.get(hand1[i].charAt(0)) > cardValuesMap.get(hand2[i].charAt(0))){
                  return PLAYER_1_WINS;
               }  else if(cardValuesMap.get(hand1[i].charAt(0)) < cardValuesMap.get(hand2[i].charAt(0))){
                  return -1;
               }
            }
            return TIE;
         } else if(hand1Eval[1] > hand2Eval[1]){
            return PLAYER_1_WINS;
         } else {
            return PLAYER_2_WINS;
         }
      } else if(hand1Eval[0] > hand2Eval[0]){
         return PLAYER_1_WINS;
      } else {
         return PLAYER_2_WINS;
      }

      for(int i=1; i<getCardRanks().length-1; i++) {
         // if I see that the next card is not decreasing in the overall index then I return false
         if(getCardRanks()[i] != getCardRanks()[i-1] - 1) {
            return false;
         }
      }
   }
    */

   /*
   private static void playerWithHigherCards(Hand hand1, Hand hand2, int p1wins) {
      if (hand1.getHandValue() == hand2.getHandValue()) {
         System.out.println("Player 1: " + hand1 + "  (" + Hand.nameMap.get(hand1.getHandValue()) +
                 ")\nPlayer 2: " + hand2 +  "  (" + Hand.nameMap.get(hand2.getHandValue()) +
                 ")\n\t\t\t    Player 1 wins.\n");
         p1wins++;
      }
   }
    */
}
