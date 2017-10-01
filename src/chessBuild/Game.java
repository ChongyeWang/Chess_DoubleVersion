/**
 * This class implements main game loop.
 */
package chessBuild;
import java.util.ArrayList;

public class Game {
    private Player white;
    private Player black;
    private int row;
    private int column;
    private boolean whiteTurn;
    private String winner;
    private boolean gameEnd;
    public Board board;

    /**
     * Default constructor of game
     */
    public Game(){
    	this.row = 8;
    	this.column = 8;
    	this.whiteTurn = true;
    	this.board = new Board(row, column);
    	this.white = new Player("white");
    	this.black = new Player("black");
    	this.winner = "";
    	this.gameEnd = false;
    	this.initializeGame();
    }
    
    /**
     * Copy constructor
     * @param other
     */
    public Game(Game other){
    	this.row = other.row;
    	this.column = other.column;
    	this.whiteTurn = other.whiteTurn;
    	this.winner = other.winner;
    	this.gameEnd = other.gameEnd;
    	this.board = new Board(other.board);
    	this.black = new Player(other.black);
    	this.white = new Player(other.white);
    }
    
    /**
     * Initialize the game
     */
    public void initializeGame(){
    	this.initializeChessBoard();
    	this.initializeBlackPlayer();
    	this.initializeWhitePlayer();
    }
    
    /**
     * Get winner method
     * @return
     */
    public String getWinner(){
    	return this.winner;
    }
    
    /**
     * Set the winner of the game
     * @param win
     */
    public void setWinner(String win){
    	this.winner = win;
    }
    
    /**
     * Get the white player of the game
     * @return
     */
    public Player getWhitePlayer(){
    	return this.white;
    }
    
    /**
     * Get the black player of the game
     * @return
     */
    public Player getBlackPlayer(){
    	return this.black;
    }
    
    /**
     * Get the row
     * @return
     */
    public int getRow(){
    	return this.row;
    }
    
    /**
     * Get the column
     * @return
     */
    public int getColumn(){
    	return this.getColumn();
    }
    
    /**
     * Get the gameEnd
     * @return
     */
    public boolean getGameEnd(){
    	return this.gameEnd;
    }
    
    /**
     * Set the gameEnd
     * @param end
     */
    public void setGameEnd(boolean end){
    	this.gameEnd = end;
    }
    
    /**
     * Get the turn of player
     * @return
     */
    public boolean getWhiteTurn(){
    	return this.whiteTurn;
    }
    
    /**
     * Set the turn of player
     * @param turn
     */
    public void setWhiteTurn(boolean turn){
    	this.whiteTurn = turn;
    }
    
    /**
     * Initialize the board of the game
     */
    public void initializeChessBoard(){
    	for(int i = 0; i < 8; i++){
    		for(int j = 0; j < 8; j++){
    			board.chessBoard[i][j] = null;
    		}
    	}
    	//initial position of black pawn
    	for(int i = 0; i < 8; i++){
    		board.chessBoard[1][i] = new Pawn(i, 1, "black", true);
    	}
    	//initial position of black rook
    	board.chessBoard[0][0] = new Rook(0, 0, "black", true);
    	board.chessBoard[0][7] = new Rook(7, 0, "black", true);
    	//initial position of black knight
    	board.chessBoard[0][1] = new Knight(1, 0, "black", true);
    	board.chessBoard[0][6] = new Knight(6, 0, "black", true);
    	//initial position of black bishop
    	board.chessBoard[0][2] = new Bishop(2, 0, "black", true);
    	board.chessBoard[0][5] = new Bishop(5, 0, "black", true);
    	//initial position of black queen
    	board.chessBoard[0][3] = new Queen(3, 0, "black", true);
    	//initial position of black king
    	board.chessBoard[0][4] = new King(4, 0, "black", true); 
    	
    	
    	//initial position of white pawn
    	for(int i = 0; i < 8; i++){
    		board.chessBoard[6][i] = new Pawn(i, 6, "white", true);
    	}
    	//initial position of black rook
    	board.chessBoard[7][0] = new Rook(0, 7, "white", true);
    	board.chessBoard[7][7] = new Rook(7, 7, "white", true);
    	//initial position of black knight
    	board.chessBoard[7][1] = new Knight(1, 7, "white", true);
    	board.chessBoard[7][6] = new Knight(6, 7, "white", true);
    	//initial position of black bishop
    	board.chessBoard[7][2] = new Bishop(2, 7, "white", true);
    	board.chessBoard[7][5] = new Bishop(5, 7, "white", true);
    	//initial position of black queen
    	board.chessBoard[7][3] = new Queen(3, 7, "white", true);
    	//initial position of black king
    	board.chessBoard[7][4] = new King(4, 7, "white", true); 
    }
    
    /**
     * Initialize the blackPlayer of the game
     */
    public void initializeBlackPlayer(){
    	//set up pawn
    	for(int i = 0; i < 8; i++){
    		black.getTrackPawn().get(i).setX(i);
        	black.getTrackPawn().get(i).setY(1);
        	black.getTrackPawn().get(i).setIsAlive(true);
    	}
    	
    	//set up Knight
    	black.getTrackKnight().get(0).setX(1);
    	black.getTrackKnight().get(0).setY(0);
    	black.getTrackKnight().get(1).setX(6);
    	black.getTrackKnight().get(1).setY(0);
    	black.getTrackKnight().get(0).setIsAlive(true);
    	black.getTrackKnight().get(1).setIsAlive(true);
    	
    	//set up Bishop
    	black.getTrackBishop().get(0).setX(2);
    	black.getTrackBishop().get(0).setY(0);
    	black.getTrackBishop().get(1).setX(5);
    	black.getTrackBishop().get(1).setY(0);
    	black.getTrackBishop().get(0).setIsAlive(true);
    	black.getTrackBishop().get(1).setIsAlive(true);
    	
    	//set up Rook
    	black.getTrackRook().get(0).setX(0);
    	black.getTrackRook().get(0).setY(0);
    	black.getTrackRook().get(1).setX(7);
    	black.getTrackRook().get(1).setY(0);
    	black.getTrackRook().get(0).setIsAlive(true);
    	black.getTrackRook().get(1).setIsAlive(true);
    	
    	//set up Queen
    	black.getTrackQueen().get(0).setX(3);
    	black.getTrackQueen().get(0).setY(0);
    	black.getTrackQueen().get(0).setIsAlive(true);
    	
    	//set up King
    	black.getTrackKing().get(0).setX(4);
    	black.getTrackKing().get(0).setY(0);
    	black.getTrackKing().get(0).setIsAlive(true);
    	
    	/////New Version Piece//////
    	black.getTrackKin().get(0).setX(-1);
    	black.getTrackKin().get(0).setY(-1);
    	black.getTrackKin().get(0).setIsAlive(false);
    	
    	black.getTrackElephant().get(0).setX(-1);
    	black.getTrackElephant().get(0).setY(-1);
    	black.getTrackElephant().get(0).setIsAlive(false);
    }
    
    /**
     * Initialize the white player of the game
     */
    public void initializeWhitePlayer(){
    	//set up pawn
    	for(int i = 0; i < 8; i++){
    		white.getTrackPawn().get(i).setX(i);
        	white.getTrackPawn().get(i).setY(6);
        	white.getTrackPawn().get(i).setIsAlive(true);
    	}

    	//set up Knight
    	white.getTrackKnight().get(0).setX(1);
    	white.getTrackKnight().get(0).setY(7);
    	white.getTrackKnight().get(1).setX(6);
    	white.getTrackKnight().get(1).setY(7);
    	white.getTrackKnight().get(0).setIsAlive(true);
    	white.getTrackKnight().get(1).setIsAlive(true);
    	
    	//set up Bishop
    	white.getTrackBishop().get(0).setX(2);
    	white.getTrackBishop().get(0).setY(7);
    	white.getTrackBishop().get(1).setX(5);
    	white.getTrackBishop().get(1).setY(7);
    	white.getTrackBishop().get(0).setIsAlive(true);
    	white.getTrackBishop().get(1).setIsAlive(true);
    	
    	//set up Rook
    	white.getTrackRook().get(0).setX(0);
    	white.getTrackRook().get(0).setY(7);
    	white.getTrackRook().get(1).setX(7);
    	white.getTrackRook().get(1).setY(7);
    	white.getTrackRook().get(0).setIsAlive(true);
    	white.getTrackRook().get(1).setIsAlive(true);
    	
    	//set up Queen
    	white.getTrackQueen().get(0).setX(3);
    	white.getTrackQueen().get(0).setY(7);
    	white.getTrackQueen().get(0).setIsAlive(true);
    	
    	//set up King
    	white.getTrackKing().get(0).setX(4);
    	white.getTrackKing().get(0).setY(7);
    	white.getTrackKing().get(0).setIsAlive(true);
    	
        /////New Version Piece//////
    	white.getTrackKin().get(0).setX(-1);
    	white.getTrackKin().get(0).setY(-1);
    	white.getTrackKin().get(0).setIsAlive(false);
    	
    	white.getTrackElephant().get(0).setX(-1);
    	white.getTrackElephant().get(0).setY(-1);
    	white.getTrackElephant().get(0).setIsAlive(false);
    }
    
    /**
     * This function move the piece on the board by
     * taking the initial position and target position
     * @param currX
     * @param currY
     * @param targetX
     * @param targetY
     */
    public void movePiece(int currX, int currY, int targetX, int targetY){
    	if(movePieceHelper(currX, currY, targetX, targetY)){
    		if(whiteTurn == true){//white turn
    			if(board.chessBoard[currY][currX].getColor().equals("white") == false){
    				return;
    			}
    			if(board.chessBoard[currY][currX].checkMove(board, targetX, targetY) == true){
    				if(checkKingTargetPosition(white, currX, currY, targetX, targetY) == false){
    					return;
    				}
    				whiteTurn = !whiteTurn;//switch the player
    				whiteMove(currX, currY, targetX, targetY);	
    			}// piece can reach target place
    		}// white turn
    		
    		
    		else if(whiteTurn == false){//black turn
    			if(board.chessBoard[currY][currX].getColor().equals("black") == false){
    				return;
    			}
    			if(board.chessBoard[currY][currX].checkMove(board, targetX, targetY) == true){
    				if(checkKingTargetPosition(black, currX, currY, targetX, targetY) == false){
    					return;
    				}
    				whiteTurn = !whiteTurn;//switch the player
    				blackMove(currX, currY, targetX, targetY);	
    			}// piece can reach target place	
    		}// black turn
    	}
    }// end of movePiece
    
    /**
     * The function will return false if the input is invalid
     * @param currX
     * @param currY
     * @param targetX
     * @param targetY
     * @return
     */
    public boolean movePieceHelper(int currX, int currY, int targetX, int targetY){
    	if(board.chessBoard[currY][currX] == null){
    		return false;
    	}//no piece in the selected spot
    	if(currX < 0 || currY < 0 || currX >= board.getColumn() || currY >= board.getRow()){
    		return false;
    	}
    	if(targetX < 0 || targetY < 0 || targetX >= board.getColumn() || targetY >= board.getRow()){
    		return false;
    	}
    	return true;
    }//movePiece helper function
    
    
    /**
     * Move the white Piece
     * @param currX
     * @param currY
     * @param targetX
     * @param targetY
     */
    public void whiteMove(int currX, int currY, int targetX, int targetY){
    	if(board.chessBoard[targetY][targetX] != null){
			if(board.chessBoard[targetY][targetX] instanceof Pawn){
				for(int i = 0; i < black.getTrackPawn().size(); i++){
					if(black.getTrackPawn().get(i).getX() == targetX && black.getTrackPawn().get(i).getY() == targetY){
						black.getTrackPawn().get(i).setX(-1);
						black.getTrackPawn().get(i).setY(-1);
						black.getTrackPawn().get(i).setIsAlive(false);
					}
				}
			}//pawn
			if(board.chessBoard[targetY][targetX] instanceof Rook){
				for(int i = 0; i < black.getTrackRook().size(); i++){
					if(black.getTrackRook().get(i).getX() == targetX && black.getTrackRook().get(i).getY() == targetY){
						black.getTrackRook().get(i).setX(-1);
						black.getTrackRook().get(i).setY(-1);
						black.getTrackRook().get(i).setIsAlive(false);
					}
				}
			}//rook
			if(board.chessBoard[targetY][targetX] instanceof Knight){
				for(int i = 0; i < black.getTrackKnight().size(); i++){
					if(black.getTrackKnight().get(i).getX() == targetX && black.getTrackKnight().get(i).getY() == targetY){
						black.getTrackKnight().get(i).setX(-1);
						black.getTrackKnight().get(i).setY(-1);
						black.getTrackKnight().get(i).setIsAlive(false);
					}
				}
			}//knight
			if(board.chessBoard[targetY][targetX] instanceof Bishop){
				for(int i = 0; i < black.getTrackBishop().size(); i++){
					if(black.getTrackBishop().get(i).getX() == targetX && black.getTrackBishop().get(i).getY() == targetY){
						black.getTrackBishop().get(i).setX(-1);
						black.getTrackBishop().get(i).setY(-1);
						black.getTrackBishop().get(i).setIsAlive(false);
					}
				}
			}//bishop
			if(board.chessBoard[targetY][targetX] instanceof Queen){
				for(int i = 0; i < black.getTrackQueen().size(); i++){
					if(black.getTrackQueen().get(i).getX() == targetX && black.getTrackQueen().get(i).getY() == targetY){
						black.getTrackQueen().get(i).setX(-1);
						black.getTrackQueen().get(i).setY(-1);
						black.getTrackQueen().get(i).setIsAlive(false);
					}
				}
			}//queen
			if(board.chessBoard[targetY][targetX] instanceof King){
				for(int i = 0; i < black.getTrackKing().size(); i++){
					if(black.getTrackKing().get(i).getX() == targetX && black.getTrackKing().get(i).getY() == targetY){
						black.getTrackKing().get(i).setX(-1);
						black.getTrackKing().get(i).setY(-1);
						black.getTrackKing().get(i).setIsAlive(false);
					}
				}
			}//king
			
			
			//////////New Version Piece//////////
			if(board.chessBoard[targetY][targetX] instanceof Kin){
				for(int i = 0; i < black.getTrackKin().size(); i++){
					if(black.getTrackKin().get(i).getX() == targetX && black.getTrackKin().get(i).getY() == targetY){
						black.getTrackKin().get(i).setX(-1);
						black.getTrackKin().get(i).setY(-1);
						black.getTrackKin().get(i).setIsAlive(false);
					}
				}
			}//kin
			if(board.chessBoard[targetY][targetX] instanceof Elephant){
				for(int i = 0; i < black.getTrackPawn().size(); i++){
					if(black.getTrackElephant().get(i).getX() == targetX && black.getTrackElephant().get(i).getY() == targetY){
						black.getTrackElephant().get(i).setX(-1);
						black.getTrackElephant().get(i).setY(-1);
						black.getTrackElephant().get(i).setIsAlive(false);
					}
				}
			}//elephant
			
			board.chessBoard[targetY][targetX] = null;
		}//the target place is not empty, eat the piece at the target place
		
		if(board.chessBoard[currY][currX] instanceof Pawn){
			for(int i = 0; i < white.getTrackPawn().size(); i++){
				if(white.getTrackPawn().get(i).getX() == currX && white.getTrackPawn().get(i).getY() == currY){
					white.getTrackPawn().get(i).setX(targetX);
					white.getTrackPawn().get(i).setY(targetY);
				}// set up new coordinates
			}
			board.chessBoard[targetY][targetX] = new Pawn(targetX, targetY, "white", true);
		}//pawn
		if(board.chessBoard[currY][currX] instanceof Rook){
			for(int i = 0; i < white.getTrackRook().size(); i++){
				if(white.getTrackRook().get(i).getX() == currX && white.getTrackRook().get(i).getY() == currY){
					white.getTrackRook().get(i).setX(targetX);
					white.getTrackRook().get(i).setY(targetY);
				}// set up new coordinates
			}
			board.chessBoard[targetY][targetX] = new Rook(targetX, targetY, "white", true);
		}//rook
		if(board.chessBoard[currY][currX] instanceof Knight){
			for(int i = 0; i < white.getTrackKnight().size(); i++){
				if(white.getTrackKnight().get(i).getX() == currX && white.getTrackKnight().get(i).getY() == currY){
					white.getTrackKnight().get(i).setX(targetX);
					white.getTrackKnight().get(i).setY(targetY);
				}// set up new coordinates
			}
			board.chessBoard[targetY][targetX] = new Knight(targetX, targetY, "white", true);
		}//knight
		if(board.chessBoard[currY][currX] instanceof Bishop){
			for(int i = 0; i < white.getTrackRook().size(); i++){
				if(white.getTrackBishop().get(i).getX() == currX && white.getTrackBishop().get(i).getY() == currY){
					white.getTrackBishop().get(i).setX(targetX);
					white.getTrackBishop().get(i).setY(targetY);
				}// set up new coordinates
			}
			board.chessBoard[targetY][targetX] = new Bishop(targetX, targetY, "white", true);
		}//bishop
		if(board.chessBoard[currY][currX] instanceof Queen){
			for(int i = 0; i < white.getTrackQueen().size(); i++){
				if(white.getTrackQueen().get(i).getX() == currX && white.getTrackQueen().get(i).getY() == currY){
					white.getTrackQueen().get(i).setX(targetX);
					white.getTrackQueen().get(i).setY(targetY);
				}// set up new coordinates
			}
			board.chessBoard[targetY][targetX] = new Queen(targetX, targetY, "white", true);
		}//queen
		if(board.chessBoard[currY][currX] instanceof King){
			for(int i = 0; i < white.getTrackKing().size(); i++){
				if(white.getTrackKing().get(i).getX() == currX && white.getTrackKing().get(i).getY() == currY){
					white.getTrackKing().get(i).setX(targetX);
					white.getTrackKing().get(i).setY(targetY);
				}// set up new coordinates
			}
			board.chessBoard[targetY][targetX] = new King(targetX, targetY, "white", true);
		}//king
		
		
		/////////New Version Piece///////////
		if(board.chessBoard[currY][currX] instanceof Kin){
			for(int i = 0; i < white.getTrackKin().size(); i++){
				if(white.getTrackKin().get(i).getX() == currX && white.getTrackKin().get(i).getY() == currY){
					white.getTrackKin().get(i).setX(targetX);
					white.getTrackKin().get(i).setY(targetY);
				}// set up new coordinates
			}
			board.chessBoard[targetY][targetX] = new Kin(targetX, targetY, "white", true);
		}//kin
		if(board.chessBoard[currY][currX] instanceof Elephant){
			for(int i = 0; i < white.getTrackElephant().size(); i++){
				if(white.getTrackElephant().get(i).getX() == currX && white.getTrackElephant().get(i).getY() == currY){
					white.getTrackElephant().get(i).setX(targetX);
					white.getTrackElephant().get(i).setY(targetY);
				}// set up new coordinates
			}
			board.chessBoard[targetY][targetX] = new Elephant(targetX, targetY, "white", true);
		}//elephant
		
		
		board.chessBoard[currY][currX] = null;//Set the current position to null
		
		if(checkMate(white)){
			this.gameEnd = true;
			this.winner = "black";
		}//checkMate for white
    }//end of whiteMove function
    
    /**
     * Move the black piece
     * @param currX
     * @param currY
     * @param targetX
     * @param targetY
     */
    public void blackMove(int currX, int currY, int targetX, int targetY){
    	if(board.chessBoard[targetY][targetX] != null){
			if(board.chessBoard[targetY][targetX] instanceof Pawn){
				for(int i = 0; i < white.getTrackPawn().size(); i++){
					if(white.getTrackPawn().get(i).getX() == targetX && white.getTrackPawn().get(i).getY() == targetY){
						white.getTrackPawn().get(i).setX(-1);
						white.getTrackPawn().get(i).setY(-1);
						white.getTrackPawn().get(i).setIsAlive(false);
					}
				}
			}//pawn
			if(board.chessBoard[targetY][targetX] instanceof Rook){
				for(int i = 0; i < white.getTrackRook().size(); i++){
					if(white.getTrackRook().get(i).getX() == targetX && white.getTrackRook().get(i).getY() == targetY){
						white.getTrackRook().get(i).setX(-1);
						white.getTrackRook().get(i).setY(-1);
						white.getTrackRook().get(i).setIsAlive(false);
					}
				}
			}//rook
			if(board.chessBoard[targetY][targetX] instanceof Knight){
				for(int i = 0; i < white.getTrackKnight().size(); i++){
					if(white.getTrackKnight().get(i).getX() == targetX && white.getTrackKnight().get(i).getY() == targetY){
						white.getTrackKnight().get(i).setX(-1);
						white.getTrackKnight().get(i).setY(-1);
						white.getTrackKnight().get(i).setIsAlive(false);
					}
				}
			}//knight
			if(board.chessBoard[targetY][targetX] instanceof Bishop){
				for(int i = 0; i < white.getTrackBishop().size(); i++){
					if(white.getTrackBishop().get(i).getX() == targetX && white.getTrackBishop().get(i).getY() == targetY){
						white.getTrackBishop().get(i).setX(-1);
						white.getTrackBishop().get(i).setY(-1);
						white.getTrackBishop().get(i).setIsAlive(false);
					}
				}
			}//bishop
			if(board.chessBoard[targetY][targetX] instanceof Queen){
				for(int i = 0; i < white.getTrackQueen().size(); i++){
					if(white.getTrackQueen().get(i).getX() == targetX && white.getTrackQueen().get(i).getY() == targetY){
						white.getTrackQueen().get(i).setX(-1);
						white.getTrackQueen().get(i).setY(-1);
						white.getTrackQueen().get(i).setIsAlive(false);
					}
				}
			}//queen
			if(board.chessBoard[targetY][targetX] instanceof King){
				for(int i = 0; i < white.getTrackKing().size(); i++){
					if(white.getTrackKing().get(i).getX() == targetX && white.getTrackKing().get(i).getY() == targetY){
						white.getTrackKing().get(i).setX(-1);
						white.getTrackKing().get(i).setY(-1);
						white.getTrackKing().get(i).setIsAlive(false);
					}
				}
			}//king
			
			
			//////////New Version Piece//////////
			if(board.chessBoard[targetY][targetX] instanceof Kin){
				for(int i = 0; i < white.getTrackKin().size(); i++){
					if(white.getTrackKin().get(i).getX() == targetX && white.getTrackKin().get(i).getY() == targetY){
						white.getTrackKin().get(i).setX(-1);
						white.getTrackKin().get(i).setY(-1);
						white.getTrackKin().get(i).setIsAlive(false);
					}
				}
			}//kin
			if(board.chessBoard[targetY][targetX] instanceof Elephant){
				for(int i = 0; i < white.getTrackElephant().size(); i++){
					if(white.getTrackElephant().get(i).getX() == targetX && white.getTrackElephant().get(i).getY() == targetY){
						white.getTrackElephant().get(i).setX(-1);
						white.getTrackElephant().get(i).setY(-1);
						white.getTrackElephant().get(i).setIsAlive(false);
					}
				}
			}//elephant
			
			board.chessBoard[targetY][targetX] = null;
		}//the target place is not empty, eat the piece at the target place
		
		
		if(board.chessBoard[currY][currX] instanceof Pawn){
			for(int i = 0; i < black.getTrackPawn().size(); i++){
				if(black.getTrackPawn().get(i).getX() == currX && black.getTrackPawn().get(i).getY() == currY){
					black.getTrackPawn().get(i).setX(targetX);
					black.getTrackPawn().get(i).setY(targetY);
				}// set up new coordinates
			}
			board.chessBoard[targetY][targetX] = new Pawn(targetX, targetY, "black", true);
		}//pawn
		if(board.chessBoard[currY][currX] instanceof Rook){
			for(int i = 0; i < black.getTrackRook().size(); i++){
				if(black.getTrackRook().get(i).getX() == currX && black.getTrackRook().get(i).getY() == currY){
					black.getTrackRook().get(i).setX(targetX);
					black.getTrackRook().get(i).setY(targetY);
				}// set up new coordinates
			}
			board.chessBoard[targetY][targetX] = new Rook(targetX, targetY, "black", true);
		}//rook
		if(board.chessBoard[currY][currX] instanceof Knight){
			for(int i = 0; i < black.getTrackKnight().size(); i++){
				if(black.getTrackKnight().get(i).getX() == currX && black.getTrackKnight().get(i).getY() == currY){
					black.getTrackKnight().get(i).setX(targetX);
					black.getTrackKnight().get(i).setY(targetY);
				}// set up new coordinates
			}
			board.chessBoard[targetY][targetX] = new Knight(targetX, targetY, "black", true);
		}//knight
		if(board.chessBoard[currY][currX] instanceof Bishop){
			for(int i = 0; i < black.getTrackRook().size(); i++){
				if(black.getTrackBishop().get(i).getX() == currX && black.getTrackBishop().get(i).getY() == currY){
					black.getTrackBishop().get(i).setX(targetX);
					black.getTrackBishop().get(i).setY(targetY);
				}// set up new coordinates
			}
			board.chessBoard[targetY][targetX] = new Bishop(targetX, targetY, "black", true);
		}//bishop
		if(board.chessBoard[currY][currX] instanceof Queen){
			for(int i = 0; i < black.getTrackQueen().size(); i++){
				if(black.getTrackQueen().get(i).getX() == currX && black.getTrackQueen().get(i).getY() == currY){
					black.getTrackQueen().get(i).setX(targetX);
					black.getTrackQueen().get(i).setY(targetY);
				}// set up new coordinates
			}
			board.chessBoard[targetY][targetX] = new Queen(targetX, targetY, "black", true);
		}//queen
		if(board.chessBoard[currY][currX] instanceof King){
			for(int i = 0; i < black.getTrackKing().size(); i++){
				if(black.getTrackKing().get(i).getX() == currX && black.getTrackKing().get(i).getY() == currY){
					black.getTrackKing().get(i).setX(targetX);
					black.getTrackKing().get(i).setY(targetY);
				}// set up new coordinates
			}
			board.chessBoard[targetY][targetX] = new King(targetX, targetY, "black", true);
		}//king
		
		
        /////////New Version Piece///////////
		if(board.chessBoard[currY][currX] instanceof Kin){
			for(int i = 0; i < black.getTrackKin().size(); i++){
				if(black.getTrackKin().get(i).getX() == currX && black.getTrackKin().get(i).getY() == currY){
					black.getTrackKin().get(i).setX(targetX);
					black.getTrackKin().get(i).setY(targetY);
				}// set up new coordinates
			}
			board.chessBoard[targetY][targetX] = new Kin(targetX, targetY, "black", true);
		}//kin
		if(board.chessBoard[currY][currX] instanceof Elephant){
			for(int i = 0; i < black.getTrackKin().size(); i++){
				if(black.getTrackElephant().get(i).getX() == currX && black.getTrackElephant().get(i).getY() == currY){
					black.getTrackElephant().get(i).setX(targetX);
					black.getTrackElephant().get(i).setY(targetY);
				}// set up new coordinates
			}
			board.chessBoard[targetY][targetX] = new Elephant(targetX, targetY, "black", true);
		}//elephant
		
		board.chessBoard[currY][currX] = null;//set current position to null on the board
		
		if(checkMate(black)){
			this.gameEnd = true;
			this.winner = "white";
		}//checkMate for black
    }//end of blackMove function
    
    
    /**
     * CheckMate function for the game
     * @param player
     * @return
     */
    public boolean checkMate(Player player){
		int kingX = player.getTrackKing().get(0).getX();
		int kingY = player.getTrackKing().get(0).getY();
		return !safePosition(player, kingX, kingY);		
    }//checkMate method
    
    /**
     * The function checks whether the selected 
     * position is safe for the player
     * @param player
     * @param x
     * @param y
     * @return
     */
    public boolean safePosition(Player player, int x, int y){
    	if(x < 0 || x >= 8 || y < 0 || y >= 8){
    		return false;
    	}
    	if(player.getColor().equals("white")){
    		for(int i = 0; i < 8; i++){
    			for(int j = 0; j < 8; j++){
    				if(board.chessBoard[i][j] != null && board.chessBoard[i][j].getColor().equals("black")
    				  && board.chessBoard[i][j].checkMove(board, x, y)){
    					return false;
    				}
    			}
    		}
    		return true;
    	}//check white
    	else{
    		for(int i = 0; i < 8; i++){
    			for(int j = 0; j < 8; j++){
    				if(board.chessBoard[i][j] != null && board.chessBoard[i][j].getColor().equals("white")
    				  && board.chessBoard[i][j].checkMove(board, x, y)){
    					return false;
    				}
    			}
    		}
    		return true;
    	}//check black
    }//safePosition Method
    
    /**
     * Check whether the target place of
     * king is dangerous
     * @param player
     * @param currX
     * @param currY
     * @param targetX
     * @param targetY
     * @return
     */
    public boolean checkKingTargetPosition(Player player, int currX, int currY, int targetX, int targetY){
    	if(board.chessBoard[currY][currX] instanceof King &&
    		safePosition(player, targetX, targetY) == false){
    		return false;
    	}
    	return true;
    }
    
    /**
     * This method changes the version of the game
     * by replacing original piece knight with new
     * piece kin and elephant.
     */
    public void changeVersion(){
    	//Set up kin and elephant on board
    	this.board.chessBoard[0][1] = null;
    	this.board.chessBoard[0][1] = new Kin(1, 0, "black", true);
    	this.board.chessBoard[0][6] = null;
    	this.board.chessBoard[0][6] = new Elephant(6, 0, "black", true);
    	
    	this.board.chessBoard[7][1] = null;
    	this.board.chessBoard[7][1] = new Kin(1, 7, "white", true);
    	this.board.chessBoard[7][6] = null;
    	this.board.chessBoard[7][6] = new Elephant(6, 7, "white", true);
    	
    	//Set up kin and elephant on player
    	this.black.getTrackKin().get(0).setX(1);
    	this.black.getTrackKin().get(0).setY(0);
    	this.black.getTrackElephant().get(0).setX(6);
    	this.black.getTrackElephant().get(0).setY(0);
    	this.black.getTrackKin().get(0).setIsAlive(true);
    	this.black.getTrackElephant().get(0).setIsAlive(true);
    	
    	this.white.getTrackKin().get(0).setX(1);
    	this.white.getTrackKin().get(0).setY(7);
    	this.white.getTrackElephant().get(0).setX(6);
    	this.white.getTrackElephant().get(0).setY(7);
    	this.white.getTrackKin().get(0).setIsAlive(true);
    	this.white.getTrackElephant().get(0).setIsAlive(true);
    	
    	//Eliminate the knight piece from the player
    	for(int i = 0; i < 2; i++){
			this.black.getTrackKnight().get(i).setX(-1);
			this.black.getTrackKnight().get(i).setY(-1);
			this.black.getTrackKnight().get(i).setIsAlive(false);
			this.white.getTrackKnight().get(i).setX(-1);
			this.white.getTrackKnight().get(i).setY(-1);
			this.white.getTrackKnight().get(i).setIsAlive(false);
    	}
    }//end of changeVersion method

}//end of class
