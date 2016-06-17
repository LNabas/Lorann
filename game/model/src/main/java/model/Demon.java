/**
 * 
 */
package model;

import java.util.Random;
import contract.IMap;
import contract.TypeEntity;

/**
 * PPCH
 * @author Maxence
 *
 */
public abstract class Demon extends Entity{
	private Random randomGenerator = new Random();
	public boolean hit() {
		return true;
	}

	public void move(IMap map, int x, int y) {
		if(turn != old_turn){
			int nx = randomGenerator.nextInt(3)-1;
			int ny = randomGenerator.nextInt(3)-1;
			if(map.get(x+nx, y+ny) == null){
				map.move(x, y, x + nx, y + ny);
			}else if(map.get(x, y+ny) == null){
				map.move(x, y, x, y + ny);
			}else if(map.get(x+nx, y) == null){
				map.move(x, y, x+nx, y);
			}
		}
	}

	public boolean isAlive() {
		return true;
	}

	public void die(IMap map) {
		map.kill(getX(), getY());
	}

	public void setLive(int live) {
		// TODO Auto-generated method stub
		
	}

	public TypeEntity getType() {
		return TypeEntity.DEMON;
	}
	
}
