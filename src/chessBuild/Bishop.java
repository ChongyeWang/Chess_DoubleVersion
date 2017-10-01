/**
 * This class implements the piece bishop.
 */
package chessBuild;
public class Bishop extends Piece{
	/**
	 * Default Constructor
	 */
	public Bishop(){
    	super();
    }
	
	/**
	 * Copy constructor
	 * @param other
	 */
	public Bishop(Bishop other){
		super(other);
	}
	
	/**
	 * Bishop constructor
	 * @param color
	 */
    public Bishop(String color){
    	super(color);
    }
    
    /**
     * Bishop constructor
     * @param x
     * @param y
     * @param color
     * @param isAlive
     */
    public Bishop(int x, int y, String color, boolean isAlive){
    	super(x, y, color, isAlive);
    }
    
    @Override
    public boolean checkMove(Board board, int targetX, int targetY){
    	if(!super.checkMove(board, targetX, targetY)){
    		return false;
    	}// out of range
        return checkBishopMoveHelper(board, targetX, targetY);
    }
    
    /**
     * Helper method for checkMove function for Bishop
     * @param board
     * @param targetX
     * @param targetY
     * @return
     */
    public boolean checkBishopMoveHelper(Board board, int targetX, int targetY){
    	if(board.chessBoard[targetY][targetX] != null
			&& board.chessBoard[targetY][targetX].getColor().equals(this.getColor())){
			return false;
		}
		if(Math.abs(this.getX() - targetX) != Math.abs(this.getY() - targetY)){
			return false;
		}
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
		return false;
    }
}
