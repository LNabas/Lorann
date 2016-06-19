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
	private boolean reload = true;
	private IMap map;
	int difficulty = 1;

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		// https://www.youtube.com/watch?v=Eb6cGHK4_yc
		Mappy();
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
	public void Mappy() {
		if(reload){
			try {
				final DAOMap daoMap = new DAOMap(DBConnection.getInstance().getConnection());
				this.setMap(daoMap.LoadMap(lvl));
			} catch (final SQLException e) {
				e.printStackTrace();
			}
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

	public void LoadNextMap() {
		try {
			final DAOMap daoMap = new DAOMap(DBConnection.getInstance().getConnection());
			if(daoMap.MaxMaps()>=lvl){
				lvl++;
			}else{
				lvl=0;
			}
			Mappy();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	public void setDifficulty(int posMenuOpt) {
		difficulty=posMenuOpt+1;
	}

	public void ForceRedraw() {
		this.setChanged();
		this.notifyObservers();
	}

	public int CurrentMap() {
		return lvl;
	}

	public int MaxMap() {
		try {
			final DAOMap daoMap = new DAOMap(DBConnection.getInstance().getConnection());
			return daoMap.MaxMaps();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int Difficulty() {
		return difficulty;
	}
}
