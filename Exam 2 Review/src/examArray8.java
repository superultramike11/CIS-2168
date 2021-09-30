/*
	Write a method which is passed an array of int 
	and returns true if the array is sorted in ascending order.
*/
import java.io.*;
import java.util.*;

public class examArray8 {
	public static void main(String[] args) {
		int A[] = {1,2,3,4};
		sortedOrNot(A);
	}
	
	public static boolean sortedOrNot(int A[]) {	
		for (int i = 0; i < A.length - 1; i++) {
	        if (A[i] > A[i + 1])
	            return false;
	    }
	    return true;
	}

}
