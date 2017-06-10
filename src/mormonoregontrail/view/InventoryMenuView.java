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
 * @author Laura
 */
public class InventoryMenuView {

    private String menu;
    private String promptMessage;
    
    /**
     * HandleAnObstacleMenuView function
     */
    public InventoryMenuView() {
        
        this.promptMessage = "\nPlease choose an option: ";
            
        this.menu = "\n"
                 + "\n------------------------------------------------"
                 + "\n| View Inventory Menu                          |"
                 + "\n------------------------------------------------"
                 + "\nO - Oxen"
                 + "\nW - Wheels for handcart/wagon"
                 + "\nA - Axles for handcart/wagon"
                 + "\nT - Tongue for handcart/wagon"
                 + "\nB - Bullets"
                 + "\nF - Food (in pounds)"
                 + "\nQ - Quit"
                 + "\n------------------------------------------------";
    }
    
    public void displayInventoryMenuView() {
        boolean done = false; // set flag to not done
        do {
            // prompt for and get players name
            String menuOption = this.getMenuOption();
            if (menuOption.toUpperCase().equals("Q")) // user wants to quit
                return; // exit the game
            
            // do the requested action and display the next view
            done = this.doAction(menuOption);
            
        } while (!done);
    }

    private String getMenuOption() {
        Scanner keyboard = new Scanner(System.in); // get infile for keyboard
        String value = ""; // value to be returned
        boolean valid = false; // initialize to not valid
        
        while (!valid) { // loop while an invalid value is entered
            System.out.println("\n" + this.menu);
            System.out.println("\n" + this.promptMessage);
            
            value = keyboard.nextLine(); // get next line typed on keyboard
            value = value.trim(); // trim off leading and trailing blanks
            
            if (value.length() < 1) { // value is blank
                System.out.println("\nInvalid value: value cannot be blank");
                continue;
            }
            
            break; // end the loop
        }
        
        return value; // return the value entered
    }

    private boolean doAction(String choice) {
        choice = choice.toUpperCase(); // convert choice to upper case
        
        switch (choice) {
            case "O": // Oxen
                this.oxen();
                break;
             case "W": // Handcart/Wagon Wheels
                this.wheels();
                break;
            case "A": // Handcart/Wagon Axles
                this.axles();
                break;    
            case "T": // Handcart/Wagon Tongues
                this.tongues();
                break;
            case "B": // Bullets
                this.bullets();
                break;
            case "F": // Food
                this.food();
                break;    
            default:
                System.out.println("\n*** Invalid selection *** Try again.");
                break;
        }
        return false;
    }

    private void oxen() {        
        System.out.println("\n*** oxen() inventory function called ***");
    }

    private void wheels() {        
        System.out.println("\n*** handcart/wagon wheels() inventory function called ***");
    }

    private void axles() {
        System.out.println("\n*** handcart/wagon axles() inventory function called ***");
    }

    private void tongues() {
        System.out.println("\n*** handcart/wagon tongues() inventory function called ***");
    }

    private void bullets() {
        System.out.println("\n*** bullets() inventory function called ***");
    }

    private void food() {
        System.out.println("\n*** food() inventory function called ***");
    }

}
