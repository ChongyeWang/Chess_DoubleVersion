/**
 * This class tests the game.
 */
package Tests;
import chessBuild.Board;
import chessBuild.Piece;
import chessBuild.Game;
import chessBuild.Pawn;
import chessBuild.Rook;
import chessBuild.Knight;
import chessBuild.Bishop;
import chessBuild.Queen;
import chessBuild.King;
import chessBuild.Player;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Scanner;  

public class testGame {
    /*test the initialization of the game*/
	@Test
	public void testGameInitialize() throws Exception{
    	Game testGame = new Game();
    	assertTrue(testGame.getWhitePlayer().getColor().equals("white"));
    	assertTrue(testGame.getBlackPlayer().getColor().equals("black"));
    	assertTrue(testGame.board.getColumn() == 8);
    	assertTrue(testGame.board.getRow() == 8);
    	assertTrue(testGame.getWhiteTurn() == true);
    	assertTrue(testGame.getGameEnd() == false);	
    }
    
    /* test the progress of the game*/
    @Test
    public void testPieceMove() throws Exception{
    	Game testGame = new Game();
    	assertTrue(testGame.getWhiteTurn() == true);
    	testGame.movePiece(6, 7, 4, 6);//cannot reach 
    	assertTrue(testGame.getWhiteTurn() == true);
    	testGame.movePiece(6, 7, 5, 5);//white knight move
    	assertTrue(testGame.getWhiteTurn() == false);//black turn
    	testGame.movePiece(0, 1, 0, 3);//black pawn move
    	assertTrue(testGame.getWhiteTurn() == true);//white turn
    	testGame.movePiece(5, 5, 6, 3);//white knight move
    	assertTrue(testGame.board.chessBoard[3][6] instanceof Knight);
    	testGame.movePiece(1, 1, 1, 3);//black pawn move
    	assertTrue(testGame.getWhiteTurn() == true);//white turn
    	testGame.movePiece(6, 3, 7, 1);//white knight move
    	assertTrue(testGame.board.chessBoard[1][7] instanceof Knight);
    	assertTrue(testGame.getBlackPlayer().getTrackPawn().get(7).getIsAlive() == false);
    	assertTrue(testGame.getBlackPlayer().getTrackPawn().get(7).getX() == -1);//dead black piece
    	assertTrue(testGame.getWhiteTurn() == false);//black turn
    	testGame.movePiece(0, 0, 0, 3);//cannot reach
    	assertTrue(testGame.getWhiteTurn() == false);//black turn
    	testGame.movePiece(6, 6, 6, 5);//(white)incorrect turn
    	assertTrue(testGame.getWhiteTurn() == false);//black turn
    	testGame.movePiece(0, 0, 0, 2);//move black rook
    	assertTrue(testGame.getWhiteTurn() == true);//white turn
    	testGame.movePiece(4, 3, 5, 3);//empty space
    	assertTrue(testGame.getWhiteTurn() == true);//white turn
    	testGame.movePiece(7, 1, 5, 2);//move white knight
    	assertTrue(testGame.board.chessBoard[2][5] instanceof Knight);
    	assertTrue(testGame.getWhiteTurn() == false);//black turn
    	testGame.movePiece(1, 0, 2, 2);//move black knight
    	testGame.movePiece(5, 2, 4, 0);//move white knight
    }
    
    @Test 
    public void testCheckMate(){
    	Game testGame = new Game();
        testGame.board.chessBoard[2][5] = new Knight(5, 2, "white", true);
        assertTrue(testGame.checkMate(testGame.getBlackPlayer()) == true);
        testGame.board.chessBoard[2][5] = null;
        testGame.board.chessBoard[2][4] = new Rook(4, 2, "white", true);
        assertTrue(testGame.checkMate(testGame.getBlackPlayer()) == false); 
        testGame.board.chessBoard[6][5] = new Pawn(5, 6, "black", true);
        assertTrue(testGame.checkMate(testGame.getWhitePlayer()) == true); 
    }
    @Test
    public void testGameWinner() throws Exception{
    	Game testGame = new Game();
    	assertTrue(testGame.getWhiteTurn() == true);
    	testGame.movePiece(6, 7, 5, 5);//white knight move
    	assertTrue(testGame.getWhiteTurn() == false);//black turn
    	testGame.movePiece(0, 1, 0, 3);//black pawn move
    	assertTrue(testGame.getWhiteTurn() == true);//white turn
    	testGame.movePiece(5, 5, 6, 3);//white knight move
    	assertTrue(testGame.board.chessBoard[3][6] instanceof Knight);
    	testGame.movePiece(1, 1, 1, 3);//black pawn move
    	assertTrue(testGame.getWhiteTurn() == true);//white turn
    	testGame.movePiece(6, 3, 7, 1);//white knight move
    	assertTrue(testGame.board.chessBoard[1][7] instanceof Knight);
    	assertTrue(testGame.getBlackPlayer().getTrackPawn().get(7).getIsAlive() == false);
    	assertTrue(testGame.getBlackPlayer().getTrackPawn().get(7).getX() == -1);//dead black piece
    	assertTrue(testGame.getWhiteTurn() == false);//black turn
    	testGame.movePiece(0, 0, 0, 3);//cannot reach
    	assertTrue(testGame.getWhiteTurn() == false);//black turn
    	testGame.movePiece(6, 6, 6, 5);//(white)incorrect turn
    	assertTrue(testGame.getWhiteTurn() == false);//black turn
    	testGame.movePiece(0, 0, 0, 2);//move black rook
    	assertTrue(testGame.getWhiteTurn() == true);//white turn
    	testGame.movePiece(4, 3, 5, 3);//empty space
    	assertTrue(testGame.getWhiteTurn() == true);//white turn
    	testGame.movePiece(7, 1, 5, 2);//move white knight
    	assertTrue(testGame.checkMate(testGame.getBlackPlayer()) == true);//black king is in check
    	testGame.movePiece(4, 0, 7, 7);//impossible move
    	testGame.movePiece(4, 0, 4, 1);//impossible move
    	assertTrue(testGame.getGameEnd() == false);
    	assertTrue(testGame.getWhiteTurn() == false);
    	assertTrue(testGame.board.chessBoard[1][7] == null);
    	testGame.movePiece(7, 0, 7, 1);
    	assertTrue(testGame.getGameEnd() == true);
    	assertTrue(testGame.getWhiteTurn() == true);
    	
    	Game testGame2 = new Game();
    	for(int i = 0; i < 8; i++){
    		testGame2.board.chessBoard[6][i] = null;
    	}
    	
    	testGame2.board.chessBoard[4][5] = new Knight(5, 4, "black", true);
    	testGame2.board.chessBoard[5][2] = new Knight(2, 5, "black", true);
    	testGame2.movePiece(0, 7, 0, 1);
    	testGame2.movePiece(5, 4, 6, 6);
    	
    	assertTrue(testGame2.checkMate(testGame2.getWhitePlayer()) == true); 
    	testGame2.movePiece(4, 7, 7, 7);//impossible move
    	testGame2.movePiece(4, 7, 5, 6);//run out of danger
    	assertTrue(testGame2.getGameEnd() == false);
    	assertTrue(testGame2.getWhiteTurn() == false);
    	
    }  
}
