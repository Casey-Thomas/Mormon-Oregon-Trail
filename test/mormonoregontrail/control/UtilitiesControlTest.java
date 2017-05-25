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
    
}
