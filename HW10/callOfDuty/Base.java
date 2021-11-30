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
    
	// methods
	/**
	  * Creates and place all targets randomly on the base
	  * larger before small
	  * buildings before tanks and oil drums
	  */
	 public void placeAllTargetRandomly() {
	  //first to place the head quarter(1)
	  HeadQuarter headQua = new HeadQuarter(this);
	  this.randomPlacement(headQua);
	  
	  // then place the armory(2)
	  Armory Arm1 = new Armory(this);
	  this.randomPlacement(Arm1);
	  Armory Arm2 = new Armory(this);
	  this.randomPlacement(Arm2);
	  
	  // place the barracks(3)
	  Barrack Bar1 = new Barrack(this);
	  this.randomPlacement(Bar1);
	  Barrack Bar2 = new Barrack(this);
	  this.randomPlacement(Bar2);
	  Barrack Bar3 = new Barrack(this);
	  this.randomPlacement(Bar3);
	  
	  //place the sentry towers(4)
	  SentryTower Sen1 = new SentryTower(this);
	  this.randomPlacement(Sen1);
	  SentryTower Sen2 = new SentryTower(this);
	  this.randomPlacement(Sen2);
	  SentryTower Sen3 = new SentryTower(this);
	  this.randomPlacement(Sen3);
	  SentryTower Sen4 = new SentryTower(this);
	  this.randomPlacement(Sen4);
	  
	  // place the tanks(4)
	  Tank tank1 = new Tank(this);
	  this.randomPlacement(tank1);
	  Tank tank2 = new Tank(this);
	  this.randomPlacement(tank2);
	  Tank tank3 = new Tank(this);
	  this.randomPlacement(tank3);
	  Tank tank4 = new Tank(this);
	  this.randomPlacement(tank4);
	  
	  // place the oil drums(4)
	  OilDrum oil1 = new OilDrum(this);
	  this.randomPlacement(oil1);
	  OilDrum oil2 = new OilDrum(this);
	  this.randomPlacement(oil2);
	  OilDrum oil3 = new OilDrum(this);
	  this.randomPlacement(oil3);
	  OilDrum oil4 = new OilDrum(this);
	  this.randomPlacement(oil4); 
	  }
	  

	 
	 /** 
	  * helper method to randomly generate the location and orientation of the target
	  * place the target if the orientation and location are legal
	  * @param given target that's waited to be placed
	  */
	 private void randomPlacement(Target target){
	  // initialize the random module
	  Random rand = new Random();
	  // generate random numbers for the target's location
	  int row = rand.nextInt(10);
	  int column = rand.nextInt(10);
	  // generate random boolean for the target's orientation
	  boolean horizontal = rand.nextBoolean();
	  // if the placement is illegal, generate the random numbers and boolean value again
	  while(okToPlaceTargetAt(target, row, column, horizontal) == false) {
	   row = rand.nextInt(10);
	   column = rand.nextInt(10);
	   horizontal = rand.nextBoolean();
	   } if(okToPlaceTargetAt(target, row, column, horizontal) == true) {
	    // if the placement is legal, then place the target at this location with this orientation
	       this.placeTargetAt(target, row, column, horizontal);
	        }
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
		if(target.getTargetName().equals("Tank")||target.getTargetName().equals("OilDrum")) {
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
	 * helper function to decide whether is OK to shoot at
	 * @param row
	 * @param column
	 * @return
	 */
	public boolean okToShootAt(int row, int column) {
		if (row >= 10 || row < 0 || column >= 10 || column < 0) {
			return false;
		} return true;
	}
	
	
	/**
	 * Attack the position specified by the row and the column.
	 * @param row
	 * @param column
	 */
	public void shootAt(int row, int column) {
		// in case of the illegal situation
		if (this.okToShootAt(row, column)) {
			
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

	
}
