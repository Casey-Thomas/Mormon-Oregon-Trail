/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormonoregontrail.control;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import mormonoregontrail.exceptions.ReportControlException;
import mormonoregontrail.model.InventoryItem;
import mormonoregontrail.model.Player;
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
}
