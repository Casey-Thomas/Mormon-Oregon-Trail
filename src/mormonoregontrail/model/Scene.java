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
 * @author Mariam
 */
public class Scene implements Serializable {

    private String name;
    private String description;
    private String obstacle;
    private int mapLocation; // this represents integer location associated with this scence
    private String validDirection;
    private int distanceFromNauvoo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getObstacle() {
        return obstacle;
    }

    public void setObstacle(String obstacle) {
        this.obstacle = obstacle;
    }

    public int getMapLocation() {
        return mapLocation;
    }

    public void setMapLocation(int mapLocation) {
        this.mapLocation = mapLocation;
    }

    public String getValidDirection() {
        return validDirection;
    }

    public void setValidDirection(String validDirection) {
        this.validDirection = validDirection;
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
        hash = 89 * hash + Objects.hashCode(this.name);
        hash = 89 * hash + Objects.hashCode(this.description);
        hash = 89 * hash + Objects.hashCode(this.obstacle);
        hash = 89 * hash + this.mapLocation;
        hash = 89 * hash + Objects.hashCode(this.validDirection);
        hash = 89 * hash + this.distanceFromNauvoo;
        return hash;
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
        final Scene other = (Scene) obj;
        if (this.mapLocation != other.mapLocation) {
            return false;
        }
        if (this.distanceFromNauvoo != other.distanceFromNauvoo) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.obstacle, other.obstacle)) {
            return false;
        }
        if (!Objects.equals(this.validDirection, other.validDirection)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Scene{" + "name=" + name + ", description=" + description + ", obstacle=" + obstacle + ", mapLocation=" + mapLocation + ", validDirection=" + validDirection + ", distanceFromNauvoo=" + distanceFromNauvoo + '}';
    }


    public Scene() {
    }

    public Scene(String name, String description, String obstacle, int mapLocation, String validDirection, int distanceFromNauvoo) {
        this.name = name;
        this.description = description;
        this.obstacle = obstacle;
        this.mapLocation = mapLocation;
        this.validDirection = validDirection;
        this.distanceFromNauvoo = distanceFromNauvoo;
    }

}
