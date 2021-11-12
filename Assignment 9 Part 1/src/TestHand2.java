import java.util.Arrays;

// Test cases to compare poker hands. Ties are resolved according to official poker rules.
public class TestHand2 {
   public static void main(String[] args) {
      String msg;  // message to print (comparison result)

      /*
      // TEST GROUP 1: comparing hands of unequal ranks (easiest)
      // test 1-1: comparing a straight flush to a full house
      Hand sf = new Hand("AS KS QS TS JS"); // straight flush (winner)
      System.out.println("sf: " + Arrays.toString(sf.getCardRanks())); // [14, 13, 12, 11, 10]
      Hand fh = new Hand("9H KC 9S KD 9C"); // full house
      System.out.println("fh: " + Arrays.toString(fh.getCardRanks())); // [13, 13, 9, 9, 9]
      System.out.println(sf.compareTo(fh)); // should print a positive int (2)
      if (sf.compareTo(fh) != 0)
         msg = sf.compareTo(fh) > 0 ? "straight flush is better than full house" :  "full house is better than straight flush" ;
      else msg = "equal hands";
      System.out.println(msg);
      System.out.println("--------------------");
       */
      /*
      // test 1-2: comparing a 3-of-a-kind to a 4-of-a-kind
      Hand kind3 = new Hand("TS 2S 4S TH TC"); // three of a kind
      System.out.println("kind3: " + Arrays.toString(kind3.getCardRanks()));
      Hand kind4 = new Hand("TS 2S 4S TH TC"); // four of a kind (winner)
      System.out.println("kind4: " + Arrays.toString(kind4.getCardRanks()));
      if (kind3.compareTo(kind4) != 0)
         msg = kind3.compareTo(kind4) > 0 ? "kind3 is better than kind4" :  "kind4 is better than kind3";
      else msg = "equal hands";
      System.out.println(msg);
      System.out.println("--------------------");
      */

      /*
      // test 1-3: comparing a flush to a straight
      Hand fl = new Hand("TS 2S 5S AS KS"); // flush (winner)
      System.out.println("fl: " + Arrays.toString(fl.getCardRanks()));
      Hand st = new Hand("2H 4S AH 3C 5H"); // straight
      System.out.println("st: " + Arrays.toString(st.getCardRanks()));
      if (fl.compareTo(st) != 0)
         msg = fl.compareTo(st) > 0 ? "flush is better than straight" :  "straight is better than flush";
      else msg = "equal hands";
      System.out.println(msg);
      System.out.println("--------------------");
       */

      /*
      // test 1-4: comparing a pair to a nothing hand
      Hand pair = new Hand("TS 2S 5S AS TC"); // pair (winner)
      System.out.println("pair: " + Arrays.toString(pair.getCardRanks()));
      Hand nothing = new Hand("2H 4S AH 3C 6H"); // nothing hand
      System.out.println("nothing: " + Arrays.toString(nothing.getCardRanks()));
      if (pair.compareTo(nothing) != 0)
         msg = pair.compareTo(nothing) > 0 ? "pair is better than nothing" :  "nothing is better than pair";
      else msg = "equal hands";
      System.out.println(msg);
      System.out.println("--------------------");
      */

      /*
      // test 1-4: comparing a pair to a nothing hand
      Hand pair2 = new Hand("KS 2S 5S 2H KC"); // pair (winner)
      System.out.println("two-pair: " + Arrays.toString(pair2.getCardRanks()));
      Hand pair1 = new Hand("TS 2S 5S AS TC"); // pair
      System.out.println("one-pair: " + Arrays.toString(pair1.getCardRanks()));
      if (pair2.compareTo(pair1) != 0)
         msg = pair2.compareTo(pair1) > 0 ? "two-pair is better than one-pair" :  "one-pair is better than two-pair";
      else msg = "equal hands";
      System.out.println(msg);
      System.out.println("--------------------");
      */

      /*
      // TEST GROUP 2: comparing hands of equal ranks
      // test 2-1: comparing a straight flush to a straight flush
      Hand sf1 = new Hand("AS KS QS TS JS"); // straight flush 1 (winner)
      System.out.println("sf1: " + Arrays.toString(sf1.getCardRanks()));
      Hand sf2 = new Hand("2H 3H 4H 5H AH"); // straight flush 2
      System.out.println("sf2: " + Arrays.toString(sf2.getCardRanks()));
      if (sf1.compareTo(sf2) != 0)
         msg = sf1.compareTo(sf2) > 0 ? "straight flush 1 is better than straight flush 2" :  "straight flush 2 is better than straight flush 1" ;
      else msg = "equal hands";
      System.out.println(msg);
      System.out.println("--------------------");
      */

      /*
      // test 2-2: comparing a four-of-a-kind to a four-of-a-kind
      Hand kind41 = new Hand("KS KH QS KC KD"); // four-of-a-kind 1 (winner)
      System.out.println("kind4 1: " + Arrays.toString(kind41.getCardRanks()));
      Hand kind42 = new Hand("TS TH AS TC TD"); // four-of-a-kind 2
      System.out.println("kind4 2: " + Arrays.toString(kind42.getCardRanks()));
      if (kind41.compareTo(kind42) != 0)
         msg = kind41.compareTo(kind42) > 0 ? "four-of-a-kind 1 is better than four-of-a-kind 2" :  "four-of-a-kind 2 is better than four-of-a-kind 1" ;
      else msg = "equal hands";
      System.out.println(msg);
      System.out.println("--------------------");
      */

      // test 2-3: comparing a three-of-a-kind to a three-of-a-kind
      Hand kind31 = new Hand("TS TH QS TC AD"); // three-of-a-kind 1
      System.out.println("kind3 1: " + Arrays.toString(kind31.getCardRanks()));
      Hand kind32 = new Hand("JS 2H JC 3C JD"); // three-of-a-kind 2 (winner)
      System.out.println("kind3 2: " + Arrays.toString(kind32.getCardRanks()));
      if (kind31.compareTo(kind32) != 0)
         msg = kind31.compareTo(kind32) > 0 ? "three-of-a-kind 1 is better than three-of-a-kind 2" :  "three-of-a-kind 2 is better than three-of-a-kind 1" ;
      else msg = "equal hands";
      System.out.println(msg);
      System.out.println("--------------------");

      /*
      // test 2-3a: comparing two-pair hands
      Hand tp1 = new Hand("JS JC AH KD KS"); // two-pair 1: Kings and Jacks
      System.out.println("tp1: " + Arrays.toString(tp1.getCardRanks())); // [14, 13, 13, 11, 11]
      Hand tp2 = new Hand("TS KC AH TH AD"); // two-pair 2: Aces and Tens (winner)
      System.out.println("tp2: " +Arrays.toString(tp2.getCardRanks())); // [14, 14, 13, 10, 10]
      if (tp1.compareTo(tp2) != 0)
         msg = tp1.compareTo(tp2) > 0 ? "two-pair 1 is better than two-pair 2" :  "two-pair 2 is better than two-pair 1" ;
      else msg = "equal hands";
      System.out.println(msg);
      System.out.println("--------------------");

      // test 2-3b: comparing two-pair hands
      tp1 = new Hand("JS JC QH KD KS"); // two-pair 1: Kings and Jacks, Queen kicker (winner)
      System.out.println("tp1: " + Arrays.toString(tp1.getCardRanks()));
      tp2 = new Hand("JS JC 9H KD KS"); // two-pair 2: Kings and Jacks, 9 kicker
      System.out.println("tp2: " +Arrays.toString(tp2.getCardRanks()));
      if (tp1.compareTo(tp2) != 0)
         msg = tp1.compareTo(tp2) > 0 ? "two-pair 1 is better than two-pair 2" :  "two-pair 2 is better than two-pair 1" ;
      else msg = "equal hands";
      System.out.println(msg);
      System.out.println("--------------------");

      // test 2-4a: comparing one-pair hands
      Hand p1 = new Hand("9S 9C QH 2D 5S"); // pair 1: 9s, 5 kicker (winner)
      System.out.println("p1: " + Arrays.toString(p1.getCardRanks()));
      Hand p2 = new Hand("9H 9D QS 2C 4S"); // pair 2: 9s, 4 kicker
      System.out.println("p2: " + Arrays.toString(p2.getCardRanks()));
      if (p1.compareTo(p2) != 0)
         msg = p1.compareTo(p2) > 0 ? "pair 1 is better than pair 2" :  "pair 2 is better than pair 1" ;
      else msg = "equal hands";
      System.out.println(msg);
      System.out.println("--------------------");

      // test 2-4b: comparing one-pair hands
      p1 = new Hand("8S 8C 3H 2D 5S"); // pair 1: 8s, 5 kicker
      System.out.println("p1: " + Arrays.toString(p1.getCardRanks()));
      p2 = new Hand("AH AD QS 2C 4S"); // pair 2: Aces, Queen kicker (winner)
      System.out.println("p2: " + Arrays.toString(p2.getCardRanks()));
      if (p1.compareTo(p2) != 0)
         msg = p1.compareTo(p2) > 0 ? "pair 1 is better than pair 2" :  "pair 2 is better than pair 1" ;
      else msg = "equal hands";
      System.out.println(msg);
      System.out.println("--------------------");
       */
   }
}
