public class BinarySearch {
	public static int indexOf(int A[], int target) {
		int lo = 0;
		int hi = A.length-1;
		
		while(lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			
			if(target < A[mid]) {
				hi = mid - 1;
			}
			else if (target > A[mid]) {
				lo = mid + 1;
			}
			else {
				return mid;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int A[] = {11,13,17,19,21,23,29,37,43,51,57,68,73,89,91};
		int target = 23;
		
		System.out.println(indexOf(A, target));
	}
}
