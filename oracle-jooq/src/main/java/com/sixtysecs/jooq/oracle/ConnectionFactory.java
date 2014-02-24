package com.sixtysecs.jooq.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection getConnection(Database database)
			throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, SQLException {
		Class.forName(database.getDbEngine().getClassForName()).newInstance();
		return DriverManager.getConnection(database.getConnectionString(),
				database.getUserName(), database.getPassword());
	}
}
