/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormonoregontrail.control;

import mormonoregontrail.model.Location;
import mormonoregontrail.model.Map;
import mormonoregontrail.model.Scene;

/**
 *
 * @author Laura
 */
public class MapControl {

    static Map createMap() {
        // create the map
        Map map = new Map(2, 13);
       
        // create the scenes for the game
        Scene[] scenes = createScenes();
        
        // assign scenes to locations
        GameControl.assignScenesToLocations(map, scenes);
        
        return map;
    }

    static void moveActorsToStartingLocation(Map map) {
        // Set starting location to 0,0
        movePlayer(map, 0, 0);
    }

    public static void movePlayer(Map map, int row, int column) {
        map.setCurrentLocation(map.getLocations()[row][column]);
        map.getCurrentLocation().setVisited(true);

        map.setCurrentRow(row);
        map.setCurrentColumn(column);
    }

    public enum SceneType {
        start,
        chariton,
        locust,
        pisgah,
        nishnabotna,
        finish;
    }
    private static Scene[] createScenes() {
        Scene[] scenes = new Scene[SceneType.values().length];
        
        // Starting Point - Nauvoo
        Scene startingScene = new Scene();
        startingScene.setName("Nauvoo");
        startingScene.setDescription(
                "Nauvoo was the starting point for the Mormon trail and the "
              + "\n early home base for LDS migrants. They left because they "
              + "\n were treated poorly by those whom lived there. Brigham Young "
              + "\n took a group of people through Illinois to Utah, not part "
              + "\n of the United States.");
        startingScene.setMapSymbol("ST");
        startingScene.setBlocked(false);
        startingScene.setDistanceFromNauvoo(0);
        scenes[SceneType.start.ordinal()] = startingScene;

        // Chariton River Crossing, Iowa
        Scene charitonScene = new Scene();
        charitonScene.setName("Chariton River Crossing");
        charitonScene.setDescription(
                "The trail continues past the modern towns of Troy, Drakesville,"
              + "\n and West Grove to reach the Chariton River. ");
        charitonScene.setMapSymbol("CH");
        charitonScene.setBlocked(false);
        charitonScene.setDistanceFromNauvoo(80);
        scenes[SceneType.chariton.ordinal()] = charitonScene;

        // Locust Creek, Iowa
        Scene locustScene = new Scene();
        locustScene.setName("Locust Creek");
        locustScene.setDescription(
                "The trail proceeds past Cincinnati to Locust Creek. There "
              + "\n on April 13 William Clayton, scribe for Brigham Young, "
              + "\n composed \"Come, Come Ye Saints,\" the most famous and "
              + "\n enduring hymn from the Mormon Trail.");
        locustScene.setMapSymbol("LC");
        locustScene.setBlocked(false);
        locustScene.setDistanceFromNauvoo(103);
        scenes[SceneType.locust.ordinal()] = locustScene;

        // Mount Pisgah, Iowa
        Scene pisgahScene = new Scene();
        pisgahScene.setName("Mount Pisgah");
        pisgahScene.setDescription(
                "As they entered Potawatomi territory, the emigrants "
              + "\n established another semi-permanent settlement that "
              + "\n they named Mount Pisgah. Several thousand acres were "
              + "\n cultivated and a settlement of about 700 Latter-day "
              + "\n Saints thrived there from 1846 to 1852.");
        pisgahScene.setMapSymbol("MP");
        pisgahScene.setBlocked(false);
        pisgahScene.setDistanceFromNauvoo(153);
        scenes[SceneType.pisgah.ordinal()] = pisgahScene;

        // Nishnabotna River Crossing, Iowa
        Scene nishnabotnaScene = new Scene();
        nishnabotnaScene.setName("Nishnabotna River Crossing");
        nishnabotnaScene.setDescription(
                "Nishnabotna River is a tributary of the Missouri River in "
              + "\n southwestern Iowa.");
        nishnabotnaScene.setMapSymbol("NR");
        nishnabotnaScene.setBlocked(false);
        nishnabotnaScene.setDistanceFromNauvoo(232);
        scenes[SceneType.nishnabotna.ordinal()] = nishnabotnaScene;

        // Finish Point - Great Salt Lake Valley
        Scene finishScene = new Scene();
        finishScene.setName("Salt Lake Valley");
        finishScene.setDescription(
                "Congratulations! Well done though good and faithful servants. "
              + "\n You have just completed your long journey and arrived at "
              + "\n the great Salt Lake Vally.");
        finishScene.setMapSymbol("FN");
        finishScene.setBlocked(false);
        finishScene.setDistanceFromNauvoo(1300);
        scenes[SceneType.finish.ordinal()] = finishScene;

        return scenes;
    }
    
}
