/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormonoregontrail.control;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author haradab
 */
public class UtilitiesControlTest {
    
    public UtilitiesControlTest() {
    }

    /**
     * Test of calcResourcesLeft method, of class UtilitiesControl.
     */
    @Test
    public void testCalcResourcesLeft() {
        System.out.println("calcResourcesLeft");
        
        /*************************************
        *  Test case #1 - All valid variables *
        *************************************/
        
        System.out.println("\tTest case #1");
        
        int startAmount = 50;
        int daysTraveled = 30;
        int unitsPerDay = 1;
        
        UtilitiesControl instance = new UtilitiesControl();
        
        int expResult = 20;
        int result = instance.calcResourcesLeft(startAmount, daysTraveled, unitsPerDay);
        assertEquals(expResult, result);
        
        /*************************************
        *  Test case #2 - Start amount is too low*
        *************************************/
        
        System.out.println("\tTest case #2");
        
        startAmount = 5;
        daysTraveled = 30;
        unitsPerDay = 1;
        
        //UtilitiesControl instance = new UtilitiesControl();
        
        expResult = -1;
        result = instance.calcResourcesLeft(startAmount, daysTraveled, unitsPerDay);
        assertEquals(expResult, result);
        
        /*************************************
        *  Test case #3 - Start amount is too high*
        *************************************/
        
        System.out.println("\tTest case #3");
        
        startAmount = 2100;
        daysTraveled = 30;
        unitsPerDay = 1;
        
        //UtilitiesControl instance = new UtilitiesControl();
        
        expResult = -2;
        result = instance.calcResourcesLeft(startAmount, daysTraveled, unitsPerDay);
        assertEquals(expResult, result);
        
        /*************************************
        *  Test case #4 - Days traveled is too low*
        *************************************/
        
        System.out.println("\tTest case #4");
        
        startAmount = 50;
        daysTraveled = 0;
        unitsPerDay = 1;
        
        //UtilitiesControl instance = new UtilitiesControl();
        
        expResult = -3;
        result = instance.calcResourcesLeft(startAmount, daysTraveled, unitsPerDay);
        assertEquals(expResult, result);
        
        /*************************************
        *  Test case #5 - Days traveled is too high*
        *************************************/
        
        System.out.println("\tTest case #5");
        
        startAmount = 50;
        daysTraveled = 375;
        unitsPerDay = 1;
        
        //UtilitiesControl instance = new UtilitiesControl();
        
        expResult = -4;
        result = instance.calcResourcesLeft(startAmount, daysTraveled, unitsPerDay);
        assertEquals(expResult, result);
        
        /*************************************
        *  Test case #6 - Units per day is too low*
        *************************************/
        
        System.out.println("\tTest case #6");
        
        startAmount = 50;
        daysTraveled = 30;
        unitsPerDay = 0;
        
        //UtilitiesControl instance = new UtilitiesControl();
        
        expResult = -5;
        result = instance.calcResourcesLeft(startAmount, daysTraveled, unitsPerDay);
        assertEquals(expResult, result);
        
        /*************************************
        *  Test case #7 - Units per day is too high*
        *************************************/
        
        System.out.println("\tTest case #7");
        
        startAmount = 50;
        daysTraveled = 30;
        unitsPerDay = 6;
        
        //UtilitiesControl instance = new UtilitiesControl();
        
        expResult = -6;
        result = instance.calcResourcesLeft(startAmount, daysTraveled, unitsPerDay);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of advanceAlongTheTrail method, of class UtilitiesControl.
     * By Mariam Erickson
     */
    @Test
    public void testAdvanceAlongTheTrail() {
        System.out.println("advanceAlongTheTrail");
        int currentLocation = 0;
        int numOfDaysTraveled = 0;
        int distanceFromNauvoo = 0;
        String obstacle = "";
        String allowedDirection = "";
        String userDirection = "";
        UtilitiesControl instance = new UtilitiesControl();
        int expResult = 0;
        int result = 0;
                        
        /*************************************
        *  Test case #1 - All valid variables *
        *************************************/
        
        currentLocation = 1;
        numOfDaysTraveled = 1;
        distanceFromNauvoo = 1;
        obstacle = null;
        allowedDirection = "n";
        userDirection = "n";
        instance = new UtilitiesControl();
        expResult = 2;
        System.out.println("\tTest case #1");
        result = instance.advanceAlongTheTrail(currentLocation, numOfDaysTraveled, distanceFromNauvoo, obstacle, allowedDirection, userDirection);
        assertEquals(expResult, result);

        /*************************************
        *  Test case #2 - Current location is invalid *
        *************************************/
        
        currentLocation = 0;
        numOfDaysTraveled = 1;
        distanceFromNauvoo = 1;
        obstacle = null;
        allowedDirection = "n";
        userDirection = "n";
        instance = new UtilitiesControl();
        expResult = -1;
        System.out.println("\tTest case #2");
        result = instance.advanceAlongTheTrail(currentLocation, numOfDaysTraveled, distanceFromNauvoo, obstacle, allowedDirection, userDirection);
        assertEquals(expResult, result);
        
                /*************************************
        *  Test case #3 - Location is out of range *
        *************************************/
        
        currentLocation = 27;
        numOfDaysTraveled = 1;
        distanceFromNauvoo = 1;
        obstacle = null;
        allowedDirection = "n";
        userDirection = "n";
        instance = new UtilitiesControl();
        expResult = -2;
        System.out.println("\tTest case #3");
        result = instance.advanceAlongTheTrail(currentLocation, numOfDaysTraveled, distanceFromNauvoo, obstacle, allowedDirection, userDirection);
        assertEquals(expResult, result);
     
                /*************************************
        *  Test case #4 - Number of days traveled is too small *
        *************************************/
        
        currentLocation = 5;
        numOfDaysTraveled = -1;
        distanceFromNauvoo = 1;
        obstacle = null;
        allowedDirection = "n";
        userDirection = "n";
        instance = new UtilitiesControl();
        expResult = -3;
        System.out.println("\tTest case #4");
        result = instance.advanceAlongTheTrail(currentLocation, numOfDaysTraveled, distanceFromNauvoo, obstacle, allowedDirection, userDirection);
        assertEquals(expResult, result);
    
                /*************************************
        *  Test case #5 - Excess number of travel days *
        *************************************/
        
        currentLocation = 5;
        numOfDaysTraveled = 377;
        distanceFromNauvoo = 1;
        obstacle = null;
        allowedDirection = "n";
        userDirection = "n";
        instance = new UtilitiesControl();
        expResult = -4;
        System.out.println("\tTest case #5");
        result = instance.advanceAlongTheTrail(currentLocation, numOfDaysTraveled, distanceFromNauvoo, obstacle, allowedDirection, userDirection);
        assertEquals(expResult, result);
   
                /*************************************
        *  Test case #6 - Distance is too short *
        *************************************/
        
        currentLocation = 5;
        numOfDaysTraveled = 1;
        distanceFromNauvoo = -1;
        obstacle = null;
        allowedDirection = "n";
        userDirection = "n";
        instance = new UtilitiesControl();
        expResult = -5;
        System.out.println("\tTest case #6");
        result = instance.advanceAlongTheTrail(currentLocation, numOfDaysTraveled, distanceFromNauvoo, obstacle, allowedDirection, userDirection);
        assertEquals(expResult, result);
        
                /*************************************
        *  Test case #7 - Distance is exceeded *
        *************************************/
        
        currentLocation = 5;
        numOfDaysTraveled = 1;
        distanceFromNauvoo = 1400;
        obstacle = null;
        allowedDirection = "n";
        userDirection = "n";
        instance = new UtilitiesControl();
        expResult = -6;
        System.out.println("\tTest case #7");
        result = instance.advanceAlongTheTrail(currentLocation, numOfDaysTraveled, distanceFromNauvoo, obstacle, allowedDirection, userDirection);
        assertEquals(expResult, result);
        
                /*************************************
        *  Test case #8 -  Invalid direction *
        *************************************/
        
        currentLocation = 1;
        numOfDaysTraveled = 1;
        distanceFromNauvoo = 1;
        obstacle = null;
        allowedDirection = "n";
        userDirection = "s";
        instance = new UtilitiesControl();
        expResult = -11;
        System.out.println("\tTest case #8");
        result = instance.advanceAlongTheTrail(currentLocation, numOfDaysTraveled, distanceFromNauvoo, obstacle, allowedDirection, userDirection);
        assertEquals(expResult, result);
        
                /*************************************
        *  Test case #9 - Allowed direction is bad *
        *************************************/
        
        currentLocation = 1;
        numOfDaysTraveled = 1;
        distanceFromNauvoo = 1;
        obstacle = null;
        allowedDirection = "x";
        userDirection = "n";
        instance = new UtilitiesControl();
        expResult = -12;
        System.out.println("\tTest case #9");
        result = instance.advanceAlongTheTrail(currentLocation, numOfDaysTraveled, distanceFromNauvoo, obstacle, allowedDirection, userDirection);
        assertEquals(expResult, result);
        
                /*************************************
        *  Test case #10 - User direction is bad *
        *************************************/
        
        currentLocation = 1;
        numOfDaysTraveled = 1;
        distanceFromNauvoo = 1;
        obstacle = null;
        allowedDirection = "n";
        userDirection = "y";
        instance = new UtilitiesControl();
        expResult = -13;
        System.out.println("\tTest case #10");
        result = instance.advanceAlongTheTrail(currentLocation, numOfDaysTraveled, distanceFromNauvoo, obstacle, allowedDirection, userDirection);
        assertEquals(expResult, result);
        
                /*************************************
        *  Test case #11 - Obstacle in your path *
        *************************************/
        
        currentLocation = 5;
        numOfDaysTraveled = 1;
        distanceFromNauvoo = 1;
        obstacle = "a river is in your path";
        allowedDirection = "n";
        userDirection = "n";
        instance = new UtilitiesControl();
        expResult = -10;
        System.out.println("\tTest case #11");
        result = instance.advanceAlongTheTrail(currentLocation, numOfDaysTraveled, distanceFromNauvoo, obstacle, allowedDirection, userDirection);
        assertEquals(expResult, result);

  
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
