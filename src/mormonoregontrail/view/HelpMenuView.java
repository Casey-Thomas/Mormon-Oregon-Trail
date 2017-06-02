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
 * @author Team
 */
public class HelpMenuView {
    private String menu;
    private String promptMessage;
    
    /**
     * MainMenuView function
     */
    public HelpMenuView() {
        
        this.promptMessage = "\nPlease choose an option: ";
            
        this.menu = "\n"
                 + "\n------------------------------------------------"
                 + "\n| Help Menu                                    |"
                 + "\n------------------------------------------------"
                 + "\nG - What is the goal of the game?"
                 + "\nM - How to move"
                 + "\nE - Estimating the amout of resources"
                 + "\nH - Harvesting resources"
                 + "\nD - Delivering resources to warehouse"
                 + "\nQ - Quit"
                 + "\n------------------------------------------------";
    }
    
    public void displayHelpMenuView() {
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
                System.out.println("\nInvalid value: value can not be blank");
                continue;
            }
            
            break; // end the loop
        }
        
        return value; // return the value entered
    }

    private boolean doAction(String choice) {
        choice = choice.toUpperCase(); // convert choice to upper case
        
        switch (choice) {
            case "G": // goal of the game
                this.goal();
                break;
            case "M": // how to move
                this.move();
                break;
            case "E": // estimating resources
                this.estimate();
                break;
            case "H": // harvesting resources
                this.harvest();
                break;
            case "D": // delivering resources to warehouse
                this.deliver();
                break;
             default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;
        }
        
        return false;
    }

    private void goal() {
        System.out.println("\n*** goal() help function called ***");
    }

    private void move() {
        System.out.println("\n*** move() help function called ***");
    }

    private void estimate() {
        System.out.println("\n*** estimate() help function called ***");
    }

    private void harvest() {
        System.out.println("\n*** harvest() help function called ***");
    }    

    private void deliver() {
        System.out.println("\n*** deliver() help function called ***");
    }    
}
