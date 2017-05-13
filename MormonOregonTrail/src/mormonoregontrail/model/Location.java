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
 * @author Braden
 */
public class Location implements Serializable{
    
    private String row;
    private String column;
    private String visited;
    private String distanceFromNauvoo;
    
    public Location() {
        
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getVisited() {
        return visited;
    }

    public void setVisited(String visited) {
        this.visited = visited;
    }

    public String getDistanceFromNauvoo() {
        return distanceFromNauvoo;
    }

    public void setDistanceFromNauvoo(String distanceFromNauvoo) {
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
    
    
}
