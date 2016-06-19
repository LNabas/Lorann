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
public class DoorClose extends Door{
	public boolean hit(){
		return true;
	}

	public Permeability getPearmeability(){
		return Permeability.IMPERMEABLE;
	}

	public VisualEntity getVisualType() {
		return VisualEntity.DOOR_CLOSED;
	}

	public TypeEntity getType() {
		return TypeEntity.DOORCLOSE;
	}
}
