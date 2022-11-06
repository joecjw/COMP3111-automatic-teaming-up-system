package COMP3111.Project;

import java.util.ArrayList;

public class Team {
	private ArrayList<Student> members;
	private Integer numOfMembers;
	
	public Team() {
		members = new ArrayList<Student>();
		numOfMembers = 0;
	}
	
	public int addMember(Student student) {
		members.add(student);
		numOfMembers += 1;
		return numOfMembers;
	}
	
	public ArrayList<Student> getMembersList(){
		return members;
	}
	
}
