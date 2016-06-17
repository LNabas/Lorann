package model;

import contract.IEntity;
import contract.IMap;

/**
 * @author Maxence, Doc0160
 *
 */
public class Map extends FAILEntity implements IMap{
	private IEntity[] map;
	private int width;
	private int height;
	public Map(){
		this(5,5);
	}
	public Map(int w, int h){
		width = w;
		height = h;
		map = new IEntity[width * height];
	}
	private static int getIndex(int col, int row, int width) {
        return row * width + col;
    }
	private void resize(int w, int h){
        int l = w*h;
        int old_l = width*height;
		IEntity [] newData = new IEntity[l];
        for(int i = 0; i<l && i<old_l; i++){
        	newData[i]=map[i];
        }
        height = h;
        width = w;
        map = newData;
	}
	public IEntity get(int x, int y) {
		return map[getIndex(x, y, width)];
	}
	public void  set(int x, int y, IEntity e) {
		if(x+1>width && y+1>height){
			resize(x+1,y+1);
		}else if(y+1>height){
			resize(width,y+1);
		}else if(x+1>width){
			resize(x+1,height);
		}
		map[getIndex(x, y, width)] = e;
	}
	/**
	 * get width
	 * @return width
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * get height
	 * @return height
	 */
	public int getHeight() {
		return height;
	}

	public void setWidth(int w) {
		resize(w, height);
	}

	public void setHeight(int h) {
		resize(width, h);
	}
	public IEntity getPlayer() {
		// TODO Auto-generated method stub
		return null;
	}
	public IEntity getFireBall() {
		// TODO Auto-generated method stub
		return null;
	}
	public void kill(int x, int y) {
		set(x,y,null);
	}
	public void move(int origin_x, int origin_y, int new_x, int new_y) {
		set(new_x,new_y, get(origin_x, origin_y));
		kill(origin_x, origin_y);
	}
	public int getXof(IEntity e) {
		for(int i = 0; i<width*height; i++){
			if(e==map[i]){
				return i%width;
			}
		}
		return -1;
	}
	public int getYof(IEntity e) {
		for(int i = 0; i<width*height; i++){
			if(e==map[i]){
				return i/width;
			}
		}
		return -1;
	}

}
