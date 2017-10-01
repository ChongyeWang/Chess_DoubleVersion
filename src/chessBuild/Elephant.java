/**
 * This class implements the piece elephant
 * and will not be displayed on the board.
 */
package chessBuild;
public class Elephant extends Piece{
	/**
	 * Default constructor
	 */
	public Elephant(){
    	super();
    }
	
	/**
	 * Elephant constructor
	 * @param color
	 */
    public Elephant(String color){
    	super(color);
    }
    
	/**
	 * Copy constructor
	 * @param other
	 */
	public Elephant(Elephant other){
		super(other);
	}
    
    /**
     * Elephant constructor
     * @param x
     * @param y
     * @param color
     * @param isAlive
     */
    public Elephant(int x, int y, String color, boolean isAlive){
    	super(x, y, color, isAlive);
    }
    
    @Override
    public boolean checkMove(Board board, int targetX, int targetY){
    	if(!super.checkMove(board, targetX, targetY)){
    		return false;
    	}
    	return checkElephantMoveHelper(board, targetX, targetY);
    }
    
    /**
     * Helper function for checkMove method
     * @param board
     * @param targetX
     * @param targetY
     * @return
     */
    public boolean checkElephantMoveHelper(Board board, int targetX, int targetY){
    	if(board.chessBoard[targetY][targetX] != null
    		&& board.chessBoard[targetY][targetX].getColor().equals(this.getColor())){
    		return false;
    	}
		if(this.getX() - targetX == 2 && this.getY() - targetY == 2){
			return true;
		}//position 1
		if(this.getX() - targetX == 2 && this.getY() - targetY == -2){
			return true;
		}//position 2
		if(this.getX() - targetX == -2 && this.getY() - targetY == 2){
			return true;
		}//position 3
		if(this.getX() - targetX == -2 && this.getY() - targetY == -2){
			return true;
		}//position 4
    	return false;
    }
}
