import java.util.ArrayList;
import java.util.Arrays;

public class TestHand {
   public static void main(String[] args) {
      /*
      // TEST 0: highestCard(), showRanks(), rankFrequency()
      Hand hand = new Hand("8C TS KC 9H 4S");
      System.out.println(hand);               // [8C, TS, KC, 9H, 4S]
      System.out.println(hand.highestCard()); // 13 (the King)
      System.out.println(hand.getCardRanks());   // [13, 10, 9, 8, 4]
      System.out.println(Arrays.toString(hand.getRankFrequency().entrySet().toArray())); // format: [4=1, 8=1, 9=1, 10=1, 13=1]
      System.out.println(hand.getRankFrequency()); // format: {4=1, 8=1, 9=1, 10=1, 13=1}
      System.out.println("-------------------------");

      // TEST 1: Full house
      System.out.println("\tFull House:");
      hand = new Hand("7D 7S 5D 7C 5H");
      System.out.println("Highest card: " + hand.highestCard() + ", ranks:" + hand.getCardRanks());
      System.out.println(Arrays.toString(hand.getRankFrequency().entrySet().toArray()));
      System.out.println(hand.isFullHouse()); // true
      System.out.println(new Hand("AS AH AD KC KS").isFullHouse()); // true
      System.out.println(new Hand("2S 2D AC 2H 3S").isFullHouse()); // false
      System.out.println("-------------------------");

      // TEST 2: isFlush()
      System.out.println("\tFlush:");
      System.out.println(new Hand("7S 8S 5H 5S 6S").isFlush()); // false
      System.out.println(new Hand("7S 8S 5S AS 6S").isFlush()); // true
      System.out.println(new Hand("AS AD AH AC TS").isFlush()); // false
      System.out.println(new Hand("AS 2S 3S 5S 4S").isFlush()); // true
      System.out.println("-------------------------");

      // TEST 3: isStraight()
      System.out.println("\tStraight:");
      System.out.println(new Hand("7S 8S 9S JS TS").isStraight()); // true
      System.out.println(new Hand("AS 8S 9S JS TS").isStraight()); // false
      System.out.println(new Hand("AS KH QS JD TS").isStraight()); // true
      System.out.println(new Hand("2D 3S 5S 4H JS").isStraight()); // false
      System.out.println(new Hand("AS QS JD TS 9H").getCardRanks()); // [14, 12, 11, 10, 9]
      System.out.println(new Hand("AS QS JD TS 9H").isStraight()); // false
      System.out.println("-------------------------");

      // TEST 5: isThreeOfaKind()
      System.out.println("\tThree of a kind:");
      System.out.println(new Hand("JS JC JH KC AD").isThreeOfaKind()); // true
      System.out.println(new Hand("7S 7D 7H 7C AD").isThreeOfaKind()); // false
      System.out.println(new Hand("JS 2S JH AC JD").isThreeOfaKind()); // true
      System.out.println(new Hand("JS JC JH KC KD").isThreeOfaKind()); // false
   */
   }
}
