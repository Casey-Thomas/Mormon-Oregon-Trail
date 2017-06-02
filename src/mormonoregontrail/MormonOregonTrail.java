/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormonoregontrail;

import mormonoregontrail.model.InventoryItem;
import mormonoregontrail.model.Location;
import mormonoregontrail.model.Map;
import mormonoregontrail.model.Scene;
import mormonoregontrail.model.Question;
import mormonoregontrail.model.Actor;
import mormonoregontrail.model.Game;
import mormonoregontrail.model.Player;
import mormonoregontrail.view.StartProgramView;

/**
 *
 * @author Team
 */
public class MormonOregonTrail {
    
    private static Game currentGame = null;
    private static Player player = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // create StartProgramViewOrig and display the start program view
        StartProgramView startProgramView = new StartProgramView();
        startProgramView.displayStartProgramView();
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
