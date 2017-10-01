/**
 * This class implements the piece pawn.
 */
package chessBuild;
public class Pawn extends Piece{
    /**
     * Default Constructor
     */
	public Pawn(){
    	super();
    }
	
	/**
	 * Copy constructor
	 * @param other
	 */
	public Pawn(Pawn other){
		super(other);
	}
	
	/**
	 * Pawn constructor
	 * @param color
	 */
    public Pawn(String color){
    	super(color);
    }
    /**
     * Pawn constructor
     * @param x
     * @param y
     * @param color
     * @param isAlive
     */
    public Pawn(int x, int y, String color, boolean isAlive){
    	super(x, y, color, isAlive);
    }
    
    @Override
    public boolean checkMove(Board board, int targetX, int targetY){
    	if(!super.checkMove(board, targetX, targetY)){
    		return false;
    	}//if the target place is out of range, return false
    	if(this.getColor().equals("black")){
    		if(board.chessBoard[targetY][targetX] != null 
    		    && board.chessBoard[targetY][targetX].getColor().equals("black")){
    			return false;
    		}//if the target place is black, return false
    		
			if(this.getY() == 1){
				if(targetX == this.getX() && targetY == this.getY() + 2){
					if(board.chessBoard[targetY][targetX] == null && board.chessBoard[targetY - 1][targetX] == null){
						return true;
					}
				}//check whether the pawn can move two space at the beginning
				if(targetX == this.getX() && targetY == this.getY() + 1){
					if(board.chessBoard[targetY][targetX] == null){
						return true;
					}
				}// check whether the pawn can move one space at the beginning
				if(targetX == this.getX() - 1 && targetY == this.getY() + 1
						|| targetX == this.getX() + 1 && targetY == this.getY() + 1){
					if(board.chessBoard[targetY][targetX] != null
						&& board.chessBoard[targetY][targetX].getColor().equals("white")){
						return true;
					}
				}//eat the piece at the target place
			}// the black pawn is at its initial place
			else{
				if(targetX == this.getX() && targetY == this.getY() + 1){
					if(board.chessBoard[targetY][targetX] == null){
						return true;
					}
				}// check whether the pawn can move one space
				if(targetX == this.getX() - 1 && targetY == this.getY() + 1
						|| targetX == this.getX() + 1 && targetY == this.getY() + 1){
					if(board.chessBoard[targetY][targetX] != null
						&& board.chessBoard[targetY][targetX].getColor().equals("white")){
						return true;
					}
				}
			}// the black pawn is not at its initial place
			return false;
    	}//check black pawn
    	
    	if(this.getColor().equals("white")){
    		if(board.chessBoard[targetY][targetX] != null 
        		&& board.chessBoard[targetY][targetX].getColor().equals("white")){
        	    return false;
        	}//if the target place is white, return false
    		
			if(this.getY() == 6){
				if(targetX == this.getX() && targetY == this.getY() - 2){
					if(board.chessBoard[targetY][targetX] == null && board.chessBoard[targetY + 1][targetX] == null){
						return true;
					}
				}//check whether the pawn can move two space at the beginning
				if(targetX == this.getX() && targetY == this.getY() - 1){
					if(board.chessBoard[targetY][targetX] == null){
						return true;
					}
				}// check whether the pawn can move one space at the beginning
				if(targetX == this.getX() - 1 && targetY == this.getY() - 1
						|| targetX == this.getX() + 1 && targetY == this.getY() - 1){
					if(board.chessBoard[targetY][targetX] != null
						&& board.chessBoard[targetY][targetX].getColor().equals("black")){
						return true;
					}
				}//eat the piece at the target place
			}// the white pawn is at its initial place
			else{
				if(targetX == this.getX() && targetY == this.getY() - 1){
					if(board.chessBoard[targetY][targetX] == null){
						return true;
					}
				}// check whether the pawn can move one space
				if(targetX == this.getX() - 1 && targetY == this.getY() - 1
						|| targetX == this.getX() + 1 && targetY == this.getY() - 1){
					if(board.chessBoard[targetY][targetX] != null
						&& board.chessBoard[targetY][targetX].getColor().equals("black")){
						return true;
					}
				}//eat the piece at the target place
			}// the white pawn is not at its initial place
			return false;
    	}//check white pawn
        return false;
    }
}
