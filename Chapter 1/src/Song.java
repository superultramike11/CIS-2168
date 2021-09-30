// Michael Ewing
// 1/29/2021
// Assignment 2. Get you a cat
// 
// This program is printing a short repeating poem about animals
//
public class Song {
	public static void main(String[] args) {
		verse1();
		verse2();
		verse3();
		verse4();
		verse5();
		verse6();
	}
	public static void beginning() {
		System.out.println("Bought me a cat and the cat pleased me,");
		System.out.println("I fed my cat under yonder tree.");
	}
	public static void pig() {
		System.out.println("Pig goes oink, oink,");
	}
	public static void sheep() {
		System.out.println("Sheep goes baa, baa,");
	}
	public static void goose() {
		System.out.println("Goose goes hissy, hissy,");
	}
	public static void duck() {
		System.out.println("Duck goes quack, quack,");
	}
	public static void hen() {
		System.out.println("Hen goes chimmy-chuck, chimmy-chuck,");
	}
	public static void cat() {
		System.out.println("Cat goes fiddle-i-fee. \n");
	}
	public static void verse1() {
		beginning();
		cat();
	}
	public static void verse2() {
		beginning();
		hen();
		cat();
	}
	public static void verse3() {
		beginning();
		duck();
		hen();
		cat();
	}
	public static void verse4() {
		beginning();
		goose();
		duck();
		hen();
		cat();
	}
	public static void verse5() {
		beginning();
		sheep();
		goose();
		duck();
		hen();
		cat();
	}
	public static void verse6() {
		beginning();
		pig();
		sheep();
		goose();
		duck();
		hen();
		cat();
	}
}