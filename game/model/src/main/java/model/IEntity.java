/**
 * 
 */
package model;

import java.util.ArrayList;

/**
 * @author Maxence
 *
 */
public interface IEntity {
	
	TypeMobile Type;
	ISprite Sprite;
	int PositionX;
	int PositionY;
	
	public boolean hit();
	
	public void move(ArrayList<ArrayList<IEntity>> map, int x, int y);
	
	public Permeability getPermeability();
}
