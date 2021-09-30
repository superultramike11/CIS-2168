/*
	Write a method called copy, which is passed A[], which is an array of int. 
	The method returns a new array consisting of exactly the same items in A[].
*/
import java.io.*;
import java.util.*;

public class examArray4 {
	public static void main(String[] args) {
		int A[] = {1,2,3,4};
		copy(A);
	}
	
	public static int[] copy(int A[]) {
		int B[] = new int[A.length];
		
		for(int i=0; i<A.length; i++) {
			B[i] = A[i];
		}
		
		System.out.println(Arrays.toString(B));
		return B;
	}

}
