/**
 * 
 */
package contract;

/**
 * @author Maxence
 *
 */
public interface IEntity {
	/**
	 * Hit
	 * @return true if it can kill something
	 */
	public boolean hit();
	/**
	 * get Permeability
	 * @return Permeability
	 */
	public Permeability getPermeability();
	/**
	 * is not a wall
	 * @return true if can be killed
	 */
	public boolean isAlive();
	/**
	 * get type
	 * @return the logical type
	 */
	public TypeEntity getType();
	/**
	 * get Visual type
	 * @return the cosmetic type
	 */
	public VisualEntity getVisualType();
	
	public void move(IMap map, int x, int y);

	public int getX();
	public int getY();
	public void setX(int x);
	public void setY(int y);
	public void die(IMap map);
	public void setLive(int live);
	public void set_turn(int t);
	public boolean hasFB();
	public void LooseFB();
	public void GainFB();
	public void GainKey();
	public boolean hasKey();
}
