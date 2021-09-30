public class Contains5 {
	public static void main(String[] args) {
		int A[] = {1,2,3,4,5,6};
		int target = 4;
		
		for(int i=0; i<A.length; i++) {
			if(A[i] == target) {
				System.out.println("Your target number was found");
			}
		}
	}
}
