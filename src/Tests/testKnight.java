/**
 * This class tests the piece knight.
 */
package Tests;
import chessBuild.Knight;
import chessBuild.Piece;
import chessBuild.Game;
import chessBuild.Player;
import org.junit.Test;
import static org.junit.Assert.*;

public class testKnight {
	@Test
	public void testKnightPosition() throws Exception{
		Game testGame = new Game();
    	assertTrue(testGame.board.chessBoard[0][1] instanceof Knight);
    	assertTrue(testGame.board.chessBoard[0][6] instanceof Knight);
    	assertTrue(testGame.board.chessBoard[7][1] instanceof Knight);
    	assertTrue(testGame.board.chessBoard[7][6] instanceof Knight);
    }
	
	@Test
	public void testKnightMove() throws Exception{
		Game testGame = new Game();
    	assertTrue(testGame.board.chessBoard[0][1].checkMove(testGame.board, 2, 2) == true);
    	assertTrue(testGame.board.chessBoard[0][1].checkMove(testGame.board, 0, 2) == true);
    	assertTrue(testGame.board.chessBoard[0][1].checkMove(testGame.board, 0, 3) == false);
    	assertTrue(testGame.board.chessBoard[0][1].checkMove(testGame.board, 3, 1) == false);
    	assertTrue(testGame.board.chessBoard[7][1].checkMove(testGame.board, 6, 3) == false);
    	assertTrue(testGame.board.chessBoard[7][1].checkMove(testGame.board, 0, 5) == true);
    	assertTrue(testGame.board.chessBoard[7][1].checkMove(testGame.board, 2, 5) == true);
    	assertTrue(testGame.board.chessBoard[7][6].checkMove(testGame.board, 5, 5) == true);
    }
	
	@Test
	public void testKnightEatPiece() throws Exception{
		Game testGame = new Game();
		testGame.board.chessBoard[2][2] = new Knight(2, 2, "white", true);
		testGame.movePiece(2, 2, 1, 0);
		assertTrue(testGame.board.chessBoard[2][2] == null);
		assertTrue(testGame.board.chessBoard[0][1].getColor().equals("white"));
    }
}
