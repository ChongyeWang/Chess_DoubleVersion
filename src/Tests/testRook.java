/**
 * This class tests the piece rook.
 */
package Tests;
import chessBuild.Piece;
import chessBuild.Game;
import chessBuild.Player;
import chessBuild.Rook;
import org.junit.Test;
import static org.junit.Assert.*;

public class testRook {
	@Test
	public void testRookPosition() throws Exception{
		Game testGame = new Game();
		assertTrue(testGame.board.chessBoard[0][0] instanceof Rook == true);
		assertTrue(testGame.board.chessBoard[7][7] instanceof Rook == true);
		assertTrue(testGame.board.chessBoard[0][7] instanceof Rook == true);
		assertTrue(testGame.board.chessBoard[7][0] instanceof Rook == true);
	}
	
	@Test
	public void testRookMove() throws Exception{
		Game testGame = new Game();
		testGame.board.chessBoard[3][3] = new Rook(3, 3, "white", true);
		assertTrue(testGame.board.chessBoard[3][3].checkMove(testGame.board, 7, 3) == true);
		assertTrue(testGame.board.chessBoard[3][3].checkMove(testGame.board, 7, 4) == false);
		assertTrue(testGame.board.chessBoard[3][3].checkMove(testGame.board, 3, 0) == false);
		assertTrue(testGame.board.chessBoard[3][3].checkMove(testGame.board, 3, 1) == true);
		assertTrue(testGame.board.chessBoard[3][3].checkMove(testGame.board, 3, 6) == false);
		assertTrue(testGame.board.chessBoard[0][0].checkMove(testGame.board, 0, 1) == false);
		assertTrue(testGame.board.chessBoard[0][0].checkMove(testGame.board, 1, 0) == false);

	}
	
	@Test
	public void testRookEatPiece() throws Exception{
		Game testGame = new Game();
		testGame.board.chessBoard[3][3] = new Rook(3, 3, "white", true);
		testGame.movePiece(3, 3, 3, 1);
		assertTrue(testGame.board.chessBoard[3][3] == null);
		assertTrue(testGame.board.chessBoard[1][3] instanceof Rook);
	}
}
