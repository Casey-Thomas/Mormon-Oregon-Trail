/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormonoregontrail.view;

/**
 *
 * @author Team - stub function
 * @author Laura - full menu with completed and stub functions 6/17/2017
 */
public class GameMenuView extends View{
    
    /**
     * MainMenuView function
     */
    public GameMenuView() {            
        super("\n"
            + "\n------------------------------------------------"
            + "\n| Game Menu                                    |"
            + "\n------------------------------------------------"
            + "\nM - Show Map"
            + "\nI - Show Inventory"
            + "\nP - Purchase Items from Store"
            + "\nH - Hunt (Scavenge) for Supplies"
            + "\nO - Overcome an Obstacle"
            + "\nW - Wagon/Handcart Status"
            + "\nV - Verify Wagon or Cart can Function"
            + "\nF - Perform Maintenance (Fix)"
            + "\nG - Seek Spiritual Guidance"
            + "\nA - Advance Along the Trail"
            + "\nN - Estimate Resources Needed"
            + "\nQ - Quit"
            + "\n------------------------------------------------"
            + "\nPlease choose an option: ");
    }
    
    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase(); // convert choice to upper case
        
        switch (value) {
            case "M": // show the map
                this.showMap();
                break;
            case "I": // show inventory
                this.displayInventoryMenu();
                break;
            case "P": // purchase items from the store
                this.displayPurchaseFromStoreMenu();
                break;
            case "H": // hunt (scavenge) for supplies
                this.huntForSupplies();
                break;
            case "O": // overcome an obstacle
                this.displayOvercomeObstacleMenu();
                break;
            case "W": // check the status of the wagon
                this.wagonStatus();
                break;
            case "V": // verify the wagon is functioning
                this.verifyWagonCanFunction();
                break;
            case "F": // perform wagon maintenance (fix)
                this.performMaintenance();
                break;
            case "G": // seek spiritual guidance
                this.seekSpiritualGuidance();
                break;
            case "A": // advance along the trail
                this.displayUserDirectionMenu();
                break;
            case "N": // estimate resources needed
                this.displayResourcesNeeded();
                break;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;
        }
        
        return false;
    }

    private void showMap() {
        System.out.println("\n*** showMap() function called ***");
    }

    private void displayInventoryMenu() {
        InventoryMenuView inventoryMenuView = new InventoryMenuView();
        inventoryMenuView.display();
    }

    private void displayPurchaseFromStoreMenu() {
        StorePurchaseView storePurchaseView = new StorePurchaseView();
        storePurchaseView.display();
    }

    private void huntForSupplies() {
        System.out.println("\n*** huntForSupplies() function called ***");
    }

    private void displayOvercomeObstacleMenu() {
        HandleAnObstacleMenuView handleObstacleView = new HandleAnObstacleMenuView();
        handleObstacleView.display();
    }

    private void wagonStatus() {
        WagonOrHandcartStatusView wagonOrHandcartStatusView = new WagonOrHandcartStatusView();
        wagonOrHandcartStatusView.display();
    }

    private void verifyWagonCanFunction() {
        System.out.println("\n*** verifyWagonCanFunction() function called ***");
    }

    private void performMaintenance() {
        PerformMaintenanceView performMaintenanceView = new PerformMaintenanceView();
        performMaintenanceView.display();
    }

    private void seekSpiritualGuidance() {
        System.out.println("\n*** seekSpiritualGuidance() function called ***");
    }

    private void displayUserDirectionMenu() {
        UserDirectionMenuView userDirectionView = new UserDirectionMenuView();
        int location = 1;
        int daysTraveled = 1;
        userDirectionView.setLocation(location);
        userDirectionView.setDaysTraveled(daysTraveled);
        userDirectionView.display();
        location = userDirectionView.getLocation();
        daysTraveled = userDirectionView.getDaysTraveled();
    }

    private void displayResourcesNeeded() {
        ResourcesNeededView resourcesNeededView = new ResourcesNeededView();
        resourcesNeededView.displayResourcesNeededView();
    }

    
}
