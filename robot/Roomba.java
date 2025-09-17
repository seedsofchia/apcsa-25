package robot;

import kareltherobot.*;

public class Roomba implements Directions {
	private static int st = 0;
	private static int av = 0;

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
		 * z
		 * @return
		 */

		// You will need to add many variables!
		int totalArea = 1;
		int largestPile = 0;
		int numberOfPiles = 0;
		int totalBeepers = 0;

		// to move stuff and pick up beepers

		while (true) {
			while (roomba.frontIsClear()) {
				totalArea++;

				if (roomba.nextToABeeper()) {
					numberOfPiles++;
					int pileSize = 0;
					while (roomba.nextToABeeper()) {
						roomba.pickBeeper();
						pileSize++;
						totalBeepers++;
					}

					if (pileSize > largestPile) {
						largestPile = pileSize;
						st = roomba.street();
						av = roomba.avenue();
					}
				}
				roomba.move();
			}
			if (roomba.nextToABeeper()) {
				numberOfPiles++;
				int pileSize = 0;
				while (roomba.nextToABeeper()) {
					roomba.pickBeeper();
					pileSize++;
					totalBeepers++;
				}
				if (pileSize > largestPile) {
					largestPile = pileSize;
					st = roomba.street();
					av = roomba.avenue();
				}
			}

			if (roomba.facingEast()) {
				roomba.turnLeft();
				if (roomba.frontIsClear()) {
					roomba.move();
					roomba.turnLeft();
				} else {
					break;
				}
			}

			else if (roomba.facingWest()) {
				turnRight(roomba);
				if (roomba.frontIsClear()) {
					roomba.move();
					turnRight(roomba);
				} else {
					break;
				}
			}
		}

		// print metrics
		System.out.println("total area is " + totalArea);
		System.out.println("largest pile is " + largestPile);
		System.out.println("largest pile is at " + st + "," + av);
		System.out.println("Number of piles " + numberOfPiles);
		System.out.println("Percent dirty is " + (100 * numberOfPiles / totalArea) + "%");
		System.out.println("Average beeper amount per pile is " + (totalBeepers / numberOfPiles));
		return totalBeepers;

	}

	public static void turnRight(Robot rob) {
		for (int i = 0; i < 3; i++)
			rob.turnLeft();

	}

	// the line below causes a null pointer exception
	// what is that and why are we getting it?

	// Need to move this somewhere else.
	// This method should return the total number of beepers cleaned up.

}
