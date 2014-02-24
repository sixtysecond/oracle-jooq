package com.sixtysecs.jooq.oracle;

import static com.sixtysecs.jooq.oracle.tables.Countries.COUNTRIES;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.testng.annotations.Test;

public class AbstractDatabaseCommandTest extends AbstractDatabaseCommand {

	@Test
	public void testIterateCountries() throws SQLException {
		doCommandLifeCycle();
	}

	@Override
	protected void doCommands(Connection conn) {
		DSLContext create = DSL.using(conn, SQLDialect.ORACLE);
		Result<Record> result = create.select().from(COUNTRIES).fetch();

		for (Record r : result) {
			String id = r.getValue(COUNTRIES.COUNTRY_ID);
			String name = r.getValue(COUNTRIES.COUNTRY_NAME);
			BigDecimal region = r.getValue(COUNTRIES.REGION_ID);

			System.out.println("ID: " + id + ", first name: " + name
					+ ", region: " + region);
		}

	}

	@Override
	protected Database getDatabase() {
		return Database.PDBORCL;
	}

}
