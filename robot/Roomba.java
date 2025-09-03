package robot;

import kareltherobot.*;

public class Roomba implements Directions {

	// Main method to make this self-contained
	public static void main(String[] args) {
		// LEAVE THIS ALONE!!!!!!
		String worldName = "robot/basicRoom.wld";
		Roomba cleaner = new Roomba();
		int totalBeepers = cleaner.cleanRoom(worldName, 6, 7);
		System.out.println("Roomba cleaned up a total of " + totalBeepers + " beepers.");

	}

	// declared here so it is visible in all the methods!
	private Robot roomba;

	// You will need to add many variables!!
	while (roomba.nextToABeeper()){
		roomba.pickBeeper();
	}

	public int cleanRoom(String worldName, int startX, int startY) {

		// A new Robot should be constructed and assigned to the global (instance) variable named roomba that is declared above.
        // Make sure it starts at startX and startY location.

		World.readWorld(worldName);
		World.setVisible(true);


		/** This section will have all the logic that takes the Robot to every location
		 * and cleans up all piles of beepers. Think about ways you can break this
		 * large, complex task into smaller, easier to solve problems.
		 */

		roomba = new Robot(15,2,South,9);

		// the line below causes a null pointer exception
		// what is that and why are we getting it?
		roomba.move();
		roomba.move();


		int totalBeepers = 20; // Need to move this somewhere else.
        // This method should return the total number of beepers cleaned up.
		return totalBeepers;
		

	}
}
