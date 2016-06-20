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
	private boolean fb=true;
	VisualEntity me = VisualEntity.PLAYER;
	public boolean isAlive() {
		return true;
	}
	public VisualEntity getVisualType() {
		return me;
	}
	public TypeEntity getType(){
		return TypeEntity.PLAYER;
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
	}
	public void setSprite(VisualEntity v){
		me=v;
	}
}
