/**
 * This class tests the piece pawn.
 */
package Tests;
import chessBuild.Pawn;
import chessBuild.Piece;
import chessBuild.Game;
import chessBuild.Player;
import org.junit.Test;
import static org.junit.Assert.*;

public class testPawn{
	@Test
    public void testPawn() throws Exception{
		Game testGame = new Game();
    	assertTrue(testGame.board.chessBoard[1][4] instanceof Pawn);
    	assertTrue(testGame.board.chessBoard[6][6] instanceof Pawn);
    }
	@Test
	public void testPawnCheckMove() throws Exception{
		Game testGame = new Game();
    	
		/*//test move 1 | 2 space at the beginning*/
		assertTrue(testGame.board.chessBoard[1][5].checkMove(testGame.board, 5, 3) == true);
		assertTrue(testGame.board.chessBoard[1][5].checkMove(testGame.board, 5, 2) == true);
		assertTrue(testGame.board.chessBoard[1][5].checkMove(testGame.board, 6, 2) == false);
		
		/*test impossible target place*/
    	testGame.movePiece(testGame.board.chessBoard[1][4].getX(), testGame.board.chessBoard[1][4].getY(), 7, 7);
    	assertTrue(testGame.board.chessBoard[1][4].getX() == 4);
    	assertTrue(testGame.board.chessBoard[1][4].getY() == 1);
    	
    	testGame.movePiece(testGame.board.chessBoard[1][4].getX(), testGame.board.chessBoard[1][4].getY(), 5, 2);
    	assertTrue(testGame.board.chessBoard[1][4].getX() == 4);
    	assertTrue(testGame.board.chessBoard[1][4].getY() == 1);
   
    	
    	/*test possible target place*/
    	testGame.movePiece(testGame.board.chessBoard[6][1].getX(), testGame.board.chessBoard[6][1].getY(), 1, 4);
    	assertTrue(testGame.board.chessBoard[6][1] == null);
    	assertTrue(testGame.board.chessBoard[4][1] instanceof Pawn);
    	assertTrue(testGame.board.chessBoard[4][1].getX() == 1);
    	assertTrue(testGame.board.chessBoard[4][1].getY() == 4);//white first
    	
    	testGame.movePiece(testGame.board.chessBoard[1][0].getX(), testGame.board.chessBoard[1][0].getY(), 0, 3);
    	assertTrue(testGame.board.chessBoard[1][0] == null);
    	assertTrue(testGame.board.chessBoard[3][0] instanceof Pawn);
    	assertTrue(testGame.board.chessBoard[3][0].getX() == 0);
    	assertTrue(testGame.board.chessBoard[3][0].getY() == 3);//then black
    	
    }
	
	@Test 
	public void testPawnEatPiece() throws Exception{
		/*test eat piece*/
    	Game testGame2 = new Game();
    	testGame2.board.chessBoard[5][5] = new Pawn(5, 5, "black", true);
    	testGame2.movePiece(testGame2.board.chessBoard[6][4].getX(), testGame2.board.chessBoard[6][4].getY(), 5, 5);
    	assertTrue(testGame2.board.chessBoard[6][4] == null);
    	assertTrue(testGame2.board.chessBoard[5][5].getColor().equals("white"));
    	assertTrue(testGame2.board.chessBoard[5][5] instanceof Pawn);
	}
}
