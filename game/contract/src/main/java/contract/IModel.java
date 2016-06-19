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
	int CurrentMap();
	int MaxMap();
	void LoadNextMap();
	void setDifficulty(int posMenuOpt);
	void ForceRedraw();
	void Mappy();
}
