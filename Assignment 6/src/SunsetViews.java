import java.util.*;

public class SunsetViews {
    public List<Integer> sunsetViews(int[] buildings, String direction) {
        // O(n) space needed to store the building indexes that will be returned:
        Stack<Integer> sunfacing = new Stack<>(); // buildings facing the sun (to return)
        if(direction.equals("EAST")) {
            int maxHeight = 0;
            for(int i = buildings.length-1; i > 0; i--) {
                int height = buildings[i];
                if (height > maxHeight) {
                    sunfacing.push(i);
                    maxHeight = height;
                }
            }
            Collections.reverse(sunfacing); // takes O(n) time do I need to remove this?
        }
        if (direction.equals("WEST")) {
            int maxHeight = 0;
            for(int i= 0; i < buildings.length-1; i++) {
                int height = buildings[i];
                if (height > maxHeight) {
                    sunfacing.push(i);
                    maxHeight = height;
                }
            }
        }
        return sunfacing;
    }

    // a couple of test cases for the sunsetViews() method
    public static void main(String[] args) {
        SunsetViews solution = new SunsetViews();
        // test 1
        int[] buildings = {3, 5, 4, 4, 3, 1, 3, 2};
        System.out.println(solution.sunsetViews(buildings, "EAST")); // prints [1, 3, 6, 7]
        System.out.println(solution.sunsetViews(buildings, "WEST")); // prints [0, 1]
    }
}