/*
procedure isBalanced(string) // are the brackets in string balanced?
    create an empty stack
    for each char in the string:
        if char is one of '(' or '[':
            stack.push(char)
        else
            if stack.isEmpty():
                return false
            top = stack.pop()
            if ( ( top == '[' and char != ']' ) and
               ( top == '(' and char != ')' ) ):
                return false
    return stack.isEmpty()
    // stack must now be empty if the brackets are balanced
 */

import java.util.*;

public class BracketMatcher<Item> {
    private Item[] a; // array of items
    private int n; // # of elements on stack'

    public BracketMatcher() {
        a = (Item[]) new Object[2];
        n = 0;
    }

    public boolean isEmpty() { return n == 0; }
    private void resize(int capacity) { a = Arrays.copyOf(a, capacity); }

    public void push(Item item) {
        if(n == a.length) resize(2*a.length); // double size of array if necessary
        a[n++] = item; // add item
    }

    public Item pop() {
        if(isEmpty()) throw new NoSuchElementException("Stack Underflow");
        Item item = a[n-1];
        a[n-1] = null;
        n--;
        if(n>0 && n == a.length/4) resize(a.length/2);
        return item;
    }

    // procedure isBalanced(string) are the brackets in string, balanced
    public static boolean isBalanced(String text) {
        Stack<Character> stack = new Stack<>();
        for (int i = 1; i <= text.length(); i++) {
            char c = text.charAt(i - 1);

            if (c == '(' || c == '[' || c == '{') {
                System.out.println(stack);
                stack.push(c);
            }
            else {
                if (stack.isEmpty()) {
                    System.out.println(stack);
                    return false;
                }
                if ( ( stack.pop() == '[' && c != ']' ) &&
                   ( stack.pop() == '(' && c != ')' ) )
                {
                    System.out.println(stack);
                    return false;
                }
            }
        }
        System.out.println(stack);
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        In in = new In("test08.txt"); // axl(rose) IT'S BALANCED
        String text = in.readLine();
        System.out.println("processing: " + text); // comment out or delete this line before submitting

        // Function call
        String expr = "([{}])";
        if (isBalanced(expr))
            System.out.println("Balanced ");
        else
            System.out.println("Not Balanced ");
    }
}
