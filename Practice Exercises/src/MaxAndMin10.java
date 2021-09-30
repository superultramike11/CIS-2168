public class MaxAndMin10 {
	public static void main(String[] args) {
		// Find the max and min value of an array
		//int A[] = {5,10,15,20,25,30};
		int B[] = {550, 5789, 2345, 8901, 4002};
		int max = 0;
		int min = 1000000;
		
		for(int i=0; i<B.length; i++) {
			if(B[i] > max) {
				max = B[i];
			}
			if(B[i] < min) {
				min = B[i];
			}
		}
		System.out.println("The max in B is: " + max + ", The min in B is: " + min);
	}
}