/**
 * This class visualizes the game using char to represent each piece
 */
package chessGUI;

import java.util.Scanner;
import chessBuild.Bishop;
import chessBuild.Elephant;
import chessBuild.Game;
import chessBuild.Kin;
import chessBuild.Player;
import chessBuild.King;
import chessBuild.Knight;
import chessBuild.Pawn;
import chessBuild.Queen;
import chessBuild.Rook;

public class visualizeGame {
	public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	Game game = new Game();
    	while(game.getGameEnd() == false){
    		for(int i = 0; i < 8; i++){
    			for(int j = 0; j < 8; j++){
    				if(game.board.chessBoard[i][j] == null){
    					System.out.print('-');
    				}
    				else if(game.board.chessBoard[i][j] instanceof Pawn){
    					System.out.print('P');
    				}
    				else if(game.board.chessBoard[i][j] instanceof Rook){
    					System.out.print('R');
    				}
    				else if(game.board.chessBoard[i][j] instanceof Knight){
    					System.out.print('N');
    				}
    				else if(game.board.chessBoard[i][j] instanceof Bishop){
    					System.out.print('B');
    				}
    				else if(game.board.chessBoard[i][j] instanceof Queen){
    					System.out.print('Q');
    				}
    				else if(game.board.chessBoard[i][j] instanceof King){
    					System.out.print('K');
    				}
    				///////New Version Piece////////
    				else if(game.board.chessBoard[i][j] instanceof Kin){
    					System.out.print('I');
    				}
    				else if(game.board.chessBoard[i][j] instanceof Elephant){
    					System.out.print('E');
    				}
    				System.out.print(' ');
    			}
    			System.out.println();
    		}
    		int currX = sc.nextInt();
        	int currY = sc.nextInt();
        	int targetX = sc.nextInt();
        	int targetY = sc.nextInt();
        	game.movePiece(currX, currY, targetX, targetY);
    	}//end while
    	System.out.println("Winner : " + game.getWinner());
    }
}
