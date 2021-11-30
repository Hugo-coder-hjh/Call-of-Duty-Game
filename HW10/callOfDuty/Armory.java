package callOfDuty;
/**
 * Represent the target: armory
 * @author Xinyang Shen
 *
 */
public class Armory extends Target {
	
	// static variables
	
	/**
	 * width of this target
	 */
	private static final int WIDTH = 2;
	
	/**
	 * length of this target
	 */
	private static final int LENGTH = 3;
	
	/**
	 * name of this target
	 */
	private static final String NAME = "Armory";
	
	// constructor
	
	/**
	 * set the constructor by given length, width and base
	 * @param base
	 */
	public Armory(Base base) {
		// call the constructor from the superclass
		super(Armory.LENGTH, Armory.WIDTH, base);
	}
	
	
	/**
	 * when armory is destroyed, it will explode
	 * the explosion range is 6 * 7 (horizontal = true) or 7 * 6 (horizontal = false)
	 * explosion could trigger explosion
	 */
	@Override
	public void explode() {
		// if the armory is vertically oriented, which has a hit-array of [3][2]
		if(this.getHorizontal() == false) {
			// iterate from the start of the explosion to the end of the explosion, getshot at each of the coordinate
			for (int i = this.getCoordinate()[0] - 2; i < this.getCoordinate()[0] + 5; i++) {
				for (int j = this.getCoordinate()[1] - 2; j < this.getCoordinate()[1] + 4; j++) {
					if(this.getBase().okToShootAt(i, j)) {
						// get the target in the explosion range
						Target[][] expTar = getBase().getTargetsArray();
						Target target = expTar[i][j];
						//shot the target
						target.getShot(i, j);
						}
					}
				}
			}else {
				// else if the armory is horizontally oriented
				// iterate from the start of the explosion to the end of the explosion, getshot at each of the coordinate
				for (int i = this.getCoordinate()[0] - 2; i < this.getCoordinate()[0] + 4; i++) {
					for (int j = this.getCoordinate()[1] - 2; j < this.getCoordinate()[1] + 5; j++) {
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
		}



		
		
	


	/**
	 * Returns the name of the target: "Armory"
	 */
	@Override
	public String getTargetName() {
		// Returns the name of the target
		return Armory.NAME;
	}

}