package com.jennifer.devega;

public class Coordinates {
	private Point x;

	public void setX(Point value) {
		x = value;
	}

	public Point getX() {
		return x;
	}

	private Point y;

	public void setY(Point value) {
		y = value;
	}

	public Point getY() {
		return y;
	}

	private Direction direction;

	public void setDirection(Direction value) {
		direction = value;
	}

	public Direction getDirection() {
		return direction;
	}

	public Coordinates(Point xValue, Point yValue, Direction directionValue) {
		setX(xValue);
		setY(yValue);
		setDirection(directionValue);
	}

	protected boolean move(Direction directionValue) {

		boolean isValid = true;
		int xLocation = x.getLocation();
		int yLocation = y.getLocation();

		switch (directionValue) {
		case NORTH:
			yLocation = y.getForwardLocation();
			break;
		case EAST:
			xLocation = x.getForwardLocation();
			break;
		case SOUTH:
			yLocation = y.getBackwardLocation();
			break;
		case WEST:
			xLocation = x.getBackwardLocation();
			break;
		default:
			isValid = false;
		}

		x.setLocation(xLocation);
		y.setLocation(yLocation);

		return isValid;
	}

	public boolean moveForward() {
		return move(direction);
	}

	public boolean moveBackward() {
		return move(direction.getBackwardDirection());
	}

	private void changeDirection(Direction directionValue, int directionStep) {
		int directions = Direction.values().length;
		int index = (directions + directionValue.getValue() + directionStep) % directions;
		direction = Direction.values()[index];
	}

	public void changeDirectionLeft() {
		changeDirection(direction, -1);
	}

	public void changeDirectionRight() {
		changeDirection(direction, 1);
	}
}
