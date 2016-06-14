/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.Random;
import contract.IEntity;

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

	public void move(ArrayList<ArrayList<IEntity>> map, int x, int y) {
		x += randomGenerator.nextInt(3)-1;// minimum -1, max 1
		y += randomGenerator.nextInt(3)-1;
	}

	public boolean isAlive() {
		return true;
	}

	public void die() {
		// TODO Auto-generated method stub
	}
	
	
	
}
