/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormonoregontrail.view;

import mormonoregontrail.MormonOregonTrail;
import mormonoregontrail.control.GameControl;
import mormonoregontrail.control.UtilitiesControl;
import static mormonoregontrail.control.UtilitiesControl.getInventoryItem;
import static mormonoregontrail.control.UtilitiesControl.getPlayerInventoryItem;
import mormonoregontrail.exceptions.UtilitiesControlException;
import mormonoregontrail.model.Game;
import mormonoregontrail.model.InventoryItem;
import mormonoregontrail.model.Player;

/**
 *
 * @author Braden
 */
public class StorePurchaseView extends View{
    
    /**
     * Store Purchase function
     */
    
    public StorePurchaseView() {
        
        super("\n"
                 + "\n------------------------------------------------"
                 + "\n|   Purchase Menu - See what you can buy...    |"
                 + "\n------------------------------------------------"
                 + "\nO - Buy oxen"
                 + "\nF - Buy food"
                 + "\nC - Buy clothing"
                 + "\nB - Buy bullets"
                 + "\nA - Buy handcart/wagon axles"
                 + "\nW - Buy handcart/wagon wheels"
                 + "\nT - Buy handcart/wagon tongues"
                 + "\nG - Buy Wagon"
                 + "\nH - Buy Handcart"
                 + "\nQ - Quit"
                 + "\n------------------------------------------------"
                 + "\nPlease choose an option: ");
        
    }
    
    @Override    
    public boolean doAction(String value) {
        try {
            value = value.toUpperCase(); // Converts input to upper case
            
            switch (value) {
               case "O": // Quantity of Oxen
                   this.buyOxen();
                    break;
               case "F": // Quantity of food
                   this.buyFood();
                    break;
               case "C": // Quantity of clothing
                    this.buyItem("Clothing");
                    break;
                case "B": // Quantity of bullets
                    this.buyItem("Bullets");
                    break;
               case "A": // Quantity of handcart/wagon axles
                    this.buyItem("Axles");
                    break;
                case "W": // Quantity of handcart/wagon wheels
                    this.buyItem("Wheels");
                    break;
                case "T": // Quantity of handcart/wagon tongues
                    this.buyItem("Tongues");
                    break;
                case "G": // Quantity of Wagons
                    this.buyItem("Wagons");
                    break;
                case "H": // Quantity of Oxen
                    this.buyItem("Handcarts");
                    break;
                default:
                    this.console.println("\n**Invalid selection *** Try again.");
                    break;
            }
        } catch (UtilitiesControlException ex) {
            ErrorView.display(this.getClass().getName(), 
                    "Error Reading Input: " + ex.getMessage());
        }
        return false;
    }
    
    /**
     * author Mariam Erickson
     */
    private void buyOxen() {
        String value = ""; // value to be returned

        Game game = MormonOregonTrail.getCurrentGame();

        InventoryItem[] gameInventory = game.getInventory();
        Player player = game.getPlayer();
        
        InventoryItem money = player.getInventory()[GameControl.Item.money.ordinal()];
        InventoryItem oxen = player.getInventory()[GameControl.Item.oxen.ordinal()];
        if (oxen == null)
        {
            oxen = new InventoryItem();
            oxen.setDescription("Oxen");
            oxen.setQuantityInStock(0);  // we start with 0 food
            player.getInventory()[GameControl.Item.oxen.ordinal()] = oxen;
        }
        
        this.console.println("\nYou have " + oxen.getQuantityInStock() + " oxen.  You have $" + money.getQuantityInStock());
        this.console.println("There are "+ gameInventory[GameControl.Item.oxen.ordinal()].getQuantityInStock() + " oxen available.  They cost $" +
                gameInventory[GameControl.Item.oxen.ordinal()].getCost() + " each.");
        this.console.println("\nHow many oxen would you like to purchase (Enter '0' quit)?");
        boolean valid = false;
        int oxenCount = 0;
        try {
            while(!valid) {
                value = keyboard.readLine(); // get next line typed on keyboard
                try {
                    //parse and convert keyboard input to an integer
                    oxenCount = Integer.parseInt(value);
                    valid = true;
                    if (oxenCount == 0)
                        return;
                } catch (NumberFormatException nf) {

                    ErrorView.display(this.getClass().getName(), 
                            "Invalid Oxen Amoount: " + nf.getMessage());
                }
                break; // end the loop
            }
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(), 
                    "Error Reading Input: " + e.getMessage());
        }
       try {
            UtilitiesControl.purchaseOxen(gameInventory, player, oxenCount);
            this.console.println("You have purchased " + oxenCount + " oxen.");
            
       } catch (UtilitiesControlException uce) {
            ErrorView.display(this.getClass().getName(), 
                    "Error Reading Input: " + uce.getMessage());
       }
    }
    
    /**
     * author Mariam Erickson
     */
    private void buyFood() {
        String value = ""; // value to be returned
        
        Game game = MormonOregonTrail.getCurrentGame();

        InventoryItem[] gameInventory = game.getInventory();
        Player player = game.getPlayer();
        
        InventoryItem money = player.getInventory()[GameControl.Item.money.ordinal()];
        InventoryItem food = player.getInventory()[GameControl.Item.food.ordinal()];
        if (food == null)
        {
            food = new InventoryItem();
            food.setDescription("Food");
            food.setQuantityInStock(0);  // we start with 0 food
            player.getInventory()[GameControl.Item.food.ordinal()] = food;
        }
        
        this.console.println("\nYou have " + food.getQuantityInStock() + " food.  You have $" + money.getQuantityInStock());
        this.console.println("There are "+gameInventory[GameControl.Item.food.ordinal()].getQuantityInStock() +
                " units of food available.  They cost $" +
                gameInventory[GameControl.Item.food.ordinal()].getCost() + " each.");
        this.console.println("\nHow much food would you like to purchase (Enter '0' quit)?");
        boolean valid = false;
        int foodCount = 0;
        try {
            while(!valid) {

                value = keyboard.readLine(); // get next line typed on keyboard
                try {
                    //parse and convert keyboard input to an integer
                    foodCount = Integer.parseInt(value);
                    valid = true;
                    if (foodCount == 0)
                        return;
                } catch (NumberFormatException nf) {

                    ErrorView.display(this.getClass().getName(), 
                            "Invalid Food Unit Count: " + nf.getMessage());
                }
                break; // end the loop
            }
        } catch(Exception e) {
            ErrorView.display(this.getClass().getName(), 
                    "Error Reading Input: " + e.getMessage());
        }
       try {
            UtilitiesControl.purchaseFood(gameInventory, player, foodCount);
            this.console.println("You have purchased " + foodCount + " units of food.");
            
       } catch (UtilitiesControlException uce) {
            ErrorView.display(this.getClass().getName(), 
                    "Error Reading Input: " + uce.getMessage());
       }
            
    }
    
    private void buyItem(String singleItem) throws UtilitiesControlException {        
        StringBuilder line;
        String itemAmount = "";
        boolean valid = false; // initialize to not valid
        int amount = 0;
        
        Game game = MormonOregonTrail.getCurrentGame(); // get the game
        InventoryItem[] inventory = game.getInventory(); // get the inventory list
        
        this.console.println("\n          AMOUNT OF " + singleItem.toUpperCase() + " IN INVENTORY");
        // Find the Maximum Value in the inventory list
        InventoryItem item = getInventoryItem(inventory, singleItem);
        
        /***********************************************************************
         *  This displays the current status of the selected inventory item.
         **********************************************************************/
        
        // Display the status of the selected inventory item
        this.console.println("\nSTORE INVENTORY STATUS OF " + item.getDescription());
        line = new StringBuilder("                                                                                ");
        line.insert(0, "DESCRIPTION");
        line.insert(20, "REQUIRED");
        line.insert(30, "IN STOCK");
        line.insert(40, "UNITS");
        line.insert(50, "COST");
        this.console.println(line.toString());
        
        // display the selected inventory item
        line = new StringBuilder("                                                                                ");
        line.insert(0, item.getDescription());
        line.insert(20, String.valueOf(item.getRequiredAmount()));
        line.insert(30, String.valueOf(item.getQuantityInStock()));
        line.insert(40, item.getUnits());
        line.insert(50, String.valueOf(item.getCost()));
        
        Player player = game.getPlayer(); // get the player object
        InventoryItem[] playerInventory = player.getInventory(); // get the player's inventory
        
        // Get the Inventory Item for the player
        InventoryItem money = playerInventory[GameControl.Item.money.ordinal()];
        InventoryItem playerItem = getPlayerInventoryItem(playerInventory, singleItem);
        
        try{
            while (!valid) {
                
                // Display the line
                this.console.println(line.toString());
            
                /***********************************************************************
                *  This prompts the player to purchase inventory items.
                **********************************************************************/
        
                this.console.println("Enter the amount of " + item.getDescription() + " you wish to purchase: ");
        
                itemAmount = keyboard.readLine();
                itemAmount = itemAmount.trim();
                
                if (itemAmount.length() < 1) { // value is blank
                    this.console.println("\nInvalid value: value cannot be blank");
                    continue;
                }
            break;
            }
        
        } catch(Exception e) {
            ErrorView.display(this.getClass().getName(), 
                    "Error Reading Input: " + e.getMessage());
        }
                
        try {
            amount = Integer.parseInt(itemAmount);
            if (amount > item.getQuantityInStock()){
                this.console.println("\nError: You cannot purchase an amount greater than current quantity in stock!");
            } else {
                this.console.println("\n Congratulations! You purchased " + itemAmount + " " 
                    + item.getDescription() + " from inventory.");
            }
        } catch (NumberFormatException nf) {
            ErrorView.display(this.getClass().getName(), 
                    "Error Reading Input: " + nf.getMessage()
                  + "\n Please try to make another purchase or 'Q' to Quit.");
        }
    }  
}