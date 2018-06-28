package fourWayStreetLights.util;

import fourWayStreetLights.service.StreetLightsContext;

public class FourWayStreetLights {
	
	private String North, East, West, South;
	private int northCars, eastCars, westCars, southCars;
	//private int directionAdd, directionMinus;
	
	public FourWayStreetLights() {
		//setDirectionAdd(-1);
		northCars=0; eastCars=0; westCars=0; southCars=0;
		North = "red"; East="red"; West="red"; South="red";
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
	
	/*public int getDirectionAdd() {
		return directionAdd;
	}

	public void setDirectionAdd(int directionIn) {
		this.directionAdd = directionIn;
	}

	public int getDirectionMinus() {
		return directionMinus;
	}

	public void setDirectionMinus(int directionMinus) {
		this.directionMinus = directionMinus;
	}*/
	
	public FourWayStreetLights updateFourWayStreetLights(FourWayStreetLights fourWayStreetLightsIn, String line, StreetLightsContext streetLightsContext) {
		String [] data = line.split(" ");
		if (data[0].equalsIgnoreCase("add")) {
			try {
				switch (data[4]) {
					case "north": fourWayStreetLightsIn.setNorthCars(fourWayStreetLightsIn.getNorthCars() + Integer.parseInt(data[1]));
								  /*streetLightsContext.getResults().setCarChange(Integer.parseInt(data[1]) + " Cars added to North");
								  setDirectionAdd(1);*/
						break;
					case "east": fourWayStreetLightsIn.setEastCars(fourWayStreetLightsIn.getEastCars() + Integer.parseInt(data[1]));
								 //setDirectionAdd(2);
						break;
					case "west": fourWayStreetLightsIn.setWestCars(fourWayStreetLightsIn.getWestCars() + Integer.parseInt(data[1]));
								 //setDirectionAdd(3);
						break;
					case "south": fourWayStreetLightsIn.setSouthCars(fourWayStreetLightsIn.getSouthCars() + Integer.parseInt(data[1]));
								  //setDirectionAdd(4);
						break;
					default: System.out.println("Not a valid Direction");
						break;
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Not valid number");
			}
		} else if (data[0].equalsIgnoreCase("turn")){
			switch(data[1]) {
				case "north": fourWayStreetLightsIn.setNorth(data[2]);
							  fourWayStreetLightsIn.setNorthCars(
									  fourWayStreetLightsIn.getNorthCars() >= 2 ? fourWayStreetLightsIn.getNorthCars() - 2
											  : (fourWayStreetLightsIn.getNorthCars() == 1 ? fourWayStreetLightsIn.getNorthCars() -1 
										: 0));
							  //setDirectionMinus(1);
					break;
				case "east": fourWayStreetLightsIn.setEast(data[2]);
							fourWayStreetLightsIn.setEastCars(
									fourWayStreetLightsIn.getEastCars() >= 2 ? fourWayStreetLightsIn.getEastCars() - 2 
											: (fourWayStreetLightsIn.getEastCars() == 1 ? fourWayStreetLightsIn.getEastCars() - 1
													: 0));
							//setDirectionMinus(2);
					break;
				case "west": fourWayStreetLightsIn.setWest(data[2]);
							 fourWayStreetLightsIn.setWestCars(
									 fourWayStreetLightsIn.getWestCars() >= 2 ? fourWayStreetLightsIn.getWestCars() - 2
											 : (fourWayStreetLightsIn.getWestCars() >= 1 ? fourWayStreetLightsIn.getWestCars() - 1 
													 : 0));
							 //setDirectionMinus(3);
					break;
				case "south": fourWayStreetLightsIn.setSouth(data[2]);
							  fourWayStreetLightsIn.setSouthCars(
									  fourWayStreetLightsIn.getSouthCars() >= 2 ? fourWayStreetLightsIn.getSouthCars() - 2
											  : (fourWayStreetLightsIn.getSouthCars() == 1 ? fourWayStreetLightsIn.getSouthCars() - 1 
													  : 0));
							  //setDirectionMinus(4);
					break;
				default: System.out.println("Not a valid Direction");
					break;
			}
		} 
		return fourWayStreetLightsIn;
	}

}
