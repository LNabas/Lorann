/**
 * 
 */
package model;

import contract.IMap;
import contract.TypeEntity;
import contract.VisualEntity;

/**
 * @author Maxence
 *
 */
public class DoorClose extends Door{
	public boolean hit(){
		return true;
	}

	public VisualEntity getVisualType() {
		return VisualEntity.DOOR_CLOSED;
	}

	public TypeEntity getType() {
		// TODO Auto-generated method stub
		return null;
	}

	public void die(IMap map) {
		// TODO Auto-generated method stub
		
	}
}
