/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormonoregontrail.view;

import mormonoregontrail.MormonOregonTrail;
import mormonoregontrail.control.GameControl;

/**
 *
 * @author Team - Braden, Laura, Mariam
 */
public class MainMenuView extends View{  
    /**
     * MainMenuView function
     */
    public MainMenuView() {            
        super("\n"
            + "\n------------------------------------------------"
            + "\n| Main Menu                                    |"
            + "\n------------------------------------------------"
            + "\nN - Start new game"
            + "\nG - Get and start saved game"
            + "\nH - Get help on how to play the game"
            + "\nS - Save game"
            + "\nQ - Quit"
            + "\n------------------------------------------------"
            + "\nPlease choose an option: ");
    }
    
    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase(); // convert choice to upper case
        
        switch (value) {
            case "N": // create and start a new game
                this.startNewGame();
                break;
            case "G": // get and start an existing game
                this.startSavedGame();
                break;
            case "H": // display the help menu
                this.displayHelpMenu();
                break;
            case "S": // save the current game
                this.saveGame();
                break;
            default:
                this.console.println("\n*** Invalid selection *** Try again");
                break;
        }
        
        return false;
    }

    private void startNewGame() {
        // create a new game
        GameControl.createNewGame(MormonOregonTrail.getPlayer());
        
        // display the game menu
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void startSavedGame() {
        String savePrompt = promptMessage;
        
        promptMessage = "\nEnter the file name where the game is saved (or type 'Q' to Quit): ";
        
        String fileName = this.getInput();
        if (fileName.toUpperCase().equals("Q")) { // user wants to quit
            promptMessage = savePrompt;
            return; // exit the view
        }
        
        try {
            // start a saved gamee
            GameControl.getSavedGame(fileName);
            
            // display the game menu
            GameMenuView gameMenu = new GameMenuView();
            gameMenu.display();
        } catch (Exception ex) {
            ErrorView.display("MainMenuView", ex.getMessage());
        }
        promptMessage = savePrompt;
    }

    private void displayHelpMenu() {        
        // display the help menu
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.display();
    }

    private void saveGame() {
        String savePrompt = promptMessage;
        
        // prompt for and get the name of the file to save the game in        
        promptMessage = "\nEnter the file name to save the game to (or type 'Q' to Quit): ";
        
        String fileName = this.getInput();
        if (fileName.toUpperCase().equals("Q")) { // user wants to quit
            promptMessage = savePrompt;
            return; // exit the view
        }
        
        try {
            // save the game to the specified file
            GameControl.saveGame(MormonOregonTrail.getCurrentGame(), fileName);
        } catch (Exception ex) {
            ErrorView.display("MainMenuView", ex.getMessage());
        }
        promptMessage = savePrompt;        
    }

}
