package COMP3111.Project;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TeamTester {
	
	Team tester;
	@Before
	public void setUp() throws Exception {
		tester = new Team();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void teamAddMembers() {
//		addMembers() method would return new number of team members
		assertEquals(1, tester.addMember(
				new Student("0", "20770625", "Leung King Suen", "ksleungac", "80", "90", "0", "1", "", "")));
	}
	
	@Test
	public void teamReturnTeamMembersArray() {
//		Testing the team array return method, it should return the list with the same content if created here
		ArrayList<Student> testmembers = new ArrayList<Student>();
		Student testStudent = new Student("0", "20770625", "Leung King Suen", "ksleungac", "80", "90", "0", "1", "", "");
		testmembers.add(testStudent);
		tester.addMember(testStudent);
		assertTrue(testmembers.equals(tester.getMembersList()));
	}
}
