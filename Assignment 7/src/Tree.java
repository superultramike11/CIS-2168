public class Tree<Key extends Comparable> {

        private Node root;
        private static class Node<Key extends Comparable<Key>> {
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


        }
        // Constructor: initializes an empty Binary Search Tree
        public Tree() { root = null; }

        // insert a new node in the binary search tree
        public void add (Key key ) {
                if ( root == null ) root = new Node( key ); // create root node
                else root.insert( key ); // call the insert method
        }

        // begin preorder traversal
        public void preorderTraversal() {
                preorderHelper( root );
        }

        private void preorderHelper( Node node ) {
                if( node == null) return;
                System.out.printf( "%s ", node.data ); // output node data
                preorderHelper( node.left ); // traverse left subtree
                preorderHelper( node.right ); // traverse right subtree
        }

        // begin inorder traversal
        public void inorderTraversal() {
                inorderHelper( root );
        }

        // recursive method to perform inorder traversal
        private void inorderHelper( Node node ) {
                if ( node == null ) return;
                inorderHelper( node.right ); // traverse left subtree
                System.out.printf( "%s ", node.data ); // output node data
                inorderHelper( node.left ); // traverse right subtree
        }

        // begin postorderTraversal
        public void postorderTraversal() {
                postorderHelper( root );
        }

        private void postorderHelper( Node node ) {
                if ( node == null ) return;
                postorderHelper( node.left );
                postorderHelper( node.right);
                System.out.printf( "%s ", node.data ); // output node data
        }

        public void levelOrder( Node node ){

        }
}
// 1: What output do you get for the following tree traversals?
//      preorder: 49 28 18 11 19 40 32 44 83 71 69 72 97 92 99
//      inorder: 11 18 19 28 32 40 44 49 69 71 72 83 92 97 99
//      postorder: 11 19 18 32 44 40 28 69 72 71 92 99 97 83 49


// 2: When you change the keys the pre/postorder will change but the inorder won't change
//      Because inorder sorts all the elements/keys together