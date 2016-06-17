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
public class Key extends ItemGood{
	public TypeEntity getType(){
		return TypeEntity.KEY;
	}
	
	public VisualEntity getVisualType() {
		return VisualEntity.KEY;
	}
}
