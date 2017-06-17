/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormonoregontrail.view;

import java.util.Scanner;

/**
 *
 * @author Team
 */
public abstract class View implements ViewInterface {
    
    protected String promptMessage;
    
    protected String additionalMessage = null;
    
    public View() {
        
    }
    
    public View(String message) {
        this.promptMessage = message;
    }
    
    @Override
    public void display() {
        boolean done = false; // set flag to not done
        do {
            // prompt for and get input from user
            String value = this.getInput();
            if (value.toUpperCase().equals("Q")) // user wants to quit
                return; // exit the view
            
            // do the requested action and display the next view
            done = this.doAction(value);
            
        } while (!done); // exit the view when done == true
    }

    public String getAdditionalMessage() {
        return additionalMessage;
    }

    public void setAdditionalMessage(String additionalMessage) {
        this.additionalMessage = additionalMessage;
    }
    
    @Override
    public String getInput() {
        Scanner keyboard = new Scanner(System.in); // get infile for keyboard
        String value = ""; // value to be returned
        boolean valid = false; // initialize to not valid
        
        // while a valid name has not been retrieved
        while (!valid) { // loop while an invalid value is entered

            if (additionalMessage != null) {
                // display the additional message
                System.out.println(this.additionalMessage);               
            }
            // display the prompt message
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
    
    
}
