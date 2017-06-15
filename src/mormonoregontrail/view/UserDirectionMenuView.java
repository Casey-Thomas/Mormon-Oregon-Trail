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
 * @author Mariam
 */
public class UserDirectionMenuView extends View{   
    /**
     * UserDirectionView function
     */
    public UserDirectionMenuView() {            
        super("\n"
                 + "\n------------------------------------------------"
                 + "\n| User Direction Menu                                    |"
                 + "\n------------------------------------------------"
                 + "\nN - Go North"
                 + "\nS - Go South"
                 + "\nE - Go East"
                 + "\nW - Go West"
                 + "\nQ - Go to Main Menu"
                 + "\n------------------------------------------------"
                 + "\nPlease choose an option: ");
    }
    
    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase(); // convert choice to upper case
        
        switch (value) {
            case "N": // create and start a new game
                this.goNorth();
                break;
            case "S": // get and start an existing game
                this.goSouth();
                break;
            case "E": // display the help menu
                this.goEast();
                break;
            case "W": // save the current game
                this.goWest();
                break;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;
        }
        
        return false;
    }

    private void goNorth() {
        System.out.println("\n*** goNorth() function called ***");
        // call the UtilitiesControl.AdvanceAlongTheTrail with a "N"
        // and handle error messages
    }

    private void goSouth() {
        System.out.println("\n*** goSouth() function called ***");
        // call the UtilitiesControl.AdvanceAlongTheTrail with a "S"
        // and handle error messages
    }

    private void goEast() {        
        System.out.println("\n*** goEast() function called ***");
        // call the UtilitiesControl.AdvanceAlongTheTrail with a "E"
        // and handle error messages
    }

    private void goWest() {
        System.out.println("\n*** goWest() function called ***");
        // call the UtilitiesControl.AdvanceAlongTheTrail with a "W"
        // and handle error messages
    }
    
    private void handleErrorMessage(int error) {
        boolean needToHandleObstacle = false;
        switch (error) {
            case -7: // You have an ox that is sick.
                System.out.println("\nYou have an ox that is sick.");
                needToHandleObstacle = true;
                break;
            case -8: // You have a health challenge.
                System.out.println("\nYou have a health challenge.");
                needToHandleObstacle = true;
                break;
            case -9: // Your wagon is damaged.
                System.out.println("\nYour wagon is damaged.");
                needToHandleObstacle = true;
                break;
            case -10: // You have an obstacle in your path.
                System.out.println("\nYou have an obstacle in your path.");
                needToHandleObstacle = true;
                break;
            case -13: // You are not allowed to go this direction.
                System.out.println("\nYou are not allowed to go this direction.");
                needToHandleObstacle = false;
                break;
           default:
                break;
        }
        if(needToHandleObstacle){
            // display the HandleAnObstacle Menu
            HandleAnObstacleMenuView obstacleMenu = new HandleAnObstacleMenuView();
            obstacleMenu.display();
            
        }
    }
    
}
