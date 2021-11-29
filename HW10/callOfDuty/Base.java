package callOfDuty;

import java.util.Random;

public class Base {
   // instance variables
	/**
	 * Every location in this array points to a Target
	 */
	private Target[][] targets = new Target[10][10];
	
	/**
	 * The total number of shots fired by the user.
	 */
	private int shotsCount;
	
	/**
	 * The number of targets destroyed.
	 */
	private int destroyedTargetCount;
	
	// constructor
	/**
	 * Creates an 10x10 empty Base
	 * initializes any game variables
	 */
	public Base() {
		// create an 10x10 empty base
		
		// initialize the variables
		this.shotsCount = 0;
		this.destroyedTargetCount = 0;
		//initial the base
		for(int i =0; i <10; i++) {
			for(int j=0;j<10;j++) {
			this.placeTargetAt(new Ground(this), i, j, true);
			}
		}
			
	}
    //
	// methods
	/**
	 * Creates and place all targets randomly on the base
	 * larger before small
	 * buildings before tanks and oil drums
	 */
	public void placeAllTargetRandomly() {
		//initial all instance target.
				HeadQuarter headQuar=new HeadQuarter(this);
			    Armory armoryH = new Armory(this);
			    Armory armoryV = new Armory(this);
			    Barrack barrackH1= new Barrack(this);
			    Barrack barrackH2= new Barrack(this);
			    Barrack barrackV= new Barrack(this);
			    SentryTower st1=new SentryTower(this);
			    SentryTower st2=new SentryTower(this);
			    SentryTower st3=new SentryTower(this);
			    SentryTower st4=new SentryTower(this);
			    Tank tank1= new Tank(this);
			    Tank tank2= new Tank(this);
			    Tank tank3= new Tank(this);
			    Tank tank4= new Tank(this);
			    OilDrum od1= new OilDrum(this);
			    OilDrum od2= new OilDrum(this);
			    OilDrum od3= new OilDrum(this);
			    OilDrum od4= new OilDrum(this);
			    //put all target in place
			    //placeTargetInplace is a method that could place one target in the OK place
			    //add one target by one, and it would result in all targets in place.
			    //be care of the horizontal and vertical value.
				this.placeTargetInPlace(headQuar, true);
				this.placeTargetInPlace(armoryH, true);
				this.placeTargetInPlace(armoryV, false);
				this.placeTargetInPlace(barrackH1, true);
				this.placeTargetInPlace(barrackH2, true);
				this.placeTargetInPlace(barrackV, false);
				this.placeTargetInPlace(st1, true);
				this.placeTargetInPlace(st2, true);
				this.placeTargetInPlace(st3, true);
				this.placeTargetInPlace(st4, true);	
				this.placeTargetInPlace(tank1, true);
				this.placeTargetInPlace(tank2, true);
				this.placeTargetInPlace(tank3, true);
				this.placeTargetInPlace(tank4, true);
				this.placeTargetInPlace(od1, true);
				this.placeTargetInPlace(od2, true);
				this.placeTargetInPlace(od3, true);
				this.placeTargetInPlace(od4, true);
			}
	
	/**
	 * returns true if it is OK to put the target with its head at this location, false otherwise
	 * @param given target
	 * @param given row
	 * @param given column
	 * @param given orientation, whether it is horizontal or not
	 * @return
	 */
	public boolean okToPlaceTargetAt(Target target, int row, int column, boolean horizontal){
		int length = target.getLength();
		int width= target.getWidth();
		int[][] hit;
		if (horizontal == false) {
			hit = new int[length][width];
		}
		else {
			hit = new int[width][length];
		}
		//determine whether it's out of the base;
		if(hit.length+row-1>9 ||hit[0].length+column-1>9 ||row<0 || column <0) {
			return false;
			}
		//check whether it's tanks or oilDrum.
		if(target.getTargetName().equals("tank")||target.getTargetName().equals("oilDrum")) {
			//if it's tanks or oilDrum, it could place anywhere within ground.
			//if it's ground return true.
			if(this.getTargetsArray()[row][column].getTargetName().equals("ground")) {
				return true;
			}else {
				return false;
			}
		}
		//determine whether it could place in this place where the surface +1 do not have any target.
		for (int i = -1; i < hit.length+1; i++) {
			for(int j = -1; j < hit[0].length+1; j++) {
				//determines whether the i+row is inside the base;
				if(i+row>=0 && i+row <=9 && j +column >=0 && j+column <=9) {
					//if it's not ground return false
						if(!this.getTargetsArray()[i+row][j+column].getTargetName().equals("ground")){
							return false;
						}
					}
				}
		}
		return true;
		}

	
	/**
	 * sets the value of the "hit" array, "coordinate" array and "horizontal" boolean value of the target
	 * @param given target
	 * @param given row
	 * @param given column
	 * @param given orientation, whether it is horizontal
	 */
	public void placeTargetAt(Target target, int row, int column, boolean horizontal) {
		int[] coordinate= new int[2];
		coordinate[0]=row;
		coordinate[1]=column;
		target.setCoordinate(coordinate);
		target.setHorizontal(horizontal);
		int length = target.getLength();
		int width= target.getWidth();
		if (horizontal == false) {
			target.setHit(new int[length][width]);
		} else {
			target.setHit(new int[width][length]);	
		}
		
		
		for (int i = 0; i < target.getHit().length; i++) {
			for(int j = 0; j < target.getHit()[0].length; j++) {
				this.getTargetsArray()[i + row][j + column] = target;
			}
		}
	}
	
	/**
	 * Returns true if the given location contains a Target;
	 * Returns false if it does not.
	 * @param row
	 * @param column
	 * @return true or false
	 */
	public boolean isOccupied(int row, int column) {
		if(this.getTargetsArray()[row][column].getTargetName() == "ground") {
			return false;
		}
		else {
			return true;
		}
		
		
		
	}
	
	/**
	 * Attack the position specified by the row and the column.
	 * @param row
	 * @param column
	 */
	public void shootAt(int row, int column) {
	// in case of the illegal situation
	if (row >= 10 || row < 0 || column >= 10 || column < 0) {
		System.out.println("Your shoot is out of bound");
	}else {
		// update the base after getting shot
		this.getTargetsArray()[row][column].getShot(row, column);
	}
}
	
	/**
	 * Returns true if run out of ammunition 
	 * or Returns true if all targets have been;
	 * otherwise, return false.
	 * @param weapon1
	 * @param weapon2
	 * @return true or false
	 */
	public boolean isGameOver(Weapon weapon1, Weapon weapon2) {
		if (this.win()) {
			return true;
		}
		else if(weapon1.getShotLeft() == 0 && weapon2.getShotLeft() == 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * Returns true if all targets have been destroyed.
	 * @return true or false
	 */
	public boolean win() {
		for(int i = 0; i < this.getTargetsArray().length; i++) {
			for(int j = 0; j < this.getTargetsArray().length; j++) {
				if(this.getTargetsArray()[i][j].isDestroyed() == false) {
					if(this.getTargetsArray()[i][j].getTargetName() != "ground") {
						return false;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Prints the Base.
	 * row/column numbers should be displayed too
	 * ¡°O¡±: Used to indicate a location that you have fired upon and hit a target
	 * ¡°-¡±: Used to indicate a location that you have fired upon and found nothing there
	 * ¡°X¡±: Used to indicate a location containing a destroyed Target
	 * ¡®.¡¯: Used to indicate a location that you have never fired upon
	 * ¡°T¡±: Used to indicate an undestroyed but hit Tank
	 */
	public void print() {
		System.out.print("  ");
		//print column number
		for(int i = 0; i < this.getTargetsArray().length; i++) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		//print row number
		for(int i = 0; i < this.getTargetsArray().length; i++) {
			System.out.print(i + " ");
			for(int j = 0; j < this.getTargetsArray()[i].length; j++) {
				if(this.getTargetsArray()[i][j].isHitAt(i, j) || this.getTargetsArray()[i][j].isDestroyed()) {
					System.out.print(this.getTargetsArray()[i][j] + " ");
				}
				else {
					System.out.print("." + " ");
				}
			}
			System.out.println();
		}
	}
	
	public void incrementShotsCount() {
		this.shotsCount++;
	}
	
	
	
	
	
	
	// getter methods
	
	/**
	 * @return The total number of shots fired by the user.
	 */
	public int getShotsCount() {
		return this.shotsCount;
	}
	
	/**
	 * @return Returns the targets array
	 */
	public Target[][] getTargetsArray(){
		return this.targets;
	}
	
	/**
	 * @return Returns the count of destroyed targets
	 */
	public int getDestroyedTargetCount() {
		return this.destroyedTargetCount;
	}
	
    // setter methods
	/**
	 * set the number of destroyedTarget
	 * @param i the count number
	 */
	public void setDestroyedTargetCount(int i) {
		this.destroyedTargetCount= i;
	}


	/**
	 * place a target in random place
	 * @param t to a Target
	 * @param horizontal or not
	 */
	void placeTargetInPlace(Target t, boolean horizontal) {
		//get a random coordinate.
		//set the head of a target.
		int[] randomCoordinate = this.getRandomCoordinate();
		// if we could not put in this place, it gives another coordinate to the head of a target
		boolean checkpoint =true;
		while(checkpoint) {
		if(this.okToPlaceTargetAt(t, randomCoordinate[0], randomCoordinate[1], horizontal)) {
				this.placeTargetAt(t, randomCoordinate[0], randomCoordinate[1], horizontal);
				//if we could place target in place exit the loop
				checkpoint =false;
			}else {
			//if it cannot put in this place, get another random coordinator.
				randomCoordinate = this.getRandomCoordinate();
		}
		}
	}

	/**
	 * get one random coordinate
	 * @return the random coordinate
	 */
	int[] getRandomCoordinate() {
		Random rand = new Random();
		int[] return_coordinate = new int[2];
		//get a list of random coordinate
		return_coordinate[0]=rand.nextInt(10);
		return_coordinate[1]=rand.nextInt(10);
		return return_coordinate;
	}
	
	
	
}
