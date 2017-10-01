/**
 * This class implements the user interface of the chess.
 */
package chessGUI;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Stack;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import chessBuild.Game;
import chessBuild.Kin;
import chessBuild.Piece;
import chessBuild.Rook;
import chessBuild.Knight;
import chessBuild.Bishop;
import chessBuild.Pawn;
import chessBuild.Queen;
import chessBuild.King;
import chessBuild.Board;
import chessBuild.Elephant;
import chessBuild.Player;

public class Control extends JPanel implements MouseListener, ActionListener{
	private static int mouseX = 0;
	private static int mouseY = 0;
	private static int newMouseX = 0;
	private static int newMouseY = 0;
	
	private ImageIcon blackRook = new ImageIcon("res/blackRook.png");
	private ImageIcon blackKnight = new ImageIcon("res/blackKnight.png");
	private ImageIcon blackBishop = new ImageIcon("res/blackBishop.png");
	private ImageIcon blackPawn = new ImageIcon("res/blackPawn.png");
	private ImageIcon blackQueen = new ImageIcon("res/blackQueen.png");
	private ImageIcon blackKing = new ImageIcon("res/blackKing.png");
	
	private ImageIcon whiteRook = new ImageIcon("res/whiteRook.png");
	private ImageIcon whiteKnight = new ImageIcon("res/whiteKnight.png");
	private ImageIcon whiteBishop = new ImageIcon("res/whiteBishop.png");
	private ImageIcon whitePawn = new ImageIcon("res/whitePawn.png");
	private ImageIcon whiteQueen = new ImageIcon("res/whiteQueen.png");
	private ImageIcon whiteKing = new ImageIcon("res/whiteKing.png");
	
	/////////////New Version Piece////////////
	private ImageIcon blackKin = new ImageIcon("res/blackKin.png");
	private ImageIcon blackElephant = new ImageIcon("res/blackElephant.png");
	
	private ImageIcon whiteKin = new ImageIcon("res/whiteKin.png");
	private ImageIcon whiteElephant = new ImageIcon("res/whiteElephant.png");
	
	private Timer timer = new Timer(100, this);

	private String originalTurn = "white";
	
	public static boolean startGame = false;
	public static Game game = new Game();

	public static Stack<Game> lastMove = new Stack<Game>();
	
	/**
	 * Control constructor
	 */
	public Control(){
		this.setLayout(null);
		this.setBounds(0, 0, 800, 800);
		addMouseListener(this);
		timer.start();
	}

    public void paint(Graphics g){
    	
    	//Set the background of the board
    	setBackground(Color.GRAY);
		for(int i = 0; i <= 600; i+=200){
			for(int j = 0; j <= 600; j+=200){
				g.clearRect(i, j, 100, 100);
			}
		}
		for(int i = 100; i <= 700; i+=200){
			for(int j = 100; j <= 700; j+=200){
				g.clearRect(i, j, 100, 100);
			}
		}
		
		//Draw the imageicon on the baord
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(game.board.chessBoard[i][j] != null){
					int tempX = game.board.chessBoard[i][j].getX();
					int tempY = game.board.chessBoard[i][j].getY();
					if(game.board.chessBoard[i][j].getColor().equals("black")){
						if(game.board.chessBoard[i][j] instanceof Rook){
							blackRook.paintIcon(this, g, tempX*100, tempY*100);
						}
						else if(game.board.chessBoard[i][j] instanceof Knight){
							blackKnight.paintIcon(this, g, tempX*100, tempY*100);
						}
						else if(game.board.chessBoard[i][j] instanceof Bishop){
							blackBishop.paintIcon(this, g, tempX*100, tempY*100);
						}
						else if(game.board.chessBoard[i][j] instanceof Pawn){
							blackPawn.paintIcon(this, g, tempX*100, tempY*100);
						}
						else if(game.board.chessBoard[i][j] instanceof Queen){
							blackQueen.paintIcon(this, g, tempX*100, tempY*100);
						}
						else if(game.board.chessBoard[i][j] instanceof King){
							blackKing.paintIcon(this, g, tempX*100, tempY*100);
						}
						///New Piece//
						else if(game.board.chessBoard[i][j] instanceof Kin){
							blackKin.paintIcon(this, g, tempX*100, tempY*100);
						}
						else if(game.board.chessBoard[i][j] instanceof Elephant){
							blackElephant.paintIcon(this, g, tempX*100, tempY*100);
						}
						
					}
					else if(game.board.chessBoard[i][j].getColor().equals("white")){
                    	if(game.board.chessBoard[i][j] instanceof Rook){
							whiteRook.paintIcon(this, g, tempX*100, tempY*100);
						}
                    	else if(game.board.chessBoard[i][j] instanceof Knight){
							whiteKnight.paintIcon(this, g, tempX*100, tempY*100);
						}
						else if(game.board.chessBoard[i][j] instanceof Bishop){
							whiteBishop.paintIcon(this, g, tempX*100, tempY*100);
						}
						else if(game.board.chessBoard[i][j] instanceof Pawn){
							whitePawn.paintIcon(this, g, tempX*100, tempY*100);
						}
						else if(game.board.chessBoard[i][j] instanceof Queen){
							whiteQueen.paintIcon(this, g, tempX*100, tempY*100);
						}
						else if(game.board.chessBoard[i][j] instanceof King){
							whiteKing.paintIcon(this, g, tempX*100, tempY*100);
						}
                    	//New Piece
						else if(game.board.chessBoard[i][j] instanceof Kin){
							whiteKin.paintIcon(this, g, tempX*100, tempY*100);
						}
						else if(game.board.chessBoard[i][j] instanceof Elephant){
							whiteElephant.paintIcon(this, g, tempX*100, tempY*100);
						}
					}
				}
			}//end of second for loop
		}//end of first for loop
		
		if(game.getGameEnd() == true){
			g.setColor(Color.BLUE);
			g.setFont(new Font("arial", Font.BOLD, 40));
			g.drawString("Winner:" + game.getWinner(), 270, 320);
		}
		
	}// end of paint method
    
    
    @Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(game.getGameEnd() == false && startGame == true){
			//Get the initial position of the mouse
			mouseX = e.getX();
	    	mouseY = e.getY();	
	    	//Push the game status to the stack
	    	Game top = new Game(game);
	    	lastMove.push(top);
	    	if(game.getWhiteTurn() == true){
	    		originalTurn = "white";
	    	}
	    	else{
	    		originalTurn = "black";
	    	}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(game.getGameEnd() == false && startGame == true){
			//Get the target position of the mouse
			newMouseX = e.getX();
			newMouseY = e.getY();
			int currX = mouseX / 100;
			int currY = mouseY / 100;
			int targetX = newMouseX / 100;
			int targetY = newMouseY / 100;
			game.movePiece(currX, currY, targetX, targetY);
			//if there is an invalid move, then pop the state from the stack
			if(originalTurn.equals("white") && game.getWhiteTurn() == true){
				lastMove.pop();
			}
			if(originalTurn.equals("black") && game.getWhiteTurn() == false){
				lastMove.pop();
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
}
