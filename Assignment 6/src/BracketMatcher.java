import java.util.Stack;

public class BracketMatcher<Item> {
    // procedure isBalanced(string) are the brackets in string, balanced
    public static boolean isBalanced(String text) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            System.out.println(c);
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        In in = new In("test05.txt");
        String text = in.readLine();

        if (isBalanced(text)) System.out.println("Balanced");
        else System.out.println("Not Balanced");
    }
}
