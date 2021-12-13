import java.util.Stack;

public class BracketMatcher<Item> {
    // procedure isBalanced(string) are the brackets in string, balanced
    public static int isBalanced(String text) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if(c == '{' || c == '[' || c == '(') stack.push(c);
            if(c == ')' || c == '}' || c == ']') {
                if(stack.isEmpty()) return i;
                if (c == '}' && stack.peek() == '{' || c == ')' && stack.peek() == '(' ||  c == ']' && stack.peek() == '[') {
                    stack.pop();
                }
                else return i;
            }
        }
        boolean c = stack.isEmpty();
        if (c == true) return -1;
        else return text.length() - 1;
    }

    public static void main(String[] args) {
        In in = new In("test09.txt");
        String text = in.readLine();

        int answer = isBalanced(text);
        if(answer == -1) System.out.println("Balanced");
        else {
            answer++;
            System.out.println(answer);
        }
    }
}
