import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1Part2 {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Scanner textfile = new Scanner(new File("input.txt"));
        while (textfile.hasNextLine()) {
            int line = textfile.nextInt();
            list.add(line);
        }
        int inc = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            try {
                int sum1 = list.get(i) + list.get(i+1) + list.get(i+2);
                int sum2 = list.get(i+1) + list.get(i+2) + list.get(i+3);
                if (sum2 > sum1) {
                    inc++;
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println(inc);
                break;
            }
        }
    }
}
