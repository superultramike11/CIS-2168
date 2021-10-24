// Solution 1 to the tree exercise of homework 7b.
import java.io.*;
import java.util.*;
public class TreeHeightCalculator {
    int n; // n = # of nodes (node IDs are 0,1,2,3...n-1)
    int parent[]; // parent[i] is parent of node i; if parent[i] = -1, then i is the root

    // Constructor
    public TreeHeightCalculator(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filename));
        n = scanner.nextInt();
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = scanner.nextInt();
            System.out.println("read these parents: " + Arrays.toString(parent));
        }
    }

    // Computes the height of the tree represented by the parent[] array
    int computeHeight() {
        int maxHeight = 0;
        // Write your code here
        return maxHeight;
    }

    // Test Cases
    public static void main(String[] args) throws FileNotFoundException {
        // Test case 1 (sample run 1 of instructions)
        TreeHeightCalculator calculator = new TreeHeightCalculator("tree1.txt");
        //System.out.println(calculator.computeHeight()); // should print 4
    }
}
