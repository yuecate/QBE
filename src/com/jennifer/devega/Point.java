package com.jennifer.devega;

public class Point {
	private int location;

	public void setLocation(int value) {
		location = value;
	}

	public int getLocation() {
		return location;
	}

	public Point(int locationValue) {
		setLocation(locationValue);
	}

	public int getForwardLocation() {
		return (getLocation() + 1);
	}

	public int getBackwardLocation() {
		return getLocation() - 1;
	}
}
