/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormonoregontrail.view;

import java.util.Random;
import java.util.Scanner;
import mormonoregontrail.MormonOregonTrail;
import mormonoregontrail.control.GameControl;

/**
 *
 * @author Mariam
 */
public class HandleAnObstacleMenuView extends View {
    /**
     * HandleAnObstacleMenuView function
     */
    public HandleAnObstacleMenuView() {            
        super("\n"
                 + "\n------------------------------------------------"
                 + "\n| Handle an obstacle Menu                                    |"
                 + "\n------------------------------------------------"
                 + "\nG - Get spiritual guidance."
                 + "\nH - Say a 'Hail Mary' prayer."
                 + "\nN - Do nothing and hope for a miracle."
                 + "\nP - Pray about it."
                 + "\nS - Sleep on it."
                 + "\nQ - Quit"
                 + "\n------------------------------------------------"
                 + "\nPlease choose an option: ");
    }
    
    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase(); // convert choice to upper case
        
        switch (value) {
            case "G": // Get spiritual guidance.
                this.spiritualGuidance();
                break;
            case "H": // Say a 'Hail Mary' prayer.
                this.hailMary();
                break;    
            case "N": // Do nothing and hope for a miracle.
                this.doNothing();
                break;
            case "P": // Pray about it.
                this.prayAboutIt();
                break;
            case "S": // Sleep on it.
                this.sleepOnIt();
                break;    
            default:
                System.out.println("\n*** Invalid selection *** Try again.");
                break;
        }
        
        Random rand = new Random();
        int randomValue = rand.nextInt(10); //50 percent chance of being less than 5.
        if (randomValue < 4){
            System.out.println("\n*** It worked! *** ");
            return true;
        }else{
            System.out.println("\n*** It didn't work. *** Try again.");
        }

        return false;
    }

    private void spiritualGuidance() {
        System.out.println("\nI went to my Bishop and repented.");
    }

    private void hailMary() {
        System.out.println("\n" + "Hail Mary, full of grace. " +
            "Our Lord is with thee." +
            "\nBlessed art thou among women, " +
            "and blessed is the fruit of thy womb," +
            "\nJesus." +
            "\nHoly Mary, Mother of God, " +
            "pray for us sinners," +
            "\nNow and at the hour of our death. " +
            "Amen." + "\nThis prayer may not work. You are on the Mormon trail!");
    }

    private void doNothing() {        
        System.out.println("\nOkay, I am doing nothing.");
    }

    private void prayAboutIt() {        
        System.out.println("\nOkay, I am saying a 'Mormon' prayer.");
    }

    private void sleepOnIt() {
        System.out.println("\nzzzzz, Wow, I feel better already.");
    }

}
