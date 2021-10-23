import java.util.*;

public class Tree<Key extends Comparable> {
        private Node root;

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

        public int getDepth() { return getDepthHelper( root ); }

        private int getDepthHelper( Node node ) {
                if ( node == null ) return 0;
                int leftDepth = getDepthHelper(node.left);
                int rightDepth = getDepthHelper(node.right);
                return (Math.max(leftDepth, rightDepth) + 1);
        }

        public void levelorderTraversal() {
                Queue<Node> q = new LinkedList<>();
                q.add(root);
                while(!q.isEmpty()) {
                        Node node = q.remove();
                        System.out.printf( "%s ", node.data);
                        q.add(node.left);
                        q.add(node.right);
                }
        }
}
// 1: What output do you get for the following tree traversals?
//      preorder: 49 28 18 11 19 40 32 44 83 71 69 72 97 92 99
//      inorder: 11 18 19 28 32 40 44 49 69 71 72 83 92 97 99
//      postorder: 11 19 18 32 44 40 28 69 72 71 92 99 97 83 49


// 2: When you change the keys the pre/postorder will change but the inorder won't change
//      Because inorder sorts all the elements/keys together