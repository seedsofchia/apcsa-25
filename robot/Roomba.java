package robot;

import kareltherobot.*;

public class Roomba implements Directions {

	// Main method to make this self-contained
	public static void main(String[] args) {
		// LEAVE THIS ALONE!!!!!!
		String worldName = "robot/finalTestWorld2024.wld";
		Roomba cleaner = new Roomba();
		int totalBeepers = cleaner.cleanRoom(worldName, 7, 6);
		System.out.println("Roomba cleaned up a total of " + totalBeepers + " beepers.");
		


	}

	// declared here so it is visible in all the methods!
	private Robot roomba;

	public int cleanRoom(String worldName, int startX, int startY) {

		// A new Robot should be constructed and assigned to the global (instance)
		// variable named roomba that is declared above.
		// Make sure it starts at startX and startY location.

		World.readWorld(worldName);
		World.setVisible(true);
		World.setDelay(0);
		

		roomba = new Robot(26, 149, West, 0);
		/**
		 * This section will have all the logic that takes the Robot to every location
		 * and cleans up all piles of beepers. Think about ways you can break this
		 * large, complex task into smaller, easier to solve problems.
		 * 
		 * @return
		 */

		// You will need to add many variables!!
		int totalBeepers = 0;
		int totalArea = 1;

		int largestPile = 0;

		while (roomba.frontIsClear()) {
			totalArea++;
			roomba.move();

			int pileSize = 0;
			while (roomba.nextToABeeper()) {

				
				pileSize++;
				roomba.pickBeeper();
				totalBeepers++;
			}
			if (pileSize > largestPile) {
				largestPile = pileSize;
			}


			if (!roomba.frontIsClear()) {

				if (roomba.facingEast()) {

					roomba.turnLeft();
					roomba.move();
					totalArea++;
					roomba.turnLeft();

				}

				else {

					roomba.turnLeft();
					roomba.turnLeft();
					roomba.turnLeft();
					roomba.move();
					totalArea++;
					roomba.turnLeft();
					roomba.turnLeft();
					roomba.turnLeft();

				}
			}
			System.out.println("total area is" + totalArea);
			System.out.println("largest pile is" + largestPile);

		}

		return totalBeepers;

	}

	// the line below causes a null pointer exception
	// what is that and why are we getting it?

	// Need to move this somewhere else.
	// This method should return the total number of beepers cleaned up.

}
