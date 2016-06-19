/**
 * 
 */
package model;

import contract.IMap;
import contract.Permeability;

/**
 * @author Maxence
 *
 */
public abstract class Item extends Entity{
	public Permeability getPermeability() {
		return Permeability.PERMEABLE;
	}
	public void die(IMap map) {
		// TODO Auto-generated method stub
		
	}


	public void GainKey() {
		// TODO Auto-generated method stub
		
	}
}
