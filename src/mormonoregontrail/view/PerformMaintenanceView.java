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
public class PerformMaintenanceView extends View{
    /**
     * Perform Maintenance function
     */
    
    public PerformMaintenanceView() {
        
        super("\n"
                 + "\n------------------------------------------------"
                 + "\n| Perform Maintenance                          |"
                 + "\n------------------------------------------------"
                 + "\nW - Change a Wheel"
                 + "\nP - Say a Prayer"
                 + "\nE - Repent"
                 + "\nB - Talk to your Bishop"
                 + "\nQ - Quit"
                 + "\n------------------------------------------------"
                 + "\nPlease choose an option: ");
    }
    
    @Override    
    public boolean doAction(String value) {
        value = value.toUpperCase(); // Converts input to upper case
        
        switch (value) {
            case "W": // Change a Wheel
                this.changeWheel();
                break;
            case "P": // Say a Prayer
                this.sayPrayer();
                break;
            case "E": // Repent
                this.repent();
                break;
            case "B": // Talk to your Bishop
                this.talkToBishop();
                break;
            default:
                this.console.println("\n**Invalid selection *** Try again.");
                break;
        }
        return false;
    }
    
    private void changeWheel() {
        this.console.println("\nYou successfully changed the wheel.");
    }
    private void sayPrayer() {
        this.console.println("\nYour prayer was heard but may not be answered yet.");
    }
    private void repent() {
        this.console.println("\nThe Lord accepts your suplication.");
    }
    private void talkToBishop() {
        this.console.println("\nCould you even find your bishop?");
    }
}