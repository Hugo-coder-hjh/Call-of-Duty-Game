package callOfDuty;
/**
 * Represents the target: oil drum
 * @author Xinyang Shen
 *
 */
public class OilDrum extends Target {
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
	private static final String NAME = "OilDrum";
		
	// constructor
	/**
	 * set the constructor by given length, width and base
	 * @param base
	 */
	public OilDrum(Base base) {
	// call the constructor from the superclass
	super(OilDrum.LENGTH, OilDrum.WIDTH, base);
	}

	@Override
	public void explode() {
		// // iterate from the start of the explosion(5*5) to the end of the explosion, getshot at each of the coordinate
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
     * Returns the name of the target, "oil drum"
     */
	@Override
	public String getTargetName() {
		// Returns name of the target
		return OilDrum.NAME;
	}

}