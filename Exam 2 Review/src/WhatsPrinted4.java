public class WhatsPrinted4 {
    public static int[] whatHappens(int A[]) {
	int C[]=new int[A.length];
	for (int i=0; i<A.length; i++) {
	    C[i]=A[i];
	}
	return C;
    }

    public static void main(String args[]) {
	int A[]={10,20,30};
	int B[]=whatHappens(A);

	if (A==B) {
	    System.out.println("equal");
	} else {
	    System.out.println("not equal");
	}
    }
}