package model;

import contract.IEntity;
import contract.IMap;
import contract.TypeEntity;

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
	 public void resize(int cols, int rows) {
		 IEntity [] newData = new IEntity[cols * rows];
	        int colsToCopy = Math.min(cols, this.width);
	        int rowsToCopy = Math.min(rows, this.height);
	        for (int i = 0; i < rowsToCopy; ++i) {
	            int oldRowStart = getIndex(0, i, this.width);
	            int newRowStart = getIndex(0, i, cols);
	            for(int j = 0; j<colsToCopy; j++){
	            	newData[newRowStart+j]=map[oldRowStart+j];
	            }
	        }
	        height = rows;
	        width = cols;
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
	 * @return  width
	 * @uml.property  name="width"
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * get height
	 * @return  height
	 * @uml.property  name="height"
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
		for(int x = 0; x<getWidth(); x++)for(int y = 0; y<getHeight(); y++)if(get(x,y)!=null)if(get(x,y).getType()==TypeEntity.PLAYER){
			get(x,y).setX(x);
			get(x,y).setY(y);
			return get(x,y);
		}
		return null;
	}
	public void kill(int x, int y) {
		set(x,y,null);
	}
	public void move(int origin_x, int origin_y, int new_x, int new_y) {
		if(new_x>-1 && new_y>-1 && new_x<getWidth() && new_y<getHeight()){
			set(new_x,new_y, get(origin_x, origin_y));
		}
		kill(origin_x, origin_y);
	}
	public int getXof(IEntity e) {
		for(int i = 0; i<width*height; i++){
			if(map[i] != null && map[i].equals(e)){
				return i%width;
			}
		}
		return -1;
	}
	public int getYof(IEntity e) {
		for(int i = 0; i<width*height; i++){
			if(map[i] != null && map[i].equals(e)){
				return i/width;
			}
		}
		return -1;
	}
	public void addFireball(int x, int y, int ox, int oy){
		set(x, y, new Fireball(ox, oy));
	}

	public void OpenDoor() {
		for(int x = 0; x<getWidth();x++)
			for(int y = 0; y<getHeight();y++)
				if(get(x, y)!=null)
					if(get(x, y).getType()==TypeEntity.DOORCLOSE)
						set(x,y, new DoorOpen());
	}
	@Override
	public IMap clone() {
	    try {
			return (IMap) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
}
