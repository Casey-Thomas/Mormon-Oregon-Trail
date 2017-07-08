/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormonoregontrail.view;

import mormonoregontrail.MormonOregonTrail;
import static mormonoregontrail.control.UtilitiesControl.doDescInventorySort;
import static mormonoregontrail.control.UtilitiesControl.getMaxInventoryItem;
import static mormonoregontrail.control.UtilitiesControl.getMinInventoryItem;
import mormonoregontrail.model.Game;
import mormonoregontrail.model.InventoryItem;
import mormonoregontrail.model.Player;

/**
 *
 * @author Laura
 */
public class ManageInventoryMenuView extends View{
    
    /**
     * ManageInventoryView function
     */
    public ManageInventoryMenuView() {            
        super("\n"
            + "\n------------------------------------------------"
            + "\n| Manage Inventory Menu                        |"
            + "\n------------------------------------------------"
            + "\nI - Show Player Inventory"
            + "\nS - Show Store Inventory"
            + "\nX - Show Store Inventory Item with Maximum Quantity In Stock"
            + "\nM - Show Store Inventory Item with Minimum Quantity In Stock"
            + "\nP - Purchase Items from Store"                
            + "\nE - Estimate Resources Needed"
            + "\nQ - Quit"
            + "\n------------------------------------------------"
            + "\nPlease choose an option: ");
    }
    
    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase(); // convert choice to upper case
        
        switch (value) {
            case "I": // show the map
                this.viewPlayerInventory();
                break;
            case "S": // show inventory
                this.viewInventory();
                break;
            case "X": // show item with maximum inventory
                this.viewMaxInventory();
                break;
            case "M": // show item with minimum inventory
                this.viewMinInventory();
                break;
            case "P": // purchase items from the store
                this.displayPurchaseFromStoreMenu();
                break;
            case "E": // estimate resources needed
                this.displayResourcesNeeded();
                break;
            default:
                this.console.println("\n*** Invalid selection *** Try again");
                break;
        }
        
        return false;
    }
    
    // @Laura
    private void viewPlayerInventory() {
        StringBuilder line;
        
        Player player = MormonOregonTrail.getPlayer();
        InventoryItem[] playerInventory = player.getInventory();
                
        this.console.println("\n     LIST OF PLAYER NVENTORY ITEMS");
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
    }

    // @Laura
    private void viewInventory() {
        StringBuilder line;
        
        Game game = MormonOregonTrail.getCurrentGame();
        InventoryItem[] inventory = game.getInventory();
                
        this.console.println("\n    LIST OF STORE INVENTORY ITEMS");
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
    
    private void displayPurchaseFromStoreMenu() {
        StorePurchaseView storePurchaseView = new StorePurchaseView();
        storePurchaseView.display();
    }

    private void displayResourcesNeeded() {
        ResourcesNeededView resourcesNeededView = new ResourcesNeededView();
        resourcesNeededView.displayResourcesNeededView();
    }
}
