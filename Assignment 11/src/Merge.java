/******************************************************************************
 *  Compilation:  javac Merge.java
 *  Execution:    java Merge < input.txt
 *  Dependencies: In.java
 *  Data files:   10ints.txt
 *
 *  Sorts a sequence of integers from an input file using mergesort.
 *
 *  % more 10ints.txt
 *  10                        [first  line: how many integers to sort]
 *  4 1 3 2 16 9 10 14 8 7    [second line: the integers to sort ]
 *
 ******************************************************************************/

//  The Merge class provides static methods for sorting an array of integers
//  using mergesort. See Merge2 for a class that sorts an array of comparable objects.
public class Merge {
   // This class should not be instantiated.
   private Merge() { }

   // stably merge a[lo .. mid] with a[mid+1 ..hi] using aux[lo .. hi]
   private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
      // copy to aux[]
      for (int k = lo; k <= hi; k++) {
         aux[k] = a[k];
      }

      // merge back to a[]
      int i = lo, j = mid+1;
      for (int k = lo; k <= hi; k++) {
         if      (i > mid)              a[k] = aux[j++]; // left sub-array border check
         else if (j > hi)               a[k] = aux[i++]; // right sub-array border check
         else if (aux[j] < aux[i])      a[k] = aux[j++]; // put smaller element in aux array
         else                           a[k] = aux[i++]; // if none, put element in aux array
      }
   }

   // mergesort a[lo..hi] using auxiliary array aux[lo..hi]
   private static void sort(int[] a, int[] aux, int lo, int hi) {
      if (hi <= lo) return;
      int mid = lo + (hi - lo) / 2;
      sort(a, aux, lo, mid); // sort left sub-array
      sort(a, aux, mid + 1, hi); // sort right sub-array
      merge(a, aux, lo, mid, hi); // merge the two sub-arrays back together
   }

   // Rearranges the array in ascending order, using the natural order.
   public static void sort(int[] a) {
      int[] aux = new int[a.length];
      sort(a, aux, 0, a.length-1);
   }

   // print array to standard output
   private static void show(int[] a) {
      for (int i = 0; i < a.length; i++) {
         System.out.print(a[i] + " ");
      }
   }

   // Reads in a sequence of strings from standard input; merge sorts them;
   // and prints them to standard output in ascending order.
   public static void main(String[] args) {
      In in = new In("10ints.txt");
      int n = in.readInt();
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
         a[i] = in.readInt();
      }
      final long startTime = System.nanoTime();
      Merge.sort(a);
      final long endTime = System.nanoTime();
      show(a);
      System.out.println("Total execution time: " + (endTime - startTime));
   }
}
