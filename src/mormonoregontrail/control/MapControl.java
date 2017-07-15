/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormonoregontrail.control;

import mormonoregontrail.exceptions.MapControlException;
import mormonoregontrail.model.Map;
import mormonoregontrail.model.Obstacle;
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

    static void moveActorsToStartingLocation(Map map) 
                    throws MapControlException {
        // Set starting location to 0,0
        movePlayer(map, 0, 0);
    }

    public static void movePlayer(Map map, int row, int column)
                            throws MapControlException {
        if (map == null) {
            throw new MapControlException("Invalid, map cannot be null.");
        }
        map.setCurrentLocation(map.getLocations()[row][column]);
        map.getCurrentLocation().setVisited(true);

        if (row < 0 || row >= map.getLocations().length || 
                column < 0 || column >= map.getLocations()[row].length) {
            throw new MapControlException("Invalid, coordinates are outside map boundaries.");
        }

        map.setCurrentRow(row);
        map.setCurrentColumn(column);
    }

    public enum SceneType {
        start,
        chariton,
        locust,
        pisgah,
        nishnabotna,
        millers,
        elkhorn,
        murdock,
        kearny,
        sand,
        confluence,
        ash,
        ancient,
        chimney,
        scotts,
        laramie,
        porters,
        ayres,
        platte,
        martins,
        rocky,
        south,
        green,
        bridger,
        needles,
        saltLakeValley;
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
        Obstacle pisgahObstacle = new Obstacle();
        pisgahObstacle.setDescription("You got bitten by a snake.");
        pisgahObstacle.setPossibilityOfDeath(50);       // 50%
        pisgahObstacle.setAllowSpiritualGuidance(true);
        pisgahObstacle.setPossibilityOfHappening(30);   // 30%
        pisgahScene.setObstacle(pisgahObstacle);
        
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
        
        // Millers Hollow, Iowa (Kanesville)
        Scene millersScene = new Scene();
        millersScene.setName("Millers Hollow");
        millersScene.setDescription(
                "This place is going to be one of the best towns"
              + "\n to come across while on your journey. You can"
              + "\n replenish your food supply, purchase parts, or"
              + "\n just take a breathe and relax for a short time.");
        millersScene.setMapSymbol("MH");
        millersScene.setBlocked(false);
        millersScene.setDistanceFromNauvoo(265);
        scenes[SceneType.millers.ordinal()] = millersScene;
        
        // Elkhorn River Crossing, Nebraska
        Scene elkhornScene = new Scene();
        elkhornScene.setName("Elkhorn River Crossing");
        elkhornScene.setDescription(
                "This river is one of the largest tributaries of"
              + "\n the Platte River.");
        elkhornScene.setMapSymbol("ER");
        elkhornScene.setBlocked(false);
        Obstacle elkhornObstacle = new Obstacle();
        elkhornObstacle.setDescription("You have contracted dysentery.");
        elkhornObstacle.setPossibilityOfDeath(50);       // 50%
        elkhornObstacle.setAllowSpiritualGuidance(true);
        elkhornObstacle.setPossibilityOfHappening(50);   // 50%
        elkhornScene.setObstacle(elkhornObstacle);       
        elkhornScene.setDistanceFromNauvoo(293);
        scenes[SceneType.elkhorn.ordinal()] = elkhornScene;
        
        // Loup Fork, Nebraska (352 mi.)
        
        // Murdock Trail, Nebraska. 
        Scene murdockTrailScene = new Scene();
        murdockTrailScene.setName("Murdock Trail Nebraska");
	murdockTrailScene.setDescription(
                    "You are surrounded by pastureland as you move along the south side of the Wood River."
                  + "\n The terrain is fairly even and should make for decent traveling.");
        murdockTrailScene.setMapSymbol("MT");
        murdockTrailScene.setBlocked(false);
        murdockTrailScene.setDistanceFromNauvoo(425);
        scenes[SceneType.murdock.ordinal()] = murdockTrailScene;

        
        // Fort Kearny, Nebraska
        Scene fortKearnyScene = new Scene();
        fortKearnyScene.setName("Fort Kearny");
		fortKearnyScene.setDescription(
                   "This fort was established in June of 1848. The site"
                 + "\n for the fort was purchased from the Pawnee Indians"
                 + "\n for about $2,000 in goods.");
        fortKearnyScene.setMapSymbol("FK");
        fortKearnyScene.setBlocked(false);
        fortKearnyScene.setDistanceFromNauvoo(469);
        scenes[SceneType.kearny.ordinal()] = fortKearnyScene;

        // Sand Hill, Nebraska. 
        Scene sandHillScene = new Scene();
        sandHillScene.setName("Sand Hill Nebraska");
	sandHillScene.setDescription(
                    ".Great sand bluffs plunge to the river's edge. You will have to travel "
                  + "\n on the north side of the North Platte River due to all of the loose sand. "
                  + "\n Your patience will be tested.");
        sandHillScene.setMapSymbol("SH");
        sandHillScene.setBlocked(false);
        Obstacle sandHillObstacle = new Obstacle();
        sandHillObstacle.setDescription("You have an ox that is sick and needs some time to rest.");
        sandHillObstacle.setPossibilityOfDeath(0);       // 0%
        sandHillObstacle.setAllowSpiritualGuidance(true);
        sandHillObstacle.setPossibilityOfHappening(40);   // 40%
        sandHillScene.setObstacle(sandHillObstacle);      
        sandHillScene.setDistanceFromNauvoo(528);
        scenes[SceneType.sand.ordinal()] = sandHillScene;
        
        // Confluence Point, Nebraska
        Scene confluencePointScene = new Scene();
        confluencePointScene.setName("Confluence Point");
		confluencePointScene.setDescription(
                    "It was from this point forward, the Mormons that"
                  + "\n traveled previously attached a 'roadometer' to "
                  + "\n Heber C. Kimball's wagon so they could track the"
                  + "\n rest of the distance covered to the Salt Lake Valley.");
        confluencePointScene.setMapSymbol("CP");
        confluencePointScene.setBlocked(false);
        confluencePointScene.setDistanceFromNauvoo(563);
        scenes[SceneType.confluence.ordinal()] = confluencePointScene;
        
        // Ash Hollow, Nebraska. 
        Scene ashHollowScene = new Scene();
        ashHollowScene.setName("Ash Hollow");
		ashHollowScene.setDescription(
                    "Once noted for its beauty, Ash Hollow became a battle field in 1855. "
                  + "\n The Sioux Indians were defeated in battle against General William S. Harney's troops. "
	          + "\n Ash Hollow is a burial site for many who died of Cholera during the gold rush years."
                  + "\n Take some time to write in your journal about this location!");
        ashHollowScene.setMapSymbol("AH");
        ashHollowScene.setBlocked(false);
        ashHollowScene.setDistanceFromNauvoo(646);
        scenes[SceneType.ash.ordinal()] = ashHollowScene;

        // Ancient Bluff, Nebraska
        Scene ancientBluffScene = new Scene();
        ancientBluffScene.setName("Ancient Bluff Nebraska");
	ancientBluffScene.setDescription(
                    "This landmark is along the north side of the North Platte River. "
                  + "\n Will you follow some Mormon leaders who climbed the highest bluff, "
                  + "\n and write your name on the buffalo skull that's placed at the southwest corner.");		
        ancientBluffScene.setMapSymbol("AB");
        ancientBluffScene.setBlocked(false);
        ancientBluffScene.setDistanceFromNauvoo(678);
        scenes[SceneType.ancient.ordinal()] = ancientBluffScene;		
        
        // Chimney Rock, Nebraska
        Scene chimneyScene = new Scene();
        chimneyScene.setName("Nishnabotna River Crossing");
        chimneyScene.setDescription(
                    "This is probably going to be a long stretch because this"
                  + "\n rock will appear closer than it really is. You may see"
                  + "\n many names carved into this rock already and you may"
                  + "\n want to add your name to it.");
        chimneyScene.setMapSymbol("CR");
        chimneyScene.setBlocked(false);
        Obstacle chimneyObstacle = new Obstacle();
        chimneyObstacle.setDescription("Unfortunately, you have been attacked by a wolf.");
        chimneyObstacle.setPossibilityOfDeath(50);       // 50%
        chimneyObstacle.setAllowSpiritualGuidance(true);
        chimneyObstacle.setPossibilityOfHappening(30);   // 30%
        chimneyScene.setObstacle(chimneyObstacle);    
        chimneyScene.setDistanceFromNauvoo(718);
        scenes[SceneType.chimney.ordinal()] = chimneyScene;
        
        // Scotts Bluff, Nebraska. 
        Scene scottsBluffScene = new Scene();
        scottsBluffScene.setName("Scotts Bluff");
		scottsBluffScene.setDescription(
                    "You are now in western Nebraska, which is located on the south side of the North Platte River."
            	  + "\n This area contains multiple bluffs (steep hills). Scotts Bluff rises over 800 feet above the plains.");				
        scottsBluffScene.setMapSymbol("SB");
        scottsBluffScene.setBlocked(false);
        scottsBluffScene.setDistanceFromNauvoo(738);
        scenes[SceneType.scotts.ordinal()] = scottsBluffScene;		
        
        // Fort Laramie, Wyoming. 
        Scene fortLaramieScene = new Scene();
        fortLaramieScene.setName("Fort Laramie");
        fortLaramieScene.setDescription(
                    "This is your final crossing of the Platte River. "
		  + "\n Winter snow storms may be fatal.");
        fortLaramieScene.setMapSymbol("FL");
        fortLaramieScene.setBlocked(false);
        fortLaramieScene.setDistanceFromNauvoo(788);
        scenes[SceneType.laramie.ordinal()] = fortLaramieScene;

        // Porter's Rock, Wyoming. 
        Scene portersRockScene = new Scene();
        portersRockScene.setName("Porter's Rock Wyoming");
        portersRockScene.setDescription(
                    "You are reaching a summit of 4682 feet. "
                  + "\n The exposed forty foot high rock bears Porter Rockwells name. "
                  + "\n The trail descends to lower land at this point.");
        portersRockScene.setMapSymbol("PR");
        portersRockScene.setBlocked(false);
        portersRockScene.setDistanceFromNauvoo(824);
        scenes[SceneType.porters.ordinal()] = portersRockScene;
		
        // Ayres Natural Bridge, Wyoming. 
        Scene naturalBridgeScene = new Scene();
        naturalBridgeScene.setName("Ayres Natural Bridge");
        naturalBridgeScene.setDescription(
                    "This may be a good place to refresh. "
                  + "\n This bridge is one of only three natural bridges in" 
                  + "\n the United States with water beneath. You may need to" 
                  + "\n find one of the nearby caves to hide from the Indians.");
        naturalBridgeScene.setMapSymbol("NB");
        naturalBridgeScene.setBlocked(false);
        naturalBridgeScene.setDistanceFromNauvoo(880);
        scenes[SceneType.ayres.ordinal()] = naturalBridgeScene;

        // Upper Platte, Wyoming. 
        Scene upperPlatteScene = new Scene();
        upperPlatteScene.setName("Upper Platte");
        upperPlatteScene.setDescription(
                    "This is your final crossing of the Platte River. "
		  + "\n It is also one of the toughest areas along the trail. "
		  + "\n Winter snow storms may be fatal.");
        upperPlatteScene.setMapSymbol("UP");
        upperPlatteScene.setBlocked(false);
        Obstacle upperPlatteObstacle = new Obstacle();
        upperPlatteObstacle.setDescription("You now have malaria.");
        upperPlatteObstacle.setPossibilityOfDeath(30);       // 30%
        upperPlatteObstacle.setAllowSpiritualGuidance(true);
        upperPlatteObstacle.setPossibilityOfHappening(50);   // 50%
        upperPlatteScene.setObstacle(upperPlatteObstacle);              
        upperPlatteScene.setDistanceFromNauvoo(914);
        scenes[SceneType.platte.ordinal()] = upperPlatteScene;

        // Martin's Cove, Wyoming. 
        Scene martinsCoveScene = new Scene();
        martinsCoveScene.setName("Martin's Cove");
        martinsCoveScene.setDescription(
                    "You will make nine river crossings during the stretch of the trail."
		  + "\n You will pass a prominent landmark known as Independence Rock. "
		  + "\n Martin's Cove is a 933 acre cove located 55 miles (89 km) southwest of Casper, Wyoming. "
		  + "\n Winter storms are a threat in this area.");
        martinsCoveScene.setMapSymbol("MR");
        martinsCoveScene.setBlocked(false);
        martinsCoveScene.setDistanceFromNauvoo(993);
        scenes[SceneType.martins.ordinal()] = martinsCoveScene;
        
        // Rocky Ridge, Wyoming. 
        Scene rockyRidgeScene = new Scene();
        rockyRidgeScene.setName("Rocky Ridge");
        rockyRidgeScene.setDescription(
                    "You are about to cross the Sweetwater River sixth time. "
		  + "\n Supplies may be getting low at this point in the journey.");
        rockyRidgeScene.setMapSymbol("RR");
        rockyRidgeScene.setBlocked(false);
        rockyRidgeScene.setDistanceFromNauvoo(1038);
        scenes[SceneType.rocky.ordinal()] = rockyRidgeScene;

        // South Pass, Wyoming. 
        Scene southPassScene = new Scene();
        southPassScene.setName("South Pass");
        southPassScene.setDescription(
                    "This area is known as the Continental Divide"
		  + "\n This is one of the most significant landmarks along the Mormon Trail.");
        southPassScene.setMapSymbol("SP");
        southPassScene.setBlocked(false);
        southPassScene.setDistanceFromNauvoo(1065);
        scenes[SceneType.south.ordinal()] = southPassScene;	

        // Green River, Wyoming. 
        Scene greenRiverScene = new Scene();
        greenRiverScene.setName("Green River");
        greenRiverScene.setDescription(
                    "This is a chief tributary of the Colorado River. "
		  + "\n Later a ferry was set up here to assist the emigrants of the church"
		  + "\n to earn money from other travelers moving westward.");
        greenRiverScene.setMapSymbol("GR");
        greenRiverScene.setBlocked(false);
        greenRiverScene.setDistanceFromNauvoo(1128);
        scenes[SceneType.green.ordinal()] = greenRiverScene;

        // Fort Bridger, Wyoming. 
        Scene fortBridgerScene = new Scene();
        fortBridgerScene.setName("Fort Bridger");
        fortBridgerScene.setDescription(
                "This fort was established by the famous mountain man Jim Bridger in 1842. "
	      + "\n This is where the trail separates into three paths - "
	      + "\n the Oregon Trail, the California Trail, and the Mormon Trail.");
        fortBridgerScene.setMapSymbol("FB");
        fortBridgerScene.setBlocked(false);
        fortBridgerScene.setDistanceFromNauvoo(1183);
        scenes[SceneType.bridger.ordinal()] = fortBridgerScene;

        
        // The Needles. Near the Wyoming border. 
        Scene theNeedlesScene = new Scene();
        theNeedlesScene.setName("The Needles");
        theNeedlesScene.setDescription(
                "This is one of the last rivers along the trail. "
	      + "\n Bear River Crossing. You are leaving Wyoming and "
	      + "\nwill descend into Echo Canyon as you enter the Utah territory.");
        theNeedlesScene.setMapSymbol("TN");
        theNeedlesScene.setBlocked(false);
        Obstacle theNeedlesObstacle = new Obstacle();
        theNeedlesObstacle.setDescription("You got ran over by a wagon wheel.");
        theNeedlesObstacle.setPossibilityOfDeath(50);       // 50%
        theNeedlesObstacle.setAllowSpiritualGuidance(true);
        theNeedlesObstacle.setPossibilityOfHappening(40);   // 40%
        theNeedlesScene.setObstacle(theNeedlesObstacle);            
        theNeedlesScene.setDistanceFromNauvoo(1236);
        scenes[SceneType.needles.ordinal()] = theNeedlesScene;
        

        // Finish Point - Great Salt Lake Valley
        Scene saltLakeValleyScene = new Scene();
        saltLakeValleyScene.setName("Salt Lake Valley");
        saltLakeValleyScene.setDescription(
                "Here you reach the highest point of the journey – "
              + "\n Big Mountain at 8,400 feet. Your final destination is near. "
              + "Congratulations! Well done though good and faithful servants. "
              + "\n You have just completed your long journey and arrived at "
              + "\n the great Salt Lake Vally.");
        saltLakeValleyScene.setMapSymbol("SL");
        saltLakeValleyScene.setBlocked(false);
        saltLakeValleyScene.setDistanceFromNauvoo(1300);
        scenes[SceneType.saltLakeValley.ordinal()] = saltLakeValleyScene;

        return scenes;
    }
    
}
