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

public class ArrayPracticeDebug {
	public static void main(String[] args) {
		int[] A = {1, 0, 1, 0, 1, 2, 1, 2, 3, 4};
		int n = 0;
		int x = 0;
		
		//System.out.println(remove(A, x));
		System.out.print(sortedAscendingRun(A, 3));
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
}
