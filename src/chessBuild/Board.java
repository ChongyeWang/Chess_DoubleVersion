/**
 * This class implements the chess board.
 */
package chessBuild;
public class Board {
    private int row;
    private int column;
    public Piece chessBoard[][];
    
    /**
     * Constructor for board
     * @param row
     * @param column
     */
    public Board(int row, int column){
    	this.row = row;
    	this.column = column;
    	this.chessBoard = new Piece[row][column];
    }
    
    /**
     * Copy constructor
     * @param other
     */
    public Board(Board other){
    	this.row = other.row;
    	this.column = other.column;
    	this.chessBoard = new Piece[row][column];
    	for(int i = 0; i < 8; i++){
    		for(int j = 0; j < 8; j++){
    			if(other.chessBoard[i][j] == null){
    				this.chessBoard[i][j] = null;
    			}//empty space
    			else{
    				if(other.chessBoard[i][j] instanceof Pawn){
    					this.chessBoard[i][j] = new Pawn();
    				}
    				else if(other.chessBoard[i][j] instanceof Rook){
    					this.chessBoard[i][j] = new Rook();
    				}
    				else if(other.chessBoard[i][j] instanceof Knight){
    					this.chessBoard[i][j] = new Knight();
    				}
    				else if(other.chessBoard[i][j] instanceof Bishop){
    					this.chessBoard[i][j] = new Bishop();
    				}
    				else if(other.chessBoard[i][j] instanceof Queen){
    					this.chessBoard[i][j] = new Queen();
    				}
    				else if(other.chessBoard[i][j] instanceof King){
    					this.chessBoard[i][j] = new King();
    				}
    				else if(other.chessBoard[i][j] instanceof Kin){
    					this.chessBoard[i][j] = new Kin();
    				}
    				else if(other.chessBoard[i][j] instanceof Elephant){
    					this.chessBoard[i][j] = new Elephant();
    				}
    				this.chessBoard[i][j].setColor(other.chessBoard[i][j].getColor());
    				this.chessBoard[i][j].setX(other.chessBoard[i][j].getX());
    				this.chessBoard[i][j].setY(other.chessBoard[i][j].getY());
    				this.chessBoard[i][j].setIsAlive(other.chessBoard[i][j].getIsAlive());
    			}//non-empty space
    		}
    	}
    }//end of copy constructor
    
    /**
     * Get the piece on the board
     * @param x
     * @param y
     * @return
     */
    public Piece getPiece(int x, int y){
    	return this.chessBoard[y][x];
    }
    
    /**
     * Set the row of board
     * @param row
     */
    public void setRow(int row){
    	this.row = row;
    }
    
    /**
     * Get the row of board
     * @return
     */
    public int getRow(){
    	return this.row;
    }
    
    /**
     * Set the column of board
     * @param column
     */
    public void setColumn(int column){
    	this.column = column;
    }
    
    /**
     * Get the column of board
     * @return
     */
    public int getColumn(){
    	return this.column;
    }
    
    /**
     * Set the piece of board
     * @param p
     * @param x
     * @param y
     */
    public void setChessBoard(Piece p, int x, int y){
    	this.chessBoard[y][x] = p;
    }
    
    /**
     * Get the piece of board
     * @param x
     * @param y
     * @return
     */
    public Piece getChessBoard(int x, int y){
    	return this.chessBoard[y][x];
    }  
}
