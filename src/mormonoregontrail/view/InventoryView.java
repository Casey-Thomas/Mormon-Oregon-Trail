/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormonoregontrail.view;

import java.util.Scanner;
import mormonoregontrail.MormonOregonTrail;
import mormonoregontrail.control.GameControl;

/**
 *
 * @author haradab
 */
public class InventoryView {
    
    private String promptMessage;
    private String menu;
    
    /**
     * InventoryView function
     */
    
    public InventoryView() {
        
        this.promptMessage = "\nPlease choose an option: ";
            
        this.menu = "\n"
                 + "\n------------------------------------------------"
                 + "\n|     Inventory Menu - See what you have...    |"
                 + "\n------------------------------------------------"
                 + "\nO - Oxen"
                 + "\nW - Spare Wheel(s)"
                 + "\nA - Spare Axle(s)"
                 + "\nT - Spare Tongue(s)"
                 + "\nB - Amount of Bullets"
                 + "\nF - Amount of Food (in pounds)"
                 + "\nM - Money"
                 + "\nQ - Quit"
                 + "\n------------------------------------------------";
    }
    
    public void displayInventoryView() {
        boolean done = false; // set flag to not done
        do {
            // prompt for and get players name
            String menuOption = this.getInventory();
            if (menuOption.toUpperCase().equals("Q")) // user wants to quit
                return; // exit the game
            
            // do the requested action and display the next view
            done = this.doAction(menuOption);
            
        } while (!done);
    }
    
    private String getInventory() {
        Scanner keyboard = new Scanner(System.in); // get infile for keyboard
        String value = ""; // value to be returned
        boolean valid = false; // initialize to not valid
        
        while (!valid) { // loop while an invalid value is entered
            System.out.println("\n" + this.menu);
            System.out.println("\n" + this.promptMessage);
            
            value = keyboard.nextLine(); // get next line typed on keyboard
            value = value.trim(); // trim off leading and trailing blanks
            
            if (value.length() < 1) { // value is blank
                System.out.println("\nInvalid value: value can not be blank");
                continue;
            }
            
            break; // end the loop
        }
        
        return value; // return the value entered
    }

    private boolean doAction(String choice) {
        choice = choice.toUpperCase(); // Converts input to upper case
        
        switch (choice) {
            case "O": // Quantity of Oxen
                this.oxen();
                break;
            case "W": // Quantity of wheels
                this.wheel();
                break;
            case "A": // Quantity of axles
                this.axle();
                break;
            case "T": // Quantity of tongues
                this.tongue();
                break;
            case "B": // Quantity of bullets
                this.bullets();
                break;
            case "F": // Quantity of food (in pounds)
                this.food();
                break;
            case "M": // Quantity of money
                this.money();
                break;
            default:
                System.out.println("\n**Invalid selection *** Try again.");
                break;
        }
        
        return false;
        
    }
    
    private void oxen() {
        System.out.println("\nThis function is not ready yet.");
    }
    
    private void wheel() {
        System.out.println("\nThis function is not ready yet.");
    }
    
    private void axle() {
        System.out.println("\nThis function is not ready yet.");
    }
    
    private void tongue() {
        System.out.println("\nThis function is not ready yet.");
    }
    
    private void bullets() {
        System.out.println("\nThis function is not ready yet.");
    }
    
    private void food() {
        System.out.println("\nThis function is not ready yet.");
    }
    
    private void money() {
        System.out.println("\nThis function is not ready yet.");
    }
    
}
