package fourWayStreetLights.util;

public class FourWayStreetLights {
	
	private String North, East, West, South;
	private int northCars, eastCars, westCars, southCars;
	
	public FourWayStreetLights() {
		northCars=0; eastCars=0; westCars=0; southCars=0;
		North = null; East=null; West=null; South=null;
	}

	public String getNorth() {
		return North;
	}

	public void setNorth(String north) {
		North = north;
	}

	public String getEast() {
		return East;
	}

	public void setEast(String east) {
		East = east;
	}

	public String getWest() {
		return West;
	}

	public void setWest(String west) {
		West = west;
	}

	public String getSouth() {
		return South;
	}

	public void setSouth(String south) {
		South = south;
	}

	public int getNorthCars() {
		return northCars;
	}

	public void setNorthCars(int northCars) {
		this.northCars = northCars;
	}

	public int getEastCars() {
		return eastCars;
	}

	public void setEastCars(int eastCars) {
		this.eastCars = eastCars;
	}

	public int getWestCars() {
		return westCars;
	}

	public void setWestCars(int westCars) {
		this.westCars = westCars;
	}

	public int getSouthCars() {
		return southCars;
	}

	public void setSouthCars(int southCars) {
		this.southCars = southCars;
	}

	public FourWayStreetLights updateFourWayStreetLights(FourWayStreetLights fourWayStreetLightsIn, String line) {
		return fourWayStreetLightsIn;
	}
}
