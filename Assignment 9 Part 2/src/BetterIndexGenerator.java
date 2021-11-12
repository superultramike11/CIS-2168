import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class BetterIndexGenerator {

   // A Map that associates Strings (words) with Lists of Integers
   private Map<String, List<Integer>> wordToListMap;

   // Constructor
   public BetterIndexGenerator() { wordToListMap = new HashMap<>(); }

   // Getter method. Returns the wordToListMap.
   public Map<String, List<Integer>> getWordToListMap() { return wordToListMap; }

   // Reads each word in data file and stores it in a Map
   // along with an ArrayList of line numbers (a value).
   public void buildIndex(Scanner scanner) {
      int lineNum = 0; // Line number
      StringTokenizer st;
      String word = null;

      // while scanner has more lines
      while(scanner.hasNextLine()) {
         lineNum++; // increment lineNum
         st = new StringTokenizer(scanner.nextLine()); // declare a str tokenizer that will be used every line

         // while there are more words to read
         while(st.hasMoreTokens()) {
            word = st.nextToken(); // when a word is scanned assign it to word
            List<Integer> lines = wordToListMap.getOrDefault(word, new ArrayList<>()); // create a List to store multiple occurrences of the same word (this is like having 2 names in the same index)
            lines.add(lineNum); // add the line number to lines list
            wordToListMap.put(word, lines); // then put the final product into the map
         }
      }
   }

   // display the wordToListMap
   public void showIndex() {
      for (String word : wordToListMap.keySet()) {
         System.out.println(String.format("%-17s %s", word, wordToListMap.get(word)));
      }
   }

   // display frequencies of word occurrences
   public void showWordFrequency() {
     for (String word : wordToListMap.keySet()) {
        System.out.println(String.format("%-17s %s", word, wordToListMap.get(word).size()));
     }
   }

   // Sorts the Map by Key
   public void sortByKey() {
      ArrayList<String> sortedKeys = new ArrayList<>(wordToListMap.keySet());

      Collections.sort(sortedKeys);

      // Display the TreeMap sorted by key
      for (String word : sortedKeys)
         System.out.println(word + "  " + wordToListMap.get(word));
   }

   public static void main(String[] args) throws FileNotFoundException {

      //Scanner scan = new Scanner(new FileInputStream("tinyTale.txt"));
      Scanner scan = new Scanner(new FileInputStream("tale.txt"));

      BetterIndexGenerator index = new BetterIndexGenerator(); // a BetterIndexGenerator instance
      index.buildIndex(scan);                                  // build the mapping from words to line numbers
      index.showIndex();                                       // display the mapping

      System.out.println();
      index.showWordFrequency();

      index.sortByKey();

      // determine which lines contain the word "fragment"
      String word = "fragment";
      if (index.getWordToListMap().get(word) != null)
         System.out.printf("\nThe word %s appears on these lines: %s\n", word, index.getWordToListMap().get(word));
      else
         System.out.printf("\nThe word %s does not appear in this document", word);
   }
}