import java.util.ArrayList;

class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;
    BinaryTree() { root = null; }

    void printPreorder(Node node, ArrayList<Integer> values) {
        if (node == null) return;

        /* first print data of node */
        values.add(node.key);

        /* then recur on left subtree */
        printPreorder(node.left, values);

        /* now recur on right subtree */
        printPreorder(node.right, values);
    }

    // Driver method
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        ArrayList<Integer> values = new ArrayList<>();

        System.out.println("Preorder traversal of binary tree is ");
        tree.printPreorder(tree.root, values);
        System.out.println(values);
    }
}
