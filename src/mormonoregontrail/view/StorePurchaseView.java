/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormonoregontrail.view;

import java.util.Scanner;
import mormonoregontrail.MormonOregonTrail;
import mormonoregontrail.control.GameControl;
import mormonoregontrail.control.UtilitiesControl;
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
                 + "\nQ - Quit"
                 + "\n------------------------------------------------"
                 + "\nPlease choose an option: ");
    }
    
    @Override    
    public boolean doAction(String value) {
        value = value.toUpperCase(); // Converts input to upper case
        
        switch (value) {
            case "O": // Quantity of Oxen
                this.buyOxen();
                break;
            case "F": // Quantity of food
                this.buyFood();
                break;
            case "C": // Quantity of clothing
                this.buyClothes();
                break;
            case "B": // Quantity of bullets
                this.buyBullets();
                break;
            case "A": // Quantity of handcart/wagon axles
                this.buyAxles();
                break;
            case "W": // Quantity of handcart/wagon wheels
                this.buyWheels();
                break;
            case "T": // Quantity of handcart/wagon tongues
                this.buyTongues();
                break;
            default:
                System.out.println("\n**Invalid selection *** Try again.");
                break;
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
    
    private void buyClothes() {
        System.out.println("\n*** buyClothes function called ***");
    }
    
    private void buyBullets() {
        System.out.println("\n*** buyBullets function called ***");
    }
    
    private void buyAxles() {
        System.out.println("\n*** buyAxles function called ***");
    }
    
    private void buyWheels() {
        System.out.println("\n*** buyWheels function called ***");
    }
    
    private void buyTongues() {
        System.out.println("\n*** buyTongues function called ***");
    }
}
