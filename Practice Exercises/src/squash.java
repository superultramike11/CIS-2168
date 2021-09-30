import java.util.Arrays;

public class squash {
	public static void squash(int A[]) {
		for(int i=0; i<A.length-1; i++) {
			if(A[i] == A[i+1]) {
				A[i] = -1;
			}
		}
		
		System.out.println(Arrays.toString(A));
	}
	
	public static void main(String[] args) {
		int A[] = {0,0,0,0,1,1,0,0,0,7,7,7,1,1,0};
		
		squash(A);
	}
}