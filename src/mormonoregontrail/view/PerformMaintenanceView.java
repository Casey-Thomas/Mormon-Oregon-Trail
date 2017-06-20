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
                 + "\nS - Repair a Spoke"
                 + "\nR - Replace a Rim"
                 + "\nT - Check Wagon Tongue or Handcart Handles"
                 + "\nP - Say a Prayer"
                 + "\nF - Feed your Animal"
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
            case "S": // Repair a Spoke
                this.repairSpoke();
                break;
            case "R": // Replace a Rim
                this.replaceRim();
                break;
            case "T": // Check Wagon Tongue or Handcart Handles
                this.checkTongue();
                break;
            case "P": // Say a Prayer
                this.sayPrayer();
                break;
            case "F": // Feed Animal
                this.feedAnimal();
                break;
            case "E": // Repent
                this.repent();
                break;
            case "B": // Talk to your Bishop
                this.talkToBishop();
                break;
            default:
                System.out.println("\n**Invalid selection *** Try again.");
                break;
        }
        return false;
    }
    
    private void changeWheel() {
        System.out.println("\n*** changeWheel() function called ***");
    }
    private void repairSpoke() {
        System.out.println("\n*** repairSpoke() function called ***");
    }
    private void replaceRim() {
        System.out.println("\n*** replaceRim() function called ***");
    }
    private void checkTongue() {
        System.out.println("\n*** checkTongue() function called ***");
    }
    private void sayPrayer() {
        System.out.println("\n*** sayPrayer() function called ***");
    }
    private void feedAnimal() {
        System.out.println("\n*** feedAnimal() function called ***");
    }
    private void repent() {
        System.out.println("\n*** repent() function called ***");
    }
    private void talkToBishop() {
        System.out.println("\n*** talkToBishop() function called ***");
    }
}