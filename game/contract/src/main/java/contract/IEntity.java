/**
 * 
 */
package contract;

/**
 * @author  Maxence
 */
public interface IEntity {
	/**
	 * Hit
	 * @return true if it can kill something
	 */
	public boolean hit();
	/**
	 * get Permeability
	 * @return  Permeability
	 * @uml.property  name="permeability"
	 * @uml.associationEnd  
	 */
	public Permeability getPermeability();
	/**
	 * is not a wall
	 * @return true if can be killed
	 */
	public boolean isAlive();
	/**
	 * get type
	 * @return  the logical type
	 * @uml.property  name="type"
	 * @uml.associationEnd  
	 */
	public TypeEntity getType();
	/**
	 * get Visual type
	 * @return  the cosmetic type
	 * @uml.property  name="visualType"
	 * @uml.associationEnd  
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
	public void setSprite(VisualEntity v);
	//public boolean has_died();
	//public void updated_died_status();
	//public int getLives();
}
