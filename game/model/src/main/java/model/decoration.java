/**
 * 
 */
package model;

import contract.IMap;
import contract.Permeability;
import contract.TypeEntity;

/**
 * @author Maxence
 *
 */
public abstract class decoration extends Entity{
	public Permeability getPearmeability(){
		return Permeability.IMPERMEABLE;
	}


	public void move(IMap map, int x, int y) {
		// TODO Auto-generated method stub
		
	}
	
	public TypeEntity getType() {
		return TypeEntity.WALL;
	}
	public void GainKey(){}
}
