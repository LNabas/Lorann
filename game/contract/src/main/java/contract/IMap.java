package contract;

public interface IMap {
	/**
	 * Get Entity in pos x,y
	 * @param x pos x
	 * @param y pos y
	 * @return Entity
	 */
	public IEntity get(int x, int y);
	/**
	 * get Width
	 * @return width
	 */
	public int getWidth();
	public int getHeight();
	public IEntity getPlayer();
	public IEntity getFireBall();
	public void kill(int x, int y);
	public void move(int origin_x, int origin_y, int new_x, int new_y);
	public void setWidth(int x);
	public void setHeight(int y);
	public int getXof(IEntity e);
	public int getYof(IEntity e);
	public void set(int x, int y, IEntity e);
}
