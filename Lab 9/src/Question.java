public class Question {
	int points, difficulty, answerSpace;
	
	static final int MIN_DIFFICULTY = 1;
	static final int MAX_DIFFICULTY = 10;
	
	String questionText;
	
	public Question(int points, int difficulty, int answerSpace, String questionText) {
		if(difficulty <= 0 || difficulty >= 11)
			throw new IllegalArgumentException("Question Difficulty must be within [" + MIN_DIFFICULTY + ", " + MAX_DIFFICULTY + "]");
		if(answerSpace < 0)
			throw new IllegalArgumentException("Give some space to fill an answer");
		if(questionText.length() <= 0)
			throw new IllegalArgumentException("Question cannot be null");
		
		this.points = points;
		this.difficulty = difficulty;
		this.answerSpace = answerSpace;
		this.questionText = questionText;
	}
	
	public int getPoints() {
		return points;
	}
	
	
	public String printAnswerSpace(int answerSpace) {
		String questionSpace = "";
		for(int i=0; i<answerSpace; i++) {
			questionSpace += "_";
		}
		return questionSpace;
	}
	
	public String toString() {
		StringBuilder outputStr = new StringBuilder();
		
		outputStr.append("\n|Question|Points: " + points + "|Diffculty: " + difficulty + "/10|")
				 .append("\nQuestion: " + questionText + " " + printAnswerSpace(answerSpace));
		
		return outputStr.toString();
	}
	
	public static void main(String[] args) {
		Question q1 = new Question(5, MAX_DIFFICULTY, 1, "How many trees are there?");
		System.out.print(q1);
	}
}
