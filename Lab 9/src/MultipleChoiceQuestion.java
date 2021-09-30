public class MultipleChoiceQuestion extends ObjectiveQuestion{

	String correctAnswer;
	String[] possibleAnswers;
	
	public MultipleChoiceQuestion(int points, int difficulty, int answerSpace, String questionText, String[] possibleAnswers, String correctAnswer) {
		super(points, difficulty, answerSpace, questionText, correctAnswer);
		
		this.possibleAnswers = possibleAnswers;
		this.correctAnswer = correctAnswer;
	}
	
	public int getPoints() {
		return points;
	}
	
	@Override
	public String toString() {
		StringBuilder outputStr = new StringBuilder();
		
		outputStr.append("\n|MultipleChoiceQuestion|Points: " + points + "|Diffculty: " + difficulty + "/10|")
				 .append("\nQuestion: ").append(questionText)
				 .append("\n1. " + possibleAnswers[0])
				 .append("\n2. " + possibleAnswers[1])
				 .append("\n3. " + possibleAnswers[2])
				 .append("\n4. " + possibleAnswers[3]);
		
		return outputStr.toString();
	}
	
	public String toAnswerString() {
		StringBuilder outputStr = new StringBuilder();
		
		outputStr.append("\n|MultipleChoiceQuestion|Points: " + points + "|Diffculty: " + difficulty + "/10|")
				 .append("\nQuestion: ").append(questionText)
				 .append("\n1. ****" + possibleAnswers[0] + "****")
				 .append("\n2. " + possibleAnswers[1])
				 .append("\n3. " + possibleAnswers[2])
				 .append("\n4. " + possibleAnswers[3])
				 .append("\nCorrect Answer: ").append(correctAnswer);
		
		return outputStr.toString();
	}
	
	public static void main(String[] args) {
		MultipleChoiceQuestion mcq1 = new MultipleChoiceQuestion(5, MAX_DIFFICULTY, 1, "A or B or C or D?", new String[]{"A", "B", "C", "D"}, "A");
		System.out.print(mcq1.toAnswerString());
	}
}