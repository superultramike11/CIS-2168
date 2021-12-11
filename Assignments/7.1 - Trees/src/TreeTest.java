public class TreeTest {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<Integer>();

        Integer[] keys = {49, 28, 83, 18, 40, 71, 97, 11, 19, 32, 44, 69, 72, 92, 99};
        System.out.println("Inserting the following keys: ");
        for (Integer key : keys) {
            System.out.printf("%d ", key);
            tree.add(key);
        }
        System.out.printf("%n%nPreorder traversal%n");
        tree.preorderTraversal();

        System.out.printf("%n%nInorder traversal%n");
        tree.inorderTraversal();

        System.out.printf("%n%nPostorder traversal%n");
        tree.postorderTraversal();

        System.out.printf("%n%nLevel Order%n");
        tree.levelorderTraversal();

        /* TESTING THE GETDEPTH METHOD */
        /*
        Tree<Integer> tree = new Tree<>();
        Integer[] keys = {2,1,6,8};
        for (Integer key : keys) {
            System.out.printf("%d ", key);
            tree.add(key);
        }
        System.out.println(tree.getDepth());
        */
    }
}
