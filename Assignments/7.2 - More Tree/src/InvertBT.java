import java.util.*;
public class InvertBT {
    public Node root;
    private static class Node<Key extends Comparable<Key>> {
        Key data; // this node's data
        Node<Key> left, right; // this node's children

        // Constructor: initializes data and makes this a leaf node
        public Node(Key key) {
            data = key;
            left = right = null;
        }

        public String toString() { return data.toString(); }
    }

    public Node invertBT(Node root) {
        if (root==null) return root;

        Node left = invertBT(root.left);
        Node right = invertBT(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    public void levelorderTraversal() {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            Node x = q.remove();
            if(x!=null) {
                System.out.printf("%s ", x.data);
                q.add(x.left);
                q.add(x.right);
            }
        }
    }

    public static void main(String[] args) {
        InvertBT tree = new InvertBT();
        // Depth 0
        tree.root = new Node(4);
        // Depth 1
        tree.root.left = new Node(2);   tree.root.right = new Node(7);
        // Depth 2
        tree.root.left.left = new Node(1);  tree.root.left.right = new Node(3);     tree.root.right.left = new Node(6);    tree.root.right.right = new Node(9);

        System.out.println("Non-Inverted Level Order Traversal");
        tree.levelorderTraversal();
        System.out.println();

        System.out.println("Inverted Level Order Traversal");
        tree.invertBT(tree.root);
        tree.levelorderTraversal();
    }
}