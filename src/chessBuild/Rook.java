/**
 * This class implements the piece rook.
 */
package chessBuild;
public class Rook extends Piece{
	/**
	 * Default constructor for rook
	 */
	public Rook(){
    	super();
    }
	
	/**
	 * Copy constructor
	 * @param other
	 */
	public Rook(Rook other){
		super(other);
	}
	
	/**
	 * Rook constructor
	 * @param color
	 */
    public Rook(String color){
    	super(color);
    }
    
    /**
     * Rook constructor
     * @param x
     * @param y
     * @param color
     * @param isAlive
     */
    public Rook(int x, int y, String color, boolean isAlive){
    	super(x, y, color, isAlive);
    }
    
    @Override
    public boolean checkMove(Board board, int targetX, int targetY){
    	if(!super.checkMove(board, targetX, targetY)){
    		return false;
    	}//out of range
    	if(this.getX() != targetX && this.getY() != targetY){
    		return false;
    	}// cannot move diagonally
    	return checkRookMoveHelper(board, targetX, targetY);
    }
    
    /**
     * Helper function for checkMove method
     * @param board
     * @param targetX
     * @param targetY
     * @return
     */
    public boolean checkRookMoveHelper(Board board, int targetX, int targetY){
		if(board.chessBoard[targetY][targetX] != null
				&& board.chessBoard[targetY][targetX].getColor().equals(this.getColor())){
				return false;
		}
		if(targetX == this.getX() && targetY != this.getY()){
			if(targetY > this.getY()){
				for(int i = this.getY() + 1; i < targetY; i++){
					if(board.chessBoard[i][targetX] != null){
						return false;
					}//blocked path
				}
				return true;
			}//move down
			else{//targetY < this.getY()
				for(int i = this.getY() - 1; i > targetY; i--){
					if(board.chessBoard[i][targetX] != null){
						return false;
					}//blocked path
				}
				return true;
			}//move up
		}// move vertically
		if(targetY == this.getY() && targetX != this.getX()){
			if(targetX > this.getX()){
				for(int i = this.getX() + 1; i < targetX; i++){
					if(board.chessBoard[targetY][i] != null){
						return false;
					}//blocked path
				}
				return true;
			}//move right
			else{//targetX < this.getX()
				for(int i = this.getX() - 1; i > targetX; i--){
					if(board.chessBoard[targetY][i] != null){
						return false;
					}//blocked path
				}
				return true;
			}//move left
		}//move horizontally
		return false;
    }
}

