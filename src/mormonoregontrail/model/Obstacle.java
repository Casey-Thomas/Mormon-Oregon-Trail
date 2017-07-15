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
 * @author Mariam E.
 */
public class Obstacle implements Serializable{
    String  description;     //Describes the obstacle
    boolean allowSpiritualGuidance;
    int  possibilityOfHappening;    //percentage of event occuring (0-100)
    int  possibilityOfDeath;        //percentage of death occuring (0-100)

    public Obstacle(String description, boolean allowSpiritualGuidance, int possibilityOfHappening, int possibilityOfDeath) {
        this.description = description;
        this.allowSpiritualGuidance = allowSpiritualGuidance;
        this.possibilityOfHappening = possibilityOfHappening;
        this.possibilityOfDeath = possibilityOfDeath;
    }


    public Obstacle() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAllowSpiritualGuidance() {
        return allowSpiritualGuidance;
    }

    public void setAllowSpiritualGuidance(boolean allowSpiritualGuidance) {
        this.allowSpiritualGuidance = allowSpiritualGuidance;
    }

    public int getPossibilityOfHappening() {
        return possibilityOfHappening;
    }

    public void setPossibilityOfHappening(int possibilityOfHappening) {
        this.possibilityOfHappening = possibilityOfHappening;
    }

    public int getPossibilityOfDeath() {
        return possibilityOfDeath;
    }

    public void setPossibilityOfDeath(int possibilityOfDeath) {
        this.possibilityOfDeath = possibilityOfDeath;
    }

    @Override
    public String toString() {
        return "Obstacle{" + "description=" + description + ", allowSpiritualGuidance=" + allowSpiritualGuidance + ", possibilityOfHappening=" + possibilityOfHappening + ", possibilityOfDeath=" + possibilityOfDeath + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.description);
        hash = 61 * hash + (this.allowSpiritualGuidance ? 1 : 0);
        hash = 61 * hash + this.possibilityOfHappening;
        hash = 61 * hash + this.possibilityOfDeath;
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
        final Obstacle other = (Obstacle) obj;
        if (this.allowSpiritualGuidance != other.allowSpiritualGuidance) {
            return false;
        }
        if (this.possibilityOfHappening != other.possibilityOfHappening) {
            return false;
        }
        if (this.possibilityOfDeath != other.possibilityOfDeath) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }


    
}
