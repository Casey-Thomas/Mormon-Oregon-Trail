/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormonoregontrail.view;

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
                 + "\nA - About the Pioneer Trek"
                 + "\nG - What is the goal of the game?"
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
            case "A": // about the trek
                this.aboutTrek();
                break;
             default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;
        }
        
        return false;
    }

    private void goal() {
        System.out.println("\n"
                + "\nThe overall goal of the game is to travel from"
                + "\n Nauvoo, Illinois to the Salt Lake Valley in "
                + "\n less than 365 days (or one full year.");
    }

    private void aboutTrek() {
        System.out.println("\n"
                + "\nThere will be many things to take on your journey"
                + "\n and many trials to overcome during your travels."
                + "\n You will get to choose how many people are in your"
                + "\n group and choose their names as well. You will then"
                + "\n visit a store and purchase items and food to take"
                + "\n with you. There will be a calculator available to"
                + "\n assist you with choosing resources wisely.");
    }   
}
