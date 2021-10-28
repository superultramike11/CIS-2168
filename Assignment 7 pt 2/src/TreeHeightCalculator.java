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
            //System.out.println("read these parents: " + Arrays.toString(parent));
        }
    }

    void fill(int i, int MaxHeightArray[]) {
        if(parent[i] == -1) {
            MaxHeightArray[i] = 1;
            return;
        }
        if(MaxHeightArray[parent[i]] == 0) fill(parent[i], MaxHeightArray);
        MaxHeightArray[i] = MaxHeightArray[parent[i]] + 1;
    }

    // Computes the height of the tree represented by the parent[] array
    int computeHeight() {
        int MaxDepthArray[] = new int[n];

        // initalize a new array
        for(int i=0; i<n; i++)
            MaxDepthArray[i] = 0;

        // fill the array based on the elements given in the file
        for(int i=0; i<n; i++)
            fill(i, MaxDepthArray);

        // equate the maxdepth to the first element
        int maxHeight = MaxDepthArray[0];

        // keep comparing the maxHeight to other elements until you reach the max
        for(int i=1; i<n; i++)
            if(maxHeight < MaxDepthArray[i]) maxHeight = MaxDepthArray[i];
        return maxHeight;
    }

    // Test Cases
    public static void main(String[] args) throws FileNotFoundException {
        // Test case 1 (sample run 1 of instructions)
        TreeHeightCalculator calculator1 = new TreeHeightCalculator("tree1.txt");
        System.out.println("The height of this tree is: " + calculator1.computeHeight()); // should print 4

        // Test case 2 (sample run 1 of instructions)
        TreeHeightCalculator calculator2 = new TreeHeightCalculator("tree2.txt");
        System.out.println("The height of this tree is: " + calculator2.computeHeight()); // should print 6

        // Test case 1 (sample run 1 of instructions)
        TreeHeightCalculator calculator3 = new TreeHeightCalculator("tree3.txt");
        System.out.println("The height of this tree is: " + calculator3.computeHeight()); // should print 5
    }
}
