/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormonoregontrail.view;

import mormonoregontrail.control.UtilitiesControl;
import mormonoregontrail.model.Scene;

/**
 *
 * @author Mariam
 */
public class UserDirectionMenuView extends View{   
    
    private Scene sceneDescription[] = {
    //public Scene(String name, String description, String obstacle, int mapLocation, String validDirection, int distanceFromNauvoo) {
        new Scene("blank", "blank", "blank", 0, "blank", 0),
        new Scene("Nauvoo", 
                "Nauvoo was the starting point for the Mormon trail and the early home base for LDS migrants. They left because they were treated poorly by those whom lived there. Brigham Young took a group of people through Illinois to Utah, not part of the United States",
                null,1,"S",0),
         new Scene("Chariton River Crossing ", 
                "The trail continues past the modern towns of Troy, Drakesville, and West Grove to reach the Chariton River. ",
                null,2,"W",80),
        new Scene("Locust Creek ", 
                "The trail proceeds past Cincinnati to Locust Creek. There on April 13 William Clayton, scribe for Brigham Young, composed \"Come, Come Ye Saints,\" the most famous and enduring hymn from the Mormon Trail",
                null,3,"N",103),
        new Scene("Mount Pisgah ", 
                "As they entered Potawatomi territory, the emigrants established another semi-permanent settlement that they named Mount Pisgah. Several thousand acres were cultivated and a settlement of about 700 Latter-day Saints thrived there from 1846 to 1852",
                null,4,"W",153)
    };
    private int location = 1;
    private int daysTraveled = 1;
    
    /**
     * UserDirectionView function
     */
    public UserDirectionMenuView() {            
        super(
                "\n------------------------------------------------"
                 + "\n User Direction Menu                                    |"
                 + "\n------------------------------------------------"
                 + "\nN - Go North"
                 + "\nS - Go South"
                 + "\nE - Go East"
                 + "\nW - Go West"
                 + "\nQ - Go to Main Menu"
                 + "\n------------------------------------------------"
                 + "\nPlease choose an option: ");
    }
    
    @Override
    public void display() {
        setLocationMessage();
        super.display();
    }

    public void setLocationMessage() {
        setAdditionalMessage(sceneDescription[location].getName() + "( " + sceneDescription[location].getDistanceFromNauvoo() +" miles from Nauvoo) \n" + sceneDescription[location].getDescription());
       
    }
    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase(); // convert choice to upper case
        
        switch (value) {
            case "N": // create and start a new game
                this.goNorth();
                break;
            case "S": // get and start an existing game
                this.goSouth();
                break;
            case "E": // display the help menu
                this.goEast();
                break;
            case "W": // save the current game
                this.goWest();
                break;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;
        }
        
        return false;
    }

    private void goNorth() {
        System.out.println("\n*** goNorth() function called ***");
        int result = UtilitiesControl.advanceAlongTheTrail(location, 
                daysTraveled,          //number of days traveled
                sceneDescription[location].getDistanceFromNauvoo(),
                sceneDescription[location].getObstacle(),
                sceneDescription[location].getValidDirection(),
                "N");
        daysTraveled++;
        if(result < 0){
            handleErrorMessage(result);
        }else{
            location = result;
            setLocationMessage();
                
        }
        //System.out.println("daysTraveled = "+daysTraveled + "location =" + location);
        // call the UtilitiesControl.AdvanceAlongTheTrail with a "N"
        // and handle error messages
    }

    private void goSouth() {
        System.out.println("\n*** goSouth() function called ***");
        int result = UtilitiesControl.advanceAlongTheTrail(location, 
                daysTraveled,          //number of days traveled
                sceneDescription[location].getDistanceFromNauvoo(),
                sceneDescription[location].getObstacle(),
                sceneDescription[location].getValidDirection(),
                "S");
        daysTraveled++;
        if(result < 0){
            handleErrorMessage(result);
        }else{
            location = result;
            setLocationMessage();
                
        }
        // System.out.println("daysTraveled = "+daysTraveled + "location =" + location);
       // call the UtilitiesControl.AdvanceAlongTheTrail with a "S"
        // and handle error messages
    }

    private void goEast() {        
        System.out.println("\n*** goEast() function called ***");
        int result = UtilitiesControl.advanceAlongTheTrail(location, 
                daysTraveled,          //number of days traveled
                sceneDescription[location].getDistanceFromNauvoo(),
                sceneDescription[location].getObstacle(),
                sceneDescription[location].getValidDirection(),
                "E");
        daysTraveled++;
        if(result < 0){
            handleErrorMessage(result);
        }else{
            location = result;
            setLocationMessage();
                
        }
        //System.out.println("daysTraveled = "+daysTraveled + "location =" + location);
        // call the UtilitiesControl.AdvanceAlongTheTrail with a "E"
        // and handle error messages
    }

    private void goWest() {
        System.out.println("\n*** goWest() function called ***");
        int result = UtilitiesControl.advanceAlongTheTrail(location, 
                daysTraveled,          //number of days traveled
                sceneDescription[location].getDistanceFromNauvoo(),
                sceneDescription[location].getObstacle(),
                sceneDescription[location].getValidDirection(),
                "W");
        daysTraveled++;
        if(result < 0){
            handleErrorMessage(result);
        }else{
            location = result;
            setLocationMessage();
                
        }
        //System.out.println("daysTraveled = "+daysTraveled + "location =" + location);
        // call the UtilitiesControl.AdvanceAlongTheTrail with a "W"
        // and handle error messages
    }

    public int getDaysTraveled() {
        return daysTraveled;
    }

    public void setDaysTraveled(int daysTraveled) {
        this.daysTraveled = daysTraveled;
    }
    
    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    private void handleErrorMessage(int error) {
        boolean needToHandleObstacle = false;
        //System.out.println("handleErrorMessage = " + error);
        switch (error) {
            case -11: // Invalid direction.
                System.out.println("\nInvalid direction.");
                break;
            case -7: // You have an ox that is sick.
                System.out.println("\nYou have an ox that is sick.");
                needToHandleObstacle = true;
                break;
            case -8: // You have a health challenge.
                System.out.println("\nYou have a health challenge.");
                needToHandleObstacle = true;
                break;
            case -9: // Your wagon is damaged.
                System.out.println("\nYour wagon is damaged.");
                needToHandleObstacle = true;
                break;
            case -10: // You have an obstacle in your path.
                System.out.println("\nYou have an obstacle in your path.");
                needToHandleObstacle = true;
                break;
            case -13: // You are not allowed to go this direction.
                System.out.println("\nYou are not allowed to go this direction.");
                needToHandleObstacle = false;
                break;
           default:
                break;
        }
        if(needToHandleObstacle){
            // display the HandleAnObstacle Menu
            HandleAnObstacleMenuView obstacleMenu = new HandleAnObstacleMenuView();
            obstacleMenu.display();
            
        }
    }
    
}
