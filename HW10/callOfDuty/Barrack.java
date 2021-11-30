package callOfDuty;
/**
 * Represents the target: barrack
 * @author Xinyang Shen
 *
 */
public class Barrack extends Target {
	// static variables
	/**
	 * length of the target
	 */
	private static final int LENGTH = 3;
	
	/**
	 * width of the target
	 */
	private static final int WIDTH = 1;
	
	/**
	 * name of the target
	 */
	private static final String NAME = "Barrack";
	
	// constructor
	
	/**
	 * set the constructor by given length, with and base
	 * @param base
	 */
	public Barrack(Base base) {
		// call the constructor from the superclass
		super(Barrack.LENGTH, Barrack.WIDTH, base);
	}
	

	@Override
	public void explode() {

	}

	/**
	 * Returns the name of the target: "Barrack"
	 */
	@Override
	public String getTargetName() {
		// Returns the name of the target
		return Barrack.NAME;
	}

}