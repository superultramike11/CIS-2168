public class FillInTheBlankQuestion extends ObjectiveQuestion{	
	String correctAnswer;
	
	public FillInTheBlankQuestion(int points, int difficulty, int answerSpace, String questionText, String correctAnswer) {
		super(points, difficulty, answerSpace, questionText, correctAnswer);
		this.correctAnswer = correctAnswer;
	}
	
	public int getPoints() {
		return points;
	}
	
	@Override
	public String toString() {
		StringBuilder outputStr = new StringBuilder();
		
		outputStr.append("\n|FillInTheBlankQuestion|Points: " + points + "|Diffculty: " + difficulty + "/10|")
		 		 .append("\nQuestion: "+ printAnswerSpace(answerSpace) + " " + questionText);

		
		return outputStr.toString();
	}
	
	public String toAnswerString() {
		StringBuilder outputStr = new StringBuilder();
		
		outputStr.append("\n|FillInTheBlankQuestion|Points: " + points + "|Diffculty: " + difficulty + "/10|")
				 .append("\nQuestion: "+ printAnswerSpace(answerSpace) + " " + questionText)
				 .append("\nCorrect Answer: " + "___" + correctAnswer + "___ " + questionText);
		
		return outputStr.toString();
	}
	
	public static void main(String[] args) {
		FillInTheBlankQuestion fitbq1 = new FillInTheBlankQuestion(5, MIN_DIFFICULTY, 14, "was the 16th US President" , "Abraham Lincoln");
		System.out.print(fitbq1);
	}
}