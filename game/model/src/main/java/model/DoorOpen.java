/**
 * 
 */
package model;

import contract.Permeability;
import contract.TypeEntity;
import contract.VisualEntity;

/**
 * @author Maxence
 *
 */
public class DoorOpen extends Door{

	public Permeability getPearmeability(){
		return Permeability.PERMEABLE;
	}

	public VisualEntity getVisualType() {
		return VisualEntity.DOOR_OPEN;
	}

	public TypeEntity getType() {
		return TypeEntity.DOOROPEN;
	}
}
