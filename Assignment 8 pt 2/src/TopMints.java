import java.io.*;
import java.util.Arrays;

public class TopMints {
   public static void main(String[] args) {
      System.out.print("\nTest 1\n------\n");
      //System.out.println(" Uncomment lines 9 through 37 in TopMints.java to run this test.");
      //In in = new In("10ints.txt");
      // Uncomment the following line when you are ready to read the file with 1 million integers
      In in = new In("https://gist.githubusercontent.com/david-dobor/b9008e5116f1816675fa15e2256b5168/raw/9baebd0943e90e0f98932ea4d53d1f508fa59dff/1Mints1.txt");

      int m = 5; // keep only top m integers
      int n = in.readInt(); // the first input integer is the number of input lines that follow
      Integer[] ints1 = new Integer[n];

      MinPQ<Integer> pq = new MinPQ<>(m);

      Stopwatch timer1 = new Stopwatch();
      for (int i = 0; i < n; i++) {
         ints1[i] = in.readInt();
         pq.insert(ints1[i]);
         // YOUR CODE HERE (1 or 2 lines should do the job)
         // remove minimum if m+1 entries on the PQ
         if (pq.size() == m+1) {
            pq.delMin(); // we want to keep removing the minimum #'s so we are only left with the 'm' highest numbers
         }
      }
      double time1 = timer1.elapsedTime();

      // print what's in the priority queue
      System.out.printf("\t\t\tTop %d integers are\n", m);
      for (Integer integer : pq) {
         System.out.println(integer);
      }

      // print the time it took to process the entire stream
      System.out.printf("\nIt took %.2f seconds to process %,d integers " +
            "using a priority queue.\n",  time1, n);

      in.close();

      // Start Test 2 (this test sorts n integers and prints the largest m of them)
      System.out.print("\nTest 2\n------\n");

      // Test the time it takes to find m largest using sorting
      in = new In("https://gist.githubusercontent.com/david-dobor/b9008e5116f1816675fa15e2256b5168/raw/9baebd0943e90e0f98932ea4d53d1f508fa59dff/1Mints1.txt");
      int M = 5;
      int N = in.readInt(); // the first input integer is the number of input lines that follow
      Integer[] ints2 = new Integer[N];


      Stopwatch timer2 = new Stopwatch();
      for (int i = 0; i < N; i++) {
         ints2[i] = in.readInt();
      }
      Arrays.sort(ints2);

      double time2 = timer2.elapsedTime();


      // print the largest m integers of the sorted array
      System.out.printf("\t\t\tTop %d integers are\n", M);
      for (int i = N-M; i < n; i++) {
         System.out.println(ints2[i]);
      }

      // print the time it took to process the entire stream
      System.out.printf("\nIt took %.2f seconds to process %,d integers " +
            "by sorting them.\n",  time2, n);

      in.close();
      System.out.println("-------------------------------------------------------------------");
   }
}
/*
sink and swim both take O(logn)
Creating a heap takes constant time O(n)
Extracting an element (sink) is O(logn)
Q1: What is the output with 1 million test
Ans: Test 1
------
			Top 5 integers are
999986
999988
999990
999995
999996

It took 2.75 seconds to process 1,000,000 integers using a priority queue.

Test 2
------
			Top 5 integers are
999986
999988
999990
999995
999996

It took 3.12 seconds to process 1,000,000 integers by sorting them.
-------------------------------------------------------------------

Q2: How long did it take for Test 1 to complete on your computer?
Ans: It took 2.75 seconds to process 1,000,000 integers using a priority queue.

Q3: What is the Big-O running time of Test 1?
Ans: O(mlogn)

Q4: How long did it take for Test 2 to complete on your computer?
Ans: It took 3.12 seconds to process 1,000,000 integers by sorting them.

Q5: What is the Big-O running time of Test 2?
Ans: Array.sort() uses TimSort which is a O(nlogn)
*/