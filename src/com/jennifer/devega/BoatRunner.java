package com.jennifer.devega;

import java.util.Scanner;

public class BoatRunner {

	public static void main(String[] args) throws Exception {

		Scanner scanner = new Scanner(System.in);

		Boat boat;
		Direction direction = null;
		Coordinates coordinates;
		Point x = new Point(0);
		Point y = new Point(0);

		int intX;
		int intY;
		char shortDirection = 0;
		char shortMovement = 0;

		System.out.println("Enter coordinates (e.g 1,0): ");
		String strCoordinates = scanner.nextLine();
		String[] coordinateList = strCoordinates.split(",");

		if (coordinateList.length == 2) {
			intX = Integer.parseInt(coordinateList[0]);
			intY = Integer.parseInt(coordinateList[1]);

			x = new Point(intX);
			y = new Point(intY);
		} else {
			throw new Exception("Invalid Input");
		}

		System.out.println();
		System.out.println("Direction : N = North, S = South, E = East, W = West");
		System.out.println("Movement: L=Left, R=Right, F=Forward, B=Backward");

		System.out.println("Enter direction and movement (e.g. SF ): ");
		String directionMovement = scanner.nextLine();

		if (!directionMovement.isBlank() && directionMovement.length() == 2) {
			shortDirection = directionMovement.charAt(0);
			shortMovement = directionMovement.charAt(1);
		} else {
			throw new Exception("Invalid Input");
		}

		direction = Direction.getDirectionName(shortDirection);
		coordinates = new Coordinates(x, y, direction);
		boat = new Boat(coordinates);

		boat.receiveSingleCommand(shortMovement);
		System.out.println();
		System.out.printf("The Coordinate is: %d, %d ", boat.getCoordinates().getX().getLocation(),
				boat.getCoordinates().getY().getLocation()).println();
	}
}
