/*
    - Add a correct yellow check
    - Maybe adjust print out
*/
import java.util.Scanner;

public class Wordle {
    public static void main(String[] args) {
        String dicWord = "crane";
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Wordle!");
        System.out.println("The Word is: " + dicWord);
        System.out.println("Please type your word now");
        String userWord = sc.nextLine();

        printDicWord(dicWord, userWord);
        printUserWord(dicWord, userWord);
        checkWords(dicWord, userWord);
    }

    public static void printDicWord(String dicWord, String userWord) {
        // Prints each letter in dictonary word
        System.out.println("Dic word is:");
        for(int i = 0; i<dicWord.length(); i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for(int i = 0; i<dicWord.length(); i++) {
            char c = dicWord.charAt(i);
            System.out.print(c + " ");
        }
        System.out.println();
        System.out.println("--------------------------");
    }

    public static void printUserWord(String dicWord, String userWord) {
        // Prints each letter in user word
        System.out.println("User word is:");
        for(int i = 0; i<dicWord.length(); i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for(int i = 0; i<userWord.length(); i++) {
            char c = userWord.charAt(i);
            System.out.print(c + " ");
        }
        System.out.println("");
        for (int i = 0; i < userWord.length(); i++) {
            if (userWord.charAt(i) == dicWord.charAt(i)) {
                System.out.print("G ");
            } else if (dicWord.indexOf(userWord.charAt(i)) != -1) {
                System.out.println("Y ");
            } else {
                System.out.print("R ");
            }
        }
        System.out.println("--------------------------");
    }

    public static void checkWords(String dicWord, String userWord) {
        int tries = 0;
        Scanner sc = new Scanner(System.in);

        while(!userWord.equals(dicWord)) {
            tries++;
            System.out.println("# of Tries: " + tries);
            if(tries == 6) {
                System.out.println("You lost");
                System.exit(0);
            }
            System.out.println("Please type your word now");
            userWord = sc.nextLine();
            printUserWord(dicWord, userWord);
        }

        if(userWord.equals(dicWord)) {
            System.out.println("You win!");
        }
    }

    // Implement later
    public static void yellowCheck(String dicWord, String userWord) {
        for(int i = 0; i<userWord.length(); i++) {
            if(dicWord.indexOf(userWord.charAt(i)) != -1) {
                System.out.print("Y ");
            }
        }
    }
}