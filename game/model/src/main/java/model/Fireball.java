/**
 * 
 */
package model;

import java.util.ArrayList;
import contract.IEntity;
import contract.Permeability;
import contract.VisualEntity;

/**
 * @author Maxence
 *
 */
public class Fireball extends Entity{

	private int X = 0;
	private int Y = 0;
	public boolean hit() {
		return true;
	}

	public void move(ArrayList<ArrayList<IEntity>> map, int x, int y) {
		
	}

	public Permeability getPermeability() {
		return Permeability.PERMEABLE;
	}

	public int getX() {
		return X;
	}

	public int getY() {
		return Y;
	}

	public void setX(int x) {
		X=x;
	}

	public void setY(int y) {
		Y=y;
	}

	public VisualEntity getVisualType() {
		return VisualEntity.FIREBALL;
	}
}
