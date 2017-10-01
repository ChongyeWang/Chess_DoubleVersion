/**
 * This class tests the piece king.
 */
package Tests;
import chessBuild.King;
import chessBuild.Piece;
import chessBuild.Game;
import chessBuild.Player;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
public class testKing {
	@Test
	public void testQueenPosition() throws Exception{
		Game testGame = new Game();
    	assertTrue(testGame.board.chessBoard[0][4] instanceof King);
    	assertTrue(testGame.board.chessBoard[7][4] instanceof King);
    }
	
	@Test
	public void testQueenMove() throws Exception{
		Game testGame = new Game();
    	assertTrue(testGame.board.chessBoard[0][4].checkMove(testGame.board, 5, 0) == false);
    	assertTrue(testGame.board.chessBoard[7][4].checkMove(testGame.board, 5, 7) == false);
    	testGame.board.chessBoard[2][2] = new King(2, 2, "white", true);
    	assertTrue(testGame.board.chessBoard[2][2].checkMove(testGame.board, 2, 1) == true);
    	assertTrue(testGame.board.chessBoard[2][2].checkMove(testGame.board, 1, 1) == true);
    	assertTrue(testGame.board.chessBoard[2][2].checkMove(testGame.board, 0, 1) == false);
    	assertTrue(testGame.board.chessBoard[2][2].checkMove(testGame.board, 3, 3) == true);
    }
}
