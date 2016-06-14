/**
 * 
 */
package model;

import contract.Permeability;

/**
 * @author Maxence
 *
 */
public class DoorOpen extends Door{

	public Permeability getPearmeability(){
		return Permeability.PERMEABLE;
	}
}
