/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormonoregontrail.control;

import java.util.Random;

/**
 *
 * @author haradab
 */
public class UtilitiesControl {
    
    public int calcResourcesLeft(int startAmount, int daysTraveled, int unitsPerDay) {
        
        if (startAmount < 10) { //start amount is too low
            return -1;
        }
        if (startAmount > 2000) { //start amount is too high
            return -2;
        }
        if (daysTraveled < 1)  { //days traveled is too low
            return -3;
        }
        if (daysTraveled > 365)  { //days traveled is too high
            return -4;
        }
        if (unitsPerDay < 1) { //units per day is too low
            return -5;
        }
        if (unitsPerDay > 5)  { //units per day is too high
            return -6;
        }

        int totalUsed = daysTraveled * unitsPerDay;

        int amtRemaining = startAmount - totalUsed;

        if (amtRemaining < 0)  { //no resources left
            return 0;
        }
        
        return amtRemaining;
        
    }
    
    /**
     * Validating and controlling advancement along the trail.
     * Mariam Erickson
     * @param currentLocation
     * @param numOfDaysTraveled
     * @param distanceFromNauvoo
     * @param obstacle
     * @param allowedDirection
     * @param userDirection
     * @return 
     */
    public int advanceAlongTheTrail(int currentLocation, int numOfDaysTraveled, int distanceFromNauvoo,
                                    String obstacle, String allowedDirection, String userDirection) {
    
        if (currentLocation < 1) { 
            return -1; //Current location is invalid
        }	
        if (currentLocation > 26) { 
            return -2; //Location is out of range
        }	
        if (numOfDaysTraveled < 1) { 
            return -3; //Number of days traveled is too small
        }	
        if (numOfDaysTraveled > 365) { 
            return -4; //Excess number of days
        }	
        if (distanceFromNauvoo < 1) { 
            return -5; //Distance is too short
        }	
        if (distanceFromNauvoo > 1325) { 
            return -6; //Distance is exceeded
        }
        
        Random rand = new Random();
        int randomValue = rand.nextInt(10); //50 percent chance of being less than 5.
        if (numOfDaysTraveled > 10 && numOfDaysTraveled < 20 && randomValue < 5) {
            return -7; //You have an ox that's sick
        }
        randomValue = rand.nextInt(10); //50 percent chance of being less than 5.
        if (distanceFromNauvoo > 500 && distanceFromNauvoo < 700 && randomValue < 5) {
            return -8; //You have a health challenge
        }
        randomValue = rand.nextInt(10); //50 percent chance of being less than 5.
        if (distanceFromNauvoo > 500 && distanceFromNauvoo < 700 && randomValue < 5) {
            return -9; //Wagon damage
        }	
        if (obstacle != null) {
            return -10; //Obstacle in your path
        }	
		//Show user current location description (found inside of scene object).
	double avgRequiredPace = (1325 - distanceFromNauvoo) / (26 - currentLocation);
		//Output average required pace to complete the journey.
		//Ask which direction user wants to go.
                
        if (allowedDirection == null || !(allowedDirection.equalsIgnoreCase("n") || allowedDirection.equalsIgnoreCase("s")
                || allowedDirection.equalsIgnoreCase("e") || allowedDirection.equalsIgnoreCase("w")))
        {
            return -12; //Allowed direction is bad
        }
	
        if (userDirection == null || !(userDirection.equalsIgnoreCase("n") || userDirection.equalsIgnoreCase("s")
                || userDirection.equalsIgnoreCase("e") || userDirection.equalsIgnoreCase("w")))
        {
            return -13; //User direction is bad
        }
            
        if (!allowedDirection.equalsIgnoreCase(userDirection)) {
            return -11; //Invalid direction
        }	
	return currentLocation + 1;    
        
        
    }
            
    
}
