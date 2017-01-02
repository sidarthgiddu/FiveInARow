package controller;

import model.Board;
import model.Game;
import model.Location;
import model.NotImplementedException;
import model.Player;

/**
 * A DumbAI is a Controller that always chooses the blank space with the
 * smallest column number from the row with the smallest row number.
 */
public class DumbAI extends Controller {

	public DumbAI(Player me) {
		super(me);

	}

	/**
	 * returns the blank Location on the board with the smallest column number
	 * from the row with the smallest row number
	 */
	protected @Override Location nextMove(Game g) {
		// Note: Calling delay here will make the CLUI work a little more
		// nicely when competing different AIs against each other.
		
		// TODO Auto-generated method stub
		
		//find Location
		Board b = g.getBoard();
		for(int i = 0; i < b.NUM_ROWS; i++){
			for(int j = 0; j < b.NUM_COLS; j++){
				if(b.get(j,i) == null){
					for(int k = 0; k < 5; k++){
						delay();
					}
					return new Location(j,i);
				}
			}
		}
		return null;
	}
}
