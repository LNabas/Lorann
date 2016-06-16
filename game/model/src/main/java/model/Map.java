/**
 * 
 */
package model;

import java.util.ArrayList;

import contract.IEntity;
import contract.IMap;
import contract.VisualEntity;

/**
 * @author Maxence
 *
 */
public class Map extends FAILEntity implements IMap{
	private ArrayList<ArrayList<IEntity>> map;

	public IEntity get(int x, int y) {
		return map.get(x).get(y);
	}

	public int getWidth() {
		return map.size();
	}

	public int getHeight() {
		return map.get(0).size();
	}

	public IEntity getFireBall() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public IEntity getPlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	public void kill(int x, int y) {
		map.get(x).set(y, null);
	}

	public void move(int origin_x, int origin_y, int new_x, int new_y) {
		map.get(new_x).set(new_y, map.get(origin_x).get(origin_y));map.get(origin_x).set(origin_y, null);
	}

	public Object getMap() {
		return map;
	}

}
