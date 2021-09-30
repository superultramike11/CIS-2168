public class UF {
	private int[] id;
	
	public UF(int n) {
		id = new int[n];
		for (int i=0; i<n; i++) {
			id[i] = i;
		}
	} 
	
	public boolean connected(int p, int q) {
		return id[p] == id[q];
	}
	
	public void union(int p, int q) {
		int pID = id[p];
		int qID = id[q];
		
		for (int i=0; i<id.length; i++) {
			if(id[i] == pID) {
				id[i] = qID;
			}
		}
	} 
}