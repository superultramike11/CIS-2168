// sample1 output works
// sample2 output works

public class Hwk3Part0 {
	public static void main(String[] args) {
		In in = new In("sample2.txt");
		int n = in.readInt();
		UF uf = new UF(n);
		while(!in.isEmpty()) {
			int p = in.readInt();
			int q = in.readInt();
			if (!uf.connected(p, q)) {
				uf.union(p, q);
				System.out.println(p + " " + q);
			} 
		}
	}
}