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
public class Player extends Entity{
	private int Lives = 11;
	private boolean fb=true;
	
	public boolean isAlive() {
		return Lives >0;
	}

	public void die() {	
		Lives--;
	}

	public VisualEntity getVisualType() {
		return VisualEntity.PLAYER;
	}
	
	public TypeEntity getType(){
		return TypeEntity.PLAYER;
	}
	
	public void setLive(int live){
		Lives = live;
	}
	public boolean hasFB() {
		return fb;
	}
	public void LooseFB() {
		fb=false;
	}
	public void GainFB() {
		fb=true;
	}

	public void die(IMap map) {
		// TODO Auto-generated method stub
		
	}
}
