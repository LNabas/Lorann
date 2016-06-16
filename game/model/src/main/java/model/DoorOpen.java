/**
 * 
 */
package model;

import contract.Permeability;
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
		// TODO Auto-generated method stub
		return null;
	}
}
