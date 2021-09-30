public class WhatsPrinted1 {
    public static void whatsPrinted(int A[]) {
	for (int i=1; i<A.length; i++) {
	    A[i]=A[i-1]*2+1;
	}
    }

    public static void main(String args[]) {
	int A[] = {12,3,8,9,7,11};
	whatsPrinted(A);
	System.out.println(A[A.length-1]);
    }
}
