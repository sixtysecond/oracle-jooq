package com.sixtysecs.jooq.oracle;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class AbstractDatabaseCommand {

//	private Connection conn;


	/**
	 * Instantiates connection. Performs database commands. Closes connection.
	 * 
	 * @throws SQLException
	 */
	protected void doCommandLifeCycle() throws SQLException {
		Database database = getDatabase();
		Connection conn = null;
		try {
			try {
				Class.forName(database.getDbEngine().getClassForName()).newInstance();
				conn = ConnectionFactory.getConnection(database);

			} catch (Exception ex) {
				ex.printStackTrace();
				throw new SQLException(ex.getMessage());
			}
			doCommands(conn);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException ignore) {
				}
			}
		}
	}

	protected abstract void doCommands(Connection conn);
	
	protected abstract Database getDatabase();
	

}
