// MUST use stack w/ push(), pop(), peek(), size(), isEmpty()

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
        if (direction.equals("EAST")) Collections.reverse(sunfacing); // takes O(n) time
        //System.out.println("Stack: " + sunfacing);
        return sunfacing;
    }

    // a couple of test cases for the sunsetViews() method
    public static void main(String[] args) {
        SunsetViews solution = new SunsetViews();
        // test 1
        int[] buildings = {3, 5, 4, 4, 3, 1, 3, 2};
        System.out.println(solution.sunsetViews(buildings, "EAST")); // prints [1, 3, 6, 7]
        System.out.println(solution.sunsetViews(buildings, "WEST")); // prints [0, 1]

        // test 2
        buildings = new int[]{0, 1};
        System.out.println(solution.sunsetViews(buildings, "EAST")); // prints [1]
        System.out.println(solution.sunsetViews(buildings, "WEST")); // prints [1]

        // test 3
        buildings = new int[]{};
        System.out.println(solution.sunsetViews(buildings, "EAST")); // prints []
        System.out.println(solution.sunsetViews(buildings, "WEST")); // prints []

        // test 4
        buildings = new int[]{1, 2, 3, 1, 5, 6, 9, 1, 9, 9, 11, 10, 9, 12, 8};
        System.out.println(solution.sunsetViews(buildings, "EAST")); // prints [13, 14]
        System.out.println(solution.sunsetViews(buildings, "WEST")); // prints [0, 1, 2, 4, 5, 6, 10, 13]
    }
}