package main;

import javax.swing.JFrame;
import controller.GameController;
import view.View;

public class JogoGourmet {
	public static void main(String[] args) {
		GameController gameController = new GameController();
		JFrame main = View.showMainPane(gameController);
		main.setVisible(true);
	}
}