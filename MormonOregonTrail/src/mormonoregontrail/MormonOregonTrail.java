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
        //
        Map testMap = new Map();
        testMap.setDescription("Trail");
        testMap.setRowCount("2");
        testMap.setColumnCount("13");
        
        Location testLocation = new Location();
        testLocation.setDistanceFromNauvoo("52");
        testLocation.setColumn("1");
        testLocation.setRow("6");
        testLocation.setVisited("Yes");
        
        InventoryItem testInventoryItem = new InventoryItem();
        testInventoryItem.setType("Wheel");
        testInventoryItem.setDescription("Axle");
        testInventoryItem.setQuantityInStock("1");
        testInventoryItem.setRequiredAmount("0");
        testInventoryItem.setUnits("1");
        
        String mapInfo = testMap.toString();
        System.out.println(mapInfo);
        String locationInfo = testLocation.toString();
        System.out.println(locationInfo);
        String inventoryItemInfo = testInventoryItem.toString();
        System.out.println(inventoryItemInfo);
                
    }
    public static void mariamClassTest(){
        //
       Scene testScene = new Scene();
       testScene.setName("Nauvoo");
       testScene.setType("water");
       testScene.setSymbol("flag");
       testScene.setDescription("foggy");
       testScene.setObstacle("log");
       
       String testSceneInfo = testScene.toString();
       System.out.println(testSceneInfo);
       
       Question testQuestion = new Question();
       testQuestion.setNoToAnswer("continue");
       testQuestion.setBonus("yes");
       testQuestion.setQuestion("yes");
       testQuestion.setAnswer1("yes");
       testQuestion.setAnswer2("yes");
       testQuestion.setAnswer3("yes");
       testQuestion.setAnswer4("yes");
       testQuestion.setAnswer5("yes");
       testQuestion.setAnswer6("yes");
       testQuestion.setAnswer7("yes");
       testQuestion.setCorrectAnswer("yes");
       
       String testQuestionInfo = testQuestion.toString();
       System.out.println(testQuestionInfo);
                        
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
