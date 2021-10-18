import java.util.Stack;

public class BracketMatcher<Item> {
    // procedure isBalanced(string) are the brackets in string, balanced
    public static boolean isBalanced(String text) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            //System.out.println(c);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                //System.out.println("Pushed: " + stack);
            }
            else {
                if (stack.isEmpty()) {
                    //System.out.println("Empty: " + stack);
                    return false;
                }
                if ((stack.pop() == '[' && c != ']') &&
                    (stack.pop() == '(' && c != ')') &&
                    (stack.pop() == '{' && c != '}')) {
                    //System.out.println("Long if: " + stack);
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        In in = new In("test03.txt");
        String text = in.readLine();

        if (isBalanced("[())[]"))
            System.out.println("Balanced ");
        else
            System.out.println("Not Balanced ");
    }
}
