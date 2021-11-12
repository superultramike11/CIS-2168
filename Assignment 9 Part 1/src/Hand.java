import java.util.*;

public class Hand implements Comparable<Hand> {
   /*************************** Public static field ***************************/
   // the name of this hand
   public static Map<Integer, String> nameMap = Map.of(
           8, "straight flush",
           7, "four of a kind",
           6, "full house",
           5, "flush",
           4, "straight",
           3, "three of a kind",
           2, "two pair",
           1, "pair",
           0, "nothing");

   /****************************** Private fields ******************************/
   // A list of cards in this hand. E.g., [8C, TS, KC, 9H, 4S] is a list of cards.
   private ArrayList<Card> hand = new ArrayList<>();

   // A map of each card's rank to the number of times it occurs in the hand. E.g,
   // "7D 7S 5D 7C 5H" has two 5s and three 7s, so its frequency map is {5=2, 7=3}.
   private Map<Integer, Integer> rankFrequency = new HashMap<>();

   // Ranks of the cards in this hand in reverse-sorted order. E.g., the hand
   // "8H KC 2S 3S QD" has ranks [13, 12, 8, 3, 2].
   private Integer[] cardRanks = new Integer[5];

   // The integer value of this poker hand in the range from 0 to 8. 8 corresponds
   // to a straight flush and 0 to a nothing hand.
   // (See the instructions or the Wikipedia article for poker hand rankings.)
   private int handValue;

   /********************************  Constructor ********************************/
   // Creates a Hand object from an input string representing a hand.
   public Hand(String cards) {
      // hand.removeAll(hand); // clear this hand to create a new one
      for (String token : cards.split("\\s+")) {
         Card card = new Card(token);
         hand.add(card);
      }
      check();                 // make sure this is a valid 5-card hand
      buildRankFrequencyMap(); // generate a map of card-rank frequencies
      buildRankArray();        // generate a card-rank array in reverse-sorted order
      determineHandRank();     // the rank of this hand on the scale 0 to 8
   }

   /*******************************  Private Methods *******************************/
   // How many times does each rank repeat in this hand? Maps each rank to the number
   // of times it occurs in this hand and returns the map. E.g., "KD KS 9H JC 9S" has
   // two Ks, two 9s, and one J, so its map is {13=2, 11=1, 9=2}.
   private void buildRankFrequencyMap() {
      Integer rank;
      for(Card card : hand) {
         rank = card.getRank();
         // if we have seen this rank before then we just increment
         if(rankFrequency.containsKey(rank)) {
            int count = rankFrequency.get(rank);
            rankFrequency.put(rank, count + 1);
         }
         // if we haven't then we add it to the map
         else {
            rankFrequency.put(rank, 1);
         }
      }
   }

   // generate a list of ranks in decreasing order (the highest rank first, the lowest last).
   private void buildRankArray() {
      int i = 0;
      for (Card c : hand){
         cardRanks[i] = c.getRank();
         i++;
      }
      Arrays.sort(cardRanks, Collections.reverseOrder());

      // the only exception is a low straight (called a wheel) where Ace
      // counts as 1, not as 14. So if the hand is "Ace, 5, 4, 3, 2"
      // we want to return "5, 4, 3, 2, 1" instead of "14, 5, 4, 3, 2"
      if (Arrays.equals(cardRanks, new Integer[]{14, 5, 4, 3, 2}))
         cardRanks = new Integer[]{5, 4, 3, 2, 1};
   }

   // determine the ranking of this hand
   private void determineHandRank() {
      if      (this.isStraightFlush()) handValue = 8;
      else if (this.isFourOfaKind())   handValue = 7;
      else if (this.isFullHouse())     handValue = 6;
      else if (this.isFlush())         handValue = 5;
      else if (this.isStraight())      handValue = 4;
      else if (this.isThreeOfaKind())  handValue = 3;
      else if (this.isTwoPair())       handValue = 2;
      else if (this.isPair())          handValue = 1;
      else                             handValue = 0;
   }

   // Check if the hand has 5 cards and if each card is in the correct format.
   private void check() {
      if (hand.size() != 5)
         throw new RuntimeException("Not a 5-card hand. Try again.");
      Set<String> cardSet = new HashSet<>();
      for (Card c : hand) cardSet.add(c.toString());  // (card validity itself is checked in Card.java)
      if (cardSet.size() != 5)
         throw new RuntimeException("Duplicate card! Try again.");
   }

   /***********************************  Getters ***********************************/
   // returns and Integer array of the card ranks in this hand in descending order
   public Integer[] getCardRanks() { return cardRanks; }

   // returns the frequency map for this hand
   public Map<Integer, Integer> getRankFrequency() { return rankFrequency; }

   // returns the list of Cards in this hand
   public ArrayList<Card> getHand() { return hand; }

   // return the rank of this hand
   public int getHandValue() { return handValue; }

   /*********************************************************************************
    Methods that check for the hand categories
    ********************************************************************************/
   // Is this hand a straight flush?
   public boolean isStraightFlush() { return isFlush() && isStraight(); }

   // Is this hand four of a kind?
   public boolean isFourOfaKind() {
      Integer rank;
      for(Card card : hand) {
         // get the rank of each card
         rank = card.getRank();
         // if the rank frequency of all the cards are 4 (meaning there are 4 cards with the same rank)
         // for a isFourOfaKind it'll go rankFrequency (1 then 2 then 3 then 4)
         if(rankFrequency.get(rank) == 4) {
            return true;
         }
      }
      return false; // delete this line and substitute it with your code
   }

   // Is this hand a full house (3 cards of the same rank & 2 cards of the same rank)?
   // if the rankFrequency size is 2, then there HAS to be 2 distinct groups of cards
   public boolean isFullHouse() {
      return rankFrequency.size() == 2;
   }

   // Is this hand a flush? (Can also be a straight.)
   public boolean isFlush() {
      Card card1 = hand.get(0);
      char suit = card1.getSuit();
      int suitCounter = 0;
      // go through each hand of the card
      for(Card card : hand) {
         // if the card in the hand equals the suit of the first card then you increment the counter
         if(card.getSuit() == suit) {
            suitCounter++;
         }
         // eventually if the counter reaches 5 (means all 5 card share the same suit) then it is true
         if(suitCounter==5) {
            return true;
         }
      }
      return false;
   }

   // Is this hand a straight? (Can also be a flush.)
   public boolean isStraight() {
      for(int i=1; i<getCardRanks().length-1; i++) {
         // if I see that the next card is not decreasing in the overall index then I return false
         if(getCardRanks()[i] != getCardRanks()[i-1] - 1) {
            return false;
         }
      }
      // if it makes it through the entire loop in a decreasing manner then it is straight
      return true;
   }

   // Is this hand three of a kind (also called a set or trips in poker)?
   public boolean isThreeOfaKind() {
      // go through all the cards in the hand
      for(Card card : hand) {
         // If the rankFrequency of the card is 3 (there's 3 of that value) and it's not a full house then it's three of a kind
         if(rankFrequency.get(card.getRank()) == 3 && !isFullHouse()) {
            return true;
         }
      }
      return false;
   }

   // Does this hand contain exactly two pairs?
   public boolean isTwoPair() {
      Integer rank;
      int pairCounter = 0;
      // go through all the cards in the hand
      for(Card card : hand) {
         rank = card.getRank();
         // if there are 2 of the same ranks then you increment by 1
         if(rankFrequency.get(rank) == 2) {
            pairCounter++;
         }
      }
      // if pair counter is 4 (that means that there 2 pairs counted)
      if(pairCounter==4) {
         return true;
      }
      return false;
   }

   // Does this hand contain exactly one pair?
   public boolean isPair() {
      Integer rank;
      // go through all the cards in the hand
      for(Card card : hand) {
         rank = card.getRank();
         // if there is a pair of cards (aka the rankFrequency.get(rank) is 2)
         // and is not 2 pair and not a full house
         if(rankFrequency.get(rank) == 2 && !isTwoPair() &&!isFullHouse()) {
            return true;
         }
      }
      return false;
   }

   // A nothing hand
   public boolean isNothing() {
      return !(isFlush() || isStraight() || isFullHouse()
              || isFourOfaKind() || isThreeOfaKind()
              || isPair() || isTwoPair());
   }

   @Override
   public String toString() { return hand.toString(); }

   // this = player 1
   // h = player 2
   @Override
   public int compareTo(Hand h) {
      // if player 1 has a better hand then player 2
      if(this.handValue != h.handValue) {
         return this.handValue - h.handValue;
      }
      else {
         if(isStraightFlush() || isStraight()) {
            return this.cardRanks[0] - h.cardRanks[0];
         }
         else if(isFlush()) {
            for(int i=0; i<this.cardRanks.length; i++) {
               if(this.cardRanks[i] == h.cardRanks[i]) {
                  continue;
               }
               else {
                  return this.cardRanks[i] - h.cardRanks[i];
               }
            }
         }
         else if(isFullHouse()|| isFourOfaKind() || isThreeOfaKind()) {
            return this.cardRanks[2] - h.cardRanks[2];
         }

         else {
            return 0;
         }
      }
      return 0;
   }
}