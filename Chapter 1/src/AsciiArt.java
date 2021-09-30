public class AsciiArt {
	private static final int SIZE = 15;
	
	public static void main(String[] args) {
		topline();
		topHalf();
		bottomHalf();
		bottomline();
	}
	
	public static void topline() {
		for (int dot = 0; dot < SIZE * 2 + 1; dot++) {
			System.out.print("--");
		}
		System.out.println();
	}
	
	public static void topHalf() {
		for (int line = 1; line <= SIZE; line++) {
			// LEFT CANVAS BORDER
			System.out.print("|");
			
			// OUTER LEFT
			for (int space = 1; space <= (line * -2 + (2 * SIZE)); space++) {
				System.out.print("0");
			}
			
			// RHOMBUS LEFT BORDER
			System.out.print("//");
			
			// TOP MIDDLE
			for (int dot = 1; dot <= (line - 1); dot++) {
				for (int dot2 = 1; dot2 <= 3; dot2++) {
					System.out.print("'");
				}
				System.out.print("3");
			}
			
			// RHOMBUS RIGHT BORDER
			System.out.print("\\\\");
			
			// INNER RIGHT
			for (int space = 1; space <= (line * -2 + (2 * SIZE)); space++) {
				System.out.print("0");
			}
			
			// RIGHT CANVAS BORDER
			System.out.println("|");
		}
	}
	
	public static void bottomHalf() {
		for (int line = SIZE; line >= 1; line--) {
			// LEFT CANVAS BORDER
			System.out.print("|");
			
			// OUTER LEFT
			for (int space = 1; space <= (line * -2 + (2 * SIZE)); space++) {
				System.out.print("1");
			}
			
			// RHOMBUS LEFT BORDER
			System.out.print("\\\\");
			
			// BOTTOM MIDDLE
			for (int dot = 1; dot <= (line * 4 - 4); dot++) {
				System.out.print("0");
			}
			
			// RHOMBUS RIGHT BORDER
			System.out.print("//");
			
			// OUTER RIGHT
			for (int space = 1; space <= (line * -2 + (2 * SIZE)); space++) {
				System.out.print("1");
			}
			
			// RIGHT CANVAS BORDER
			System.out.println("|");
		}
	}
	
	public static void bottomline() {
		for (int dot = 0; dot < SIZE * 2 + 1; dot++) {
			System.out.print("--");
		}
		System.out.println();
	}
}