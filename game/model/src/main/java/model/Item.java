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
public class Item extends Entity{
	public Permeability getPermeability() {
		return Permeability.PERMEABLE;
	}

	public VisualEntity getVisualType() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setLive(int live) {
		// TODO Auto-generated method stub
		
	}

	public TypeEntity getType() {
		// TODO Auto-generated method stub
		return null;
	}

	public void die(IMap map) {
		// TODO Auto-generated method stub
		
	}

}
