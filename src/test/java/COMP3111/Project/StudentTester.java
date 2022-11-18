package COMP3111.Project;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StudentTester {
	
	Student tester;
	Student tester_studentID;
	
	@Before
	public void setUp() throws Exception {
		tester = new Student("0", "22345678",  "TestStudent", "email", "10", "5", "1", "0", "1", "");
	}

	@Test
	public void studentGetRowid() {
		assertEquals("0", tester.getRowid());
	}
	
	@Test
	public void studentGetStudentid() {
		assertEquals("22345678", tester.getStudentid());
	}

	@Test
	public void studentGetStudentname() {
		assertEquals("TestStudent", tester.getStudentname());
	}
	
	@Test
	public void studentGetEmail() {
		assertEquals("email", tester.getEmail());
	}


	@Test
	public void studentGetK1energy() {
		assertEquals("10", tester.getK1energy());
	}

	@Test
	public void studentGetK2energy() {
		assertEquals("5", tester.getK2energy());
	}

	@Test
	public void studentGetK3trick1() {
		assertEquals("1", tester.getK3trick1());
	}

	@Test
	public void studentGetK3trick2() {
		assertEquals("0", tester.getK3trick2());
	}

	@Test
	public void studentGetMypreference() {
		assertEquals("1", tester.getMypreference());
	}

	@Test
	public void studentGetConcerns() {
		assertEquals("", tester.getConcerns());
	}
}
