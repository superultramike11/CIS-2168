/*
	Write a method called copy, which is passed A[], 
	which is an array of int, and an integer n. 
	The method returns a new array consisting of all of the items in A[] which are greater or equal to n.
*/
import java.io.*;
import java.util.*;

public class examArray7 {
	public static void main(String[] args) {
		int A[] = {1,2,3,4};
		int n = 3;
		copy(A, n);
	}
	
	public static int[] copy(int A[], int n) {	
		int B[] = new int[A.length];
		
		for(int i=0; i<A.length; i++) {
			if(A[i] >= n) {
				B[i] = A[i];
			}
		}
		
		System.out.println(Arrays.toString(B));
		return B;
	}

}
