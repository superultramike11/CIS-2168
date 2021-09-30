/*
	Write a method same( ), which is passed two arrays of int. 
	The method returns true if the two arrays contain exactly the same contents.
*/
import java.io.*;
import java.util.*;

public class examArray3 {
	public static void main(String[] args) {
		int A[] = {1,2,3,4};
		int B[] = {1,2,7,4};
		same(A, B);
	}
	
	public static boolean same(int A[], int B[]) {
		for(int i=0; i<A.length; i++) {
			if (A[i] != B[i]) {
				System.out.println("They are both not equal");
				return false;
			}
		}
		System.out.println("They are equal");
		return true;
	}

}
