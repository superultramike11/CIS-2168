package brickBreaker;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		JFrame obj = new JFrame();
		Gameplay gamePlay = new Gameplay();
		obj.setBounds(10, 10, 700, 600); // resolution of the window
		obj.setTitle("Breakout Ball"); // title of the window
		obj.setResizable(false); // if the window can be resized
		obj.setVisible(true); // if the window is visable or not
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		obj.add(gamePlay);
	}
}