/**
 * This class tests the new version of 
 * chess game, which replaces the knight 
 * pieces with kin and elephant
 */
package Tests;
import chessBuild.Piece;
import chessBuild.Elephant;
import chessBuild.Game;
import chessBuild.Kin;
import chessBuild.Player;
import org.junit.Test;
import static org.junit.Assert.*;

public class testNewVersion {
	@Test
    public void testReplacePiece() throws Exception{
    	Game testGame = new Game();
    	testGame.changeVersion();
    	assertTrue(testGame.getWhiteTurn());
    	assertTrue(testGame.board.chessBoard[0][1] instanceof Kin == true);
    	assertTrue(testGame.board.chessBoard[0][6] instanceof Elephant == true);
    	assertTrue(testGame.board.chessBoard[0][1].getColor().equals("black"));
    	
    	assertTrue(testGame.board.chessBoard[7][1] instanceof Kin == true);
    	assertTrue(testGame.board.chessBoard[7][6] instanceof Elephant == true);
    	assertTrue(testGame.board.chessBoard[7][6].getColor().equals("white"));
    	
    	assertTrue(testGame.getBlackPlayer().getTrackKnight().get(1).getX() == -1);
    	assertTrue(testGame.getWhitePlayer().getTrackKnight().get(0).getY() == -1);
    	assertTrue(testGame.board.chessBoard[7][6].checkMove(testGame.board, 4, 5));
    	assertTrue(!testGame.board.chessBoard[7][6].checkMove(testGame.board, 4, 4));
    	assertTrue(!testGame.board.chessBoard[7][6].checkMove(testGame.board, -1, -1));
    }
}
