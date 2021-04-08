package com.smartrec.nbeq;

import java.util.Scanner;

import com.smartrec.nbeq.exception.DataException;
import com.smartrec.nbeq.utils.ParseCoordinates;

/**
 * @author Raja Boppana
 *
 */
public class EarthquakesNearby {
	
	    //variable to check to toggle scanner to quit
	    private boolean isRunning = true;
	    
	    //Invoke EQManager to before invoking the main method
	    private EQManager eqManager = new EQManager();
	 
	    //Scanner for co-ordinate input
	    private Scanner scanner = new Scanner(System.in);
	    

	    public static void main(String[] args) {
	        new EarthquakesNearby().start();
	    }

	    private void start() {
	    	
	        if (isRunning) {
	        	System.out.println("Enter latitude [-90.0, 90.0] and longitude [-180.0,180.0] to find nearby earthquakes");
	            System.out.println("Latitude and Longitude inputs should be seperate (press enter after entering each value)");
	            System.out.println("Enter 'E or e' to exit");
	            search();
	        }
	    }

	    private void search() {
	        String line = scanner.nextLine();
	        //exit check
	        if (line.equalsIgnoreCase("E")) {
	            eqManager.shutdown();
	            isRunning = false;
	        } else {
	            try {
	                double latitude = ParseCoordinates.parseLatitude(line);
	                double longitude = ParseCoordinates.parseLongitude(scanner.nextLine());
	                System.out.println(eqManager.getPrintableNearbyEarthquakes(latitude, longitude));
	            } catch (IllegalArgumentException e) {
	                System.out.println(e.getMessage());
	            } catch (DataException e) {
	                System.out.println("WTF");
	            }
	        }
	    }

}
