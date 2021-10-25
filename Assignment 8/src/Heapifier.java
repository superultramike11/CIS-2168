/*
EXERCISE 10.1
    PLAYGROUND arranged as a max-heap would be
    [Y, U, R, P, G, A, O, L, N, D]

EXERCISE 10.2(a)
    a: [U, T, S, I, O, M, N, C, E, D]
      i  0 1 2 3 4 5 6 7 8 9 10
    a[i] - U T S I O M N C E D
           U
             T S
                 I O M N
                         C E D

EXERCISE 10.3
    run code below to produce heapify output for both
    PLAYGROUND and MISCOUNTED
*/
import java.util.Arrays;

public class Heapifier {
    // Clients shouldn't instanitate this class (use it as shown in main())
    private Heapifier() {};

    // converts array a into a heap
    public static void heapify(Comparable[] a) {
        int n = a.length;
        for(int k=n/2; k >= 1; k--)
            sink(a, k, n);
    }

    // restores the heap invariant for the subtree rooted at index k
    private static void sink(Comparable[] a, int k, int n) {
        while(2*k <= n) {
            int j = 2*k;
            if(j < n && less(a, j, j+1)) j++;
            if(!less(a,k,j)) break;
            exch(a,k,j);
            k = j;
        }
    }

    // Helper methods for comparisons and swaps
    // Indices are "off-by-one" to support 1-based indexing
    private static boolean less(Comparable[] a, int i, int j) {
        return a[i-1].compareTo(a[j-1]) < 0;
    }

    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i-1];
        a[i-1] = a[j-1];
        a[j-1] = swap;
    }

    public static void main(String[] args) {
        Character[] playground = {'P', 'L', 'A', 'Y', 'G', 'R', 'O', 'U', 'N', 'D'};
        System.out.println(Arrays.toString(playground)); // prints [P,L,A,Y,G,R,O,U,N,D]
        Heapifier.heapify(playground);
        System.out.println(Arrays.toString(playground)); // prints [Y,U,R,P,G,A,O,L,N,D]

        Character[] miscounted = {'M', 'I', 'S', 'C', 'O', 'U', 'N', 'T', 'E', 'D'};
        System.out.println(Arrays.toString(miscounted));
        Heapifier.heapify(miscounted);
        System.out.println(Arrays.toString(miscounted));
    }
}
