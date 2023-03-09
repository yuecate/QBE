package com.jennifer.devega;

public enum Direction {


	NORTH(0, 'N'), EAST(1, 'E'), SOUTH(2, 'S'), WEST(3, 'W');

	private int value;
	private char shortName;

	private Direction(int newValue, char shortNameValue) {
		value = newValue;
		shortName = shortNameValue;
	}

	public Direction getBackwardDirection() {
		return values()[(this.getValue() + 2) % 4];
	}

	public int getValue() {
		return value;
	}

	public char getShortName() {
		return shortName;
	}

	public static Direction getDirectionName(char shortName) {

		Direction direction = null;
		switch (Character.toUpperCase(shortName)) {
		case 'N':
			direction = Direction.NORTH;
			break;
		case 'S':
			direction = Direction.SOUTH;
			break;
		case 'E':
			direction = Direction.EAST;
			break;
		case 'W':
			direction = Direction.WEST;
			break;
		default:
			break;
		}

		return direction;
	}

}
