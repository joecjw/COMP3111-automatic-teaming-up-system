package COMP3111.Project;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TeamTester {
	
	Team tester1;
	Team tester2;
	Team tester3;
	ArrayList<Student> s;
	Student s1;
	Student sForAdd;
	Student sForDelete;
	
	
	@Before
	public void setUp() throws Exception {
		tester1 = new Team();
		tester2 = new Team(tester1);
		s = new ArrayList<Student>();
		s.add(s1);
		s1 = new Student("0", "22345678",  "TestStudent1", "email1", "10", "5", "1", "0", "1", "");
		sForAdd = new Student("4", "20770625", "Leung King Suen1", "ksleungac1", "80", "90", "0", "1", "", "");
		sForDelete = new Student("7", "26723645", "Leung King Suen2", "ksleungac2", "80", "90", "0", "1", "", "");
		tester3 = new Team(s);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void teamAddMembers() {
//		addMembers() method would return new number of team members
		tester1.addMember(sForAdd);
		assertEquals(1, tester1.getNumOfMembers());
	}
	
	@Test
	public void teamRemoveMembers() {
		tester1.addMember(sForDelete);
		tester1.removeMember(sForDelete);
		assertEquals(0, tester1.getNumOfMembers());
	}
	
	@Test
	public void teamReturnTeamMembersArray() {
//		Testing the team array return method, it should return the list with the same content if created here
		assertTrue(s.equals(tester3.getMembersList()));
	}
}
