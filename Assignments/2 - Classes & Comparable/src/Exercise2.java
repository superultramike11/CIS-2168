import java.util.Arrays;

public class Exercise2 {
   public static void main(String[] args) {
      int a[] = {2,11,7,50};
      int target = 9;
      int sums[] = new int[2];
      
      for(int i=0; i<a.length; i++) {
    	  int first = a[i];
    	  for(int j=0; j<a.length; j++) {
    		  int second = a[j];
    		  if(first + second == target) {
    			  sums[0] = first;
    			  sums[1] = second;    			  
    		  }
    	  }
      }
      System.out.println(Arrays.toString(sums));
   }
} 