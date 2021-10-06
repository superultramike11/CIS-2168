import java.util.*;

public class HalfLife {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the radioactive parent amount:");
        double RP = sc.nextInt(); // 12 or 25

        System.out.println("Enter the stable daughter amount (MUST BE BIGGER):");
        double SD = sc.nextInt(); // 88 or 75

        halflife(RP, SD);
    }

    public static void halflife(double RP, double SD) {
        double halflives = 0;

        while(SD > RP) {
            SD /= 2;
            halflives++;
            if(SD < RP) System.out.println("# of Half Lives: " + halflives);
        }
    }
}
