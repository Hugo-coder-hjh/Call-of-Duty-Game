package callOfDuty;
/**
 * Represents the target: head quarter
 * @author Xinyang Shen
 *
 */
public class HeadQuarter extends Target {
	
	// static variables
	/**
	 * width of the target
	 */
	private static final int WIDTH = 1;
	
	/**
	 * length of the target
	 */
	private static final int LENGTH = 6;
	
	/**
	 * name of the target
	 */
	private static final String NAME = "Head Quarter";
	
	// constructor
	/**
	 * set the constructor by given with, length and base
	 * @param base
	 */
	public HeadQuarter(Base base) {
		// call the constructor in the superclass
		super(HeadQuarter.LENGTH, HeadQuarter.WIDTH, base);
		
	}
	
	
	

	@Override
	void explode() {
		// TODO Auto-generated method stub

	}

	/**
	 * returns the name of this target: "Head Quarter"
	 */
	@Override
	public String getTargetName() {
		// returns the name of this target
		return HeadQuarter.NAME;
	}

}
