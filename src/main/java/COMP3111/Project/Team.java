package COMP3111.Project;

import java.util.ArrayList;

public class Team {
	private ArrayList<Student> members;
	private Integer numOfMembers;
	
	public Team() {
		members = new ArrayList<Student>();
		numOfMembers = 0;
	}
	
	public Team(Team t) {
		members = new ArrayList<Student>(t.getMembersList());
		numOfMembers = t.getNumOfMembers();
	}

	public Team(ArrayList<Student> s) {
		members = (ArrayList<Student>) s.clone();
		numOfMembers = s.size();
	}
	
	public void addMember(Student student) {
		members.add(student);
		numOfMembers++;
	}
	
	public void removeMember(Student student) {
		members.remove(student);
		numOfMembers--;
	}
	
	
	public ArrayList<Student> getMembersList(){
		return members;
	}
	
	public int getNumOfMembers() {
		return numOfMembers;
	}
	
	public boolean isEmptyMemberList() {
		if(members.isEmpty())
			return true;
		return false;
	}
}
