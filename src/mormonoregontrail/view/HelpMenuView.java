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
public class HelpMenuView extends View{
    /**
     * HelpMenuView function
     */
    public HelpMenuView() {            
        super("\n"
                 + "\n------------------------------------------------"
                 + "\n| Help Menu                                    |"
                 + "\n------------------------------------------------"
                 + "\nG - What is the goal of the game?"
                 + "\nM - How to move"
                 + "\nE - Estimating the amout of resources"
                 + "\nH - Harvesting resources"
                 + "\nD - Delivering resources to warehouse"
                 + "\nQ - Quit"
                 + "\n------------------------------------------------"
                 + "\nPlease choose an option: ");
    }
    
    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase(); // convert choice to upper case
        
        switch (value) {
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
