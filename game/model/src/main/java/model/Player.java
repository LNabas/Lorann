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
	private boolean has_died = false;
	VisualEntity me = VisualEntity.PLAYER;
	public boolean isAlive() {
		return Lives >0;
	}
	public VisualEntity getVisualType() {
		return me;
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
		Lives--;
		has_died=true;
	}
	public void setSprite(VisualEntity v){
		me=v;
	}
	public boolean has_died() {
		return has_died;
	}
	public void updated_died_status() {
		has_died=false;
	}
}
