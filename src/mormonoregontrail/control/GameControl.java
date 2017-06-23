/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormonoregontrail.control;

import mormonoregontrail.MormonOregonTrail;
import mormonoregontrail.model.Actor;
import mormonoregontrail.model.Game;
import mormonoregontrail.model.InventoryItem;
import mormonoregontrail.model.Location;
import mormonoregontrail.model.Map;
import mormonoregontrail.model.Player;
import mormonoregontrail.model.Scene;

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
    
    public static void createNewGame(Player player) {
        Game game = new Game(); // create new game
        MormonOregonTrail.setCurrentGame(game); // save in Mormon Oregon Trail
        
        game.setPlayer(player); // save player in game
        
        // create the inventory list and save in the game
        InventoryItem[] inventoryList = GameControl.createInventoryList();
        game.setInventory(inventoryList);
        
        Map map = MapControl.createMap(); //create and initialize new map
        game.setMap(map); // save map in game
        
        Actor[] actor = GameControl.createActorList();
        game.setActor(actor); // create game player names
        
        // move actors to starting position in the map
        MapControl.moveActorsToStartingLocation(map);
    }
    public enum Item {
        axles,
        wheels,
        tongues,
        oxen,
        bullets,
        food,
        money,
        wagon,
        handcart;
    }

    private static InventoryItem[] createInventoryList() {
        // created array(list) of inventory items
        InventoryItem[] inventory = new InventoryItem[9];
        
        // Axles
        InventoryItem axles = new InventoryItem();
        axles.setDescription("Axles");
        axles.setQuantityInStock(0);
        axles.setRequiredAmount(0);
        axles.setCost(0);
        inventory[Item.axles.ordinal()] = axles;
        
        // Wheels
        InventoryItem wheels = new InventoryItem();
        wheels.setDescription("Wheels");
        wheels.setQuantityInStock(0);
        wheels.setRequiredAmount(0);
        wheels.setCost(0);
        inventory[Item.wheels.ordinal()] = wheels;

        // Tongues
        InventoryItem tongues = new InventoryItem();
        tongues.setDescription("Tongues");
        tongues.setQuantityInStock(0);
        tongues.setRequiredAmount(0);
        tongues.setCost(0);
        inventory[Item.tongues.ordinal()] = tongues;

        // Oxen
        InventoryItem oxen = new InventoryItem();
        oxen.setDescription("Oxen");
        oxen.setQuantityInStock(0);
        oxen.setRequiredAmount(0);
        oxen.setCost(0);
        inventory[Item.oxen.ordinal()] = oxen;

        // Bullets
        InventoryItem bullets = new InventoryItem();
        bullets.setDescription("Bullets");
        bullets.setQuantityInStock(0);
        bullets.setRequiredAmount(0);
        bullets.setCost(0);
        inventory[Item.bullets.ordinal()] = bullets;

        // Food
        InventoryItem food = new InventoryItem();
        food.setDescription("Food");
        food.setQuantityInStock(0);
        food.setRequiredAmount(0);
        food.setCost(0);
        inventory[Item.food.ordinal()] = food;

        // Money
        InventoryItem money = new InventoryItem();
        money.setDescription("Money");
        money.setQuantityInStock(0);
        money.setRequiredAmount(0);
        money.setCost(0);
        inventory[Item.money.ordinal()] = money;

        // Wagon
        InventoryItem wagon = new InventoryItem();
        wagon.setDescription("Wagon");
        wagon.setQuantityInStock(0);
        wagon.setRequiredAmount(0);
        wagon.setCost(0);
        inventory[Item.wagon.ordinal()] = wagon;

        // Handcart
        InventoryItem handcart = new InventoryItem();
        handcart.setDescription("Handcart");
        handcart.setQuantityInStock(0);
        handcart.setRequiredAmount(0);
        handcart.setCost(0);
        inventory[Item.handcart.ordinal()] = handcart;

        return inventory;
    }

    private static Actor[] Actor() {
        System.out.println("\n*** Actor() function called ***");
        return null;
    }

    public enum Actors {
        brigham,
        mariam,
        william,
        eliza,
        joseph;
    }

    private static Actor[] createActorList() {
        // created array(list) of inventory items
        Actor[] actor = new Actor[5];
        
        // Brigham
        Actor brigham = new Actor();
        brigham.setName("Brigham");
        brigham.setDescription("He is the prophet chosen to lead the church to the Salt Lake Valley.");
        brigham.setRow(0);
        brigham.setColumn(0);
//        brigham.coordinates("");
        actor[Actors.brigham.ordinal()] = brigham;
        
        // Mariam
        Actor mariam = new Actor();
        mariam.setName("Mariam");
        mariam.setDescription("Brigham's wife and confidant.");
        mariam.setRow(0);
        mariam.setColumn(0);
 //       mariam.coordinates("");        
        actor[Actors.mariam.ordinal()] = mariam;

        // William
        Actor william = new Actor();
        william.setName("William");
        william.setDescription("Chosen to be a help and guide for this journey.");
        william.setRow(0);
        william.setColumn(0);
 //       william.coordinates("");        
        actor[Actors.william.ordinal()] = william;

        // Eliza
        Actor eliza = new Actor();
        eliza.setName("Eliza");
        eliza.setDescription("First born daughter is 17 years old and a very good cook.");
        eliza.setRow(0);
        eliza.setColumn(0);
 //       eliza.coordinates("");
        actor[Actors.eliza.ordinal()] = eliza;

        // Joseph
        Actor joseph = new Actor();
        joseph.setName("Joseph");
        joseph.setDescription("The youngest child and a loyal helper in the family.");
        joseph.setRow(0);
        joseph.setColumn(0);
//        joseph.coordinates("");
        actor[Actors.joseph.ordinal()] = joseph;

        return null;
    }
    
    static void assignScenesToLocations(Map map, Scene[] scenes){
        Location[][] locations = map.getLocations();
        
        // starting point
        locations[0][0].setScene(scenes[MapControl.SceneType.start.ordinal()]);
        locations[0][1].setScene(scenes[MapControl.SceneType.chariton.ordinal()]);
        locations[0][2].setScene(scenes[MapControl.SceneType.locust.ordinal()]);
        locations[0][3].setScene(scenes[MapControl.SceneType.pisgah.ordinal()]);
        locations[0][4].setScene(scenes[MapControl.SceneType.nishnabotna.ordinal()]);
        locations[0][5].setScene(scenes[MapControl.SceneType.millers.ordinal()]);
        locations[0][6].setScene(scenes[MapControl.SceneType.elkhorn.ordinal()]);
//        locations[0][7].setScene(scenes[MapControl.SceneType.???.ordinal()]);
//        locations[0][8].setScene(scenes[MapControl.SceneType.???.ordinal()]);
        locations[0][9].setScene(scenes[MapControl.SceneType.kearny.ordinal()]);
//        locations[0][10].setScene(scenes[MapControl.SceneType.???.ordinal()]);
        locations[0][11].setScene(scenes[MapControl.SceneType.confluence.ordinal()]);
        locations[0][12].setScene(scenes[MapControl.SceneType.ash.ordinal()]);
        locations[1][0].setScene(scenes[MapControl.SceneType.chimney.ordinal()]);
        locations[1][1].setScene(scenes[MapControl.SceneType.scotts.ordinal()]);
        locations[1][2].setScene(scenes[MapControl.SceneType.laramie.ordinal()]);
//        locations[1][3].setScene(scenes[MapControl.SceneType.???.ordinal()]);
//        locations[1][4].setScene(scenes[MapControl.SceneType.???.ordinal()]);
        locations[1][5].setScene(scenes[MapControl.SceneType.platte.ordinal()]);
        locations[1][6].setScene(scenes[MapControl.SceneType.martins.ordinal()]);
        locations[1][7].setScene(scenes[MapControl.SceneType.rocky.ordinal()]);
        locations[1][8].setScene(scenes[MapControl.SceneType.south.ordinal()]);
        locations[1][9].setScene(scenes[MapControl.SceneType.green.ordinal()]);
        locations[1][10].setScene(scenes[MapControl.SceneType.bridger.ordinal()]);
        locations[1][11].setScene(scenes[MapControl.SceneType.needles.ordinal()]);
        locations[1][12].setScene(scenes[MapControl.SceneType.saltLakeValley.ordinal()]);
    }
    
    
}
