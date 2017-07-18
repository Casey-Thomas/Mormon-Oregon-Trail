/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormonoregontrail.view;

import java.util.Random;
import mormonoregontrail.MormonOregonTrail;
import mormonoregontrail.control.GameControl;
import mormonoregontrail.control.MapControl;
import static mormonoregontrail.control.UtilitiesControl.getPlayerInventoryItem;
import mormonoregontrail.exceptions.MapControlException;
import mormonoregontrail.model.Actor;
import mormonoregontrail.model.Game;
import mormonoregontrail.model.InventoryItem;
import mormonoregontrail.model.Location;
import mormonoregontrail.model.Map;
import mormonoregontrail.model.Obstacle;
import mormonoregontrail.model.Player;
import mormonoregontrail.model.Scene;

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
            + "\nT - Advance Along the Trail"
            + "\nL - View Current Location"
            + "\nI - Manage Inventory"
            + "\nA - Show List of Actors"
            + "\nH - Hunt (Scavenge) for Supplies"
            + "\nW - Wagon/Handcart Status"
            + "\nV - Verify Wagon or Cart can Function"
            + "\nF - Perform Maintenance (Fix)"
            + "\nR - Reports"
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
            case "T": // advance along the trail
                return this.advanceAlongTheTrail();
            case "L": // show distance traveled
                this.viewCurrentLocation();
                break;
            case "I": // show inventory
                this.displayManageInventoryMenu();
                break;
            case "A": // show list of actors
                this.viewActors();
                break;
            case "H": // hunt (scavenge) for supplies
                this.huntForSupplies();
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
            case "R": // show inventory
                this.displayReportsMenu();
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
        game.setSeenMap(true);
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

    private void displayManageInventoryMenu() {
        ManageInventoryMenuView manageInventoryMenuView = new ManageInventoryMenuView();
        manageInventoryMenuView.display();
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

    private boolean advanceAlongTheTrail(){
        Game game = MormonOregonTrail.getCurrentGame(); // retreive the game
        
        // Check to see if the player has purchased inventory supplies from the store
        Player player = game.getPlayer(); // get the player object
        InventoryItem[] playerInventory = player.getInventory(); // get the player's inventory
        InventoryItem playerMoney = playerInventory[GameControl.Item.money.ordinal()];        
        if (playerMoney.getCost() == 0){
            this.console.println("\nYou haven't purchased any supplies from the store yet."
                    + "\n Please go the Manage Inventory menu to purchase your supplies.");
            return false;
        }
        
        Map map = game.getMap(); // retreive the map from game

        int currentRow = map.getCurrentRow();
        int currentColumn = map.getCurrentColumn();
        
        if(game.isSeenMap() == false)
        {
            showMap();
            return false;
        }
        
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
        Location currentLocation=map.getCurrentLocation();
        Scene currentScene=currentLocation.getScene();
        Obstacle currentObstacle=currentScene.getObstacle();
        if (currentObstacle != null) {
            
            Random rand = new Random();
            int randomValue = rand.nextInt(100);
            if(randomValue < currentObstacle.getPossibilityOfHappening()) {
              this.console.println("****"+ currentObstacle.getDescription());
              int randomDeath = rand.nextInt(100);
              if(randomDeath < currentObstacle.getPossibilityOfDeath()) {
                this.console.println("**** Sorry, but you died.");
                MormonOregonTrail.setPlayerDeath(currentObstacle.getDescription());
                MormonOregonTrail.setPlayerIsDead(true);
                return true;
              }
              if (currentObstacle.isAllowSpiritualGuidance()) {
                  HandleAnObstacleMenuView handleObstacle = new HandleAnObstacleMenuView();
                  handleObstacle.display();
              }
            }
        }
        return false;
    }
//    private void displayUserDirectionMenu() {
//        UserDirectionMenuView userDirectionView = new UserDirectionMenuView();
//        int location = 1;
//        int daysTraveled = 1;
//        userDirectionView.setLocation(location);
//        userDirectionView.setDaysTraveled(daysTraveled);
//        userDirectionView.display();
//        location = userDirectionView.getLocation();
//        daysTraveled = userDirectionView.getDaysTraveled();
//    }
//

    private void displayReportsMenu() {
        ReportsMenuView reportsMenuView = new ReportsMenuView();
        reportsMenuView.display();
    }
}
