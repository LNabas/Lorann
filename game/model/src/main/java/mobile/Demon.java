/**
 * 
 */
package mobile;

import java.util.ArrayList;

import contract.IEntity;
import contract.Permeability;

/**
 * @author Maxence
 *
 */
public class Demon implements IEntity{

	private int c;


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
	
	
	public void PosDemon(){
		c = (int)( Math.random() * ( 1 - (-1) + 1 ) ) + (-1);
		
		
	}
	
	
	
}
