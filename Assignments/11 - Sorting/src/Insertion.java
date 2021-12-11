/******************************************************************************
 *  Compilation:  javac Insertion.java
 *  Execution:    java Insertion < input.txt
 *  Dependencies: In.java
 *  Data files:   10ints.txt
 *
 *  Sorts a sequence of integers from an input file using mergesort.
 *
 *  % more 10ints.txt
 *  10                        [first  line: how many integers to sort]
 *  4 1 3 2 16 9 10 14 8 7    [second line: the integers to sort ]
 *
 * (A) implemented below
 * (B) O(n^2)
 * (C) Insertion Sort took 3900 nano seconds
 *     Merge Sort took 8100 nano seconds
 * (D) Both Insertion and Merge sort are stable sorting algorithms
 * (E) Insertion sort has two main advantages, it works best with small scale arrays/data
 *     That's why it performs better than Merge Sort (even though merge has better Big O)
 *     And the second main advantage is that insertion takes up a space complexity of O(1)
 *     while Merge Sort has a space complexity of O(n).
 ******************************************************************************/

// Insertion class provides static methods for sorting an
// array of integers using insertion sort.
public class Insertion {

   // This class should not be instantiated.
   private Insertion() {
   }

   // Rearranges the array in ascending order.
   public static void sort(int[] a) {
      for(int i=1; i<a.length; i++) {
         int key = a[i];
         int j = i-1;
         while (j >= 0 && a[j] > key) {
            a[j+1] = a[j];
            j = j-1;
         }
         a[j+1] = key;
      }
   }

   // print array to standard output
   private static void show(int[] a) {
      for (int i = 0; i < a.length; i++) {
         System.out.print(a[i] + " ");
      }
   }

   // Reads in a sequence of integers from a file; insertion sorts them;
   // and prints them to standard output in ascending order.
   public static void main(String[] args) {
      In in = new In("10ints.txt");
      int n = in.readInt();
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
         a[i] = in.readInt();
      }
      final long startTime = System.nanoTime();
      Insertion.sort(a);
      final long endTime = System.nanoTime();
      show(a);
      System.out.println("Total execution time: " + (endTime - startTime));
   }
}