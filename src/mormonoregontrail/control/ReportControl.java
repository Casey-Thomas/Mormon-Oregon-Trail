/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormonoregontrail.control;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import mormonoregontrail.MormonOregonTrail;
import mormonoregontrail.exceptions.ReportControlException;
import mormonoregontrail.model.Game;
import mormonoregontrail.model.InventoryItem;
import mormonoregontrail.model.Location;
import mormonoregontrail.model.Map;
import mormonoregontrail.model.Player;
import mormonoregontrail.model.Scene;
import mormonoregontrail.view.ErrorView;

/**
 *
 * @author Laura
 */
public class ReportControl {
    
    public static void playerInventoryReport(Player player, String fileName)
            throws ReportControlException {
//        try( FileOutputStream fops = new FileOutputStream(fileName)) {
//            ObjectOutputStream output = new ObjectOutputStream(fops);
//            
//            output.writeObject(player); //write the game object out to a file
//        }
//        catch(Exception e) {
//            throw new ReportControlException(e.getMessage());
//        }
        FileWriter outFile = null;
        try (PrintWriter out = new PrintWriter(fileName)){
            InventoryItem[] playerInventory = player.getInventory();
            DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

            Date date = new Date();

            // create and open a new filestream for the output file
            out.println("\n\n             Player Inventory Report - as of " + sdf.format(date));
            out.printf("%n%-20s%10s%10s%15s%10s", "Description", "Required", "Quantity", "Units", "Price");
            out.printf("%n%-20s%10s%10s%15s%10s", "-----------", "--------", "--------", "-----", "-----");
            
            // print the description, quantity, and price of each item
            for (InventoryItem item : playerInventory) {
                out.printf("%n%-20s%10d%10s%15s%10d", item.getDescription()
                                            , item.getRequiredAmount()
                                            , item.getQuantityInStock()
                                            , item.getUnits()
                                            , item.getCost());
            }
        } catch (IOException ex) {
            ErrorView.display("ReportControl", ex.getMessage());
        }
    } 
    
    /**
     * Mariam E.
     * @param map
     * @param fileName
     * @return 
     * @throws ReportControlException 
     */
    public static boolean sceneReport(Map map, String fileName)
            throws ReportControlException {

        boolean success = true;
        try (PrintWriter out = new PrintWriter(fileName)){
            DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

            Date date = new Date();

            // create and open a new filestream for the output file
            out.println("\n\n             Scene Report - as of " + sdf.format(date));
            out.printf("%n%-30s%-10s%-10s%-10s%-20s", "Name", "Symbol", "Location", "Visited", "Dist. from Nauvoo");
            out.printf("%n%-30s%-10s%-10s%-10s%-20s", "----", "------", "--------", "-------", "-----------------");

            // print the Name, Symbol, Location, Visited, Dist. from Nauvoo
        for (int row = 0; row < map.getRowCount(); row++) {
            for (int column = 0; column < map.getColumnCount(); column++) {
                // create and initialize new Location object instance
                Location location = map.getLocations()[row][column];
                Scene scene = location.getScene();
                out.printf("%n%-30s%-10s%-10d%-10s%-20d", scene.getName()
                                            , scene.getMapSymbol()
                                            , scene.getMapLocation()
                                            , (location.getVisited()?"Y":"N")
                                            , scene.getDistanceFromNauvoo());

            }
        }
            

 
        } catch (IOException ex) {
            ErrorView.display("ReportControl", ex.getMessage());
            success = false;
        }
        return success;
    }    

    /**
    * @author Braden
    */
    public static void storeInventoryReport(Player player, String fileName)
        throws ReportControlException {
//        try( FileOutputStream fops = new FileOutputStream(fileName)) {
//            ObjectOutputStream output = new ObjectOutputStream(fops);
//            
//            output.writeObject(player); //write the game object out to a file
//        }
//        catch(Exception e) {
//            throw new ReportControlException(e.getMessage());
//        }
        Game game = MormonOregonTrail.getCurrentGame();
        FileWriter outFile = null;
        try (PrintWriter out = new PrintWriter(fileName)){
            InventoryItem[] storeInventory = game.getInventory();
            DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

            Date date = new Date();

            // create and open a new filestream for the output file
            out.println("\n\n             Store Inventory Report - as of " + sdf.format(date));
            out.printf("%n%-20s%10s%10s%15s%10s", "Description", "Required", "Quantity", "Units", "Price");
            out.printf("%n%-20s%10s%10s%15s%10s", "-----------", "--------", "--------", "-----", "-----");
            
            // print the description, quantity, and price of each item
            for (InventoryItem item : storeInventory) {
                out.printf("%n%-20s%10d%10s%15s%10d", item.getDescription()
                                            , item.getRequiredAmount()
                                            , item.getQuantityInStock()
                                            , item.getUnits()
                                            , item.getCost());
            }
        } catch (IOException ex) {
            ErrorView.display("ReportControl", ex.getMessage());
        }
    }
    
}
