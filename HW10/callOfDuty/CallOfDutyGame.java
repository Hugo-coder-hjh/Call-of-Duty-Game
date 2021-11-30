package callOfDuty;

import java.util.Scanner;

/**
 * 
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
			//create the array to place the weapon(it is for switching)
			Weapon[] weapons = new Weapon[] {rl, missile};
			int currentWeapon = 0;
			
			
			while(!base.isGameOver(rl, missile)) {
				//when the game continues, we need print the base to inform the current situation
				base.print();
				
				int row;
				int column;
				
				while (true) {
					//we need print the information of the weapon number
					System.out.println();
					System.out.println("Rocketlauncher: " + rl.getShotLeft() + " Missile: " + missile.getShotLeft());
					//use the % to switch the weapon.When the currentWeapon number increase, it will change the weapon
					System.out.println("Your current weapon is: " + weapons[currentWeapon%2].getWeaponType());
					System.out.println("Enter row, column, or q to switch a weapon.");
					
					try {
						String input = scanner.next();
						if (input.charAt(0) == 'q'||input.charAt(0) == 'Q') {
							//increase the number of currentWeapon to change the weapon from odd number to even number or from the even number to odd number
							currentWeapon ++;
							continue;
						}
						
						//get the (row, column) of shoot
						String[] loc = input.split(",");
						row = Integer.parseInt(loc[0]);
						column = Integer.parseInt(loc[1]);
						//if the place can not be shot
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
						}catch(Exception e) {
						System.out.println("invalid input");
						continue;
					}break;
				}
			}
			//at the end of the game, print the base
			base.print();
			System.out.println("Game Over");
			System.out.println("You current score is "+ base.getDestroyedTargetCount());
			System.out.println((18-base.getDestroyedTargetCount()) + " target(s) left.");
			System.out.println("You've used " + base.getShotsCount()+ " ammunition");
			if(base.win()) {
				System.out.println("You WIN!");
				System.out.println("Every Target has been destroyed!");
			}
			else {
				System.out.println("You LOST!");
				System.out.println("You ran out of ammunition!");
			}
			//System.out.println(base.getShotsFired() + " shots were needed!");
			System.out.println("Do you want to play again?");
			System.out.println("'Y' for yes. If not click any button.");
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
