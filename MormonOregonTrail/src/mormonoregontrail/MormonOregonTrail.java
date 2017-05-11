/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormonoregontrail;

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
        
    }
    public static void bradenClassTest(){
        
    }
    public static void mariamClassTest(){
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
