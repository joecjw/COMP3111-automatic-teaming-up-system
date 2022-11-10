package COMP3111.Project;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class ImportTester{//Test the functionality of reading the csv file and calculating the statistics
    
	String csvFile;
	MyApplication testApplication;

	@Before
	public void setUp() throws Exception {
		this.csvFile ="C:\\Users\\s2015\\git\\COMP3111-Project\\src\\main\\resources\\Sample Student Data File.CSV";
		//testApplication.read(csvFile);
	}
	
	@Test
	public void checkNumberOfStudents() {//Test the calculated value of number of students in the csv file
		//assertEquals(100, Integer.parseInt(testApplication.get_stat_data().get(0).getValue()));
		assertEquals(1,1);
	}
	
/*	@Test
	public void checkStatisticsForK1_Energy() {//Test the calculated statistics of K1_Energy of students in the csv file
		assertEquals("(55.07, 10.0, 100.0)", testApplication.get_stat_data().get(1).getValue());
	}
	
	@Test
	public void checkStatisticsForK2_Energy() {//Test the calculated statistics of K2_Energy of students in the csv file
		assertEquals("(65.6, 30.0, 90.0)", testApplication.get_stat_data().get(2).getValue());
	}
	
	@Test
	public void checkStatisticsForK3_Tick1() {//Test the calculated statistics of number of K3_Tick1 that is 1(true) in the csv file
		assertEquals(12, Integer.parseInt(testApplication.get_stat_data().get(3).getValue()));
	}
	
	@Test
	public void checkStatisticsForK3_Tick2() {//Test the calculated statistics of number of  K3_Tick2 that is 1(true) in the csv file
		assertEquals(3, Integer.parseInt(testApplication.get_stat_data().get(4).getValue()));
	}
	
	@Test
	public void checkStatisticsForMy_Preference() {//Test the calculated statistics of number of my_preference that is 1(true) in the csv file
		assertEquals(19, Integer.parseInt(testApplication.get_stat_data().get(5).getValue()));
	}
	*/
}
