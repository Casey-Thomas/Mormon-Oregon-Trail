/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormonoregontrail.view;

/**
 *
 * @author Laura
 */
public class InventoryMenuView extends View {
    /**
     * InventoryMenuView function
     */
    public InventoryMenuView() {            
        super("\n"
                 + "\n------------------------------------------------"
                 + "\n| View Inventory Menu                          |"
                 + "\n------------------------------------------------"
                 + "\nO - Oxen"
                 + "\nW - Spare Wheel(s) for handcart/wagon"
                 + "\nA - Spare Axle(s) for handcart/wagon"
                 + "\nT - Spare Tongue(s) for handcart/wagon"
                 + "\nB - Amount of Bullets"
                 + "\nF - Amount of Food (in pounds)"
                 + "\nM - Money"
                 + "\nQ - Quit"
                 + "\n------------------------------------------------"
                 + "\nPlease choose an option: ");
    }
    
    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase(); // convert choice to upper case
        
        switch (value) {
            case "O": // Oxen
                this.oxen();
                break;
             case "W": // Handcart/Wagon Wheels
                this.wheels();
                break;
            case "A": // Handcart/Wagon Axles
                this.axles();
                break;    
            case "T": // Handcart/Wagon Tongues
                this.tongues();
                break;
            case "B": // Bullets
                this.bullets();
                break;
            case "F": // Food
                this.food();
                break;    
            case "M": // Quantity of money
                this.money();
                break;
            default:
                System.out.println("\n*** Invalid selection *** Try again.");
                break;
        }
        return false;
    }

    private void oxen() {        
        System.out.println("\n*** oxen() inventory function called ***");
    }
    
    private void wheels() {        
        System.out.println("\n*** handcart/wagon wheels() inventory function called ***");
    }

    private void axles() {
        System.out.println("\n*** handcart/wagon axles() inventory function called ***");
    }

    private void tongues() {
        System.out.println("\n*** handcart/wagon tongues() inventory function called ***");
    }

    private void bullets() {
        System.out.println("\n*** bullets() inventory function called ***");
    }

    private void food() {
        System.out.println("\n*** food() inventory function called ***");
    }
    
    private void money() {
        System.out.println("\n*** money() inventory function called ***");
    }

}
