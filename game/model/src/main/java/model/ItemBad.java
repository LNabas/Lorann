/**
 * 
 */
package model;

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
}
