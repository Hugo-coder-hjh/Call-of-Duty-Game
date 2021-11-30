package callOfDuty;
/**
 * Represents the weapon: missiles
 * missiles can hit 3*3 area
 * @author Jiahao He
 *
 */
public class Missile extends Weapon {
	// static variables
	
	/**
	 * initial shots of missiles
	 */
	private static final int INITIALSHOTS = 3;
	
	/**
	 * type of this weapon
	 */
	private static final String NAME = "Missile";
	
	// constructor
	/**
	 * call the constructor by the static variables
	 */
	public Missile() {
		super(Missile.INITIALSHOTS);
	}
	
	/**
	 * get the type of this weapon
	 */
	@Override
	public String getWeaponType() {
		// get the type of this weapon
		return Missile.NAME;
	}
  
	
	@Override
	public void shootAt(int row, int column, Base base) {
		// in case of the illegal situation
		if (this.okToShootAt(row, column)) {
		
		// count the increment shots
		// if > 0 means we could shoot
		if (this.getShotLeft() > 0) {
			base.incrementShotsCount();	
			
		// shoot at 3x3 area
		for(int i = -1; i < 2; i++) {
			for(int j = -1; j < 2; j++) {
				base.shootAt(i + row, j + column);
			}
		}	
			
			
		}
	
	// decrements the available missile shots
	this.decrementShotLeft();

}


}
}