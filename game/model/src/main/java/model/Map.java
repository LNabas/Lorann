/**
 * 
 */
package model;

import java.util.ArrayList;
import contract.IEntity;
import contract.IMap;

/**
 * @author Maxence, Doc0160
 *
 */
public class Map extends FAILEntity implements IMap{
	private ArrayList<ArrayList<IEntity>> map;

	public IEntity get(int x, int y) {
		return map.get(x).get(y);
	}
	public IEntity set(int x, int y, IEntity e) {
		if(x>getWidth()){
			setWidth(x);
		}if(x>getHeight()){
			setHeight(x);
		}
		return map.get(x).set(y, e);
	}
	/**
	 * get width
	 * @return width
	 */
	public int getWidth() {
		return map.size();
	}
	/**
	 * get height
	 * @return height
	 */
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

	public void setWidth(int x) {
		for(int i = map.size(); i<x; i++){
			map.add(new ArrayList<IEntity>());
		}
		setHeight(getHeight());
	}

	public void setHeight(int y) {
		for(int i = 0; i<map.size(); i++){
			for(int j = map.get(i).size(); j<y; j++){
				map.get(i).add(null);
			}
		}
	}
	public int getXof(IEntity e) {
		for(int x = 0;x<getWidth(); x++){
			for(int y = 0; y<getWidth(); y++){
				if(map.get(x).get(y) == e){
					return x;
				}
			}
		}
		return -1;
	}
	public int getYof(IEntity e) {
		for(int x = 0;x<getWidth(); x++){
			for(int y = 0; y<getWidth(); y++){
				if(map.get(x).get(y) == e){
					return y;
				}
			}
		}
		return -1;
	}

}
