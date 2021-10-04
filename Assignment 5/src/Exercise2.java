import javax.lang.model.element.Element;
import java.util.*;

public class Exercise2<E> {
   // the initial capacity of the underlying resizing array
   private static final int INIT_CAPACITY = 10;

   private E[] elements;   // the underlying array of generic elements
   private int n;          // the number of elements in the list

   /* Constructor: Initializes an empty list. */
   public Exercise2() {
      elements = (E[]) new Object[INIT_CAPACITY];
      n = 0;
   }

   public static List<Integer> moveToEnd(List<java.lang.Integer> list, int b) {
      //------------ YOUR CODE BELOW --------------
      int j=0;
      for (int i = 0; i < list.size(); i++) {
         if(list.get(i) != b) {
            swap(i, j, list);
            j++;
         }
      }
      return list;
   }

   // Returns the number of elements in the list.
   public int size() { return n; }

   // Is this list empty?
   public boolean isEmpty() { return n == 0;}

   // Resizes the underlying array holding the elements
   private void resize(int capacity) {
      assert capacity >= n;
      elements = Arrays.copyOf(elements, capacity);
   }

   // exchanges the elements at positions i and j in the list
   private static void swap(int i, int j, List<Integer> list) { // all ops are constant time here
      int temp = list.get(j);
      list.set(j, list.get(i));
      list.set(i, temp);
   }

   // Returns the item at index without removing it
   public E get(int index) {
      if (index < 0 || index >= n) throw new ArrayIndexOutOfBoundsException();
      return elements[index];
   } // TODO: IMPLEMENT IN CLASS

   public static void main(String[] args) {
      List<Integer> list;
      List<Integer> result;

      //--------------------- TEST 1 -----------------------
      list = new ArrayList<>(List.of(4, 4, 4, 4, 4, 4, 1, 2, 3, 5, 6, 7, 8, 9, 10, 11, 12));
      System.out.println("list:" + list);  // should print [4, 4, 4, 4, 4, 4, 1, 2, 3, 5, 6, 7, 8, 9, 10, 11, 12]

      result = moveToEnd(list, 4);
      System.out.println("result: " + result + "\n");  // should print [1, 2, 3, 5, 6, 7, 8, 9, 10, 11, 12, 4, 4, 4, 4, 4, 4]

      //------------- ADD YOUR OWN TESTS HERE ---------------
   }
}

