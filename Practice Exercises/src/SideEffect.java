public class SideEffect {
    public static int x;

    public static int f(int y) {
        x = x * 2;
        return x + y;
    }

    public static void main(String[] args) {
        x = 1;
        int result = f(x) + f(x);
        result = result + 2 * f(x);
        System.out.println(result);
    }
}
