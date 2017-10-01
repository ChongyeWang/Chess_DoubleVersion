/**
 * This class tests the piece bishop.
 */
package Tests;
import chessBuild.Bishop;
import chessBuild.Piece;
import chessBuild.Game;
import chessBuild.Player;
import org.junit.Test;
import static org.junit.Assert.*;
public class testBishop {
	@Test
	public void testBishopPosition() throws Exception{
		Game testGame = new Game();
    	assertTrue(testGame.board.chessBoard[0][2] instanceof Bishop);
    	assertTrue(testGame.board.chessBoard[0][5] instanceof Bishop);
    	assertTrue(testGame.board.chessBoard[7][2] instanceof Bishop);
    	assertTrue(testGame.board.chessBoard[7][5] instanceof Bishop);
    }
	
	@Test
	public void testBishopMove() throws Exception{
		Game testGame = new Game();
    	assertTrue(testGame.board.chessBoard[0][2].checkMove(testGame.board, 3, 1) == false);
    	assertTrue(testGame.board.chessBoard[0][5].checkMove(testGame.board, 7, 2) == false);
    	testGame.board.chessBoard[2][2] = new Bishop(2, 2, "white", true);
    	testGame.board.chessBoard[5][5] = new Bishop(5, 5, "black", true);
    	assertTrue(testGame.board.chessBoard[2][2].checkMove(testGame.board, 4, 4) == true);
    	assertTrue(testGame.board.chessBoard[2][2].checkMove(testGame.board, 5, 5) == true);
    	assertTrue(testGame.board.chessBoard[2][2].checkMove(testGame.board, 3, 1) == true);
    	assertTrue(testGame.board.chessBoard[2][2].checkMove(testGame.board, 6, 6) == false);
    	assertTrue(testGame.board.chessBoard[5][5].checkMove(testGame.board, 5, 5) == false);
    	assertTrue(testGame.board.chessBoard[5][5].checkMove(testGame.board, 6, 6) == true);
    	assertTrue(testGame.board.chessBoard[5][5].checkMove(testGame.board, 7, 7) == false);
    	assertTrue(testGame.board.chessBoard[5][5].checkMove(testGame.board, 1, 1) == false);
    	assertTrue(testGame.board.chessBoard[5][5].checkMove(testGame.board, 2, 2) == true);
    	assertTrue(testGame.board.chessBoard[5][5].checkMove(testGame.board, 7, 3) == true);
    	assertTrue(testGame.board.chessBoard[5][5].checkMove(testGame.board, 8, 2) == false);
    }
	
}
