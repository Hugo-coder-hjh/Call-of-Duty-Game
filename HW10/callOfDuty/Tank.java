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
	void explode() {
		// TODO Auto-generated method stub

	}

	/**
	 * Returns name of the target, "Tank"
	 */
	@Override
	public String getTargetName() {
		// Returns name of the target
		return Tank.NAME;
	}

}
