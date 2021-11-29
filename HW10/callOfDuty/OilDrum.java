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
	private static final String NAME = "Oil Drum";
		
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
	void explode() {
		// TODO Auto-generated method stub

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
