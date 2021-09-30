/*
	Write a method which is passed a two-dimensional array of int and prints it row by row. 
	Do not assume that each row has the same number of columns.
*/
import java.io.*;
import java.util.*;

public class examArray12 {
	public static void main(String[] args) {
		int A[][] = new int[5][5]; 
		print(A);
	}
	
	public static void print(int A[][]) {	
	    for(int i=0; i<5; i++) {
	    	for(int j=0; j<5; j++) {
	    		System.out.println(A[i][j]);
	    	}
	    }
	}
}
