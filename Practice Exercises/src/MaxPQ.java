import java.util.NoSuchElementException;

// Class MaxPQ represents a PQ of generic keys
public class MaxPQ<Key> {
    private Key[] pq;
    private int n;

    // Make a empty PQ with the given inital capacity
    public MaxPQ(int initCapacity) {
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }

    // Make an empty PQ
    public MaxPQ() {this(1);}

    // Takes time proportional to the number of keys, using sink-based heap construction
    public MaxPQ(Key[] keys) {
        n = keys.length;
        pq = (Key[]) new Object[keys.length + 1];
        for(int i=0; i<n; i++) {
            pq[i+1] = keys[i];
        }
        for(int k= n/2; k>= 1; k--) {
            sink(k);
        }
    }

    // returns true if this PQ is empty
    public boolean isEmpty() {return n==0;}

    // returns the number of keys on this PQ
    public int size() {return n;}

    // Throws NoSuchElementException if this PQ is empty
    public Key max() {
        if(isEmpty()) throw new NoSuchElementException("PQ underflow");
        return pq[1];
    }

    // helper function to double the size of the heap array
    private void resize(int capacity) {
        assert capacity > n;
        Key[] temp = (Key[]) new Object[capacity];
        for(int i=1; i<=n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    // adds a new key to this PQ
    public void insert(Key x) {
        // double size of array if necessary
        if(n == pq.length-1) resize(2 * pq.length);

        // add x, and percolate it up to maintain heap invariant
        pq[++n] = x;
        swim(n);
    }

    // Removes and returns a largest key on this PQ
    public Key delMax() {
        if(isEmpty()) throw new NoSuchElementException("PQ underflow");
        Key max = pq[1];
        exch(1, n--);
        sink(1);
        pq[n+1] = null; // to avoid loitering and help with garbage collection
        if ((n > 0) && (n == (pq.length -1) /4 )) resize(pq.length /2);
        return max;
    }

    /* Private helper methods below*/

    // restores the heap invariant by percolating up the node at index k
    private void swim(int k) {
        while(k > 1 && less(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    // restores the heap for the subtree rooted at index k
    private void sink(int k) {
        while(2*k <= n) {
            int j = 2*k;
            if(j < n && less(j, j+1)) j++;
            if(!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    // Helper methods for comparisons and swaps
    private boolean less(int i, int j) {
        return ((Comparable<Key>) pq[i]).compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    // Unit tests the MaxPQ data type.
    public static void main(String[] args) {
        MaxPQ<Character> pq = new MaxPQ<>(); // create pq of characters
        Character[] input = {'P', 'Q', 'E', '-', 'X', 'A', 'M', '-', 'P', 'L', 'E', '-'};
        System.out.println("\n\tProcessing characters in [P Q E - X A M - P L E -]");
        System.out.println("\tby placing each character in a max-priority queue and ");
        System.out.println("\tby removing the largest character when I see a '-':");
        for(Character character : input) {
            if (!character.equals('-')) pq.insert(character);
            else if (!pq.isEmpty()) System.out.println(pq.delMax() + " ");
        }
        System.out.println("(" + pq.size() + " left on pq)");
    }
}
