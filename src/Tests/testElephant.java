/**
 * This class tests the piece elephant.
 */
package Tests;
import chessBuild.Elephant;
import chessBuild.Piece;
import chessBuild.Game;
import chessBuild.Player;
import org.junit.Test;
import static org.junit.Assert.*;

public class testElephant {
	@Test
	public void testElephantMove() throws Exception{
        Game testGame = new Game();
        testGame.board.chessBoard[5][0] = new Elephant(0, 5, "white", true);
        assertTrue(testGame.board.chessBoard[5][0] instanceof Elephant);
        assertTrue(testGame.board.chessBoard[5][0].checkMove(testGame.board, 2, 3) == true);
        assertTrue(testGame.board.chessBoard[5][0].checkMove(testGame.board, 2, 7) == false);
        assertTrue(testGame.board.chessBoard[5][0].checkMove(testGame.board, 1, 6) == false);
    }
	
	@Test
	public void testElephantEatPiece() throws Exception{
		 Game testGame = new Game();
	     testGame.board.chessBoard[5][0] = new Elephant(0, 5, "white", true);
	     testGame.board.chessBoard[3][2] = new Elephant(2, 3, "black", true);
	     assertTrue(testGame.board.chessBoard[5][0].checkMove(testGame.board, 2, 3) == true);
    }
}
