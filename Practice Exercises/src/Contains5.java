public class Contains5 {
	public static void main(String[] args) {
		int n = 512;

		for(int i=1; i<= n; i*= 2) {
			System.out.println(i);
		}

		while (n >= 1) {
			System.out.println(n);
			n = n/2;
		}
	}
}
