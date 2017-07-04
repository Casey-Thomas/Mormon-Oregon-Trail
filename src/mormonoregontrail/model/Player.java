/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormonoregontrail.model;

import java.io.Serializable;
import java.util.Objects;
import mormonoregontrail.control.GameControl;

/**
 *
 * @author Laura, Braden, and Mariam
 */
public class Player implements Serializable{
    
    // class instance variables
    private String name;
    InventoryItem[] inventory;    
    
    public Player() {
        inventory = new InventoryItem[10];

        // Money
        InventoryItem money = new InventoryItem();
        money.setDescription("Money");
        money.setQuantityInStock(2000);
        money.setUnits("Dollar");
        inventory[GameControl.Item.money.ordinal()] = money;        
    }    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }  
    
    public InventoryItem[] getInventory() {
        return inventory;
    }

    public void setInventory(InventoryItem[] inventory) {
        this.inventory = inventory;
    }    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public String toString() {
        return "Player{" + "name=" + name + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Player other = (Player) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
    
}
