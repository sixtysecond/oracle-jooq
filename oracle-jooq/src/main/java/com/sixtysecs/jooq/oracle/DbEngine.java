package com.sixtysecs.jooq.oracle;

import org.jooq.SQLDialect;

public enum DbEngine {

	ORACLE("oracle:thin:@", "oracle.jdbc.OracleDriver", SQLDialect.ORACLE);

	private DbEngine(String driver, String classForName, SQLDialect sqlDialect) {
		this.driver = driver;
		this.classForName = classForName;
		this.sqlDialect = sqlDialect;
	}

	private String driver;
	private String classForName;
	private SQLDialect sqlDialect;

	public String getDriver() {
		return driver;
	}

	public String getClassForName() {
		return classForName;
	}

	public SQLDialect getSqlDialect() {
		return sqlDialect;
	}
}
