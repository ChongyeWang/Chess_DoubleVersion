/**
 * This class implements the piece kin
 * and will not be displayed on the board.
 */
package chessBuild;
import chessBuild.Piece;
import chessBuild.Game;
import chessBuild.Player;
import org.junit.Test;
import static org.junit.Assert.*;
public class Kin extends Piece{
	/**
	 * Default constructor
	 */
	public Kin(){
    	super();
    }
	
	/**
	 * Copy constructor
	 * @param other
	 */
	public Kin(Kin other){
		super(other);
	}
	
	/**
	 * Kin constructor
	 * @param color
	 */
    public Kin(String color){
    	super(color);
    }
    
    /**
     * Kin constructor
     * @param x
     * @param y
     * @param color
     * @param isAlive
     */
    public Kin(int x, int y, String color, boolean isAlive){
    	super(x, y, color, isAlive);
    }
    
    @Override
    public boolean checkMove(Board board, int targetX, int targetY){
    	if(!super.checkMove(board, targetX, targetY)){
    		return false;
    	}
    	return checkKinMoveHelper(board, targetX, targetY);
    }
    
    /**
     * Helper function for checkMove method
     * @param board
     * @param targetX
     * @param targetY
     * @return
     */
    public boolean checkKinMoveHelper(Board board, int targetX, int targetY){
    	if(board.chessBoard[targetY][targetX] != null
    		&& board.chessBoard[targetY][targetX].getColor().equals(this.getColor())){
    		return false;
    	}
    	if(this.getColor().equals("black") && targetY > 3){
    		return false;
    	}// black kin cannot move to the lower half of the board
    	if(this.getColor().equals("white") && targetY < 4){
    		return false;
    	}// white kin cannot move to the upper half of the board
		if(Math.abs(this.getX() - targetX) == 1 && Math.abs(this.getY() - targetY) == 1){
			return true;
		}//move diagonally
		if(Math.abs(this.getX() - targetX) == 0 && Math.abs(this.getY() - targetY) == 1){
			return true;
		}//move vertically
		if(Math.abs(this.getX() - targetX) == 1 && Math.abs(this.getY() - targetY) == 0){
			return true;
		}//move horizontally
    	return false;
    }
}
