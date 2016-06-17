package contract;

public interface IMap{
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
	/**
	 * get Height
	 * @return height
	 */
	public int getHeight();
	/**
	 * set Width
	 * @param x width
	 */
	public void setWidth(int x);
	/**
	 * set Height
	 * @param y height
	 */
	public void setHeight(int y);
	/**
	 * Set entity to map at position x,y
	 * @param x pos x
	 * @param y pos y
	 * @param e Entity
	 */
	public void set(int x, int y, IEntity e);
	/**
	 * make an entity at position x, y disapear
	 * @param x pos x
	 * @param y pos y
	 */
	public void kill(int x, int y);
	/**
	 * "teleport" an entity
	 * @param origin_x pos x origin
	 * @param origin_y pos y origin
	 * @param new_x new x
	 * @param new_y new y
	 */
	public void move(int origin_x, int origin_y, int new_x, int new_y);
	public int getXof(IEntity e);
	public int getYof(IEntity e);
	public IEntity getPlayer();
	public IEntity getFireBall();
	public void addFireball(int x, int y, int ox, int oy);
	public void push();
}
