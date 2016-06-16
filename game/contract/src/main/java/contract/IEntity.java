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
	
	public boolean hit();
	
	public void move(ArrayList<ArrayList<IEntity>> map, int x, int y);
	
	public Permeability getPermeability();

	public int getX();
	public int getY();
	public void setX(int x);
	public void setY(int y);
	public boolean isAlive();
	public TypeEntity getType();
	public void die();
	
}
