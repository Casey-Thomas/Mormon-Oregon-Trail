/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormonoregontrail;

import mormonoregontrail.model.Game;
import mormonoregontrail.model.Player;

/**
 *
 * @author Laura
 */
public class MormonOregonTrail {

    public static void teamClassTest(){
        
        // create instance
        
        Player playerOne = new Player();
        
        playerOne.setName("Fred Flintstone");
        
        String playerInfo = playerOne.toString();
        System.out.println(playerInfo);
    }
    public static void lauraClassTest(){
        
        // Game Class Test
        Game gameOne = new Game();
        
        gameOne.setTotalTime(5000);
        gameOne.setNoPeople(5);
        
        String gameInfo = gameOne.toString();
        System.out.println(gameInfo);
    }
    public static void bradenClassTest(){
        
    }
    public static void mariamClassTest(){
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        teamClassTest();
        lauraClassTest();
        bradenClassTest();
        mariamClassTest();
    }
    
}
