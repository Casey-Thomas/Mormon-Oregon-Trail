/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormonoregontrail.control;

import mormonoregontrail.MormonOregonTrail;
import mormonoregontrail.model.Player;

/**
 *
 * @author Laura
 */
public class GameControl {

    public static Player createPlayer(String playersName) {
        if (playersName == null) {
            return null;
        }
        
        Player player = new Player();
        player.setName(playersName);
        
        MormonOregonTrail.setPlayer(player); // save the player
        
        return player;
    }
    
}
