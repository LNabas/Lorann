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
	/**
	 * @uml.property  name="ox"
	 */
	int ox=0;
	/**
	 * @uml.property  name="oy"
	 */
	int oy=0;
	/**
	 * @uml.property  name="me"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	VisualEntity me = VisualEntity.FIREBALL;
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
		return me;
	}
	public void move(IMap map, int x, int y){
		if(old_turn != turn){
			switch(me){
			case FIREBALL:
				me = VisualEntity.FIREBALL1;
				break;
			case FIREBALL1:
				me = VisualEntity.FIREBALL2;
				break;
			case FIREBALL2:
				me = VisualEntity.FIREBALL3;
				break;
			case FIREBALL3:
				me = VisualEntity.FIREBALL4;
				break;
			case FIREBALL4:
				me = VisualEntity.FIREBALL;
				break;
			default:
				break;
			}
			if(x+ox < map.getWidth() && y+oy < map.getHeight() && x+ox>0 && y+oy>0){ 
				IEntity e = map.get(x + ox, y + oy);
				if(e==null){
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
