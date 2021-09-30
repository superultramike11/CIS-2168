/*
	Write a method called generateTriangleNumbers(). 
	This method will take in an integer x and will return an array of integers containing the first x triangle numbers. 
	The nth triangle number is the sum of 1 + 2 + 3 + 4...(n - 1) + n.
		generateTriangleNumbers(3) returns the array {1,3,6}
		generateTriangleNumber(1) returns the array {1}
		generateTriangleNumbers(7) returns the array {1, 3, 6, 10, 15, 21, 28}
*/
import java.io.*;
import java.util.*;

public class examArray9 {
	public static void main(String[] args) {
		int x = 3;
		generateTriangleNumbers(x);
	}
	
	public static int[] generateTriangleNumbers(int x) {	
		int A[] = new int[x];
		for(int i=0; i<A.length; i++) {
			A[i] = ((A[i] - 1) + A[i]);
		}
		System.out.println(Arrays.toString(A));
		return A;
	}
}
