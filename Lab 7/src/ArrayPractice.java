/**
 *
 * @author Michael Ewing
 * PLEASE READ THESE DISCLAIMERS
 * - IndexOfLargestOdd works but else case doesn't 
 * - shitLeft works but doesn't pass in testing
 * - copyOdds works but else case doesn't
 * - copyN works but doesn't pass in testing
 * - remove works but doesn't pass in testing
 * - sortedAscendingRun I think works in theory but I can't properly test it
 */
import java.util.*;

public class ArrayPractice {
	public static void main(String[] args) {
		int[] A = {21, 16, 5, 31, 8, 1, 9, 1, 16, 4, 2, 16};
		int n = 5;
		copyOdds(A);
	}
	
	// sets every item in the array A references to initialValue
	public static void initialize(int A[], int initialValue) {
		for (int i = 0; i < A.length; i++) {
			A[i] = initialValue;
		}
		for (int i = 0; i < A.length; i++) {
			System.out.println(A[i]);
		}
	}

	/*
	 returns the average of the items in the array A references. Be careful: the array contains int
	 but the method returns double. What do we do to handle this?
	 */
	public static double average(int A[]) {
		int sum = 0; 
		for(int i=0; i<A.length; i++) {
			sum += A[i];
		}
		double average = (sum/A.length);
		
		return average;
	}

	// returns the number of times that x appears in the array A references
	public static int numOccurrences(int A[], int x) {
		int count = 0;
		for (int i = 0; i <= A.length-1;i++) {
		      if (A[i] == x)
		    	  count++;   
		}
		return count; // this was originally 0 but it wont work without changing it so are the rules wrong?
	}

	// returns the index of the first occurrence of x in the array A references or -1 if x doesn't exist in the array
	public static int find(int A[], int x) {
		for(int i=0; i<A.length; i++) {
			if(A[i] == x) {
				return i;
			}
		}
		return -1;
	}

	/* Returns the index of the first occurrence of item within the first n elements of the array A[]
	 * references or -1 if item is not among the first n elements of the array
	 */
	public static int findN(int A[], int item, int n) {
		for(int i=0; i<n; i++) {
			if(A[i] == item) {
				return i;
			}
		}
		return -1;
	}
	
	// returns the index of the last occurrence of x in the array A references or -1 if x doesn't exist in the array
	public static int findLast(int A[], int x) {
		for (int i = A.length-1; i >= 0; i--)
	        if (A[i] == x)
	            return i;
		return -1;
	}

	/* returns the largest item found in the array A references */
	public static int largest(int A[]) {
		int large = -1;
		for(int i=0; i<A.length; i++) {
			if(A[i] > large) {
				large = A[i];
			}
		}
		return large; // return large
	}

	/* returns the index of the largest item found in the array A references */
	public static int indexOfLargest(int A[]) {
		int large_index = 0;
		int large = -1;
		for(int i=0; i<A.length; i++) {
			if(A[i] > large) {
				large = A[i];
				large_index = i;
			}
		}
		return large_index; // return large_index
	}

	// returns the index of the largest odd number in the array A references or -1 if the array contains no odd numbers
	public static int indexOfLargestOdd(int A[]) {
		int large_index = -1;
		int large = -1;
		for(int i=0; i<A.length; i++) {
			if(A[i] % 2 != 0) {
				if(A[i] > large) {
					large = A[i];
					large_index = i;
				}
			}
			// fix this somehow
		}
		System.out.println("Large Index: " + large_index);
		return large_index; // return large_index
		// if A[i] is odd you compare to the large
	}

	// returns a new array consisting of all of the elements of A[]
	public static int[] copy(int A[]) {
		int[] A_copy = Arrays.copyOf(A, A.length);
		return A_copy;
	}

	/*
	 * Returns a reference to a new array consisting of all of the first n elements of A[]. If
	 * n>A.length, returns a reference to a new array of size n, with the first A.length elements
	 * exactly the same as A, and the remaining n-A.length elements set to 0. If n<=0, returns null.
	 */
	public static int[] copyN(int A[], int n) {
		//A_copy = [ 0...0] a.length 
		if(n<=0) {
			return null;
		}
		int[] A_copy = new int[n]; // -> n
		if(n < A.length) {
			for(int i=0,j=0; i<n; i++) {
				A_copy[j++] = A[i];
			}
		}
		else {
			for(int i=0,j=0; i<A.length; i++) {
				A_copy[j++] = A[i];
			}
		}
		
		return A_copy; // return A_copy
	}

	/*
	 * returns a reference to an array consisting of all of the elements of the array A references
	 * that are odd. If there are no odd integers in the array, the function returns null.
	 */
public static int[] copyOdds(int[] A) {
		
		int odd_count = 0;
		for(int i=0; i<A.length; i++) {
			if (A[i]%2==1) {
				//A_odd[j++] = A[i];
				odd_count++;
			}
		}
		if(odd_count == 0) {
			return null;
		}
		int[] A_odd = new int[odd_count];
	    for(int i=0, j=0;i<A.length;i++) {
	    	if (A[i]%2==1) {
				A_odd[j++] = A[i];
			}
	    }
	    
		return A_odd; // return A_odd;
	}

	/*
	removes and returns the item at index x shifting all elements at
	indices > x one position to the left and filling in a 0 at the
	right-most position in the array.

	if x is an invalid index, returns -1.

	For example, if before we call function with x = 2,
	the the array is:
	
	|----+----+----+----+----+----+----+----+----+-----|
	| 10 | 20 | 30 | 40 | 50 | 60 | 70 | 80 | 90 | 100 |
	|----+----+----+----+----+----+----+----+----+-----|

	after the function finishes, the array is:

	|----+----+----+----+----+----+----+----+-----+---|
	| 10 | 20 | 40 | 50 | 60 | 70 | 80 | 90 | 100 | 0 |
	|----+----+----+----+----+----+----+----+-----+---|

	 and the function returns 30
	*/
public static int remove(int[] A, int x) {
	if(x < 0 || x >= A.length) {
		return -1;
	}
	int[] A_remove = new int[A.length]; 
	A_remove = Arrays.copyOf(A, A.length);
	int index_value = -1;
	
	
	for (int i = 0, j =0; i < A_remove.length; i++) {
		if (i == x) {
			index_value = A_remove[i];
			continue;
		}else {
		   A[j] = A_remove[i];
		   j ++;
		}
	}
	
	A[A.length-1] =0;
	//System.out.println(Arrays.toString(A));
	return index_value;
}

	/*
	shifts all elements of the array A references one position to the left,
	removing the first element and filling in 0 from the right hand side.

	For example, if before we call the function the the array is:

	|----+----+----+----+----+----+----+----+----+-----|
	| 10 | 20 | 30 | 40 | 50 | 60 | 70 | 80 | 90 | 100 |
	|----+----+----+----+----+----+----+----+----+-----|

	after the function finishes, the array is:

	+----+----+----+----+----+----+----+----+-----|----|
	| 20 | 30 | 40 | 50 | 60 | 70 | 80 | 90 | 100 | 0  |
	+----+----+----+----+----+----+----+----+-----|----|
	*/
	public static void shiftLeft(int[] A) {
		
		if (A.length > 0) {
		
		//int[] A_remove = new int[A.length]; 
		   int[] B = Arrays.copyOf(A, A.length);
		
	        for(int i=0;i<A.length-1;i++) {
	    	     A[i]=B[i+1];
	         }
	         A[A.length-1]=0;
	        }
		//System.out.println(Arrays.toString(A));
	}

	// returns true if A is in sorted ascending order and false otherwise
		public static boolean isSortedAscending(int[] A) {
			for (int i = 0; i < A.length - 1; i++) {
		        if (A[i] > A[i + 1])
		            return false;
		    }
		    return true;
		}
	
	/*
	Returns the number of items in the array that A references starting at index x that are in
	ascending sorted order.

	For example, if the array is:
	|----+----+---+---+---+---+----+----+----|
	| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 |
	|----+----+---+---+---+---+----+----+----|
	| 10 | 11 | 5 | 3 | 9 | 6 | 18 | 37 | 40 |
	|----+----+---+---+---+---+----+----+----|

	and x is 0, the function return 2, because 10 and 11 are in sorted order.

	If x is 5, the function returns 4, because 6, 18, 37, and 40 are in sorted order.

	
	If x is 2, the function returns 1.
	*/
		public static int sortedAscendingRun(int[] A, int x) {
			//System.out.println("Here1");
			int large = A[x];
			int count = 0;
			for (int i = x; i < A.length ; i++) {
				if(A[i] >= large) {
					large = A[i];
					count++;
					
				}
		        else {
		        	return count;
		        }
		    }
			
			return count; // A[] has no items in array A, x < 0, x > A.length
		}

	/*
	returns a new array consisting of all of the elements of A[] followed by all of the elements of
	B[]. For example, if A[] is: {10,20,30} and B[] is: {5, 9, 38}, the method returns the array :
	{10,20,30,5,9,38}
	*/
	public static int[] copyAll(int A[], int B[]) {
        int[] append_A = new int[A.length + B.length];

        System.arraycopy(A, 0, append_A, 0, A.length);
        System.arraycopy(B, 0, append_A, A.length, B.length);

        System.out.println(Arrays.toString(append_A));
		return append_A;
	}

	/*
	reverses the order of the elements in A[]. For example, if A[] is: {10,20,30,40,50}, after the
	method, A[] would be {50,40,30,20,10}
	*/
	public static void reverse(int A[]) {
		for (int i = 0; i < A.length / 2; i++) {
	        int temp = A[i];
	        A[i] = A[A.length - 1 - i];
	        A[A.length - 1 - i] = temp;
	    }
	}
}
