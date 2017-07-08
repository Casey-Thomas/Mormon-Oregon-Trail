/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormonoregontrail.view;

import mormonoregontrail.MormonOregonTrail;
import mormonoregontrail.control.ReportControl;
import mormonoregontrail.model.InventoryItem;
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
    
}
