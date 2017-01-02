/* NetId(s): sg766, ret87. Time spent: 20 hours, 30 minutes. */

package gui;





import javax.swing.*;


import controller.Controller;
import controller.DumbAI;
import controller.RandomAI;
import controller.SmartAI;
import model.Game;
import model.Player;

public class Main {
	public static void main(String[] args) {
		String [] options = {"Human","Dumb AI",
				"Random AI","Smart AI"};
 		int i = JOptionPane.showOptionDialog(null, "How should X be played?", null,
 				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane
				.DEFAULT_OPTION, null, options, null);
 		
 		Controller playerX = createController(i,Player.X);
 		
 		int j = JOptionPane.showOptionDialog(null, "How should O be played?", null,
 				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane
				.DEFAULT_OPTION, null, options, null);
 		Controller playerO = createController(j, Player.O);
		
		Game g = new Game();
		FiveInARow gui = new FiveInARow(g);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setVisible(true);
		g.addListener(gui);
		if(playerX != null){
			gui.setController(playerX, Player.X);
			g.addListener(playerX);
			
			
		}
		if(playerO != null){
			gui.setController(playerO, Player.O);
			g.addListener(playerO);
		}
	}
	
	public static Controller createController(int option, Player p){
		if(option == 0){
			return null;
		}
		else if(option == 1){
			return new DumbAI(p);
		}
		else if(option == 2){
			return new RandomAI(p);
		}
		else{
			return new SmartAI(p);
		}
	}
}

