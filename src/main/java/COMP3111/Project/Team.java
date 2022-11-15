package COMP3111.Project;

import java.util.ArrayList;

public class Team {
	private ArrayList<Student> members;
	private Integer numOfMembers;
	private Integer team_id;
	private String team_name;
	
	public Team() {
		members = new ArrayList<Student>();
		numOfMembers = 0;
		team_id = 0;
		team_name = "";
	}
	
	public Team(Team t) {
		members = new ArrayList<Student>(t.getMembersList());
		numOfMembers = t.getNumOfMembers();
		team_id = 0;
		team_name = "";
	}

	public Team(ArrayList<Student> s) {
		members = (ArrayList<Student>) s.clone();
		numOfMembers = s.size();
		team_id = 0;
		team_name = "";
	}
	
	public Team(int team_id, String team_name, Student s, boolean is_team_Leader) {
		this.team_id = team_id;
		this.team_name = new String(team_name);
		members = new ArrayList<Student>();
		members.add(s);
		numOfMembers = 1;
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
	
	public int getTeamId() {
		return team_id;
	}

	public String getName() {
		return team_name;
	}
	
	public boolean isEmptyMemberList() {
		if(members.isEmpty())
			return true;
		return false;
	}
}
