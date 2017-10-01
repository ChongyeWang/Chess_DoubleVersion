/**
 * This class tests the chess board.
 */
package Tests;
import chessBuild.Board;
import chessBuild.Piece;
import chessBuild.Game;
import chessBuild.Player;
import org.junit.Test;
import static org.junit.Assert.*;
public class testBoard {
	@Test
	public void testBoard() throws Exception{
		Board board = new Board(8, 8);
		assertTrue(board.getRow() == 8);
		assertTrue(board.getColumn() == 8);
	}
}
