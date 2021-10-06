/******************************************************************************
 *
 *  Stack implementation with a resizing array.
 *
 *  % more tobe.txt
 *  to be or not to - be - - that - - - is
 *
 *  % java ResizingArrayStack < tobe.txt
 *  to be not that or be (2 left on stack)
 *
 ******************************************************************************/

import java.util.*;

/**
 *  The ResizingArrayStack class represents a last-in-first-out (LIFO) stack
 *  of generic items.
 *  It supports the usual push and pop operations, along with methods for peeking
 *  at the top item, testing if the stack is empty, and iterating through the
 *  items in LIFO order.
 *
 *  This implementation uses a resizing array, which doubles the underlying array
 *  when it is full and halves the underlying array when it is one-quarter full.
 *  The push and pop operations take constant amortized time. The size, peek, and
 *  is-empty operations takes constant time in the worst case.
 */

public class Stack<Item> implements Iterable<Item> {
   private Item[] a;         // array of items
   private int n;            // number of elements on stack

   // Initializes an empty stack.
   public Stack() {
      // YOUR CODE HERE
   }

   // Is this stack empty?
   public boolean isEmpty() { return n == 0; }

   // Returns the number of items in the stack.
   public int size() { return n; }

   // resize the underlying array holding the elements
   private void resize(int capacity) {
      assert capacity >= n;
      Arrays.copyOf(a, capacity);
   }

   // Adds the item to this stack.
   public void push(Item item) {
      // double size of array if necessary
      if(n == a.length) resize(2 * a.length);
      // add item
      a[n++] = item;
   }

   // Removes and returns the item most recently added to this stack.
   // Throws java.util.NoSuchElementException if this stack is empty.
   public Item pop() {
      if (isEmpty()) throw new NoSuchElementException("Stack underflow");
      // YOUR CODE HERE
      return a[n--];  // <- CHANGE THIS return STATEMENT TO A CORRECT ONE
   }


   // Returns (but does not remove) the item most recently added to this stack.
   public Item peek() {
      if (isEmpty()) throw new NoSuchElementException("Stack underflow");
      // YOUR CODE HERE
      return null;  // <- CHANGE THIS return STATEMENT TO A CORRECT ONE
   }

   // Returns an iterator to this stack that iterates through the items in LIFO order.
   public Iterator<Item> iterator() {
      return new ReverseArrayIterator();
   }

   // an iterator, doesn't implement remove() since it's optional
   private class ReverseArrayIterator implements Iterator<Item> {
      private int i;

      public ReverseArrayIterator() {
         // YOUR CODE HERE
      }

      public boolean hasNext() {
         // YOUR CODE HERE
         return false;  // <- CHANGE THIS return STATEMENT TO A CORRECT ONE
      }

      public void remove() {
         throw new UnsupportedOperationException();
      }

      public Item next() {
         if (!hasNext()) throw new NoSuchElementException();
         // YOUR CODE HERE
         return null;  // <- CHANGE THIS return STATEMENT TO A CORRECT ONE
      }
   }

   // Unit tests the Stack data type.
   public static void main(String[] args) {
      Stack<String> stack = new Stack<String>();
      In in = new In("tobe.txt");
      while (!in.isEmpty()) {
         String item = in.readString();
         if (!item.equals("-")) stack.push(item);
         else if (!stack.isEmpty()) System.out.print(stack.pop() + " ");
      }
      System.out.println("(" + stack.size() + " left on stack)");
   }
}
