/**
 * This class tests the piece rook.
 */
package Tests;
import chessBuild.Queen;
import chessBuild.Piece;
import chessBuild.Game;
import chessBuild.Player;
import org.junit.Test;
import static org.junit.Assert.*;

public class testQueen {
	@Test
	public void testQueenPosition() throws Exception{
		Game testGame = new Game();
    	assertTrue(testGame.board.chessBoard[0][3] instanceof Queen);
    	assertTrue(testGame.board.chessBoard[7][3] instanceof Queen);
    }
	
	@Test
	public void testQueenMove() throws Exception{
		Game testGame = new Game();
    	assertTrue(testGame.board.chessBoard[0][3].checkMove(testGame.board, 3, 1) == false);
    	assertTrue(testGame.board.chessBoard[7][3].checkMove(testGame.board, 4, 7) == false);
    	testGame.board.chessBoard[2][2] = new Queen(2, 2, "white", true);
    	assertTrue(testGame.board.chessBoard[2][2].checkMove(testGame.board, 6, 2) == true);//move horizontally
    	assertTrue(testGame.board.chessBoard[2][2].checkMove(testGame.board, 0, 4) == true);//move diagonally
    	assertTrue(testGame.board.chessBoard[2][2].checkMove(testGame.board, 2, 6) == false);
    	assertTrue(testGame.board.chessBoard[2][2].checkMove(testGame.board, 2, 6) == false);
    	assertTrue(testGame.board.chessBoard[2][2].checkMove(testGame.board, 2, 1) == true);
    }
}
