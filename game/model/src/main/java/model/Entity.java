package model;

import java.util.ArrayList;

import contract.IEntity;
import contract.IMap;
import contract.Permeability;
import contract.VisualEntity;

/**
 * The Class Entity.
 *
 * @author Maxence
 */
abstract class Entity implements IEntity{
	/**
	 * @uml.property  name="x"
	 */
	private int x;
	/**
	 * @uml.property  name="y"
	 */
	private int y;
	/**
	 * @uml.property  name="turn"
	 */
	protected int turn = 0;
	/**
	 * @uml.property  name="old_turn"
	 */
	protected int old_turn = 0;

	public boolean hit() {
		return false;
	}

	public void move(ArrayList<ArrayList<IEntity>> map, int x, int y) {}

	public Permeability getPermeability() {
		return Permeability.IMPERMEABLE;
	}

	/**
	 * @return
	 * @uml.property  name="x"
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return
	 * @uml.property  name="y"
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param x
	 * @uml.property  name="x"
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @param y
	 * @uml.property  name="y"
	 */
	public void setY(int y) {
		this.y=y;
	}

	public boolean isAlive() {
		return false;
	}

	public void die() {	}
	public void move(IMap map, int x, int y){
		
	}

	public void setLive(int live) {
		// TODO Auto-generated method stub
		
	}
	
	public void set_turn(int t){
		old_turn = turn;
		turn = t;
	}
	public boolean hasFB() {
		return false;
	}
	public void LooseFB() {}
	public void GainFB() {}
	public void setSprite(VisualEntity v){}
	public boolean has_died() {
		return false;
	}

	public void updated_died_status() {}
	public int getLives(){
		return 0;
		
	}
}
