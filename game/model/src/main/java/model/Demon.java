/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.Random;
import contract.IEntity;
import contract.IMap;
import contract.VisualEntity;

/**
 * PPCH
 * @author Maxence
 *
 */
public class Demon extends Entity{
	private Random randomGenerator = new Random();
	public boolean hit() {
		return true;
	}

	public void move(IMap map, int x, int y) {
		int nx = randomGenerator.nextInt(3)-1;
		//if(map.get(, y))
		map.move(x, y, x + nx, y + randomGenerator.nextInt(3)-1);
		System.out.println("mama");
	}

	public boolean isAlive() {
		return true;
	}

	public void die() {
		//kill(getX(), getY());
		
	}

	public VisualEntity getVisualType() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setLive(int live) {
		// TODO Auto-generated method stub
		
	}
	
}
