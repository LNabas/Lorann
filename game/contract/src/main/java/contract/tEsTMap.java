package contract;

import java.util.ArrayList;

public class tEsTMap implements IMap{
	private ArrayList<ArrayList<IEntity>> map = new ArrayList<ArrayList<IEntity>>();
	private class Item implements IEntity{

		public boolean hit() {
			// TODO Auto-generated method stub
			return false;
		}

		public void move(ArrayList<ArrayList<IEntity>> map, int x, int y) {
			// TODO Auto-generated method stub
			
		}

		public Permeability getPermeability() {
			// TODO Auto-generated method stub
			return null;
		}

		public int getX() {
			// TODO Auto-generated method stub
			return 0;
		}

		public int getY() {
			// TODO Auto-generated method stub
			return 0;
		}

		public void setX(int x) {
			// TODO Auto-generated method stub
			
		}

		public void setY(int y) {
			// TODO Auto-generated method stub
			
		}

		public boolean isAlive() {
			// TODO Auto-generated method stub
			return false;
		}

		public TypeEntity getType() {
			// TODO Auto-generated method stub
			return TypeEntity.ITEMGOOD;
		}

		public void die() {
			// TODO Auto-generated method stub
			
		}
		
	}
	private class Paul implements IEntity{

		public boolean hit() {
			// TODO Auto-generated method stub
			return false;
		}

		public void move(ArrayList<ArrayList<IEntity>> map, int x, int y) {
			// TODO Auto-generated method stub
			
		}

		public Permeability getPermeability() {
			// TODO Auto-generated method stub
			return null;
		}

		public int getX() {
			// TODO Auto-generated method stub
			return 0;
		}

		public int getY() {
			// TODO Auto-generated method stub
			return 0;
		}

		public void setX(int x) {
			// TODO Auto-generated method stub
			
		}

		public void setY(int y) {
			// TODO Auto-generated method stub
			
		}

		public boolean isAlive() {
			// TODO Auto-generated method stub
			return false;
		}

		public TypeEntity getType() {
			// TODO Auto-generated method stub
			return TypeEntity.DEMON;
		}

		public void die() {
			// TODO Auto-generated method stub
			
		}
		
	}
	private class Sol implements IEntity{

		public boolean hit() {
			// TODO Auto-generated method stub
			return false;
		}

		public void move(ArrayList<ArrayList<IEntity>> map, int x, int y) {
			// TODO Auto-generated method stub
			
		}

		public Permeability getPermeability() {
			// TODO Auto-generated method stub
			return null;
		}

		public int getX() {
			// TODO Auto-generated method stub
			return 0;
		}

		public int getY() {
			// TODO Auto-generated method stub
			return 0;
		}

		public void setX(int x) {
			// TODO Auto-generated method stub
			
		}

		public void setY(int y) {
			// TODO Auto-generated method stub
			
		}

		public boolean isAlive() {
			// TODO Auto-generated method stub
			return false;
		}

		public TypeEntity getType() {
			return TypeEntity.UNKOWN;
		}

		public void die() {
			// TODO Auto-generated method stub
			
		}
		
	}
	public tEsTMap(){
		/*"*-----------------*
		*------------------*
		*------------------*
		*------------------*
		*------------------*
		*------------------*
		*------------------*
		*------------------*
		*------------------*"*/
		for(int i = 0; i<20; i++){
			ArrayList<IEntity> m = new ArrayList<IEntity>(20);
			for(int j = 0; j<20; j++){
				m.add(new Sol());
			}
			map.add(m);
		}
		map.get(5).set(2, new Item());
		map.get(5).set(6, new Paul());

	}
	public IEntity get(int x, int y) {
		return map.get(x).get(y);
	}

	public int getWidth() {
		return 20;
	}

	public int getHeight() {
		return 20;
	}

	public IEntity getPlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	public void kill(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	public void move(int origin_x, int origin_y, int new_x, int new_y) {
		// TODO Auto-generated method stub
		
	}

	public void reload() {
		// TODO Auto-generated method stub
		
	}

}
