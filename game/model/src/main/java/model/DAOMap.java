/**
 * 
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;

/**
 * @author Maxence
 *
 */
public class DAOMap extends DAOEntity<Map> {
		/**
		 * Instantiates a new DAO Map.
		 *
		 * @param connection
		 *          the connection
		 * @throws SQLException
		 *           the SQL exception
		 */
		public DAOMap(final Connection connection) throws SQLException {
			super(connection);
		}

		/*
		 * (non-Javadoc)
		 *
		 * @see model.DAOEntity#create(model.Entity)
		 */
		@Override
		public void LoadMap() {
			try {
				final String sql = "{call recup_map(?)}";
				final CallableStatement call = this.getConnection().prepareCall(sql);
				call.setInt(1, 1);
				call.execute();
				final ResultSet resultSet = call.getResultSet();
				System.out.println("meh");
				System.out.println(resultSet);
				return;
			} catch (final SQLException e) {
				e.printStackTrace();
			}
			return;
		}

		/*
		 * (non-Javadoc)
		 *
		 * @see model.DAOEntity#delete(model.Entity)
		 */
		@Override
		public boolean delete(final Map entity) {
			// Not implemented
			return false;
		}

		/*
		 * (non-Javadoc)
		 *
		 * @see model.DAOEntity#update(model.Entity)
		 */
		@Override
		public boolean update(final Map entity) {
			// Not implemented
			return false;
		}

		@Override
		public Map find(int id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map find(String key) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean create(Map entity) {
			// TODO Auto-generated method stub
			return false;
		}
	
	
	
}
