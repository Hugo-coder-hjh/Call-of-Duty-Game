package callOfDuty;
/**
 * represents the target: sentry tower
 * @author Xinyang Shen
 *
 */
public class SentryTower extends Target {
	
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
	private static final String NAME = "SentryTower";
	
	// constructor
	/**
	 * set the constructor by given length, width and base
	 * @param base
	 */
	public SentryTower(Base base) {
		// call the constructor from the superclass
		super(SentryTower.LENGTH, SentryTower.WIDTH, base);
	}

	@Override
	public void explode() {

	}

	/**
	 * Returns the name of the target, "Sentry Tower"
	 */
	@Override
	public String getTargetName() {
		// Returns the name of the target
		return SentryTower.NAME;
	}

}