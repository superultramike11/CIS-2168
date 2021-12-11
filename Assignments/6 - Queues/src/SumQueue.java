import java.util.*;

public class SumQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= 5; i++) {
            queue.add(i);
        }
        System.out.println(queue); // 1,2,3,4,5
        System.out.println(sum(queue)); // what gets printed
        System.out.println(queue); // what gets printed
    }

    public static int sum(Queue<Integer> q) {
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            int n = q.remove();
            sum += n;
        }
        return sum;
    }
}
