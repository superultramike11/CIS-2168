import java.util.*;

public class HalfLife {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the radioactive parent amount:");
        int RP = sc.nextInt(); // 12

        System.out.println("Enter the stable daughter amount (MUST BE BIGGER):");
        int SD = sc.nextInt(); // 88

        halflife(RP, SD);
    }

    public static void halflife(int RP, int SD) {
        int halflifes = 0;

        while(SD >= RP) {
            SD /= 2;
            halflifes++;
            if(SD <= RP) System.out.println("Halflifes: " + halflifes);
        }
    }
}
