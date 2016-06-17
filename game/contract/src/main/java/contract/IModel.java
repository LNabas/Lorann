package contract;

import java.util.Observable;

/**
 * The Interface IModel.
 *
 * @author Doc0160
 */
public interface IModel {

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();
	/**
	 * Is it necessary ?
	 * @return Fireball
	 */
	IEntity getFireball();
	/**
	 * Is it necessary ?
	 * @return Player
	 */
	IEntity getPlayer();
	/**
	 * Return the entire map
	 * @return Map
	 */
	IMap getMap();
	/**
	 * Load next maps
	 */
	void LoadNextMap();
	/**
	 * Reload a fresh instance of the current map
	 */
	void RealoadMap();
	void setDifficulty(int posMenuOpt);
	void ForceRedraw();
	void Mappy(int i);
}
