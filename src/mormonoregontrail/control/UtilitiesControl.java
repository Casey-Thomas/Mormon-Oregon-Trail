/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormonoregontrail.control;

import java.util.Random;
import mormonoregontrail.exceptions.UtilitiesControlException;
import mormonoregontrail.model.InventoryItem;
import mormonoregontrail.model.Player;

/**
 *
 * @author Braden
 */
public class UtilitiesControl {

 /**
     * author Mariam Erickson
     * @param gameInventory
     * @param player
     * @param oxenCount
     * @throws UtilitiesControlException 
     */
    public static void purchaseOxen(InventoryItem[] gameInventory, Player player, int oxenCount) throws UtilitiesControlException {
       if (oxenCount <=0) {
           throw new UtilitiesControlException("This is an invalid oxen count. You must purchase at least one ox.");
       }
//        InventoryItem oxen = new InventoryItem();
//        oxen.setDescription("Oxen");
//        oxen.setQuantityInStock(30);
//        oxen.setRequiredAmount(2);
//        oxen.setCost(20);
//        oxen.setUnits("Each");
//        inventory[Item.oxen.ordinal()] = oxen;       

        InventoryItem playerMoney = player.getInventory()[GameControl.Item.money.ordinal()];
        InventoryItem playerOxen = player.getInventory()[GameControl.Item.oxen.ordinal()];
        InventoryItem storeMoney = gameInventory[GameControl.Item.money.ordinal()];
        InventoryItem storeOxen = gameInventory[GameControl.Item.oxen.ordinal()];
        int costOfOxen = storeOxen.getCost();
        int availableOxen = storeOxen.getQuantityInStock();
        // They do not have enough money
        if (costOfOxen * oxenCount > playerMoney.getQuantityInStock()) {
           throw new UtilitiesControlException("You do not have enough money for this purchase.");
            
        }
        // The store does not have enough inventory
        if (availableOxen < oxenCount) {
           throw new UtilitiesControlException("There are only " + availableOxen + " oxen available to purchase.");
            
        }

        // Make purchase
        storeOxen.setQuantityInStock(availableOxen - oxenCount);
        playerOxen.setQuantityInStock(playerOxen.getQuantityInStock() + oxenCount);   
        
        storeMoney.setQuantityInStock(storeMoney.getQuantityInStock() + (costOfOxen * oxenCount));
        playerMoney.setQuantityInStock(playerMoney.getQuantityInStock() - (costOfOxen * oxenCount));        
        
    }

    /**
     * author Mariam Erickson
     * @param gameInventory
     * @param player
     * @param foodCount
     * @throws UtilitiesControlException 
     */
    public static void purchaseFood(InventoryItem[] gameInventory, Player player, int foodCount) throws UtilitiesControlException {
       if (foodCount <=0) {
           throw new UtilitiesControlException("This is an invalid food count. You must purchase at least one food unit.");
       }

        InventoryItem playerMoney = player.getInventory()[GameControl.Item.money.ordinal()];
        InventoryItem playerFood = player.getInventory()[GameControl.Item.food.ordinal()];
        InventoryItem storeMoney = gameInventory[GameControl.Item.money.ordinal()];
        InventoryItem storeFood = gameInventory[GameControl.Item.food.ordinal()];
        int costOfFood = storeFood.getCost();
        int availableFood = storeFood.getQuantityInStock();
        // They do not have enough money
        if (costOfFood * foodCount > playerMoney.getQuantityInStock()) {
           throw new UtilitiesControlException("You do not have enough money for this purchase.");
            
        }
        // The store does not have enough inventory
        if (availableFood < foodCount) {
           throw new UtilitiesControlException("There are only " + availableFood + " food units available to purchase.");
            
        }

        // Make purchase
        storeFood.setQuantityInStock(availableFood - foodCount);
        playerFood.setQuantityInStock(playerFood.getQuantityInStock() + foodCount);   
        
        storeMoney.setQuantityInStock(storeMoney.getQuantityInStock() + (costOfFood * foodCount));
        playerMoney.setQuantityInStock(playerMoney.getQuantityInStock() - (costOfFood * foodCount));        
        
    }
    
 /**
     * author Mariam Erickson
     * @param gameInventory
     * @param player
     * @param purchaseQty
     * @throws UtilitiesControlException 
     */
    public static void purchaseInventoryItem(InventoryItem[] gameInventory, Player player, int purchaseQty) throws UtilitiesControlException {
        InventoryItem playerMoney = player.getInventory()[GameControl.Item.money.ordinal()];
        InventoryItem playerInventoryItem = player.getInventory()[GameControl.Item.oxen.ordinal()];
        InventoryItem storeMoney = gameInventory[GameControl.Item.money.ordinal()];
        InventoryItem storeInventoryItem = gameInventory[GameControl.Item.oxen.ordinal()];
        int itemCost = storeInventoryItem.getCost();
        int availableQty = storeInventoryItem.getQuantityInStock();

        if (purchaseQty <=0) {
           throw new UtilitiesControlException("This is an invalid amount. You must purchase at least one " + storeInventoryItem.getDescription());
       }
//        InventoryItem oxen = new InventoryItem();
//        oxen.setDescription("Oxen");
//        oxen.setQuantityInStock(30);
//        oxen.setRequiredAmount(2);
//        oxen.setCost(20);
//        oxen.setUnits("Each");
//        inventory[Item.oxen.ordinal()] = oxen;       

        // They do not have enough money
        if (itemCost * purchaseQty > playerMoney.getQuantityInStock()) {
           throw new UtilitiesControlException("You do not have enough money for this purchase.");
            
        }
        // The store does not have enough inventory
        if (availableQty < purchaseQty) {
           throw new UtilitiesControlException("There are only " + availableQty + " " + storeInventoryItem.getDescription() + " available to purchase.");
            
        }

        // Make purchase
        storeInventoryItem.setQuantityInStock(availableQty - purchaseQty);
        playerInventoryItem.setQuantityInStock(playerInventoryItem.getQuantityInStock() + purchaseQty);   
        
        storeMoney.setQuantityInStock(storeMoney.getQuantityInStock() + (itemCost * purchaseQty));
        playerMoney.setQuantityInStock(playerMoney.getQuantityInStock() - (itemCost * purchaseQty));        
    }
    
        
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
    public static int advanceAlongTheTrail(int currentLocation, int numOfDaysTraveled, int distanceFromNauvoo,
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
        if (distanceFromNauvoo < 0) { 
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
        if (distanceFromNauvoo > 100 && distanceFromNauvoo < 1000 && randomValue < 5) {
            return -9; //Wagon damage
        }	
        if (obstacle != null) {
            return -10; //Obstacle in your path
        }	
		//Show user current location description (found inside of scene object).
	double avgRequiredPace = (1300 - distanceFromNauvoo) / (26 - currentLocation);
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
    
    /*********************************************************
     * Calculating Resources Needed for group for the journey.
     * Laura Friedman
     * @param journeyTime
     * @param noPeople
     * @param minRequired
     * @param resourceType
     * @param qtyInStock
     * @return 
     *********************************************************/
            
    public int calcResourcesNeeded(int journeyTime, int noPeople, int minRequired, char resourceType, int qtyInStock) {

        int resourcesNeeded; //Resources needed for the group for the journey
        
        if (journeyTime < 100) { 
            return -1; //Journey Time is too low
        }	
        if (journeyTime > 365) { 
            return -2; //Journey Time is too high
        }	
        if (noPeople < 1) { 
            return -3; //Number of people is too low
        }	
        if (noPeople > 5) { 
            return -4; //Number of people is too high
        }	
        if (minRequired < 1) { 
            return -5; //Minimum supplies required is too low
        }	
        if (minRequired > 200) { 
            return -6; //Minimum supplies required is too high
        }
        if (resourceType != 'J'&& resourceType != 'D') {
            return -7; //Resource type does not equal Journey or Daily
        }	
        if (qtyInStock < 10) { 
            return -8; //Quantity in stock is too low
        }	
        if (qtyInStock > 365000) { 
            return -9; //Quantity in stock is too high
        }
        
        if (resourceType == 'J') {
            resourcesNeeded = minRequired * noPeople;
        }
        else {
            resourcesNeeded = journeyTime * minRequired * noPeople;
        }
        
        if (resourcesNeeded > qtyInStock) {
            return 0; //Not enough Quantity in Stock available
        }
        else {
            return resourcesNeeded;
        }
    }    
    
     /*********************************************************
     * Calculating Resources Needed for group for the journey.
     * Braden Harada
     * @param currentRow
     * @param currentColumn
     * @param nextStopRow
     * @param nextStopColumn
     * @return 
     *********************************************************/
    
    public int calcDistToNext(int currentRow, int currentColumn, int nextStopRow, int nextStopColumn) {
	int distToPoint;  // Distance to the next map point
        if ((currentRow  ==  nextStopRow) && (currentColumn  ==  nextStopColumn)) {
            return -1; //Current location cannot equal next stop coordinates
        }
        if (currentRow < 1) {
            return -2; //Current row cannot be less than 1
        }
        if (currentColumn < 1) {
            return -3; //Current column cannot be less than 1
        }
        if (nextStopRow < 1) {
            return -4; //Next stop row cannot be less than 1
        }
        if (nextStopColumn < 1) {
            return -5; //Next stop column cannot be less than 1
        }
        else return distToPoint = ((currentRow - nextStopRow) + (currentColumn - nextStopColumn)) * 46;
    }
    
    /*
     * @Laura
    */
    // sort inventory by maximum value
    public static InventoryItem[] doDescInventorySort(InventoryItem[] item) {
        for (int i = 0; i < item.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < item.length; j++)
                if (item[j].getQuantityInStock() > item[index].getQuantityInStock())
                    index = j;
      
            InventoryItem largerItem = item[index]; 
            item[index] = item[i];
            item[i] = largerItem;
        }
        return item;        
    }    
    
    // getting the maximum value
    public static InventoryItem getMaxInventoryItem(InventoryItem[] item) {
        int maxValue = item[0].getQuantityInStock();
        int arrayvalue = 0;
        for (int i = 1; i < item.length; i++) {
            if (item[i].getQuantityInStock() > maxValue) {
                maxValue = item[i].getQuantityInStock();
                arrayvalue = i;
            }
        }
        return item[arrayvalue];
    }    
    // getting the minimum value
    public static InventoryItem getMinInventoryItem(InventoryItem[] item) {
        int minValue = item[0].getQuantityInStock();
        int arrayvalue = 0;
        for (int i = 1; i < item.length; i++) {
            if (item[i].getQuantityInStock() < minValue) {
                minValue = item[i].getQuantityInStock();
                arrayvalue = i;
            }
        }
        return item[arrayvalue];
    }
    
    /*
     * @Laura
    */
    // get a single inventory item
    public static InventoryItem getInventoryItem(InventoryItem[] item, String singleItem)
                                    throws UtilitiesControlException {
        for (InventoryItem item1 : item) {
            if (item1.getDescription().equals(singleItem)) {
                return item1;
            }
        }
        throw new UtilitiesControlException("No " + singleItem + " Inventory in Stock");
    }
    
    /*
     * @Laura
     */
    // get a player inventory item
    public static InventoryItem getPlayerInventoryItem(InventoryItem[] item, String singleItem)
                                    throws UtilitiesControlException {
        for (InventoryItem item1 : item) {
            if (item1.getDescription().equals(singleItem)) {
                return item1;
            }
        }
        throw new UtilitiesControlException("No " + singleItem + " in Player's Inventory");
    }
}
