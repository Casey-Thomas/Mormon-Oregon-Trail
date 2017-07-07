/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormonoregontrail.view;

import java.io.BufferedReader;
import java.io.PrintWriter;
import mormonoregontrail.MormonOregonTrail;
import mormonoregontrail.control.UtilitiesControl;

/**
 *
 * @author Laura
 */
public class ResourcesNeededView {
        private String journeyTimeMessage;
        private String noPeopleMessage;
        private String minRequiredMessage;
        private String resourceTypeMessage;
        private String journeyTime;
        private String noPeople;
        private String minRequired = "50";
        private char resourceType = 'D';     
        
        private BufferedReader keyboard = MormonOregonTrail.getInFile();
        private PrintWriter console = MormonOregonTrail.getOutFile();
        
    
    public ResourcesNeededView() {
        
        this.journeyTimeMessage = "\nEnter the number of days for your journey (100-365): ";
        this.noPeopleMessage = "\nEnter the number of people for your journey (1-5): ";
        this.minRequiredMessage = "\nEnter the minimum resources required for your journey(1-200): ";
        this.resourceTypeMessage = "\nAre these daily supplies or general supplies for the journey? (D/J): ";
        
        // display the banner when view is created
        this.displayBanner();
    }

    private void displayBanner() {
        this.console.println(
            "\n*******************************************************"
           +"\n*                                                     *"
           +"\n* Calculate Resources Needed                          *"
           +"\n*                                                     *"
           +"\n* This tool will help you calculate how much of each  *"
           +"\n* resource you need to purchase for your journey      *"
           +"\n* based on the type of resource, number of days you   *"
           +"\n* plan for the journey, and the number of people in   *"
           +"\n* your group. You will use the results calculated to  *"
           +"\n* purchase your supplies from the general store.      *"
           +"\n*                                                     *"
           +"\n* You can run the calculations as often as you want   *"
           +"\n* with different numbers until you determine the      *"
           +"\n* right amount for your group.                        *"
           +"\n*                                                     *"
           +"\n*******************************************************"
           );
    }

    public void displayResourcesNeededView() {
        boolean done = false; // set flag to not done
        do {
            // Prompt for and get the length of the journey
            this.journeyTime = this.getUserString(this.journeyTimeMessage);
            if (this.journeyTime.toUpperCase().equals("Q")) // user wants to quit
                return; // exit the game
            
            // do the requested action and display the next view
            done = this.doNumericAction(this.journeyTime);
        
        } while (!done);
        
        done = false; // set flag to not done
        do {
            // Prompt for and get the number of people in the group
            this.noPeople = this.getUserString(this.noPeopleMessage);
            if (this.noPeople.toUpperCase().equals("Q")) // user wants to quit
                return; // exit the game
            
            // do the requested action and display the next view
            done = this.doNumericAction(this.noPeople);
        
        } while (!done);
        
        done = false; // set flag to not done
        do {
            // Prompt for and get the minimum resources required
            this.minRequired = this.getUserString(this.minRequiredMessage);
            if (this.minRequired.toUpperCase().equals("Q")) // user wants to quit
                return; // exit the game
            
            // do the requested action and display the next view
            done = this.doNumericAction(this.minRequired);
        
        } while (!done);

        done = false; // set flag to not done
        do {
            // Prompt for and get the type of resource required
            this.resourceType = this.getUserChar(this.resourceTypeMessage);
            if (Character.toUpperCase(this.resourceType) == 'Q') // user wants to quit
                return; // exit the game
            
            // do the requested action and display the next view
            done = this.doAlphaAction(this.resourceType);
        
        } while (!done);

        this.displayNextView();

    }

    private String getUserString(String promptMessage) {
        String value = ""; // value to be returned
        boolean valid = false; // initialize to not valid
        
        try{
            while (!valid) { // loop while an invalid value is entered
                this.console.println("\n" + promptMessage);
            
                value = this.keyboard.readLine(); // get next line typed on keyboard
                value = value.trim(); // trim off leading and trailing blanks
            
                if (value.length() < 1) { // value is blank
                    this.console.println("\nInvalid value: value cannot be blank");
                    continue;
                }

                break; // end the loop
            }
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(), e.getMessage());
        }
        
        return value; // return the value entered
    }

    private boolean doNumericAction(String userInput) {
        
        if (userInput.contains("[a-zA-Z]+") == true) {        
            this.console.println("\nInvalid Value: "
                + "must be numeric only");
            return false;
        }
        
        if (userInput.length() < 1) {        
            this.console.println("\nInvalid Value: "
                + "value cannot be blank");
            return false;
        }
                
        return true; // success !
    }

    private char getUserChar(String promptMessage) {
        String value = ""; // value to be returned
        boolean valid = false; // initialize to not valid
                
        try {
            while (!valid) { // loop while an invalid value is entered
                this.console.println("\n" + promptMessage);
            
                value = keyboard.readLine(); // get next line typed on keyboard
                value = value.trim(); // trim off leading and trailing blanks
            
                if (value.length() < 1) { // value is blank
                    this.console.println("\nInvalid value: value cannot be blank");
                    continue;
                }
                if (value.length() > 1) { // value is too long
                    this.console.println("\nInvalid value: value cannot be more than 1 character");
                    continue;
                }
            
               break; // end the loop
            }
        } catch(Exception e) {
            ErrorView.display(this.getClass().getName(), e.getMessage());
        }
        return value.charAt(0); // return the value entered
    }

    private boolean doAlphaAction(char userInput) {
        
        if (!Character.isLetter(userInput)) {        
            this.console.println("\nInvalid Value: "
                + "must be a letter only");
            return false;
        }
        
        return true; // success !
    }

    private void displayNextView() {
        // display a message showing user input
        this.console.println("\n========================================"
                          + "\n Number of Days: " + this.journeyTime
                          + "\n Number of People in Group: " + this.noPeople
                          + "\n Minimum Resources Needed: " + this.minRequired
                          + "\n Type of Resource: " + this.resourceType
                          + "\n"
                          + "\n======================================"
                          );
        
        // @Team - added try . . . catch - 6/28/2017
        int time = 0;
        int people = 0;
        int required = 0;
        try {
            time = Integer.parseInt(this.journeyTime);
        } catch (NumberFormatException nf) {
            ErrorView.display(this.getClass().getName(), 
                    "Invalid number for the journey: " + nf.getMessage()
                   + " Try again or enter Q to quit.");
        }
        
        try {
            people = Integer.parseInt(this.noPeople);
        } catch (NumberFormatException nf) {
            ErrorView.display(this.getClass().getName(), 
                    "Invalid valid number of people: " + nf.getMessage()
                   + " Try again or enter Q to quit.");
        }
        
        try {
            required = Integer.parseInt(this.minRequired);
        } catch (NumberFormatException nf) {
            ErrorView.display(this.getClass().getName(), 
                    "Invalid number for minimum required: " + nf.getMessage()
                   + " Try again or enter Q to quit.");
        }
            
        // Create MainMenuView object
        UtilitiesControl needed = new UtilitiesControl();
        int resourcesNeeded = needed.calcResourcesNeeded(time, people, required, this.resourceType, 365000);
        
        switch (resourcesNeeded) {
            case -1:
                this.console.println("\n*** Journey Time is too low ***");
                break;
            case -2:
                this.console.println("\n*** Journey Time is too high ***");
                break;
            case -3:
                this.console.println("\n*** Number of People is too low ***");
                break;
            case -4:
                this.console.println("\n*** Number of People is too high ***");
                break;
            case -5:
                this.console.println("\n*** Minimum suppies required too low ***");
                break;
            case -6:
                this.console.println("\n*** Minimum supplies required is too high  ***");
                break;
            case -7:
                this.console.println("\n*** Resource type does not equal (J)ourney or (D)aily ***");
                break;
            default:
                this.console.println("\n*** Total amount of this resource required: " + resourcesNeeded);
                break;
        }
        
        return;
    }
}
