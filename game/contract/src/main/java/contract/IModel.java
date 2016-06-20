package contract;

import java.util.Observable;

/**
 * The Interface IModel.
 * @author  Doc0160
 */
public interface IModel {

	/**
	 * Gets the observable.
	 * @return  the observable
	 * @uml.property  name="observable"
	 */
	Observable getObservable();
	/**
	 * Is it necessary ?
	 * @return  Player
	 * @uml.property  name="player"
	 * @uml.associationEnd  
	 */
	IEntity getPlayer();
	/**
	 * Return the entire map
	 * @return  Map
	 * @uml.property  name="map"
	 * @uml.associationEnd  
	 */
	IMap getMap();
	int CurrentMap();
	int MaxMap();
	/**
	 * Load next map
	 */
	void LoadNextMap();
	void setDifficulty(int posMenuOpt);
	void ForceRedraw();
	void Mappy();
	int Difficulty();
	public void removeLife();
	public void resetLives();
	public int getLives();
}
