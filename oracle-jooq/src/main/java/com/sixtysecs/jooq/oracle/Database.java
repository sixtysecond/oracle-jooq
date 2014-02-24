package com.sixtysecs.jooq.oracle;


public enum Database {

	PDBORCL("localhost", 1521, "pdborcl", "system", "Password1",
			DbEngine.ORACLE);

	private Database(String server, int port, String databaseName,
			String userName, String password, DbEngine dbEngine) {

		this.databaseName = databaseName;
		this.server = server;
		this.password = password;
		this.port = port;
		this.userName = userName;
		this.dbEngine = dbEngine;

		this.connectionString = buildConnectionString();
	}

	private String databaseName;
	private String server;
	private String password;
	private String userName;
	private int port;
	private String connectionString;
	private DbEngine dbEngine;

	private String buildConnectionString() {
		StringBuilder builder = new StringBuilder();
		builder.append("jdbc:");
		builder.append(dbEngine.getDriver() + "//");
		builder.append(server + ":");
		builder.append(port + "/");
		builder.append(databaseName);

		// oracle:thin:@//localhost:1521/pdborcl)
		return builder.toString();
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public String getServer() {
		return server;
	}

	public String getPassword() {
		return password;
	}

	public String getUserName() {
		return userName;
	}

	public int getPort() {
		return port;
	}

	public String getConnectionString() {
		return connectionString;
	}

	public DbEngine getDbEngine() {
		return dbEngine;
	}
}
