/**
 * This class implements the piece knight.
 */
package chessBuild;
public class Knight extends Piece{
	/**
	 * Default constructor
	 */
	public Knight(){
    	super();
    }
	
	/**
	 * Copy constructor
	 * @param other
	 */
	public Knight(Knight other){
		super(other);
	}
	
	/**
	 * Knight constructor
	 * @param color
	 */
    public Knight(String color){
    	super(color);
    }
    
    /**
     * Knight constructor
     * @param x
     * @param y
     * @param color
     * @param isAlive
     */
    public Knight(int x, int y, String color, boolean isAlive){
    	super(x, y, color, isAlive);
    }
    
    @Override
    public boolean checkMove(Board board, int targetX, int targetY){
    	if(!super.checkMove(board, targetX, targetY)){
    		return false;
    	}
    	return checkKnightMoveHelper(board, targetX, targetY);
    }
    
    /**
     * Helper function for checkMove method
     * @param board
     * @param targetX
     * @param targetY
     * @return
     */
    public boolean checkKnightMoveHelper(Board board, int targetX, int targetY){
    	if(board.chessBoard[targetY][targetX] != null
    		&& board.chessBoard[targetY][targetX].getColor().equals(this.getColor())){
    		return false;
    	}
		if(this.getX() - targetX == 1 && this.getY() - targetY == 2){
			return true;
		}//position 1
		if(this.getX() - targetX == 2 && this.getY() - targetY == 1){
			return true;
		}//position 2
		if(this.getX() - targetX == 2 && this.getY() - targetY == -1){
			return true;
		}//position 3
		if(this.getX() - targetX == 1 && this.getY() - targetY == -2){
			return true;
		}//position 4
		if(this.getX() - targetX == -1 && this.getY() - targetY == 2){
			return true;
		}//position 5
		if(this.getX() - targetX == -2 && this.getY() - targetY == 1){
			return true;
		}//position 6
		if(this.getX() - targetX == -2 && this.getY() - targetY == -1){
			return true;
		}//position 7
		if(this.getX() - targetX == -1 && this.getY() - targetY == -2){
			return true;
		}//position 8
    	return false;
    }
}
