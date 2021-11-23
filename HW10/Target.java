
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
	 * 
	 * 
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
	public void getShot (int row, int column) {
		
	}
	
	public boolean isDestroyed() {
		
		
	}
	
	public boolean isHitAt(int row, int column) {
		
		
	}
	
	public String toString() {
		
		
	}
	
	
	
	
	
	
}
