import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    Tree left, right;
    int root;
    public Tree(int root) {
        this.root = root;
    }

    public void insert(int key) {
        // if the tree value is smaller than the root
        if(key <= root) {
            // and no left child, make a new left child
            if(left == null) left = new Tree(key);
            // if there is a child then compare tree value to THAT root and repeat
            else left.insert(key);
        }
        // if the tree value is greater than the root
        else {
            // and no right child, make a new right child
            if(right == null) right = new Tree(key);
            // if there is a child then compare node value to THAT root and repeat
            else right.insert(key);
        }
    }

    // Inorder traversal
    public void printInOrder() {
        if(left != null) left.printInOrder(); // left
        System.out.print(root + " "); // root
        if(right != null) right.printInOrder(); // right
    }

    public static void main(String[] args) {
        // make a new tree with a root of 10
        Tree tree = new Tree(10);
        // insert key 15 into tree (goes to the right of 10)
        tree.insert(15);
        // insert key 5 into tree (goes to the left of 10)
        tree.insert(5);

        // print tree in order
        System.out.println("Inorder Traversal");
        tree.printInOrder();
    }
}
