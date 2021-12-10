package callOfDuty;

import java.util.Scanner;

/**
 * In the game, you serve as a soldier and your mission is destroying a 10x10 enemy base. 
 * You need to destroy all Targets in the base.
 * @author Jiahao He(15953838) & Xinyang Shen(89346044)
 */

public class CallOfDutyGame {

	public static void main(String[] args) {
		
Scanner scanner = new Scanner(System.in);
		
		while(true) {
			// create an instance of Base
			Base base = new Base();
			// place the targets on the base
			base.placeAllTargetRandomly();
			//create the weapons
			Weapon rl = new RocketLauncher();
			Weapon missile = new Missile();
			//create the array to place the weapon
			Weapon[] weapons = new Weapon[] {rl, missile};
			int currentWeapon = 0;
			
			
			while(!base.isGameOver(rl, missile)) {
				//show the base map, which is updated after the user's operation
				base.print();
				System.out.println();
				System.out.println("**** The number of destroyed targets is "+ base.getDestroyedTargetCount()+" ****");
				
				int row;
				int column;
				
				while (true) {
					//we need print the information of the weapon number
					System.out.println();
					System.out.println("Rocketlauncher: " + rl.getShotLeft() + " Missile: " + missile.getShotLeft());
					//use the % to switch the weapon, odd/even according to 2 different weapon types
					System.out.println("Your current weapon is: " + weapons[currentWeapon%2].getWeaponType());
					System.out.println("Enter row, column, or q to switch a weapon");
					
					try {
						String input = scanner.next();
						if (input.charAt(0) == 'q'||input.charAt(0) == 'Q') {
							//increase the number of currentWeapon to change the weapon
							currentWeapon ++;
							continue;
						}
						
						//change the input(row, column) from String type to Integer 
						String[] loc = input.split(",");
						int num = loc.length;
						// if input size is larger than 2, throw an exception
						if (num > 2) {
							throw new Exception("out of index");
						} else {
						row = Integer.parseInt(loc[0]);
						column = Integer.parseInt(loc[1]);
						//in case of the out of the bound situation
						if(row >=10 ||row <0 || column >=10 || column <0) {
							System.out.println("You can not shoot at here.");
							continue;
						}
						//if there is no weapon left
						if(weapons[currentWeapon%2].getShotLeft() <= 0) {
							System.out.println("There is no "+weapons[currentWeapon%2].getWeaponType()+" left.");
							continue;
						}
							weapons[currentWeapon%2].shootAt(row, column, base);							
						}}catch(Exception e) {
						System.out.println("invalid input, please enter again");
						continue;
					}break;
				}
			}
			//at the end of the game, print the base
			base.print();
			System.out.println();
			System.out.println("Game Over");
			System.out.println("****************************************");
			System.out.println("The number of destroyed targets is "+ base.getDestroyedTargetCount());
			System.out.println((18-base.getDestroyedTargetCount()) + " target(s) left.");
			System.out.println("You've used " + base.getShotsCount()+ " ammunition");
			if(base.win()) {
				System.out.println("Congradulations! You WIN!");
				System.out.println("Every Target has been destroyed!");
				System.out.println("****************************************");
			}
			else {
				System.out.println("Sorry, you LOST!");
				System.out.println("You ran out of ammunition!");
				System.out.println("****************************************");
			}
			System.out.println();
			System.out.println("Do you want to play again?");
			System.out.println("'Y/y' for yes. If not click any button.");
			String input = scanner.next();
			if(input.charAt(0) == 'Y'||input.charAt(0) == 'y') {
				continue;
			}
			//exit the loop
			break;
		}
		scanner.close();
	}

}
