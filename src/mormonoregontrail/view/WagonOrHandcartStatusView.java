/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormonoregontrail.view;

/**
 *
 * @author Braden
 */
public class WagonOrHandcartStatusView extends View{
    /**
     * Wagon Or Handcart Status function
     */
    
    public WagonOrHandcartStatusView() {
        
        super("\n"
                 + "\n------------------------------------------------"
                 + "\n| Wagon/Handcart Status                        |"
                 + "\n------------------------------------------------"
                 + "\nP - Perform Maintenance"
                 + "\nW - Check Wagon/Handcart"
                 + "\nI - View Inventory"
                 + "\nQ - Quit"
                 + "\n------------------------------------------------"
                 + "\nPlease choose an option: ");
    }
    
    @Override    
    public boolean doAction(String value) {
        value = value.toUpperCase(); // Converts input to upper case
        
        switch (value) {
            case "P": // Perform Maintenance
                this.performMaintenance();
                break;
            case "W": // Check Wagon/Handcart
                this.checkWagon();
                break;
            case "I": // View Inventory
                this.viewInventory();
                break;
            default:
                this.console.println("\n**Invalid selection *** Try again.");
                break;
        }
        return false;
    }
    
    private void performMaintenance() {
        PerformMaintenanceView performMaintenanceView = new PerformMaintenanceView();
        performMaintenanceView.display();
    }
    private void checkWagon() {
        this.console.println("\n***checkWagon function called ***");
    }
    private void viewInventory() {
        InventoryMenuView inventoryMenuView = new InventoryMenuView();
        inventoryMenuView.display();
    }

}
