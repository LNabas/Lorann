/**
 * 
 */
package model;

import java.util.ArrayList;
import contract.IEntity;
import contract.IMap;
import contract.Permeability;
import contract.VisualEntity;

/**
 * @author Maxence
 *
 */
public class Fireball extends Entity{
	int ox;
	int oy;
	public Fireball(int ox, int oy){
		this.ox = ox;
		this.oy = oy;
	}
	public boolean hit() {
		return true;
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
	public void move(IMap map, int x, int y){
		if(x<map.getWidth() && y < map.getHeight()){
			System.out.println("a");
			map.move(x, y, x+ox, y+oy);
			System.out.println("-");
		}
	}
}
