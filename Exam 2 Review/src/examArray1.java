/*
	Write a method which is passed A[], 
	which is an array of int, and an int passingScore. 
	The method returns the number of items in A[] which are greater than or equal to passingScore.
*/
import java.io.*;
import java.util.*;

public class examArray1 {
	public static void main(String[] args) {
		int[] A = {63, 75, 86, 99, 100};
		numOfItems(A);
	}
	
	public static int numOfItems(int A[]) {
		int passingScore = 65;
		int passingScoreCount = 0;
		for(int i=0; i<A.length; i++) {
			if(A[i] >= passingScore) {
				passingScoreCount++;
			}
		}
		System.out.println(passingScoreCount);
		return passingScoreCount;
	}
}
