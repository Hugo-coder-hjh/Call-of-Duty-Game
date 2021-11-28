package callOfDuty;
public class Base {
   // instance variables
	/**
	 * Every location in this array points to a Target
	 */
	private Target[][] targets;
	
	/**
	 * The total number of shots fired by the user.
	 */
	private int shotsCount;
	
	/**
	 * The number of targets destroyed.
	 */
	private int destroyedTargetCount;
	
	// constructor
	/**
	 * Creates an 10x10 empty Base
	 * initializes any game variables
	 */
	public Base() {
		// create an 10x10 empty base
		
		// initialize the variables
		this.shotsCount = 0;
		this.destroyedTargetCount = 0;
		
	}

	// methods
	/**
	 * Creates and place all targets randomly on the base
	 * larger before small
	 * buildings before tanks and oil drums
	 */
	public void placeAllTargetRandomly() {
		
	}
	
	/**
	 * returns true if it is OK to put the target with its head at this location, false otherwise
	 * @param given target
	 * @param given row
	 * @param given column
	 * @param given orientation, whether it is horizontal or not
	 * @return
	 */
	public boolean okToPlaceTargetAt(Target target, int row, int column, boolean horizontal):{
		
	}
	
	/**
	 * sets the value of the "hit" array, "coordinate" array and "horizontal" boolean value of the target
	 * @param given target
	 * @param given row
	 * @param given column
	 * @param given orientation, whether it is horizontal
	 */
	public void placeTargetAt(Target target, int row, int column, boolean horizontal) {
		
	}
	
	/**
	 * Returns true if the given location contains a Target;
	 * Returns false if it does not.
	 * @param row
	 * @param column
	 * @return true or false
	 */
	public boolean isOccupied(int row, int column) {
		
	}
	
	/**
	 * Attack the position specified by the row and the column.
	 * @param row
	 * @param column
	 */
	public void shootAt(int row, int column) {
	// in case of the illegal situation
	if (row >= 10 || row < 0 || column >= 10 || column < 0) {
		System.out.println("Your shoot is out of bound");
	}
	
	// update the base after getting shot
	this.getTargetsArray()[row][column].getShot(row, column)
	
	}
	
	/**
	 * Returns true if run out of ammunition 
	 * or Returns true if all targets have been;
	 * otherwise, return false.
	 * @param weapon1
	 * @param weapon2
	 * @return true or false
	 */
	public boolean isGameOver(Weapon weapon1, Weapon weapon2) {
		
	}
	
	/**
	 * Returns true if all targets have been destroyed.
	 * @return true or false
	 */
	public boolean win() {
		
	}
	
	/**
	 * Prints the Base.
	 * row/column numbers should be displayed too
	 * ¡°O¡±: Used to indicate a location that you have fired upon and hit a target
	 * ¡°-¡±: Used to indicate a location that you have fired upon and found nothing there
	 * ¡°X¡±: Used to indicate a location containing a destroyed Target
	 * ¡®.¡¯: Used to indicate a location that you have never fired upon
	 * ¡°T¡±: Used to indicate an undestroyed but hit Tank
	 */
	public void print() {
		
	}
	
	public void incrementShotsCount() {
		this.shotsFired++;
	}
	
	
	
	
	
	
	// getter methods
	
	/**
	 * @return The total number of shots fired by the user.
	 */
	public int getShotsCount() {
		return this.shotsCount;
	}
	
	/**
	 * @return Returns the targets array
	 */
	public Target[][] getTargetsArray(){
		return this.targets;
	}
	
	/**
	 * @return Returns the count of destroyed targets
	 */
	public int getDestroyedTargetCount() {
		return this.destroyedTargetCount;
	}
	
    // setter methods
	/**
	 * set the number of destroyedTarget
	 * @param i the count number
	 */
	public void setDestroyedTargetCount(int i) {
		this.destroyedTargetCount= i;
	}
	
	
	
	
	
}
