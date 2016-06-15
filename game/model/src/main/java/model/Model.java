package model;

import java.sql.SQLException;
import java.util.Observable;

import contract.IEntity;
import contract.IMap;
import contract.IModel;

/**
 * The Class Model.
 *
 * @author somebody maybe
 */
public class Model extends Observable implements IModel {

	/** The message. */
	private String message;
	private IMap map;

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		// TODO(doc): 
			// * connect to bdd
			// * instantiate the map in "map"
			// * load the map from bdd
			// * find player on the "map" and store it in "player"
			// * it's dangerous to go alone! Take this.
				// https://www.youtube.com/watch?v=Eb6cGHK4_yc
		this.message = "";
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage()
	 */
	public String getMessage() {
		return this.message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message
	 *          the new message
	 */
	private void setMessage(final String message) {
		this.message = message;
		this.setChanged();
		this.notifyObservers();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage(java.lang.String)
	 */
	public void loadMessage(final String key) {
		try {
			final DAOHelloWorld daoHelloWorld = new DAOHelloWorld(DBConnection.getInstance().getConnection());
			this.setMessage(daoHelloWorld.find(key).getMessage());
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	public Observable getObservable() {
		return this;
	}

	public IEntity getPlayer() {
		return getMap().getPlayer();
	}

	public IMap getMap() {
		return map;
	}
}
