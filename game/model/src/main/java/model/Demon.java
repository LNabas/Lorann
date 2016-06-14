/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.Random;

import contract.IEntity;
import contract.Permeability;

/**
 * @author Maxence
 *
 */
public class Demon implements IEntity{
	
	private int x;
	private int y;
	private Random randomGenerator = new Random();
	private int c;


	public boolean hit() {
		// TODO Auto-generated method stub
		return false;
	}

	public void move(ArrayList<ArrayList<IEntity>> map, int x, int y) {
		x += randomGenerator.nextInt(3)-1;// minimum -1, max 1
		y += randomGenerator.nextInt(3)-1;
	}

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
		// TODO Auto-generated method stub
		
	}

	public void setY(int y) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
