/**
 * 
 */
package immobille;

import java.util.ArrayList;
import contract.IEntity;
import contract.Permeability;

/**
 * @author Maxence
 *
 */
public class Item implements IEntity{

	public boolean hit() {
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

}
