/*
	Driver createTest
	Driver printTest and answerKey
*/
import java.util.*;

public class Driver{
	public static void main(String[] args) {
		List<Object> questionBank = new ArrayList<>(); // Create a question bank
		
		questionBank.add(new ObjectiveQuestion(1,1,1,"ObejctiveQuesiton (T/F)", "T"));
		questionBank.add(new FillInTheBlankQuestion(1,1,1,"Today is ___", "Monday"));
		questionBank.add(new MultipleChoiceQuestion(2,4,1,"MultipleChoiceQuestion", new String[]{"A", "B", "C", "D"}, "A"));
		
		Test studentTest = new Test(questionBank);
		
		System.out.println("Max amount of points: " + studentTest.getTotalPoints);
		
		System.out.println(studentTest.printTest());
		System.out.println("Answer Key: ");
		studentTest.answerKey();
	}
}