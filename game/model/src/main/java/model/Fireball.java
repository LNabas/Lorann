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

	public boolean hit() {
		return true;
	}

	public void move(ArrayList<ArrayList<IEntity>> map, int x, int y) {
		
	}

	public Permeability getPermeability() {
		return Permeability.PERMEABLE;
	}

	public VisualEntity getVisualType() {
		return VisualEntity.FIREBALL;
	}

	public void setLive(int live) {
		// TODO Auto-generated method stub
		
	}
}
