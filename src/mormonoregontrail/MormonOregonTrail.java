/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormonoregontrail;

import mormonoregontrail.model.Game;
import mormonoregontrail.model.Player;
import mormonoregontrail.view.StartProgramView;

public class MormonOregonTrail {
    
    private static Game currentGame = null;
    private static Player player = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // create StartProgramViewOrig and display the start program view
        StartProgramView startProgramView = new StartProgramView();
        
        // @Team - added try . . . catch - 6/28/2017
        try {
            startProgramView.displayStartProgramView();
        } catch (Throwable te) {
            System.out.println(te.getMessage());
            te.printStackTrace();
            startProgramView.display();
        }
        
    }

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        MormonOregonTrail.currentGame = currentGame;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        MormonOregonTrail.player = player;
    }
    
    
}
