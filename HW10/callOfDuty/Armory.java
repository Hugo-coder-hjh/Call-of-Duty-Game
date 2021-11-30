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

	@Override
	public void explode() {
		for(int i = -2; i < this.getHit().length + 2; i++) {
			for(int j = -2; j < this.getHit()[0].length + 2; j++) {
				this.getBase().shootAt(i + this.getCoordinate()[0], j + this.getCoordinate()[1]);
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
