/**
 * 
 */
package model;

import contract.VisualEntity;

/**
 * @author Maxence
 *
 */
public class Player extends Entity{
	private int Lives = 11;
	
	public boolean isAlive() {
		if(Lives >0){
			return true;
		}
		else{
			return false;
		}
		
	}

	public void die() {	
		Lives = Lives - 1;
		
	}

	public VisualEntity getVisualType() {
		return VisualEntity.PLAYER;
	}
	
	
}
