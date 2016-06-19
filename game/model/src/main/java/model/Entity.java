package model;

import java.util.ArrayList;

import contract.IEntity;
import contract.IMap;
import contract.Permeability;
import contract.TypeEntity;

/**
 * The Class Entity.
 *
 * @author Maxence
 */
abstract class Entity implements IEntity{
	private int x;
	private int y;
	protected int turn = 0;
	protected int old_turn = 0;

	public boolean hit() {
		return false;
	}

	public void move(ArrayList<ArrayList<IEntity>> map, int x, int y) {}

	public Permeability getPermeability() {
		return Permeability.IMPERMEABLE;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

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
	public void LooseFB() {
		// TODO Auto-generated method stub
		
	}
	public void GainFB() {
		// TODO Auto-generated method stub
		
	}
	public boolean hasKey() {
		// TODO Auto-generated method stub
		return false;
	}
}
