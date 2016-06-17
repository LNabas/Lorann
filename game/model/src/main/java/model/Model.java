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
	private int lvl=1;
	private IMap map;

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		// https://www.youtube.com/watch?v=Eb6cGHK4_yc
		Mappy(1);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage()
	 */
	public IMap getMap() {
		return this.map;
	}

	/**
	 * Sets the message.
	 *
	 * @param message
	 *          the new message
	 */
	private void setMap(final IMap map) {
		this.map = map;
		this.setChanged();
		this.notifyObservers();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage(java.lang.String)
	 */
	public void Mappy(int i) {
		lvl = i;
		try {
			final DAOMap daoMap = new DAOMap(DBConnection.getInstance().getConnection());
			this.setMap(daoMap.LoadMap(lvl));
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

	public IEntity getFireball() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	public void loadMessage(String key) {
		// TODO Auto-generated method stub
		
	}

	public void LoadNextMap() {
		// TODO Auto-generated method stub
		
	}

	public void RealoadMap() {
		// TODO Auto-generated method stub
		
	}

	public void setDifficulty(int posMenuOpt) {
		// TODO Auto-generated method stub
		
	}

	public void ForceRedraw() {
		this.setChanged();
		this.notifyObservers();
	}
}
