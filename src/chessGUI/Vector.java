/**
 * This class serves as the container of the 
 * control JPanel and Menu JPanel
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

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import chessBuild.Game;
import chessBuild.Piece;
import chessBuild.Rook;
import chessBuild.Knight;
import chessBuild.Bishop;
import chessBuild.Pawn;
import chessBuild.Queen;
import chessBuild.King;
import chessBuild.Board;
import chessBuild.Player;

public class Vector extends JPanel{
	private Control control;
	private Menu menu;
	public Vector(){
		this.setBounds(0, 0, 1000, 800);
		this.setLayout(null);
		control = new Control();
		menu = new Menu();
		this.add(control);//Add control panel
		this.add(menu);//Add menu panel
	}
}
