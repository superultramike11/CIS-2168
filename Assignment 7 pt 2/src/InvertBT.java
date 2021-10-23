public class InvertBT {
    private Node root;
    private static class Node<Key extends Comparable<Key>> {
        Key data;
        Node<Key> left, right;

        public Node(Key key) {
            data = key;
            left = right = null;
        }
    }

    // study and redo this
    public Node InvertBT(Node root) {
        if (root == null) {
            return null;
        }

        final Node left = root.left,
                right = root.right;
        root.left = InvertBT(right);
        root.right = InvertBT(left);
        return root;
    }

    public static void main(String[] args) {
        InvertBT tree = new InvertBT();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        System.out.println("Tree Presentation");
        System.out.println("depth 0:      " + tree.root.data);
        System.out.println("depth 1:   " + tree.root.left.data + "       " + tree.root.right.data);


        System.out.println("Inverting the Tree");
        tree.InvertBT(tree.root);

        System.out.println("Inverted Tree Presentation");
        System.out.println("depth 0:      " + tree.root.data);
        System.out.println("depth 1:   " + tree.root.left.data + "       " + tree.root.right.data);
    }
}
