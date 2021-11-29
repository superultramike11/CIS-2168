import java.util.*;

public class Test {
    public static void main(String[] args) {
        int n = 50;
        Stack<Integer> s = new Stack<>();
        while (n > 0) {
            s.push(n % 2);
            n = n / 2;
        }
        while (!s.isEmpty())
            System.out.print(s.pop());
    }
}
