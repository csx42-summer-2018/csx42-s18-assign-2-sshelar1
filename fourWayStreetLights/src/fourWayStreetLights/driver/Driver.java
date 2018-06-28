package fourWayStreetLights.driver;

import fourWayStreetLights.service.StreetLightsContext;
import fourWayStreetLights.util.FileProcessor;
import fourWayStreetLights.util.FourWayStreetLights;
import fourWayStreetLights.util.Logger;
import fourWayStreetLights.util.Results;

public class Driver{

	
	public static void main(String[] args) {
		FileProcessor fileProcessor = null;
		Results results = null;
		int debugLevel=-1;
		String line = null;
		
		/**
		 * Checking for valid arguments
		 */
		if (args.length != 3) {
			System.out.println("Invaid number of arguments");
			System.exit(1);
		}
		
		/**
		 * Checking for valid debug level
		 */
		try {
			debugLevel = Integer.parseInt(args[2]);
			Logger.setDebugValue(debugLevel);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Invalid debug level");
			System.exit(1);
		}
		
		if (debugLevel < 0 || debugLevel > 3) {
			System.out.println("Debug value out of range");
			System.exit(1);
		}
		
		fileProcessor = new FileProcessor(args[0]);
		results = new Results(args[1]);
		
		StreetLightsContext streetLightsContext = new StreetLightsContext(debugLevel);
		streetLightsContext.setResults(results);
		
		FourWayStreetLights fourWayStreetLights = new FourWayStreetLights();
		
		while ((line = fileProcessor.readLine()) != null) {
			fourWayStreetLights = streetLightsContext.passTraffic(fourWayStreetLights, line);
		}
		results = streetLightsContext.getResults();
		results.storeNewResult(fourWayStreetLights.getEastCars() + " remaining in East side");
		results.storeNewResult(fourWayStreetLights.getNorthCars() + " remaining in North side");
		results.storeNewResult(fourWayStreetLights.getSouthCars() + " remaining in South side");
		results.storeNewResult(fourWayStreetLights.getWestCars() + " remaning in West side");
		results.writeToFile();
	}
	
}