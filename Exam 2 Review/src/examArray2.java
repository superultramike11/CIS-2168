/*
	Write a method which is passed an array of int A[]. 
	The method returns true if A[] is the same backwards and forwards.
*/
import java.io.*;
import java.util.*;

public class examArray2 {
	public static void main(String[] args) {
		int A[] = {2,2,2,2};
		backForth(A);
	}
	
	public static boolean backForth(int A[]) {
		for(int i=0; i<A.length; i++) {
			System.out.print(A[i]);
		}
		System.out.println();
		for(int j=A.length-1; j>=0; j--) {
			System.out.print(A[j]);
		}
		
		for(int i=0; i<A.length; i++) {
			for(int j=A.length-1; j>=0; j--) {
				if(A[i].equals(A[j])) {
					System.out.println("true");
					return true;
				}
			}
		}
		System.out.println("false");
		return false;
	}
}
