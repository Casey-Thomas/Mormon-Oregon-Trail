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
import mormonoregontrail.view.HandleAnObstacleMenuView;
import mormonoregontrail.view.InventoryMenuView;
import mormonoregontrail.view.ResourcesNeededView;
import mormonoregontrail.view.StartProgramView;
import mormonoregontrail.view.StorePurchaseView;
import mormonoregontrail.view.UserDirectionMenuView;

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
        
        //@author Mariam E. for testing only
        UserDirectionMenuView userDirectionView = new UserDirectionMenuView();
        int location = 1;
        int daysTraveled = 1;
        userDirectionView.setLocation(location);
        userDirectionView.setDaysTraveled(daysTraveled);
        userDirectionView.display();
        location = userDirectionView.getLocation();
        daysTraveled = userDirectionView.getDaysTraveled();
        
        //@author Mariam E. for testing only
        HandleAnObstacleMenuView handleObstacleView = new HandleAnObstacleMenuView();
        handleObstacleView.display();
        
        //@author LauraFriedman for testing only
        InventoryMenuView inventoryMenuView = new InventoryMenuView();
        inventoryMenuView.display();
        
        //@author LauraFriedman - for testing only
        ResourcesNeededView resourcesNeededView = new ResourcesNeededView();
        resourcesNeededView.displayResourcesNeededView();

        //@author Braden Harada - for testing only
        StorePurchaseView storePurchaseView = new StorePurchaseView();
        storePurchaseView.display();
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
