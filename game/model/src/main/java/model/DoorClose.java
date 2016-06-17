/**
 * 
 */
package model;

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
}
