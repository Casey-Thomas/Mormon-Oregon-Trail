/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormonoregontrail.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Team (06.21.2017)
 */
public enum Actor implements Serializable{
    
    Brigham("He is the prophet chosen to lead the church to the Salt Lake Valley."),
    Mariam("Brigham's wife and confidant."),
    William("Chosen to be a help and guide for this journey."),
    Eliza("First born daughter whose age is now 17 years and a very good cook."),
    Laura("The youngest daughter and loyal helper to her older sister, Eliza.");
    
    private final String description;
    private final Point coordinates;
    
    Actor(String description){
        this.description = description;
        coordinates = new Point(1,1);
    }

    public String getDescription() {
        return description;
    }

    public Point getCoordinates() {
        return coordinates;
    }
//    @Override
//    public String toString() {
//        return "Actor{" + "name=" + name + ", description=" + description + ", coordinates=" + coordinates + '}';
//    } 
}