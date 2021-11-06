import java.util.*;

public class Hand {

   /****************************** Private fields ******************************/
   // A list of cards in this hand. E.g., [8C, TS, KC, 9H, 4S] is a list of cards.
   private ArrayList<Card> hand = new ArrayList<>();

   // ADD YOUR MAP HERE
   // private
   // Ranks of the cards in this hand in reverse-sorted order. E.g., the hand
   // "8H KC 2S 3S QD" has ranks [13, 12, 8, 3, 2].
   private ArrayList<Integer> cardRanks = new ArrayList<>(5);

   /********************************  Constructor ********************************/
   // Creates a Hand object from an input string representing a hand.
   public Hand(String cards) {
      // hand.removeAll(hand); // clear this hand to create a new one
      for (String token : cards.split("\\s+")) {
         Card card = new Card(token);
         hand.add(card);
      }
      buildRankFrequencyMap(); // generate the map of rank frequencies
      reverseSortRanks();
   }

   /*******************************  Private Methods *******************************/
   // How many times does each rank repeat in this hand? Maps each rank to the number
   // of times it occurs in this hand and returns the map. E.g., "KD KS 9H JC 9S" has
   // two Ks, two 9s, and one J, so its map is {13=2, 11=1, 9=2}.
   private void buildRankFrequencyMap() {
   }

   // generate a list of ranks in decreasing order (the highest rank first, the lowest last).
   private void reverseSortRanks() {
      for (Card c : hand)
         cardRanks.add(c.getRank());
      Collections.sort(cardRanks, Collections.reverseOrder());

      // the only exception is a low straight (called a wheel) where Ace counts as 1.
      if (cardRanks.equals(new ArrayList<>(List.of(14, 5, 4, 3, 2))))
         cardRanks = new ArrayList<>(List.of(5, 4, 3, 2, 1));
   }

   /***********************************  Getters ***********************************/
   // returns the list of card ranks in this hand in descending order
   public ArrayList<Integer> getCardRanks() { return cardRanks; }

   // returns the frequency map for this hand
   public Map<Integer, Integer> getRankFrequency() { /* return rankFrequency; */ return null; }

   // returns the list of Cards in this hand
   public ArrayList<Card> getHand() { return hand; }

   /*********************************************************************************
                        Methods that check for the hand categories
    ********************************************************************************/
   // Is this hand a straight flush?
   public boolean isStraightFlush() { /* CHANGE WITH YOUR CODE */ return false; }

   // Is this hand four of a kind?
   public boolean isFourOfaKind() { /* CHANGE WITH YOUR CODE */ return false; }

   // Is this hand a full house (3 cards of the same rank & 2 cards of the same rank)?
   public boolean isFullHouse() { /* CHANGE WITH YOUR CODE */ return false; }

   // Is this hand a flush? (Can also be a straight.)
   public boolean isFlush() { /* CHANGE WITH YOUR CODE */ return false; }

   // Is this hand a straight? (Can also be a flush.)
   public boolean isStraight() { /* CHANGE WITH YOUR CODE */ return false; }

   // Is this hand three of a kind (also called a set or trips in poker)?
   public boolean isThreeOfaKind() { /* CHANGE WITH YOUR CODE */ return false; }

   // Does this hand contain exactly two pairs?
   public boolean isTwoPair() { /* CHANGE WITH YOUR CODE */ return false; }

   // Does this hand contain exactly one pair?
   public boolean isPair() { /* CHANGE WITH YOUR CODE */ return false; }

   // A nothing hand
   public boolean isNothing() { /* CHANGE WITH YOUR CODE */ return false; }

   @Override
   public String toString() { return hand.toString(); }
}
