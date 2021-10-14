/*
procedure isBalanced(string) // are the brackets in string, balanced
    create an empty stack
    for each char in the string:
        if char is one of '(' or '[';
            stack.push(char)
        else
            if stack.isEmpty();
                return false;
            top = stack.pop()
            if ( ( top == '[' and char != ']' ) AND
               ( top == '(' and char != ')' ) );
               return false
    return stack.isEmpty()
        // stack must now be empty if the brackets are balanced
 */

import java.util.*;

public class BracketMatcher<Item> implements Iterable<Item> {
    private Item[] a; // array of items
    private int n; // number of elements on stack

    // Initializes an empty stack
    public BracketMatcher() {
        a = (Item[]) new Object[2];
        n = 0;
    }

    // The methods isEmpty(), size(), resize() are the same as in ResizingArrayList
    public boolean isEmpty() { return n == 0; }
    public int size() { return n; }
    private void resize(int capacity) { a = Arrays.copyOf(a, capacity); }

    // Adds the item to this stack
    public void push(Item item) {
        if (n == a.length) resize(2*a.length); // double size of array
        a[n++] = item;
    }

    // Removes and returns the item most recently added to this stack
    // Throws java.util.NoSuchElementException if this stack is empty
    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = a[n-1];
        a[n-1] = null; // to avoid loitering
        n--;
        // shrink size of array if necessary
        if (n > 0 && n == a.length/4) resize(a.length/2);
        return item;
    }

    // Returns (but does not remove) the item most recently added to this stack
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack Underflow");
        return a[n-1];
    }

    // Returns an iterator to this stack that iterates through the items in LIFO order.
    public Iterator<Item> iterator() { return new ReverseArrayIterator(); }

    // an iterator, doesn't implement remove() since it's optional
    private class ReverseArrayIterator implements Iterator<Item> {
        private int i;
        public ReverseArrayIterator() { i = n-1; }
        public boolean hasNext() { return i >= 0; }
        public void remove() {throw new UnsupportedOperationException(); }
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return a[i--];
        }
    }

    public static void main(String[] args) {

    }
}
