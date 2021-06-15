package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import controller.GameController;

public class View {

	public static JFrame showMainPane(GameController gameController) {
		JFrame frame;
		JLabel startLabel = new JLabel("Pense em um prato que gosta.");
		startLabel.setBounds(50, 20, 250, 20);
		JButton startButton = new JButton("OK");
		startButton.setBounds(105, 50, 55, 25);
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameController.startActivity();
			}
		});
		frame = new JFrame("Jogo Gourmet");
		frame.add(startButton);
		frame.add(startLabel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(285, 130);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		return frame;
	}
	
	public static void showPaneVictoryMessage() {
        JOptionPane.showMessageDialog(
                null,
                "Acertei de novo!", 
                "Jogo Gourmet",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
	
    public static int showPaneIsDishQuestion(String description) {
    	Object[] options = {"Sim", "Não"};
        return JOptionPane.showOptionDialog(
                null,
                "O prato que você pensou é " + description + "?",
                "Jogo Gourmet",
                JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
    }
    
    public static String showPaneDishNameQuestion(){
    	UIManager.put("OptionPane.cancelButtonText", "Cancelar");
        return JOptionPane.showInputDialog(
                null,
                "Qual prato você pensou?", 
                "Jogo Gourmet",
                JOptionPane.QUESTION_MESSAGE
        );
    }
    
    public static String showPaneDishDifferenceQuestion(String newDescription, String currentDescription){
        return JOptionPane.showInputDialog(
                null,
                newDescription + " é ________ mas " + currentDescription + " não.", 
                "Jogo Gourmet",
                JOptionPane.QUESTION_MESSAGE
        );
    }
}