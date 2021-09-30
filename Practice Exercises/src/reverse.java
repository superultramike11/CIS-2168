import java.util.*;

public class reverse {
	public static void main(String[] args) {
		int a[] = {1,2,3,4,5};
		
		System.out.println(a.length - 1 - 0);
		
		//                2
		for(int i=0; i<a.length / 2; i++) {
		//  temp equals index 0
			int temp = a[i];
		
		//	index 0 equals 
			a[i] = a[a.length - 1 - i];
			
		//		
			a[a.length - 1 - i] = temp;
		}
		
		System.out.println(Arrays.toString(a));
	}
}
