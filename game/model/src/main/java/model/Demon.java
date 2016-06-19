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
	protected Random randomGenerator = new Random();
	public boolean hit() {
		return true;
	}

	public void move(IMap map, int x, int y) {
		if(turn != old_turn){
			int max_r = 5;
			int nx = 0;
			int ny = 0;
			int retry = 0;
			boolean loop = true;
			while(loop && retry<max_r){
				loop = false;
				nx = randomGenerator.nextInt(3)-1;
				ny = randomGenerator.nextInt(3)-1;
				if(map.get(x + nx, y + ny) == null){
				}else if(map.get(x + nx, y + ny).getType() == TypeEntity.PLAYER){
					map.get(x + nx, y + ny).die(map);
					return;
				}else if(map.get(x, y + ny) == null){
					nx = 0;
				}else if(map.get(x + nx, y) == null){
					ny = 0;
				}else{
					loop = true;
				}
				retry++;
			}
			if(retry<max_r){
				map.move(x, y, x + nx, y + ny);
			}
		}
	}

	public boolean isAlive() {
		return true;
	}

	public void die(IMap map) {
		map.kill(getX(), getY());
	}

	public TypeEntity getType() {
		return TypeEntity.DEMON;
	}
}
