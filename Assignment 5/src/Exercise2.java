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

      /*------------- START TEST 1 ---------------*/
      list = new ArrayList<>(List.of(2, 1, 2, 2, 2, 6, 8, 2));
      result = moveToEnd(list, 2);
      System.out.println(result + "\n");  // should print [1, 6, 8, 2, 2, 2, 2, 2]

      /*------------- START TEST 2 ---------------*/
      list = new ArrayList<>(List.of(1, 2, 3, 4));
      result = moveToEnd(list, 3);
      System.out.println(result + "\n");  // should print [1, 2, 4, 3]

      /*------------- START TEST 3 ---------------*/
      list = new ArrayList<>(List.of(0, 8, 3, 0));
      result = moveToEnd(list, 1);
      System.out.println(result + "\n");  // should print [0, 8, 3, 0]

      /*------------- START TEST 4 ---------------*/
      list = new ArrayList<>(List.of(4, 4, 4, 4, 4, 4, 1, 2, 3, 5, 6, 7, 8, 9, 10, 11, 12));
      result = moveToEnd(list, 4);
      System.out.println(result + "\n");  // should print [1, 2, 3, 5, 6, 7, 8, 9, 10, 11, 12, 4, 4, 4, 4, 4, 4]

      /*------------- START TEST 5 ---------------*/
      list = new ArrayList<>(List.of());
      result = moveToEnd(list, 1);
      System.out.println(result + "\n");  // should print []

      /*------------- START TEST 6 ---------------*/
      list = new ArrayList<>(List.of(1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 4, 4, 4, 4, 4, 4));
      result = moveToEnd(list, 4);
      System.out.println(result + "\n");  // should print [1, 2, 3, 6, 7, 8, 9, 10, 11, 12, 4, 4, 4, 4, 4, 4, 4]

      /*------------- START TEST 7 ---------------*/
      list = new ArrayList<>(List.of(1, 1, 1, 1, 1));
      result = moveToEnd(list, 1);
      System.out.println(result + "\n");  // should print [1, 1, 1, 1, 1]
   }
}

