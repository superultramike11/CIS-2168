import java.io.*;
import java.util.*;

public class UnqiueWords {
    public static void main(String[] args) throws FileNotFoundException {
        Set<String> words = new HashSet<>();
        Scanner in = new Scanner(new File("mobydick.txt"));
        while(in.hasNext()) {
            String word = in.next();
            word = word.toLowerCase();
            words.add(word);
        }
        System.out.println(words.size());
    }
}
