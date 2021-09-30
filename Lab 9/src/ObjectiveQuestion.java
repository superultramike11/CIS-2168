public class ObjectiveQuestion extends Question{
	String correctAnswer;
	
	public ObjectiveQuestion(int points, int difficulty, int answerSpace, String questionText, String correctAnswer) {
		super(points, difficulty, answerSpace, questionText);
		this.correctAnswer = correctAnswer;
	}
	
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	
	public int getPoints() {
		return points;
	}
	
	@Override
	public String toString() {
		StringBuilder outputStr = new StringBuilder();
		
		outputStr.append("\n|Objective Question|Points: " + points + "|Diffculty: " + difficulty + "/10|")
		 		 .append("\nQuestion: " + questionText + ", " + printAnswerSpace(answerSpace));

		
		return outputStr.toString();
	}
	
	public String toAnswerString() {
		StringBuilder outputStr = new StringBuilder();
		
		outputStr.append("\n|Objective Question|Points: " + points + "|Diffculty: " + difficulty + "/10|")
		 		 .append("\nQuestion: " + questionText + ", " + printAnswerSpace(answerSpace))
				 .append("\nCorrect Answer: " + correctAnswer);
		
		return outputStr.toString();
	}
	
	public static void main(String[] args) {
		ObjectiveQuestion oq1 = new ObjectiveQuestion(5, MIN_DIFFICULTY, 1, "What is 2+3?", "5");
		System.out.print(oq1);
	}
}