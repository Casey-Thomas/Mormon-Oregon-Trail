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
public class StorePurchaseView {
    
    private String promptMessage;
    private String menu;
    
    /**
     * Store Purchase function
     */
    
    public StorePurchaseView() {
        
        this.promptMessage = "\nPlease choose an option: ";
                
        this.menu = "\n"
                 + "\n------------------------------------------------"
                 + "\n|   Purchase Menu - See what you can buy...    |"
                 + "\n------------------------------------------------"
                 + "\nO - Buy oxen"
                 + "\nF - Buy food"
                 + "\nC - Buy clothing"
                 + "\nB - Buy bullets"
                 + "\nP - Buy spare parts"
                 + "\nQ - Quit"
                 + "\n------------------------------------------------";
    }
    
    public void displayStorePurchaseView() {
        boolean done = false; // set flag to not done
        do {
            // prompt for and get players name
            String menuOption = this.getPurchasing();
            if (menuOption.toUpperCase().equals("Q")) // user wants to quit
                return; // exit the game
            
            // do the requested action and display the next view
            done = this.doAction(menuOption);
            
        } while (!done);
    }
    
    private String getPurchasing() {
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
                this.buyOxen();
                break;
            case "W": // Quantity of wheels
                this.buyFood();
                break;
            case "A": // Quantity of axles
                this.buyClothes();
                break;
            case "T": // Quantity of tongues
                this.buyBullets();
                break;
            case "B": // Quantity of bullets
                this.buySpareParts();
                break;
            default:
                System.out.println("\n**Invalid selection *** Try again.");
                break;
        }
        
        return false;
        
    }
    
    private void buyOxen() {
        System.out.println("\nThis function is not ready yet.");
    }
    
    private void buyFood() {
        System.out.println("\nThis function is not ready yet.");
    }
    
    private void buyClothes() {
        System.out.println("\nThis function is not ready yet.");
    }
    
    private void buyBullets() {
        System.out.println("\nThis function is not ready yet.");
    }
    
    private void buySpareParts() {
        System.out.println("\nThis function is not ready yet.");
    }
}
