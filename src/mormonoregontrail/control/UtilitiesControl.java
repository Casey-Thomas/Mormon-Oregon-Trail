/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormonoregontrail.control;

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
    
}
