package model;

import java.util.ArrayList;

import contract.IEntity;
import contract.Permeability;
import contract.TypeEntity;

/**
 * The Class Entity.
 *
 * @author Maxence
 */
class Entity implements IEntity{
	private int x;
	private int y;

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

	public TypeEntity getType() {
		return TypeEntity.UNKOWN;
	}

}
