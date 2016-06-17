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
public class ItemGood extends Item{

	public VisualEntity getVisualType() {
		return VisualEntity.ITEMGOOD;
	}

	public TypeEntity getType() {
		return TypeEntity.ITEMGOOD;
	}
}
