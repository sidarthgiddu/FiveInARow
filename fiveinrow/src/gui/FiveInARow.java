package gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.*;

import controller.Controller;
import model.Board;
import model.Game;
import model.GameListener;
import model.Line;
import model.Location;
import model.Player;
import model.Victory;

public class FiveInARow extends JFrame implements GameListener{
	private boolean gameOn = false;
	
	private int X_SIZE = 1440;
	private int Y_SIZE = 1440;
	private int NUM_BUTTONS = 9;
	
	private Grid grid = new Grid();
	private StatusWindow status = new StatusWindow();
	private MainLayout main = new MainLayout();
	
	private Game g;
	private Location current_location;
	private JButton[][] button_array;
	private Controller playerX = null;
	private Controller playerO = null;
	
	public FiveInARow(Game g){
		gameOn = true;
		setTitle("Five In A Row");
		add(main);
		pack();
		this.g = g;
	}
	
	class Grid extends JPanel implements ActionListener{
		Grid(){
			setPreferredSize(new Dimension(X_SIZE,Y_SIZE));
			setLayout(new GridLayout(NUM_BUTTONS,NUM_BUTTONS));
			button_array = new JButton[NUM_BUTTONS][NUM_BUTTONS];
			for(int y = 0; y < NUM_BUTTONS; y++){
				for(int x = 0; x < NUM_BUTTONS; x++){
					JButton b = new JButton();
					button_array[x][y] = b;
					b.setPreferredSize(new Dimension(X_SIZE/NUM_BUTTONS, Y_SIZE/NUM_BUTTONS));
					b.setFont(b.getFont().deriveFont(48.0f));
					b.addActionListener(this);
					add(b);
				}
			}
		}
		public void actionPerformed(ActionEvent e){
			if(!gameOn || (playerX != null && playerO != null)){
				return;
			}
			JButton b = (JButton)e.getSource();
			if(b.getText() != ""){
				return;
			}
			if(g.nextTurn() == Player.X){
				int x = b.getX();
				int y = b.getY();
				int loc_x = (x%X_SIZE)/(X_SIZE/NUM_BUTTONS);
				int loc_y = (y%Y_SIZE)/(Y_SIZE/NUM_BUTTONS);
				current_location = new Location(loc_x, loc_y);
				g.submitMove(Player.X, current_location);
			}
			else{
				int x = b.getX();
				int y = b.getY();
				int loc_x = (x%X_SIZE)/(X_SIZE/NUM_BUTTONS);
				int loc_y = (y%Y_SIZE)/(Y_SIZE/NUM_BUTTONS);
				current_location = new Location(loc_x, loc_y);
				g.submitMove(Player.O, current_location);
			}			
		}
	}
	
	class MainLayout extends JPanel{
		MainLayout(){
			setPreferredSize(new Dimension(X_SIZE, 1590));
			setLayout(new BorderLayout());
			add(grid, BorderLayout.NORTH);
			add(status, BorderLayout.SOUTH);
		}
	}
	
	public void gameChanged(Game g) {
		Board b = g.getBoard();
		for(int i = 0; i < NUM_BUTTONS; i++){
			for(int j = 0; j < NUM_BUTTONS; j++){
				Player p = b.get(i,j);
				JButton button = button_array[i][j];
				if(p != null){
					if(p == Player.X){
						button.setText("X");
					}
					else{
						button.setText("O");
					}
				}
			}
		}
		switch(b.getState()) {
		case HAS_WINNER:
			status.setText(g.getBoard().getWinner().winner + " wins!");
			for(int i = 0; i < NUM_BUTTONS; i++){
				for(int j = 0; j < NUM_BUTTONS; j++){
					button_array[i][j].setEnabled(false);
				}
			}
			Victory v = b.getWinner();
			Line l = v.line;
			Iterator<Location> locs = l.iterator();
			while(locs.hasNext()){
				Location loc = locs.next();
				button_array[loc.row][loc.col].setBackground(Color.ORANGE);
			}
			return;
		case DRAW:
			status.setText("Game ended in a draw!");
			for(int i = 0; i < NUM_BUTTONS; i++){
				for(int j = 0; j < NUM_BUTTONS; j++){
					button_array[i][j].setEnabled(false);
				}
			}
			return;
		case NOT_OVER:
			status.setText("It is " + g.nextTurn() + "'s turn");
			break;
		}
	}
	
	/**
	 * This method initializes instance variables playerX and playerO. playerX and playerO are used
	 * to determine how buttons respond to clicks in method actionPerformed.
	 */
	public void setController(Controller c, Player p){
		if(p == Player.X){
			playerX = c;
		}
		else{
			playerO = c;
		}
	}
	
	class StatusWindow extends JLabel{
		StatusWindow(){
			super("", SwingConstants.CENTER);
			setPreferredSize(new Dimension(X_SIZE,150));
			setFont(getFont().deriveFont(48.0f));
		}
	}
}
