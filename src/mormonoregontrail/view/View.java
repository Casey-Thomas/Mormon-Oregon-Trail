/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormonoregontrail.view;

import java.io.BufferedReader;
import java.io.PrintWriter;
import mormonoregontrail.MormonOregonTrail;

/**
 *
 * @author Team
 */
public abstract class View implements ViewInterface {
    
    protected String promptMessage;
    
    protected String additionalMessage = null;
    
    protected final BufferedReader keyboard = MormonOregonTrail.getInFile();
    protected final PrintWriter console = MormonOregonTrail.getOutFile();
    
    public View() {
        
    }
    
    public View(String message) {
        this.promptMessage = message;
    }
    
    @Override
    public void display() {
        boolean done = false; // set flag to not done
        String value = "";
        do {
            // prompt for and get input from user
            value = this.getInput();
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
        String value = ""; // value to be returned
        boolean valid = false; // initialize to not valid
        
        try {
            // while a valid name has not been retrieved
            while (!valid) { // loop while an invalid value is entered
            
              if (additionalMessage != null) {
                  // display the additional message
                  this.console.println(this.additionalMessage);               
              }
              // display the prompt message
              this.console.println("\n" + this.promptMessage);
                          
              value = this.keyboard.readLine(); // get next line typed on keyboard
              value = value.trim(); // trim off leading and trailing blanks
            
              if (value.length() < 1) { // value is blank
                  ErrorView.display(this.getClass().getName(),
                                    "Invalid value: value cannot be blank");
                continue;
              }
            
              break; // end the loop
            }
        } catch(Exception e) {
            ErrorView.display(this.getClass().getName(),
                              "Error reading input: " + e.getMessage());
        }
        
        return value; // return the value entered
    }  
}
