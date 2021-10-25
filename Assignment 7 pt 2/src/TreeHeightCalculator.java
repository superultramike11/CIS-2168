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

    // Maybe this will help?
    public int getDepth() { return getDepthHelper( root ); }

    private int getDepthHelper( Node node ) {
        if ( node == null ) return 0;
        int leftDepth = getDepthHelper(node.left);
        int rightDepth = getDepthHelper(node.right);
        return (Math.max(leftDepth, rightDepth) + 1);
    }

    // Computes the height of the tree represented by the parent[] array
    int computeHeight() {
        int maxHeight = 0;
        for (int i=0; i<parent.length; i++) {
            if(parent[i] == -1) {
                System.out.println("The root is " + i);
            }
        }
        return maxHeight;
    }

    // Test Cases
    public static void main(String[] args) throws FileNotFoundException {
        // Test case 1 (sample run 1 of instructions)
        TreeHeightCalculator calculator = new TreeHeightCalculator("tree1.txt");
        System.out.println("The height of this tree is: " + calculator.computeHeight()); // should print 4
    }
}
