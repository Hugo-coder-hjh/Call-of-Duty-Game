package callOfDuty;
/**
 * represents the target: ground
 * @author Xinyang Shen
 *
 */
public class Ground extends Target {
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
	private static final String NAME = "No Target";
	
	// constructor
	/**
	 * sets the constructor by given length, width and base
	 * @param base
	 */
	public Ground(Base base) {
	   // call the constructor from the superclass
		super(Ground.LENGTH, Ground.WIDTH, base);
	}

	@Override
	void explode() {
		// TODO Auto-generated method stub

	}
	
	
    /**
     * Returns name of the target, in this case, there's no target
     */
	@Override
	public String getTargetName() {
		// Returns name of the target, which is "no target here"
		return Ground.NAME;
	}

}