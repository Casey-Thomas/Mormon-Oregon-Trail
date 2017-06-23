/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormonoregontrail.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Braden
 */
public class Location implements Serializable{
    
    private int row;
    private int column;
    private Boolean visited;
    private int distanceFromNauvoo;
    private Scene scene;
    private ArrayList<Actor> actors;
    
    public Location() {
        
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean getVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getDistanceFromNauvoo() {
        return distanceFromNauvoo;
    }

    public void setDistanceFromNauvoo(int distanceFromNauvoo) {
        this.distanceFromNauvoo = distanceFromNauvoo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.row);
        hash = 53 * hash + Objects.hashCode(this.column);
        hash = 53 * hash + Objects.hashCode(this.visited);
        hash = 53 * hash + Objects.hashCode(this.distanceFromNauvoo);
        return hash;
    }

    @Override
    public String toString() {
        return "Location{" + "row=" + row + ", column=" + column + ", visited=" + visited + ", distanceFromNauvoo=" + distanceFromNauvoo + '}';
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
        final Location other = (Location) obj;
        if (!Objects.equals(this.row, other.row)) {
            return false;
        }
        if (!Objects.equals(this.column, other.column)) {
            return false;
        }
        if (!Objects.equals(this.visited, other.visited)) {
            return false;
        }
        if (!Objects.equals(this.distanceFromNauvoo, other.distanceFromNauvoo)) {
            return false;
        }
        return true;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public boolean isVisited() {
        return visited;
    }

    public Scene getScene() {
        return scene;
    }    
}
