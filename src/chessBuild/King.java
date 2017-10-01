/**
 * This class implements the piece king.
 */
package chessBuild;
public class King extends Piece{
	/**
	 * Default Constructor
	 */
	public King(){
    	super();
    }
	
	/**
	 * Copy constructor
	 * @param other
	 */
	public King(King other){
		super(other);
	}
	
	/**
	 * Constructor for king
	 * @param color
	 */
    public King(String color){
    	super(color);
    }
    
    /**
     * Constructor for King
     * @param x
     * @param y
     * @param color
     * @param isAlive
     */
    public King(int x, int y, String color, boolean isAlive){
    	super(x, y, color, isAlive);
    }
    
    @Override
    public boolean checkMove(Board board, int targetX, int targetY){
    	if(!super.checkMove(board, targetX, targetY)){
    		return false;
    	}
    	return checkKingMoveHelper(board, targetX, targetY);
    }
    
    /**
     * Helper function for checkMove method
     * @param board
     * @param targetX
     * @param targetY
     * @return
     */
    public boolean checkKingMoveHelper(Board board, int targetX, int targetY){
    	if(board.chessBoard[targetY][targetX] != null 
	      && board.chessBoard[targetY][targetX].getColor().equals(this.getColor())){
	    	return false;
	    }
	    if(this.getX() - targetX == 1 && this.getY() - targetY == 1){
	    	return true;
	    }//position 1
	    if(this.getX() - targetX == 1 && this.getY() - targetY == 0){
	    	return true;
	    }//position 2
	    if(this.getX() - targetX == 1 && this.getY() - targetY == -1){
	    	return true;
	    }//position 3
	    if(this.getX() - targetX == 0 && this.getY() - targetY == -1){
	    	return true;
	    }//position 4
	    if(this.getX() - targetX == -1 && this.getY() - targetY == -1){
	    	return true;
	    }//position 5
	    if(this.getX() -targetX == -1 && this.getY() - targetY == 0){
	    	return true;
	    }//position 6
	    if(this.getX() -targetX == -1 && this.getY() - targetY == 1){
	    	return true;
	    }//position 7
	    if(this.getX() -targetX == 0 && this.getY() - targetY == 1){
	    	return true;
	    }//position 8
	    return false;
    }  
}
