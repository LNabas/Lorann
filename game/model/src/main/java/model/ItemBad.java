/**
 * 
 */
package model;

import contract.TypeEntity;
import contract.VisualEntity;

/**
 * @author Maxence
 *
 */
public class ItemBad extends Item{
	public boolean hit(){
		return true;
	}
	

	public VisualEntity getVisualType() {
		return VisualEntity.ITEMBAD;
	}

	public TypeEntity getType() {
		return TypeEntity.ITEMBAD;
	}
}
