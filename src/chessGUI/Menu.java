/**
 * This class implements the menu of the game.
 */
package chessGUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import chessBuild.Game;

public class Menu extends JPanel implements ActionListener{
	private JLabel date;
	private JButton start;
	private JButton quit;
	private JButton restart;
	private JButton undo;
	private JButton changeVersion;
		
	public Menu(){;
		this.setBackground(Color.lightGray);
		this.setBounds(800, 0, 200, 800);
		this.setLayout(null);
		
		//Print date 
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        date = new JLabel(dtf.format(now));
        date.setFont(new Font("arial", Font.BOLD, 30));
	    date.setBounds(20, 0, 200, 90);
        add(date);
        
        //Set up start button
        start = new JButton("Start");
		start.setFont(new Font("arial", Font.BOLD, 30));
	    start.setBounds(0, 100, 200, 100);
	    start.addActionListener(this);
	    add(start);
        
		//Set up quit button
		quit = new JButton("Quit");
		quit.setFont(new Font("arial", Font.BOLD, 30));
	    quit.setBounds(0, 700, 200, 100);
	    quit.addActionListener(this);
	    add(quit);
	    
	    //Set up restart button
	    restart = new JButton("Restart");
		restart.setFont(new Font("arial", Font.BOLD, 30));
	    restart.setBounds(0, 600, 200, 100);
	    restart.addActionListener(this);
	    add(restart);
	    
	    //Set up undo button
	    undo = new JButton("Undo");
		undo.setFont(new Font("arial", Font.BOLD, 30));
	    undo.setBounds(0, 500, 200, 100);
	    undo.addActionListener(this);
	    add(undo);
	    
	    //Set up changeVersion Button
	    changeVersion = new JButton("Version2");
	    changeVersion.setFont(new Font("arial", Font.BOLD, 30));
	    changeVersion.setBounds(0, 200, 200, 100);
	    changeVersion.addActionListener(this);
	    add(changeVersion);
	    
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == start){
			Control.startGame = true;
		}//Button start pressed
		else if(e.getSource() == changeVersion){
			//Clear the lastMove stack 
			while(Control.lastMove.isEmpty() == false){
				Control.lastMove.pop();
			}
			Control.game = new Game();
			Control.game.changeVersion();
		}//Button changeVersion pressed
	    else if(e.getSource() == quit){
	    	if(Control.startGame == false){
	    		return;
	    	}
			Control.game.setGameEnd(true);
		    if(Control.game.getWhiteTurn() == true){
		    	Control.game.setWinner("black");
		    }
		    else{
		    	Control.game.setWinner("white");
		    }
		}//Button quit pressed
		else if(e.getSource() == restart){
		    //Clear the lastMove stack 
			while(Control.lastMove.isEmpty() == false){
				Control.lastMove.pop();
			}
			Control.game = new Game();
		}//Button restart pressed
		else if(e.getSource() == undo){
			if(Control.lastMove.isEmpty() == false){
			    Control.game = new Game(Control.lastMove.pop());
			}
		}//Button undo pressed
	}//end of actionPerformed method
	
}//end of class
