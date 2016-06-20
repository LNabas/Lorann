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
	/**
	 * @uml.property  name="lives"
	 */
	private int Lives = 11;
	/**
	 * @uml.property  name="fb"
	 */
	private boolean fb=true;
	/**
	 * @uml.property  name="has_died"
	 */
	private boolean has_died = false;
	/**
	 * @uml.property  name="me"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
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
	/**
	 * @return
	 * @uml.property  name="lives"
	 */
	public int getLives(){
		return Lives;
	}
}
