package callOfDuty;

/**
 * Represents the target on the map
 * @author Xinyang Shen
 *
 */
public abstract class Target {
	// instance variables
	/**
	 * An array of length 2 that specifies the coordinate of the head of a target.
	 * Head means the upper left part of a Target.
	 */
	private int[] coordinate;
	
	/**
	 * The length of the Target
	 */
	private int length;
	
	/**
	 * The width of the Target
	 * width <= length
	 */
	private int width;
	
	
	/**
	 * Indicates whether the Target is horizontal or not
	 */
	private boolean horizontal;
	
	/**
	 * Array of the same size as the target
	 * Indicating the number of times a part of the target has been hit
	 */
	private int[][] hit;
	
	
	/**
	 * An instance of Base that the target is placed in
	 */
	private Base base;
	
	// default Constructor
	/**
	 * This constructor sets the length, the width and the base of the Target.
	 * @param the length of the target 
	 * @param the width of the target
	 * @param the base of the target
	 */
	public Target(int length, int width, Base base) {
		this.length = length;
		this.width = width;
		this.base = base;
	}
	
	// getter method
	/**
	 * @return Returns the coordinate array
	 */
	public int[] getCoordinate() {
		return this.coordinate;
	}
	
	/**
	 * @return Returns whether the target is horizontal or not (True or False)
	 */
	
	public boolean getHorizontal() {
		return this.horizontal;
	}
	
	/**
	 * @return Returns the hit array
	 */
	public int[][] getHit(){
		return this.hit;
	}
	
	/**
	 * @return Returns the base
	 */
	public Base getBase() {
		return this.base;
	}
	
	/**
	 * @return Returns the length of this target
	 */
	public int getLength() {
		return this.length;
	}
	
	/**
	 * @return Returns the width of this target
	 */
	public int getWidth () {
		return this.width;
	}
	
	// setter method
	/**
	 * Sets the coordinate array
	 * @param coordinate
	 */
	public void setCoordinate(int[] coordinate) {
		this.coordinate = coordinate;
	}
	
	/**
	 * Sets the value of horizontal
	 * @param horizontal
	 */
	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}
	
	/**
	 * Sets the value of hit array
	 * @param hit
	 */
	public void setHit(int[][] hit) {
		this.hit = hit;
	}
	
	
	// Abstract Methods
	/**
	 * Defines the behavior when a target is destroyed. Some may explode, while some do nothing.
	 */
	abstract void explode();
	
	/**
	 * This method is not case sensitive
	 * @return Returns the type of Target as a String.
	 */
	public abstract String getTargetName();
	
	
	// Other Methods
	/**
	 * If part of the target occupies the given row and column and it is not destroyed, mark the part as "hit"
	 * index (0,0) indicated the head
	 * @param given row
	 * @param given column
	 */
	public void getShot (int row, int column) {
		
	}
	
	/**
	 * returns the destroy status of the target
	 * for tank, every part should be hit twice
	 * @return true if every part of the target has been hit, false otherwise
	 */
	public boolean isDestroyed() {
		
		
	}
	
	/**
	 * returns the hit status of the target. This method is used to print the base.
	 * @param given row
	 * @param given column
	 * @return true if the target has been hit at the given coordinate
	 */
	public boolean isHitAt(int row, int column) {
		int[] coordinate = this.getCoordinate();
		if(this.hit[row-coordinate[0]][column-coordinate[1]] >=1)
		{	return true;
		}else
		{return false;
	}
	}
	
	/**
	 * Returns a single-character String to use in the Base's print method(which has been shot at)
	 * Returns 'X' if the target has been destroyed
	 * Returns 'O' if the target has not been destroyed
	 * Returns 'T' if the tank has not been destroyed
	 * Returns '-' is the target is ground
	 */
	public String toString() {
		
		
	}
	
	
	
	
	
	
}
