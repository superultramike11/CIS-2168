import java.util.*;

public class SunsetViewsNoStack {

   public List<Integer> sunsetViews(int[] buildings, String direction) {

      // O(n) space needed to store the building indexes that will be returned:
      ArrayList<Integer> sunfacing = new ArrayList<>(); // buildings facing the sun (to return)

      int startAt = buildings.length - 1;  // If the sun is in the "EAST", start from the right side
      int step = -1;                       // and step from right to left

      if (direction.equals("WEST")) {     // but if the direction is "WEST,"
         startAt = 0;                     // start from the left side
         step = 1;                        // and move from left to right
      }

      int i = startAt;
      int maxHeight = 0;
      while (i >= 0 && i < buildings.length) { // while runs in O(n) time
         int height = buildings[i];
         if (height > maxHeight) {  // got a taller building at index i,
            sunfacing.add(i);       // it can see the sun, so keep its index.
            maxHeight = height;     // update the running maximum height
         }
         i += step;
      }
      if (direction.equals("EAST")) Collections.reverse(sunfacing); // takes O(n) time
      return sunfacing;
   }

   // a couple of test cases for the sunsetViews() method
   public static void main(String[] args) {
      SunsetViewsNoStack solution = new SunsetViewsNoStack();
      // test 1
      int[] buildings = {3, 5, 4, 4, 3, 1, 3, 2};
      System.out.println(solution.sunsetViews(buildings, "EAST")); // prints [1, 3, 6, 7]
      System.out.println(solution.sunsetViews(buildings, "WEST")); // prints [0, 1]
   }
}