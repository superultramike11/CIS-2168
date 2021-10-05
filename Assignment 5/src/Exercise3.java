/*
* while
*   if(A[i] a peak)
*       calculate length
*       if longer length
*           replace previous length
*   else
*       i++;
* */

public class Exercise3 {

    public static int longestPeak(int[] array) {
        int longestPeakLength = 0;
        int tempLength = 0;
        /*
        int j=1;
        for (int i = 1; i < array.length-1; i++) {
            if(isPeak(array, i)) {
                System.out.println("index: " + i);
                System.out.println("Value at element:" + array[i]);
                longestPeakLength = i+1;
                System.out.println("long Peak:" + longestPeakLength);
            }
            else {
                //j++;
            }
        }
        */
        int i=1;

        while(i < array.length-1) {
            // if A[i] is a peak
            if (isPeak(array, i)) {
                // calculate the highestlength and assign it a temp length
                // increment from the middle to both the left and right sides to figure out the bounds
                // longestPeakLength = i + 1;
                // if tempLength is longer
                if (longestPeakLength > tempLength) {
                    // replace previous length
                    tempLength = longestPeakLength;
                }
            } else {
                i++;
            }
        }
        return longestPeakLength;
    }

    // is the element at index i a peak? (i must be > 0 and < a.length - 1)
    private static boolean isPeak(int[] a, int i) {
        return a[i-1] < a[i] && a[i] > a[i + 1];
    }

    // test cases for the longestPeak() method
    public static void main(String[] args) {

        int[] a = {1, 2, 4, 4, 5, 3, 9, 7, 6, 4, 2, 7, 8}; // peak 5
        System.out.println(longestPeak(a)); // longestPeak 6

        /*
        int[] b = {5, 5, 7, 0}; // peak 7
        System.out.println(longestPeak(b)); // longestPeak 3

        int[] c = {1, 2, 3, 3, 4, 5}; // no peak
        System.out.println(longestPeak(c)); // longestPeak 0

        int[] d = {}; // no peak
        System.out.println(longestPeak(d)); // longestPeak 0

        int[] e = {1, 2, 3, 3, 2, 1}; // no peak
        System.out.println(longestPeak(e)); // longestPeak 0

        int[] f = {1, 2, 3, 2, 1, 1}; // peak 3
        System.out.println(longestPeak(f)); // longestPeak 5

        int[] g = {1, 1, 1, 2, 3, 10, 12, -3, -3, 2, 3, 45, 800, 99, 98, 0, -1, -1, 2, 3, 4, 5, 0, -1, -1}; // peak 12
        System.out.println(longestPeak(g)); // longestPeak 9

        int[] h = {1, 2, 3, 3, 4, 0, 8}; // peak 4
        System.out.println(longestPeak(h)); // longestPeak 3
         */
    }
}