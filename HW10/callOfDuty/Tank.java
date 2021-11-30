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
		for(int i = -2; i < this.getHit().length + 2; i++) {
			for(int j = -2; j < this.getHit()[0].length + 2; j++) {
				this.getBase().shootAt(i + this.getCoordinate()[0], j + this.getCoordinate()[1]);
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
	
	@Override
	public void getShot(int row, int column) {
			if(!this.isDestroyed()) {
				this.getHit()[0][0]+=1;
				if(this.isDestroyed()) {
					this.explode();
					this.getBase().setDestroyedTargetCount(this.getBase().getDestroyedTargetCount() + 1);
			
	}
	}	
}
	
	
	/**
	 * returns true if every part of the target has been hit. false otherwise.
	 * if it's tank it should shoot twice. 
	 * @return true
	 */
	@Override
	public boolean isDestroyed() {
		if (this.getHit()[0][0]==2) {
			return true;
		}else {
			return false;
		}
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
