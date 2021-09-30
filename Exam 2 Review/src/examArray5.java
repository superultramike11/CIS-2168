/*
	Write a method called copy, which is passed A[], which is an array of int, and an integer n. 
	The method returns a new array consisting of the first n items in A[].
*/
import java.io.*;
import java.util.*;

public class examArray5 {
	public static void main(String[] args) {
		int A[] = {1,2,3,4};
		int n = 2;
		copy(A, n);
	}
	
	public static int[] copy(int A[], int n) {
		int B[] = new int[A.length];
		
		for(int i=0; i<n; i++) {
			B[i] = A[i];
		}
		
		System.out.println(Arrays.toString(B));
		return B;
	}

}
