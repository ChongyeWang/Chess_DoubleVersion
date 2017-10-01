 /**
 * This class implements the piece queen.
 */
package chessBuild;
public class Queen extends Piece{
	/**
	 * Default constructor
	 */
	public Queen(){
    	super();
    }
	
	/**
	 * Copy constructor
	 * @param other
	 */
	public Queen(Queen other){
		super(other);
	}
	
	/**
	 * Queen constructor
	 * @param color
	 */
    public Queen(String color){
    	super(color);
    }
    
    /**
     * Queen constructor
     * @param x
     * @param y
     * @param color
     * @param isAlive
     */
    public Queen(int x, int y, String color, boolean isAlive){
    	super(x, y, color, isAlive);
    }
    
    @Override
    public boolean checkMove(Board board, int targetX, int targetY){
    	if(!super.checkMove(board, targetX, targetY)){
    		return false;
    	}
    	return checkQueenMoveHelper(board, targetX, targetY);
    }
    
    /**
     * Helper function for checkMove
     * @param board
     * @param targetX
     * @param targetY
     * @return
     */
    public boolean checkQueenMoveHelper(Board board, int targetX, int targetY){
    	if(board.chessBoard[targetY][targetX] != null
			&& board.chessBoard[targetY][targetX].getColor().equals(this.getColor())){
			return false;
		}
		if(targetX == this.getX() && targetY != this.getY() 
		   || targetY == this.getY() && targetX != this.getX()){
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
		}//move along rank and file
		
		if(Math.abs(this.getX() - targetX) == Math.abs(this.getY() - targetY)){
			if(targetX < this.getX() && targetY < this.getY()){
    			for(int i = 1; i < Math.abs(this.getX() - targetX); i++){
    				if(board.chessBoard[this.getY() - i][this.getX() - i] != null){
    					return false;
    				}//blocked path
    			}
    			return true;
    		}//Northwest
    		if(targetX < this.getX() && targetY > this.getY()){
    			for(int i = 1; i < Math.abs(this.getX() - targetX); i++){
    				if(board.chessBoard[this.getY() + i][this.getX() - i] != null){
    					return false;
    				}//blocked path
    			}
    			return true;
    		}//Southwest
    		if(targetX > this.getX() && targetY < this.getY()){
    			for(int i = 1; i < Math.abs(this.getX() - targetX); i++){
    				if(board.chessBoard[this.getY() - i][this.getX() + i] != null){
    					return false;
    				}//blocked path
    			}
    			return true;
    		}//NorthEast
    		if(targetX > this.getX() && targetY > this.getY()){
    			for(int i = 1; i < Math.abs(this.getX() - targetX); i++){
    				if(board.chessBoard[this.getY() + i][this.getX() + i] != null){
    					return false;
    				}//blocked path
    			}
    			return true;
    		}//SouthEast
		}//move along diagonal
		return false;
    }
}
