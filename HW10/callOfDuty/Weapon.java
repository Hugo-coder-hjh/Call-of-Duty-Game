package callOfDuty;

/**
 * Represents the weapon the user choose
 * @author Xinyang Shen
 *
 */
public abstract class Weapon {
	
	// instance variables
	/**
	 * The number of shots left
	 * 20 for RocketLauncher and 3 for Missile
	 */
	private int shotLeft;
	
	// constructor
	/**
	 * set the constructor by given shot count 
	 * @param shotCount 
	 */
	public Weapon(int shotCount) {
		this.shotLeft = shotCount;
	}
	
	
	
    // getters method
	
	/**
	 * @return the number of shots left
	 */
	public int getShotLeft() {
		return this.shotLeft;
	}
	
	
	// Abstract methods
	
	/**
	 * @return the type of the weapon
	 */
	 public abstract String getWeaponType();
	 
	 /**
	  * gets the shoot area for each weapon
	  * @param given row
	  * @param given column
	  * @param base
	  */
	 public abstract void shootAt(int row, int column, Base base);
	 
	 
	 
	 // other methods
	 /**
	  * decrements the count of left shots
	  */
	 public void decrementShotLeft() {
		if (this.getShotLeft() > 0) {
			this.shotLeft--;
		}else {
			System.out.println("No ammunition");
		}
	 }
	 
	 /**
		 * helper function to decide whether is OK to shoot at
		 * @param row
		 * @param column
		 * @return
		 */
		public boolean okToShootAt(int row, int column) {
			if (row >= 10 || row < 0 || column >= 10 || column < 0) {
				return false;
			} return true;
		}
	
	

}
