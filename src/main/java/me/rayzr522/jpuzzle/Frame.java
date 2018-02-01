package me.rayzr522.jpuzzle;

import javax.swing.JFrame;

public class Frame {

	final int WIDTH = 512;
	final int HEIGHT = 512;

	public static void main(String[] args) {

		new Frame();

	}

	public Frame() {

		JFrame f = new JFrame("me/rayzr522/jpuzzle");
		f.setSize(WIDTH, HEIGHT + 22);
		f.add(new Board());
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

	}

}
