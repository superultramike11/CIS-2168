public class Node<Key extends Comparable<Key>> {
    Key data; // this node's data
    Node<Key> left, right; // this node's children

    // Constructor: initializes data and makes this a leaf node
    public Node(Key key) {
        data = key;
        left = right = null;
    }

    // find insertion point and insert new node, ignoring duplicate keys
    public void insert(Key key) {
        if (key.compareTo(data) < 0) { // insert in the left subtree
            if (left == null) left = new Node(key);
            else left.insert(key); // continue traversing left subtree recursively
        }
        else if (key.compareTo(data) > 0) { // insert in the right subtree
            if (right == null) right = new Node(key);
            else right.insert(key); // continue traversing right subtree recursively
        }
    }

    public String toString() { return data.toString(); }

    public static void main(String[] args) {
        Node<Integer> root = new Node<>(6);
        root.insert(7);
        root.insert(4);
        root.insert(9);
        root.insert(5);

        System.out.println("depth 0:              " + root);
        System.out.println("depth 1:       " + root.left + "            " + root.right);
        System.out.println("depth 2: " + root.left.left + "      " + root.left.right +
                "   " + root.right.left + "   " + root.right.right);
    }
}
