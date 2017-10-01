/**
 * This class tests the piece kin.
 */
package Tests;
import chessBuild.Piece;
import chessBuild.Elephant;
import chessBuild.Game;
import chessBuild.Kin;
import chessBuild.Player;
import org.junit.Test;
import static org.junit.Assert.*;
public class testKin {
	@Test
	public void testKinMove() throws Exception{
        Game testGame = new Game();
        testGame.board.chessBoard[3][3] = new Kin(3, 3, "black", true);
        testGame.board.chessBoard[4][4] = new Kin(4, 4, "white", true);
        assertTrue(testGame.board.chessBoard[3][3].checkMove(testGame.board, 2, 2) == true);
        assertTrue(testGame.board.chessBoard[3][3].checkMove(testGame.board, 2, 3) == true);
        assertTrue(testGame.board.chessBoard[3][3].checkMove(testGame.board, 3, 4) == false);
        assertTrue(testGame.board.chessBoard[3][3].checkMove(testGame.board, 4, 4) == false);
        assertTrue(testGame.board.chessBoard[4][4].checkMove(testGame.board, 3, 3) == false);
        assertTrue(testGame.board.chessBoard[4][4].checkMove(testGame.board, 4, 3) == false);
        assertTrue(testGame.board.chessBoard[4][4].checkMove(testGame.board, 5, 4) == true);
        assertTrue(testGame.board.chessBoard[4][4].checkMove(testGame.board, 5, 5) == true);
    }
}
