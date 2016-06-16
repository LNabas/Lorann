/**
 * 
 */
package model;

/**
 * @author Maxence
 *
 */
public class Player extends Entity{
	private int Lives = 11;
	
	public boolean isAlive() {
		return true;
	}

	public void die() {	
		Lives = Lives - 1;
		
	}
	
	
}
