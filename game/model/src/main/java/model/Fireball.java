/**
 * 
 */
package model;

import contract.IEntity;
import contract.IMap;
import contract.Permeability;
import contract.TypeEntity;
import contract.VisualEntity;

/**
 * @author Maxence
 *
 */
public class Fireball extends Entity{
	int ox=0;
	int oy=0;
	public Fireball(int x, int y){
		ox = x;
		oy = y;
	}
	public boolean hit() {
		return false;
	}

	public Permeability getPermeability() {
		return Permeability.PERMEABLE;
	}

	public VisualEntity getVisualType() {
		return VisualEntity.FIREBALL;
	}
	public void move(IMap map, int x, int y){
		if(old_turn != turn){
			if(x<map.getWidth() && y < map.getHeight() && x>0 && y>0){
				IEntity e = map.get(x + ox, y + oy);
				if(e==null || e.getPermeability() == Permeability.PERMEABLE){
					map.move(x, y, x + ox, y + oy);
				}else{
					switch(e.getType()){
					case DEMON:
						map.kill(x + ox, y + oy);
						map.kill(x, y);
						map.getPlayer().GainFB();
						break;
					case PLAYER:
						map.kill(x, y);
						map.getPlayer().GainFB();
						break;
					default:
						ox*=-1;
						oy*=-1;
						break;
					}
				}
			}
		}
	}
	public void die(IMap map) {
		// TODO Auto-generated method stub
	}
	public TypeEntity getType() {
		return TypeEntity.RFB;
	}
}
