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
public class StorePurchaseView extends View{
    /**
     * Store Purchase function
     */
    
    public StorePurchaseView() {
        
        super("\n"
                 + "\n------------------------------------------------"
                 + "\n|   Purchase Menu - See what you can buy...    |"
                 + "\n------------------------------------------------"
                 + "\nO - Buy oxen"
                 + "\nF - Buy food"
                 + "\nC - Buy clothing"
                 + "\nB - Buy bullets"
                 + "\nA - Buy handcart/wagon axles"
                 + "\nW - Buy handcart/wagon wheels"
                 + "\nT - Buy handcart/wagon tongues"
                 + "\nQ - Quit"
                 + "\n------------------------------------------------"
                 + "\nPlease choose an option: ");
    }
    
    @Override    
    public boolean doAction(String value) {
        value = value.toUpperCase(); // Converts input to upper case
        
        switch (value) {
            case "O": // Quantity of Oxen
                this.buyOxen();
                break;
            case "F": // Quantity of food
                this.buyFood();
                break;
            case "C": // Quantity of clothing
                this.buyClothes();
                break;
            case "B": // Quantity of bullets
                this.buyBullets();
                break;
            case "A": // Quantity of handcart/wagon axles
                this.buyAxles();
                break;
            case "W": // Quantity of handcart/wagon wheels
                this.buyWheels();
                break;
            case "T": // Quantity of handcart/wagon tongues
                this.buyTongues();
                break;
            default:
                System.out.println("\n**Invalid selection *** Try again.");
                break;
        }
        return false;
    }
    
    private void buyOxen() {
        System.out.println("\n*** buyOxen function called ***");
    }
    
    private void buyFood() {
        System.out.println("\n*** buyFood function called ***");
    }
    
    private void buyClothes() {
        System.out.println("\n*** buyClothes function called ***");
    }
    
    private void buyBullets() {
        System.out.println("\n*** buyBullets function called ***");
    }
    
    private void buyAxles() {
        System.out.println("\n*** buyAxles function called ***");
    }
    
    private void buyWheels() {
        System.out.println("\n*** buyWheels function called ***");
    }
    
    private void buyTongues() {
        System.out.println("\n*** buyTongues function called ***");
    }
}
