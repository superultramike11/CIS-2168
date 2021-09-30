import java.util.Arrays; 

class remove { 
	public static int removeTheElement(int[] A, int x) { 
		int[] A_remove = new int[A.length - 1]; 
		int index_value = -1;
		
		// copy to a new array
		for (int i = 0, j = 0; i < A.length; i++) { 
			if (i == x) { 
				index_value = A[i];
				continue; 
			} 
			A_remove[j++] = A[i]; 
		} 
		
		// shift the new array
		for(int i=0;i<A_remove.length-1;i++) {
			A_remove[i]=A_remove[i+1];
	    }
		A_remove[A_remove.length-1]=0;

		System.out.println(index_value);
		// return the resultant array 
		return index_value;
	} 

	public static void main(String[] args) { 
		int[] A = { 1, 2, 3, 4, 5 }; 
		int x = 2; 
		
		System.out.println("Original Array: " + Arrays.toString(A)); 

		System.out.println("Index to be removed: " + x); 


		System.out.println("Resultant Array: " + Arrays.toString(A)); 
	} 
} 
