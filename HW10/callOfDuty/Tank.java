package callOfDuty;
/**
 * represents the target: tank
 * @author Xinyang Shen
 *
 */
public class Tank extends Target {
	// static variables
	/**
	 * length of the target
	 */
	private static final int LENGTH = 1;
	
	/**
	 * width of the target
	 */
	private static final int WIDTH = 1;
	
	/**
	 * name of the target
	 */
	private static final String NAME = "Tank";
	
	
	// constructor
	/**
	 * set the constructor by given length, width and base
	 * @param base
	 */
	public Tank(Base base) {
		// call the constructor from the superclass
		super(Tank.LENGTH, Tank.WIDTH, base);
	}


	@Override
	public void explode() {
		// iterate from the start of the explosion(5*5) to the end of the explosion, getshot at each of the coordinate
		for (int i = this.getCoordinate()[0] - 2; i < this.getCoordinate()[0] + 3; i++) {
			for (int j = this.getCoordinate()[1] - 2; j < this.getCoordinate()[1] + 3; j++) {
				if(this.getBase().okToShootAt(i, j)) {
					// get the target in the explosion range
					Target[][] expTar = getBase().getTargetsArray();
					Target target = expTar[i][j];
					//shot the target
					target.getShot(i, j);
					}
				}
			}
		}
	

	/**
	 * Returns name of the target, "Tank"
	 */
	@Override
	public String getTargetName() {
		// Returns name of the target
		return Tank.NAME;
	}
	
	
	/**
	 * returns true if every part of the target has been hit. false otherwise.
	 * if it's tank it should shoot twice. (override method from the target class)
	 * @return true if the tank is destroyed
	 */
	@Override
	public boolean isDestroyed() {
		//iterate over the hit array
		for (int i =0; i < this.getHit().length; i ++) {
			for(int j = 0; j < this.getHit()[0].length; j ++) {
				//if the [i][j] part of the hit array has been hit, increment the hitNum
				if (this.getHit()[i][j] == 2) {
					return true;
				}else {
					continue;
					}
				}	
			}
		return false;
	}
			
		
	
	
	@Override
	public String toString() {
		if (this.isDestroyed()) {
			return "X";
		}else {
			return "T";
		}
	}
	
}