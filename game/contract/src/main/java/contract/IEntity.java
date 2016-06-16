/**
 * 
 */
package contract;

import java.util.ArrayList;

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
	
	public void move(ArrayList<ArrayList<IEntity>> map, int x, int y);

	public int getX();
	public int getY();
	public void setX(int x);
	public void setY(int y);
	public void die();
	
}
