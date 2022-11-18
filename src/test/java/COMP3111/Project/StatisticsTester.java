package COMP3111.Project;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StatisticsTester {
	
	Statistics tester;
	
	@Before
	public void setUp() throws Exception {
		tester = new Statistics("column1", "column2");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void statisticsGetEntry() {
		assertEquals("column1", tester.getEntry());
	}
	
	@Test
	public void statisticsSetEntry() {
		tester.setEntry("resetEntry");
		assertEquals("resetEntry", tester.getEntry());
	}
	
	@Test
	public void statisticsGetValue() {
		assertEquals("column2", tester.getValue());
	}
	
	@Test
	public void statisticsSetValue() {
		tester.setValue("resetValue");
		assertEquals("resetValue", tester.getValue());
	}
}
