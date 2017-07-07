/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormonoregontrail.view;

import mormonoregontrail.MormonOregonTrail;
import mormonoregontrail.control.MapControl;
import static mormonoregontrail.control.UtilitiesControl.doDescInventorySort;
import static mormonoregontrail.control.UtilitiesControl.getMaxInventoryItem;
import static mormonoregontrail.control.UtilitiesControl.getMinInventoryItem;
import mormonoregontrail.exceptions.MapControlException;
import mormonoregontrail.model.Actor;
import mormonoregontrail.model.Game;
import mormonoregontrail.model.InventoryItem;
import mormonoregontrail.model.Location;
import mormonoregontrail.model.Map;

/**
 *
 * @author Team - stub function
 * @author Laura - full menu with completed and stub functions 6/17/2017
 */
public class GameMenuView extends View{
    
    /**
     * MainMenuView function
     */
    public GameMenuView() {            
        super("\n"
            + "\n------------------------------------------------"
            + "\n| Game Menu                                    |"
            + "\n------------------------------------------------"
            + "\nM - Show Map"
            + "\nL - View Current Location"
            + "\nE - View Scenes"
            + "\nI - Show Inventory"
            + "\nX - Show Inventory Item with Maximum Quantity In Stock"
            + "\nU - Show Inventory Item with Minimum Quantity In Stock"
            + "\nA - Show List of Actors"
            + "\nP - Purchase Items from Store"
            + "\nH - Hunt (Scavenge) for Supplies"
            + "\nO - Overcome an Obstacle"
            + "\nW - Wagon/Handcart Status"
            + "\nV - Verify Wagon or Cart can Function"
            + "\nF - Perform Maintenance (Fix)"
            + "\nG - Seek Spiritual Guidance"
            + "\nT - Advance Along the Trail"
            + "\nN - Estimate Resources Needed"
            + "\nQ - Quit"
            + "\n------------------------------------------------"
            + "\nPlease choose an option: ");
    }
    
    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase(); // convert choice to upper case
        
        switch (value) {
            case "M": // show the map
                this.showMap();
                break;
            case "L": // show distance traveled
                this.viewCurrentLocation();
                break;
            case "E": // show all scenes
                this.viewScenes();
                break;
            case "I": // show inventory
                this.viewInventory();
                break;
            case "X": // show item with maximum inventory
                this.viewMaxInventory();
                break;
            case "U": // show item with minimum inventory
                this.viewMinInventory();
                break;
            case "A": // show list of actors
                this.viewActors();
                break;
            case "P": // purchase items from the store
                this.displayPurchaseFromStoreMenu();
                break;
            case "H": // hunt (scavenge) for supplies
                this.huntForSupplies();
                break;
            case "O": // overcome an obstacle
                this.displayOvercomeObstacleMenu();
                break;
            case "W": // check the status of the wagon
                this.wagonStatus();
                break;
            case "V": // verify the wagon is functioning
                this.verifyWagonCanFunction();
                break;
            case "F": // perform wagon maintenance (fix)
                this.performMaintenance();
                break;
            case "G": // seek spiritual guidance
                this.seekSpiritualGuidance();
                break;
            case "T": // advance along the trail
                return this.advanceAlongTheTrail();
            case "N": // estimate resources needed
                this.displayResourcesNeeded();
                break;
            default:
                this.console.println("\n*** Invalid selection *** Try again");
                break;
        }
        
        return false;
    }

    private void showMap() {
        String leftIndicator;
        String rightIndicator;

        Game game = MormonOregonTrail.getCurrentGame(); // retreive the game
        Map map = game.getMap(); // retreive the map from game
        Location[][] locations = map.getLocations(); // retreive the locations from map
        
          // Game Title
          this.console.println("               MORMON OREGON TRAIL");
          // Build the heading of the map
          this.console.print("  |");
          for( int column = 0; column < locations[0].length; column++){
            // print col numbers to side of map
            if (column < 10)
                this.console.print("  " + column + " |");
            else
                this.console.print(" " + column + " |");
          }
          // Now build the map.  For each row, show the column information
          this.console.println();
          for( int row = 0; row < locations.length; row++){
           this.console.print(row + " "); // print row numbers to side of map
            for( int column = 0; column < locations[row].length; column++){
              // set default indicators as blanks
              leftIndicator = " ";
              rightIndicator = " ";
              if(locations[row][column] == map.getCurrentLocation()){
                // Set star indicators to show this is the current location.
                leftIndicator = "*"; 
                rightIndicator = "*"; 
              } 
              else if(locations[row][column].isVisited()){
                 // Set < > indicators to show this location has been visited.
                 leftIndicator = ">"; // can be stars or whatever these are indicators showing visited
                 rightIndicator = "<"; // same as above
              }
             this.console.print("|"); // start map with a |
              if(locations[row][column].getScene() == null)
              {
                   // No scene assigned here so use ?? for the symbol
                   this.console.print(leftIndicator + "??" + rightIndicator);
              }
              else
                this.console.print(leftIndicator
                   + locations[row][column].getScene().getMapSymbol()
                   + rightIndicator);
            }
           this.console.println("|");
          } 
          if (map.getCurrentLocation().getScene() != null)
              this.console.println("Your current location is: "
                + map.getCurrentLocation().getScene().getName()
                + "\nYou are " + map.getCurrentLocation().getScene().getDistanceFromNauvoo() + " miles from Nauvoo!"
                + "\n" + map.getCurrentLocation().getScene().getDescription()
                + "\nYou have " + (1300 - map.getCurrentLocation().getScene().getDistanceFromNauvoo()) + " miles to go!");
    }
    
    private void viewCurrentLocation(){
        Game game = MormonOregonTrail.getCurrentGame(); // retreive the game
        Map map = game.getMap(); // retreive the map from game
        
        int locationcount = (map.getCurrentLocation().getRow() + 1) * (map.getCurrentLocation().getColumn());
        
          if (map.getCurrentLocation().getScene() != null)
              this.console.println("Your current location is "
                + "(" + map.getCurrentLocation().getScene().getMapSymbol() + ") " + map.getCurrentLocation().getScene().getName()
                + " and you are " + map.getCurrentLocation().getScene().getDistanceFromNauvoo() + " miles from Nauvoo!"
                + "\n" + map.getCurrentLocation().getScene().getDescription()
                + "\n\nYou have also traveled to " + locationcount + " locations and have "
                + (1300 - map.getCurrentLocation().getScene().getDistanceFromNauvoo()) + " miles to go!");
          
    }

    private void viewScenes() {
        StringBuilder line;
        
        Game game = MormonOregonTrail.getCurrentGame(); // retrieve the game
        Map map = game.getMap(); // retrieve the map from the game
        Location[][] locations = map.getLocations(); // retrieve the locations from map
                       
        this.console.println("\n          LIST OF SCENES");
        line = new StringBuilder("                                                                                ");
        line.insert(0, "NAME");
        line.insert(30, "SYMBOL");
        line.insert(40, "BLOCKED");
        line.insert(50, "DIST. FROM NAUVOO");
        line.insert(70, "LOCATION");
        this.console.println(line.toString());
        
       // for each scene
       for (int row = 0; row < locations.length; row++) {
            for (int column = 0; column < locations[row].length; column++) {
                 if (locations[row][column].getScene() != null) {                      
                     line = new StringBuilder("                                                                                ");
                     line.insert(0, locations[row][column].getScene().getName());
                     line.insert(30, locations[row][column].getScene().getMapSymbol());
                     line.insert(40, locations[row][column].getScene().getBlocked());
                     line.insert(50, String.valueOf(locations[row][column].getScene().getDistanceFromNauvoo()));
                     if(row == 0){
                         line.insert(70, String.valueOf(((row + 1)*(column + 1))));
                     }
                     else {
                         line.insert(70, String.valueOf(((row * 13) + (column + 1))));
                     }
            
                     // Display the line
                     this.console.println(line.toString());
                 }
            }
       }
    }

    private void viewInventory() {
        StringBuilder line;
        
        Game game = MormonOregonTrail.getCurrentGame();
        InventoryItem[] inventory = game.getInventory();
                
        this.console.println("\n          LIST OF INVENTORY ITEMS");
        line = new StringBuilder("                                                                                ");
        line.insert(0, "DESCRIPTION");
        line.insert(20, "REQUIRED");
        line.insert(30, "IN STOCK");
        line.insert(40, "UNITS");
        line.insert(50, "COST");
        this.console.println(line.toString());
        
        // for each inventory item
        for (InventoryItem item : inventory) {
            line = new StringBuilder("                                                                                ");
            line.insert(0, item.getDescription());
            line.insert(20, String.valueOf(item.getRequiredAmount()));
            line.insert(30, String.valueOf(item.getQuantityInStock()));
            line.insert(40, item.getUnits());
            line.insert(50, String.valueOf(item.getCost()));
            
            // Display the line
            this.console.println(line.toString());
        }
    }

    // @Laura
    private void viewMaxInventory() {
        StringBuilder line;
        
        Game game = MormonOregonTrail.getCurrentGame(); // get the game
        InventoryItem[] inventory = game.getInventory(); // get the inventory list
                
        // Find the Maximum Value in the inventory list
        InventoryItem item = getMaxInventoryItem(inventory);     
        this.console.println("\nInventory Item with Max Quantity in Stock:"
                + "\nDescription: " + item.getDescription()
                + "\nQuanity In Stock: " + item.getQuantityInStock());
        
        // Sort the inventory items by quanity in stock in descending order
        InventoryItem[] sortedArray = doDescInventorySort(inventory);
        
        // Display a sorted list, in descending order
        this.console.println("\nLIST OF INVENTORY ITEMS BY QUANITY IN STOCK IN DESCENDING ORDER");
        line = new StringBuilder("                                                                                ");
        line.insert(0, "DESCRIPTION");
        line.insert(20, "REQUIRED");
        line.insert(30, "IN STOCK");
        line.insert(40, "UNITS");
        line.insert(50, "COST");
        this.console.println(line.toString());
        
        // for each inventory item
        for (InventoryItem sortedItem : sortedArray) {
            line = new StringBuilder("                                                                                ");
            line.insert(0, sortedItem.getDescription());
            line.insert(20, String.valueOf(sortedItem.getRequiredAmount()));
            line.insert(30, String.valueOf(sortedItem.getQuantityInStock()));
            line.insert(40, sortedItem.getUnits());
            line.insert(50, String.valueOf(item.getCost()));
            
            // Display the line
            this.console.println(line.toString());
        }
    }
    
    private void viewMinInventory() {
        Game game = MormonOregonTrail.getCurrentGame();
        InventoryItem[] inventory = game.getInventory();
        
        InventoryItem item = getMinInventoryItem(inventory);
        
        this.console.println("\nInventory Item with the Lowest Quantity in Stock:"
                + "\nDescription: " + item.getDescription()
                + "\nQuanity In Stock: " + item.getQuantityInStock()
                + "\nPlease re-order soon!");
    }
    
    private void viewActors() {
        StringBuilder line;
        
        Game game = MormonOregonTrail.getCurrentGame();
        Actor[] actor = game.getActor();
        
        this.console.println("\n          LIST OF ACTORS IN THE GAME");
        line = new StringBuilder("                                                                                ");
        line.insert(0, "NAME");
        line.insert(12, "DESCRIPTION");
        this.console.println(line.toString());
        
        // for each inventory item
        for (Actor oneactor : actor) {
            line = new StringBuilder("                                                                                ");
            line.insert(0, oneactor.getName());
            line.insert(12, oneactor.getDescription());            
            // Display the line
            this.console.println(line.toString());
        }
    }
    
    private void displayInventoryMenu() {
        InventoryMenuView inventoryMenuView = new InventoryMenuView();
        inventoryMenuView.display();
    }

    private void displayPurchaseFromStoreMenu() {
        StorePurchaseView storePurchaseView = new StorePurchaseView();
        storePurchaseView.display();
    }

    private void huntForSupplies() {
        this.console.println("\n*** huntForSupplies() function called ***");
    }

    private void displayOvercomeObstacleMenu() {
        HandleAnObstacleMenuView handleObstacleView = new HandleAnObstacleMenuView();
        handleObstacleView.display();
    }

    private void wagonStatus() {
        WagonOrHandcartStatusView wagonOrHandcartStatusView = new WagonOrHandcartStatusView();
        wagonOrHandcartStatusView.display();
    }

    private void verifyWagonCanFunction() {
        this.console.println("\n*** verifyWagonCanFunction() function called ***");
    }

    private void performMaintenance() {
        PerformMaintenanceView performMaintenanceView = new PerformMaintenanceView();
        performMaintenanceView.display();
    }

    private void seekSpiritualGuidance() {
        this.console.println("\n*** seekSpiritualGuidance() function called ***");
    }

    private boolean advanceAlongTheTrail() {
        Game game = MormonOregonTrail.getCurrentGame(); // retreive the game
        Map map = game.getMap(); // retreive the map from game

        int currentRow = map.getCurrentRow();
        int currentColumn = map.getCurrentColumn();
        
        // @Team - add try . .. catch - 6/28/2017
        if (currentColumn < 12) {
            try {
                MapControl.movePlayer(map, currentRow, currentColumn + 1);
            } catch (MapControlException me) {
                ErrorView.display(this.getClass().getName(), me.getMessage());
            }
        } 
        else {
            try {
                MapControl.movePlayer(map, currentRow + 1, 0);
            } catch (MapControlException me) {
                ErrorView.display(this.getClass().getName(), me.getMessage());
            }
        }    
        
        if (map.getCurrentRow() == 1 && map.getCurrentColumn() == 12) {
            this.console.println("You've arrived at the Salt Lake Valley!! "
                              + "\n The game is over! Thanks for playing . . .");
            return true;
        }
        // this is where we should go to a scene associated with the new location
        showMap();
        return false;
    }
    private void displayUserDirectionMenu() {
        UserDirectionMenuView userDirectionView = new UserDirectionMenuView();
        int location = 1;
        int daysTraveled = 1;
        userDirectionView.setLocation(location);
        userDirectionView.setDaysTraveled(daysTraveled);
        userDirectionView.display();
        location = userDirectionView.getLocation();
        daysTraveled = userDirectionView.getDaysTraveled();
    }

    private void displayResourcesNeeded() {
        ResourcesNeededView resourcesNeededView = new ResourcesNeededView();
        resourcesNeededView.displayResourcesNeededView();
    }

    
}
