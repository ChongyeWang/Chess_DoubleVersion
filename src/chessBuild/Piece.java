/**
 * This will be the abstract class 
 * of the chess pieces.
 */
package chessBuild;
public abstract class Piece {
    private String color;
    private int x;
    private int y;
    private boolean isAlive;
    
    /**
     * Default constructor for piece
     */
    public Piece(){
    	
    }
    
    /**
     *Constructor for piece
     *@param color 
     */
    public Piece(String color){
    	this.color = color;
    	this.x = -1;
    	this.y = -1;
    	this.isAlive = false;
    }
    
    /**
     * Copy constructor
     * @param other
     */
    public Piece(Piece other){
    	this.color = other.color;
    	this.x = other.x;
    	this.y = other.y;
    	this.isAlive = other.isAlive;
    }
    
    /**
     * Constructor for piece
     * @param x
     * @param y
     * @param color
     * @param isAlive
     */
    public Piece(int x, int y, String color, boolean isAlive){
    	this.x = x;
    	this.y = y;
    	this.color = color;
    	this.isAlive = isAlive;
    }
    
    /**
     * Set x coordinate of piece
     * @param x
     */
    public void setX(int x){
    	this.x = x;
    }
    
    /**
     * Set y coordinate of piece
     * @param y
     */
    public void setY(int y){
    	this.y = y;
    }
    
    /**
     * Set color of piece
     * @param color
     */
    public void setColor(String color){
    	this.color = color;
    }
    
    /**
     * Set isAlive of piece
     * @param isAlive
     */
    public void setIsAlive(boolean isAlive){
    	this.isAlive = isAlive;
    }
    
    /**
     * get x of piece
     * @return 
     */
    public int getX(){
    	return this.x;
    }
    
    /**
     * get y of piece
     * @return
     */
    public int getY(){
    	return this.y;
    }
    
    /**
     * get color of piece
     * @return 
     */
    public String getColor(){
    	return this.color;
    }
    
    /**
     * get isAlive of piece
     * @return 
     */
    public boolean getIsAlive(){
    	return this.isAlive;
    }
    
    /**
     * checkMove method for piece
     * check whether the piece is out of boundary
     * @param board
     * @param targetX
     * @param targetY
     * @return
     */
    public boolean checkMove(Board board, int targetX, int targetY){
    	if(targetX >= board.getColumn() || targetY >= board.getRow() || targetX < 0 || targetY < 0){
    		return false;
    	}
    	return true;
    }
}
