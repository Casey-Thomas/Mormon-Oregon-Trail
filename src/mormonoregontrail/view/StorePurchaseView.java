/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormonoregontrail.view;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import mormonoregontrail.MormonOregonTrail;
import mormonoregontrail.control.GameControl;
import mormonoregontrail.control.UtilitiesControl;
import static mormonoregontrail.control.UtilitiesControl.getInventoryItem;
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
                    System.out.println("\n**Invalid selection *** Try again.");
                    break;
            }
        } catch (UtilitiesControlException ex) {
            Logger.getLogger(StorePurchaseView.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    /**
     * author Mariam Erickson
     */
    private void buyOxen() {
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
        
        System.out.println("\nYou have " + oxen.getQuantityInStock() + " oxen.  You have $" + money.getQuantityInStock());
        System.out.println("There are "+gameInventory[GameControl.Item.oxen.ordinal()].getQuantityInStock() + " oxen available.  They cost $" +
                gameInventory[GameControl.Item.oxen.ordinal()].getCost() + " each.");
        System.out.println("\nHow many oxen would you like to purchase (Enter '0' quit)?");
        boolean valid = false;
        int oxenCount = 0;
        Scanner keyboard = new Scanner(System.in); // get infile for keyboard
        while(! valid) {
         
            String value = ""; // value to be returned
            value = keyboard.nextLine(); // get next line typed on keyboard
            try {
                //parse and convert keyboard input to an integer
                oxenCount = Integer.parseInt(value);
                valid = true;
                if (oxenCount == 0)
                    return;
            } catch (NumberFormatException nf) {
                
                System.out.println("Enter a valid oxen amount.");
            }
        }
       try {
            UtilitiesControl.purchaseOxen(gameInventory, player, oxenCount);
            System.out.println("You have purchased " + oxenCount + " oxen.");
            
       } catch (UtilitiesControlException uce) {
            System.out.println(uce.getMessage());           
       }
    }
    
    /**
     * author Mariam Erickson
     */
    private void buyFood() {
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
        
        System.out.println("\nYou have " + food.getQuantityInStock() + " food.  You have $" + money.getQuantityInStock());
        System.out.println("There are "+gameInventory[GameControl.Item.food.ordinal()].getQuantityInStock() +
                " units of food available.  They cost $" +
                gameInventory[GameControl.Item.food.ordinal()].getCost() + " each.");
        System.out.println("\nHow much food would you like to purchase (Enter '0' quit)?");
        boolean valid = false;
        int foodCount = 0;
        Scanner keyboard = new Scanner(System.in); // get infile for keyboard
        while(! valid) {
         
            String value = ""; // value to be returned
            value = keyboard.nextLine(); // get next line typed on keyboard
            try {
                //parse and convert keyboard input to an integer
                foodCount = Integer.parseInt(value);
                valid = true;
                if (foodCount == 0)
                    return;
            } catch (NumberFormatException nf) {
                
                System.out.println("Enter a valid food unit count.");
            }
        }
       try {
            UtilitiesControl.purchaseFood(gameInventory, player, foodCount);
            System.out.println("You have purchased " + foodCount + " units of food.");
            
       } catch (UtilitiesControlException uce) {
            System.out.println(uce.getMessage());           
       }
            
    }
    
    private void buyItem(String singleItem) throws UtilitiesControlException {        
        Scanner keyboard = new Scanner(System.in);
        StringBuilder line;
        String itemAmount;
        
        Game game = MormonOregonTrail.getCurrentGame(); // get the game
        InventoryItem[] inventory = game.getInventory(); // get the inventory list
        
        System.out.println("\n          AMOUNT OF " + singleItem.toUpperCase() + " IN INVENTORY");
        // Find the Maximum Value in the inventory list
        InventoryItem item = getInventoryItem(inventory, singleItem);
        
        /***********************************************************************
         *  This displays the current status of the selected inventory item.
         **********************************************************************/
        
        // Display the status of the selected inventory item
        System.out.println("\nINVENTORY STATUS OF " + item.getDescription());
        line = new StringBuilder("                                                                                ");
        line.insert(0, "DESCRIPTION");
        line.insert(20, "REQUIRED");
        line.insert(30, "IN STOCK");
        line.insert(40, "UNITS");
        line.insert(50, "COST");
        System.out.println(line.toString());
        
        // display the selected inventory item
        line = new StringBuilder("                                                                                ");
        line.insert(0, item.getDescription());
        line.insert(20, String.valueOf(item.getRequiredAmount()));
        line.insert(30, String.valueOf(item.getQuantityInStock()));
        line.insert(40, item.getUnits());
        line.insert(50, String.valueOf(item.getCost()));
            
        // Display the line
        System.out.println(line.toString());
            
        /***********************************************************************
         *  This prompts the player to purchase inventory items.
         **********************************************************************/
        
        System.out.println("Enter the amount of " + item.getDescription() + " you wish to purchase: ");
        
        int amount = 0;
        
        itemAmount = keyboard.nextLine();
        itemAmount = itemAmount.trim();
                
        try {
            amount = Integer.parseInt(itemAmount);
            if (amount > item.getQuantityInStock()){
                System.out.println("\nError: You cannot purchase an amount greater than current quantity in stock!");
            } else {
                System.out.println("\n Congratulations! You purchased " + itemAmount + " " 
                    + item.getDescription() + " from inventory.");
            }
        } catch (NumberFormatException nf) {
            System.out.println("\nINPUT ERROR: You must enter a valid number of " + item.getDescription() + " to purchase."
                    + " Please try to make another purchase or 'Q' to Quit.");
        }
    }  
}