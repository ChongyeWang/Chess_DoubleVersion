/**
 * Main class of the game.
 */
package chessGUI;

import java.awt.BorderLayout;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import chessBuild.Game;

public class Main {
	public static void main(String[] args){
    	JFrame frame = new JFrame();
    	frame.setResizable(false);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0, 0, 1000, 820);
        frame.setLayout(null);
        frame.add(new Vector());
        frame.setVisible(true);  
    }
}
