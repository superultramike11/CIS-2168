import java.util.*;

public class Lottery1 {
	public static void main(String[] args) {
	int n = 49; // 1 through n is the set of numbers to draw from
	int k = 6; // how many numbers will be drawn from this set
	
	int[] numbers = new int[n];
	
	for(int i=0; i<n; i++) {
		numbers[i] = i+1;
	}

	int[] result = new int[k];
	
	// draw k numbers from the first array and put them into the second
	for(int i=0; i<6; i++){
	// make a random index between 0 and n - 1
	// YOUR CODE HERE 
		int r = (int) (Math.random() * n); // this scales the 0.0 to 1.0 range
		
	// pick the element at that random index
	// YOUR CODE HERE
		result[i] = numbers[r];
	
	// move the last element (of the first array) into the random location
	// YOUR CODE HERE
		numbers[i] = numbers[numbers.length-1];
		n--;
	}
	// print the sorted array
	//System.out.println("Draw the following integers " + "from the set 1 to " + (n + k) + ":");
	// YOUR CODE HERE
	System.out.println(Arrays.toString(numbers));
	System.out.println(Arrays.toString(result));
	}
}