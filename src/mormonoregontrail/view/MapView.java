/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormonoregontrail.view;

import mormonoregontrail.MormonOregonTrail;
import mormonoregontrail.model.Game;
import mormonoregontrail.model.Location;
import mormonoregontrail.model.Map;
import mormonoregontrail.control.MapControl;
import mormonoregontrail.exceptions.MapControlException;

/**
 *
 * @author Laura
 */
public class MapView extends View {

    //private final String map;
    private String promptMessage;
    
    public MapView() {
         super("\n"
         + "\n------------------------------------------"
         + "\n Enter your desired location "
         + "\n------------------------------------------");
    }
    
    @Override
    public boolean doAction(String mapOption) {
       mapOption = mapOption.toUpperCase();
       
       //retrieve the game
       Game game = MormonOregonTrail.getCurrentGame();
       
       // retrieve the map from the game
       Map map = game.getMap();
       
       // retrieve the locations from map
       Location[][] locations = map.getLocations();
       
       for (int row = 0; row < locations.length; row++) {
            for (int column = 0; column < locations[row].length; column++) {
                 if (locations[row][column].getScene() != null) {               
                      if (mapOption.equals(locations[row][column].getScene().getMapSymbol())) {
                          // @Team - Add try . . . catch - 6/28/2017
                           try{
                               MapControl.movePlayer(map, row, column);
                           } catch (MapControlException me) {
                                ErrorView.display(this.getClass().getName(), me.getMessage());
                           }
                           return true;
                      }
                   }
              }
       }
       this.console.println("\n*** Invalid selection *** Try Again later");
       return false;
     }
}

