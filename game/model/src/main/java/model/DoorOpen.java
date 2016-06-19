/**
 * 
 */
package model;

import contract.IMap;
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
		// TODO Auto-generated method stub
		return null;
	}

	public void die(IMap map) {
		// TODO Auto-generated method stub
		
	}
}
