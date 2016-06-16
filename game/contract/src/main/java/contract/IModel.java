package contract;

import java.util.Observable;

/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel {

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();
	
	IEntity getFireball();
	IEntity getPlayer();
	IMap getMap();

	void LoadNextMap();
	void RealoadMap();
}
