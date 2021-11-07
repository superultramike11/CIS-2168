public class Test {
    public static void main(String[] args) {
        for (int i = 0; i <= 239; i++) {
            int k = i % 239;
            System.out.println(i + " mod 239 = " + k);
        }
    }
}
