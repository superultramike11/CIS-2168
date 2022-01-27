public class reverse {
	public static void main(String[] args) {
		String s = "abcdefg";
		int k = 2;
		reverseStr(s, k);
	}

	public static String reverseStr(String s, int k) {
		for(int i=k; i<(s.length() / 2); i++) {
			char c = s.charAt(i);
			//  temp equals index 0
			char temp = c;

			//	index 0 equals
			c = s.charAt(s.length() - 1 - i);

			//
			s.charAt(s.length() - 1 - i) = temp;
		}
		return s;
	}
}
