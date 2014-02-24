package com.sixtysecs.jooq.oracle;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
public class DatabaseTest {
	
	@Test
	public void testGetConnectionString() {
		assertEquals(Database.PDBORCL.getConnectionString(),"jdbc:oracle:thin:@//localhost:1521/pdborcl");
	}

}
