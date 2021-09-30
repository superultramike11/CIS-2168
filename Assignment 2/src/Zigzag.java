import java.util.ArrayList;
import java.util.List;

public class Zigzag {
   public static List<Integer> zigzag(List<List<Integer>> array) {
      int height = array.size() - 1;
      int width = array.get(0).size() - 1;
      List<Integer> result = new ArrayList<>();
      int row = 0;
      int col = 0;
      
      // Your code below:
      boolean canGoDown = true; 
      while(outOfBounds(row, col, height, width) == false) {
    	  result.add(array.get(row).get(col));
    	  if(canGoDown == true) {
    		  if(col == 0 || row == height /*on the left or bottom boundary*/) {
    			  if(row == height /*on the bottom boundary*/) {
    				  // go right
    				  col++;
    			  }
    			  else { 
    				  // go down
    				  row++;
    			  }
    			  canGoDown = false; // should this be here or inside the condition above?
    		  } 
    		  else {
    			  // go left and down
    			  col--;
    			  row++;
    		  }
    	  }
    	  else { 
    		  if(row == 0 || col == width) { /*on the up or right boundary*/
    			  if(col == array.get(0).size()-1) { /*on the right boundary*/
    				  // go down
    				  row++;
    			  }
    			  else {
    				  // go right
    				  col++;
    			  }
    			  canGoDown = true; // should this be here or inside the condition above?
    		  }
    		  else {
    			  // go right and up
    			  col++;
    			  row--; 
    		  }
    	  }
      }
      /*
      canGoDown = T
      While(inside the matrix)
      	results.add(current element)
      	if canGoDown == T
      		if on the left or bottom boundary
      			if on the bottom boundary: go right
      			else (on the left boundary): go down
      			canGoDown = F
      		else: go left down
      	else
      		if on the up or right boundary
      			if on the right boundary: go down
      			else(on the up boundary): go right
      			canGoDown = T
      		else: go right up
      */

      return result;
   }

   // Feel free to use this method -- it's intended to simplify your code in
   // the zigzag method. Otherwise, write your own, or delete it if you'd like.
   public static boolean outOfBounds(int row, int col, int height, int width) {
      return row < 0 || row > height || col < 0 || col > width;
   }

   // These are the test-cases to help you debug your code.
   // (Some test-cases are commented out. Feel free to uncomment them.)
   public static void main(String[] args) {

      List<List<Integer>> table;
      List<Integer> result;

      List<Integer> row1, row2, row3, row4, row5, row6;  // in test cases, these will be table rows

      /*------------- START TEST 1 ---------------*/
      row1 = new ArrayList<>(List.of(1, 3, 4, 7));
      row2 = new ArrayList<>(List.of(2, 5, 6, 8));
      table = new ArrayList<>(List.of(row1, row2));
      result = zigzag(table);
      System.out.println("Test 1 result: \n\t " + result + "\n"); // [ 1, 2, 3, 4, 5, 6, 7, 8 ]

      /*------------- START TEST 2 ---------------*/
      row1 = new ArrayList<>(List.of(1, 3, 4, 10));
      row2 = new ArrayList<>(List.of(2, 5, 9, 11));
      row3 = new ArrayList<>(List.of(6, 8, 12, 15));
      row4 = new ArrayList<>(List.of(7, 13, 14, 16));
      table = new ArrayList<>(List.of(row1, row2, row3, row4));
      result = zigzag(table);
      System.out.println("Test 2 result: \n\t " + result + "\n");  // should print [ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]

      /*------------- START TEST 3 ---------------*/
      row1 = new ArrayList<>(List.of(1)); // [1]
      table = new ArrayList<>(List.of(row1));
      result = zigzag(table);
      System.out.println("Test 3 result: \n\t " + result + "\n");  // should print [1]

      /*------------- START TEST 4 ---------------*/
      row1 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7));
      table = new ArrayList<>(List.of(row1));
      result = zigzag(table);
      System.out.println("Test 4 result: \n\t " + result + "\n");  // should print [1, 2, 3, 4, 5, 6, 7]

      /*------------- START TEST 5 ---------------*/
      row1 = new ArrayList<>(List.of(1));
      row2 = new ArrayList<>(List.of(2));
      row3 = new ArrayList<>(List.of(3));
      row4 = new ArrayList<>(List.of(4));
      table = new ArrayList<>(List.of(row1, row2, row3, row4));
      result = zigzag(table);
      System.out.println("Test 5 result: \n\t " + result + "\n");  // should print [1, 2, 3, 4]
      }
}