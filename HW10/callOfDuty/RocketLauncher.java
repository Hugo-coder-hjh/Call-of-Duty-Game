package callOfDuty;
/**
 * represents the weapon: rocket launcher
 * rocket launcher can hit 1*1
 * @author Jiahao He
 *
 */
public class RocketLauncher extends Weapon {
	// static variables
	
	/**
	 * the initial shots number for RoketLanucher
	 */
	private static int INITIALSHOTS = 20;
	
	/**
	 * type of this weapon
	 */
	private static String NAME = "rocketLauncher";
	
	// constructor
	/**
	 * call the constructor by the static variable
	 */
	public RocketLauncher() {
		// call the constructor from the superclass
		super(RocketLauncher.INITIALSHOTS);
	}
	
	/**
	 * get the type of the weapon
	 */
	@Override
	public String getWeaponType() {
		// get the type of the weapon
		return RocketLauncher.NAME;
	}

	@Override
	public void shootAt(int row, int column, Base base) {
	// in case of the illegal situation
	if (row >= 10 || row < 0 || column >= 10 || column < 0) {
		System.out.println("Your shoot is out of bound");
	}
		
	// count the increment shots
	// if > 0 means we could shoot
	if (this.getShotLeft() > 0) {
		// increases the shotsFired
		base.getBase().incrementShotsFired();
		// updates the base after getting shot
		base.getBase().shootAt(row, column);		
	}

	
}
	
	// decrements the available missile shots
	this.decrementShotLeft();
}	
	
