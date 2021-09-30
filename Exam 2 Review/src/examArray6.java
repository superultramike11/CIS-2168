/*
	Write a method called slice, which is passed A[], 
	which is an array of int, an integer i and an integer j. 
	The method returns a new array consisting of all of the items in A from A[i] to A[j] inclusive.
*/
import java.io.*;
import java.util.*;

public class examArray6 {
	public static void main(String[] args) {
		int A[] = {1,2,3,4};
		int i = 1;
		int j = 3;
		splice(A, i, j);
	}
	
	public static int[] splice(int A[], int i, int j) {		
		for(int k=i; k<j; k++) {
			System.out.println(A[k]);
		}
		return A;
	}

}
