/**
 * 
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import contract.IMap;

import java.io.BufferedReader;
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
		public IMap LoadMap() {
			try {
				Map map = new Map();
				final String sql = "{call recup_map(?)}";
				final CallableStatement call = this.getConnection().prepareCall(sql);
				call.setInt(1, 1);
				call.execute();
				final ResultSet resultSet = call.getResultSet();
				if (resultSet.first()) {
				String str = resultSet.getString("map");
				System.out.println(resultSet.getString("map"));
				int ligne = 0;
				int col = 0;
				for(int i = 0 ; i<str.length(); i++){
					col++;
					if(str.charAt(i) == '\n'){ 
						ligne++;
						col = 0;
					}
					
					
					else if(str.charAt(i) == '*'){ 
						map.set(col, ligne, new Skull());
					}
					
					
					else if (str.charAt(i) == '='){
						map.set(col, ligne, new Hbone());
					}
					
					
					else if (str.charAt(i) == '|'){
						map.set(col, ligne, new Vbone());
					}
					
					
					else if (str.charAt(i) == 'P'){
						map.set(col, ligne, new DoorOpen());
					}
					
					
					else if (str.charAt(i) == 'C'){
						map.set(col, ligne, new Charles());
					}
					
					
					else if (str.charAt(i) == 'G'){
						map.set(col, ligne, new ItemGood());
						
					}
					
					
					else if (str.charAt(i) == 'F'){
						map.set(col, ligne, new ItemGood());
					}
					
					
					else if (str.charAt(i) == '3'){
						map.set(col, ligne, new Pierre());
						
					}
					
					
					else if (str.charAt(i) == '4'){
						map.set(col, ligne, new Paul());
						
					}
					
					
					else if (str.charAt(i) == '9'){
						map.set(col, ligne, new Henry());
						
					}
					
					
				}
				
				}
				return map;
			} catch (final SQLException e) {
				e.printStackTrace();
			}
			return null;
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
