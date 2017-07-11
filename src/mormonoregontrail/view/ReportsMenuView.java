/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormonoregontrail.view;

import mormonoregontrail.MormonOregonTrail;
import mormonoregontrail.control.ReportControl;
import mormonoregontrail.control.UtilitiesControl;
import mormonoregontrail.exceptions.ReportControlException;
import mormonoregontrail.model.Game;
import mormonoregontrail.model.InventoryItem;
import mormonoregontrail.model.Location;
import mormonoregontrail.model.Map;
import mormonoregontrail.model.Player;

/**
 *
 * @author Laura
 */
class ReportsMenuView extends View{
    
    /**
     * ManageInventoryView function
     */
    public ReportsMenuView() {            
        super("\n"
            + "\n------------------------------------------------"
            + "\n| Reports Menu                                 |"
            + "\n------------------------------------------------"
            + "\nI - Print Player Inventory"
            + "\nT - Print Store Inventory"
            + "\nS - Print Scenes"
            + "\nQ - Quit"
            + "\n------------------------------------------------"
            + "\nPlease choose an option: ");
    }
    
    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase(); // convert choice to upper case
        
        switch (value) {
            case "I": // show the map
                this.printPlayerInventory();
                break;
            case "T": // show all actors
                this.printStoreInventory();
                break;
            case "S": // show all scenes
                this.printScenes();
                break;
            default:
                this.console.println("\n*** Invalid selection *** Try again");
                break;
        }
        
        return false;
    }
    
    // @Laura
    private void printPlayerInventory() {
        StringBuilder line;
        
        Player player = MormonOregonTrail.getPlayer();
        InventoryItem[] playerInventory = player.getInventory();
                
        this.console.println("\n     LIST OF PLAYER INVENTORY ITEMS");
        line = new StringBuilder("                                                                                ");
        line.insert(0, "DESCRIPTION");
        line.insert(20, "REQUIRED");
        line.insert(30, "IN STOCK");
        line.insert(40, "UNITS");
        line.insert(50, "COST");
        this.console.println(line.toString());
        
        // for each inventory item
        for (InventoryItem item : playerInventory) {
            line = new StringBuilder("                                                                                ");
            line.insert(0, item.getDescription());
            line.insert(20, String.valueOf(item.getRequiredAmount()));
            line.insert(30, String.valueOf(item.getQuantityInStock()));
            line.insert(40, item.getUnits());
            line.insert(50, String.valueOf(item.getCost()));
            
            // Display the line
            this.console.println(line.toString());
        }
        String savePrompt = promptMessage;
        
        // prompt for and get the name of the file to save the game in        
        promptMessage = "\n*** TO PRINT THIS REPORT, PLEASE ENTER A FILE NAME (or type 'Q' to Quit): ";
        
        String fileName = this.getInput();
        if (fileName.toUpperCase().equals("Q")) { // user wants to quit
            promptMessage = savePrompt;
            return; // exit the view
        }
        
        try {
            // save the game to the specified file
            ReportControl.playerInventoryReport(MormonOregonTrail.getCurrentGame().getPlayer(), fileName);
        } catch (Exception ex) {
            ErrorView.display("ReportsMenuView", ex.getMessage());
        }
        promptMessage = savePrompt;        
        
    }
    
    /**
     * author Braden
     */
    private void printStoreInventory() {
        StringBuilder line;
        
        Game game = MormonOregonTrail.getCurrentGame(); // retrieve the game
        InventoryItem[] storeInventory = game.getInventory();
                
        this.console.println("\n     LIST OF STORE INVENTORY ITEMS");
        line = new StringBuilder("                                                                                ");
        line.insert(0, "DESCRIPTION");
        line.insert(20, "REQUIRED");
        line.insert(30, "IN STOCK");
        line.insert(40, "UNITS");
        line.insert(50, "COST");
        this.console.println(line.toString());
        
        // for each inventory item
        for (InventoryItem item : storeInventory) {
            line = new StringBuilder("                                                                                ");
            line.insert(0, item.getDescription());
            line.insert(20, String.valueOf(item.getRequiredAmount()));
            line.insert(30, String.valueOf(item.getQuantityInStock()));
            line.insert(40, item.getUnits());
            line.insert(50, String.valueOf(item.getCost()));
            
            // Display the line
            this.console.println(line.toString());
        }
        String savePrompt = promptMessage;
        
        // prompt for and get the name of the file to save the game in        
        promptMessage = "\n*** TO PRINT THIS REPORT, PLEASE ENTER A FILE NAME (or type 'Q' to Quit): ";
        
        String fileName = this.getInput();
        if (fileName.toUpperCase().equals("Q")) { // user wants to quit
            promptMessage = savePrompt;
            return; // exit the view
        }
        
        try {
            // save the game to the specified file
            ReportControl.storeInventoryReport(MormonOregonTrail.getCurrentGame().getPlayer(), fileName);
        } catch (ReportControlException ex) {
            ErrorView.display("ReportsMenuView", ex.getMessage());
        }
        promptMessage = savePrompt;
    }

    /**
     * author Mariam E.
     */
    private void printScenes() {
        StringBuilder line;
        
        Game game = MormonOregonTrail.getCurrentGame(); // retrieve the game
        Map map = game.getMap(); // retrieve the map from the game
        Location[][] locations = map.getLocations(); // retrieve the locations from map
                       
        this.console.println("\n          LIST OF SCENES");
        line = new StringBuilder("                                                                                ");
        line.insert(0, "NAME");
        line.insert(30, "SYMBOL");
        line.insert(40, "LOCATION");
        line.insert(53, "VISITED");
        line.insert(65, "DIST. FROM NAUVOO");
        this.console.println(line.toString());
        
       // for each scene
       for (int row = 0; row < locations.length; row++) {
            for (int column = 0; column < locations[row].length; column++) {
                 if (locations[row][column].getScene() != null) {                      
                     line = new StringBuilder("                                                                                ");
                     line.insert(0, locations[row][column].getScene().getName());
                     line.insert(30, locations[row][column].getScene().getMapSymbol());
                     if(row == 0){
                         line.insert(40, String.valueOf(((row + 1)*(column + 1))));
                     }
                     else {
                         line.insert(40, String.valueOf(((row * 13) + (column + 1))));
                     }                     
                    line.insert(53, locations[row][column].getVisited());
                    line.insert(65, String.valueOf(locations[row][column].getScene().getDistanceFromNauvoo()));
 
                     // Display the line
                     this.console.println(line.toString());
                 }
            }
       }
       
         String savePrompt = promptMessage;
        
        // prompt for and get the name of the file to save the game in        
        promptMessage = "\n*** TO PRINT THIS REPORT, PLEASE ENTER A FILE NAME (or type 'Q' to Quit): ";
        
        String fileName = this.getInput();
        if (fileName.toUpperCase().equals("Q")) { // user wants to quit
            promptMessage = savePrompt;
            return; // exit the view
        }
        
        exportScenesToFile(map, fileName);

        promptMessage = savePrompt;        
      
    }

    /**
     * author Mariam E.
     * @param fileName 
     */
    private void exportScenesToFile(Map map, String fileName) {
        try {
            // save the game to the specified file
            boolean success = ReportControl.sceneReport(map, fileName); 
            if (success)
                this.console.println("\n     Your file was successfully saved.");
        } catch (Exception ex) {
            ErrorView.display("ReportsMenuView", ex.getMessage());
        }
   
    }
}
