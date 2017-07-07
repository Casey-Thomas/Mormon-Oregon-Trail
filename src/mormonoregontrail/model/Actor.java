/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormonoregontrail.model;

import java.io.Serializable;

/**
 *
 * @author Team (06.21.2017)
 */
public class Actor implements Serializable{
    
    private String name;
    private String description;
    private int row;
    private int column;
    
//    Actor(String description){
//        this.description = description;
//        coordinates = new Point(1,1);
//    }

    public Actor() {
        this.name = name;
        this.description = description;
        this.row = row;
        this.column = column;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

//    @Override
//    public String toString() {
//        return "Actor{" + "name=" + name + ", description=" + description + ", coordinates=" + coordinates + '}';
//    } 

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}