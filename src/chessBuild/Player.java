/**
 * This class implements the players.
 */
package chessBuild;
import java.util.ArrayList;
public class Player {
    private String color;
    private ArrayList<Pawn> trackPawn;
    private ArrayList<Knight> trackKnight;
    private ArrayList<Bishop> trackBishop;
    private ArrayList<Rook> trackRook;
    private ArrayList<Queen> trackQueen;
    private ArrayList<King> trackKing;
    
    private ArrayList<Kin> trackKin;
    private ArrayList<Elephant> trackElephant;
    
    /**
     * Constructor for player
     * @param color
     */
    public Player(String color){
    	this.color = color;
    	trackPawn = new ArrayList<Pawn>(8);
    	for(int i = 0; i < 8; i++){
    		trackPawn.add(new Pawn(color));
    	}
    	trackKnight = new ArrayList<Knight>(2);
    	for(int i = 0; i < 2; i++){
    		trackKnight.add(new Knight(color));
    	}
    	trackBishop = new ArrayList<Bishop>(2);
    	for(int i = 0; i < 2; i++){
    		trackBishop.add(new Bishop(color));
    	}
    	trackRook = new ArrayList<Rook>(2);
    	for(int i = 0; i < 2; i++){
    		trackRook.add(new Rook(color));
    	}
    	trackQueen = new ArrayList<Queen>(1);
    	trackQueen.add(new Queen(color));
    	trackKing = new ArrayList<King>(1);
    	trackKing.add(new King(color));	
    	
    	//////////New Version Piece/////////
    	trackKin = new ArrayList<Kin>(1);
    	trackKin.add(new Kin(color));	
    	
    	trackElephant = new ArrayList<Elephant>(1);
    	trackElephant.add(new Elephant(color));	
    }
    
    
    /**
     * Copy constructor
     * @param other
     */
    public Player(Player other){
    	this.color = other.color;
    	trackPawn = new ArrayList<Pawn>(8);
    	for(int i = 0; i < 8; i++){
    		trackPawn.add(new Pawn(other.getTrackPawn().get(i)));
    	}
    	trackKnight = new ArrayList<Knight>(2);
    	for(int i = 0; i < 2; i++){
    		trackKnight.add(new Knight(other.getTrackKnight().get(i)));
    	}
    	trackBishop = new ArrayList<Bishop>(2);
    	for(int i = 0; i < 2; i++){
    		trackBishop.add(new Bishop(other.getTrackBishop().get(i)));
    	}
    	trackRook = new ArrayList<Rook>(2);
    	for(int i = 0; i < 2; i++){
    		trackRook.add(new Rook(other.getTrackRook().get(i)));
    	}
    	trackQueen = new ArrayList<Queen>(1);
    	trackQueen.add(new Queen(other.getTrackQueen().get(0)));
    	trackKing = new ArrayList<King>(1);
    	trackKing.add(new King(other.getTrackKing().get(0)));	
    	
    	//////////New Version Piece/////////
    	trackKin = new ArrayList<Kin>(1);
    	trackKin.add(new Kin(other.getTrackKin().get(0)));	
    	
    	trackElephant = new ArrayList<Elephant>(1);
    	trackElephant.add(new Elephant(other.getTrackElephant().get(0)));	
    }
  
    
    /**
     * Set color methods for player
     * @param color
     */
    public void setColor(String color){
    	this.color = color;
    }
    
    /**
     * Get color method for player
     * @return
     */
    public String getColor(){
    	return this.color;
    }
    
    /**
     * GetTrackPawn method for player
     * @return
     */
    public ArrayList<Pawn> getTrackPawn(){
    	return this.trackPawn;
    }
    
    /**
     * GetTrackKnight method for player
     * @return
     */
    public ArrayList<Knight> getTrackKnight(){
    	return this.trackKnight;
    }
    
    /**
     * GetTrackBishop method for player
     * @return
     */
    public ArrayList<Bishop> getTrackBishop(){
    	return this.trackBishop;
    }
    
    /**
     * GetTrackRook method for player
     * @return
     */
    public ArrayList<Rook> getTrackRook(){
    	return this.trackRook;
    }
    
    /**
     * GetTrackQueen method for player
     * @return
     */
    public ArrayList<Queen> getTrackQueen(){
    	return this.trackQueen;
    }
    
    /**
     * GetTrackKing method for player
     * @return
     */
    public ArrayList<King> getTrackKing(){
    	return this.trackKing;
    }
    
    //////New Version Piece///////
    /**
     * GetTrackKin for player
     * @return
     */
    public ArrayList<Kin> getTrackKin(){
    	return this.trackKin;
    }
    
    /**
     * GetTrackElephant for player
     * @return
     */
    public ArrayList<Elephant> getTrackElephant(){
    	return this.trackElephant;
    }
}
