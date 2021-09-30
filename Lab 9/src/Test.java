import java.util.*;

public class Test {
	static List<Object> questionBank;
	static int getTotalPoints;
	static Object q;
	
	public Test(List<Object> questionBank) {
		this.questionBank = new ArrayList<> (questionBank);
		
		for (Object q : this.questionBank) {
			getTotalPoints += ((Question) q).getPoints();
		}
	}
	
	public static int getTotalPoints() {
		return getTotalPoints;
	}
	
	public void answerKey() {
		
		for (Object q : this.questionBank) {
			System.out.println( ((ObjectiveQuestion) q).getCorrectAnswer());
		}
	}
	
	public String printTest() {
		for(int i=0; i<questionBank.size(); i++) {
			System.out.println(questionBank.get(i));
		}
		return "";
	}
	
	public static void main(String[] args) {
	}
}
