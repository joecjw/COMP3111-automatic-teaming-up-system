package COMP3111;

import java.util.ArrayList;

public class ATU_Team{
	private ArrayList<Team> teams;
	private Integer numOfStudentsPerTeam;
	private Integer currentNumOfTeams;
	private Integer currentNumOfStudentsPerTeam;
	
//	ATU_Team(){
//		teams = new ArrayList<Team>();
//		numOfTeams = 0;
//		numOfStudentsPerTeam = 0;
//	}
	ATU_Team(int numOfStudents, int Team_Size){
		teams = new ArrayList<Team>();
		this.numOfStudentsPerTeam = numOfStudents/Team_Size;
		this.currentNumOfStudentsPerTeam = 0;
		this.currentNumOfTeams = 0;
	}
	
	public ArrayList<Team> getTeams(){
		return teams;
	}
	
	public void append(int team_id, String team_name, Student s, 
			boolean is_team_Leader, boolean remainderFlag) {
		if(!remainderFlag) {
			if(currentNumOfStudentsPerTeam == 0) {
				teams.add(new Team(team_id, team_name, s, is_team_Leader));
				currentNumOfStudentsPerTeam++;
			} else {
				teams.get(currentNumOfTeams).addMember(s);
				currentNumOfStudentsPerTeam++;
				if(currentNumOfStudentsPerTeam == numOfStudentsPerTeam) {
					currentNumOfTeams++;
					currentNumOfStudentsPerTeam = 0;
				}
			}
		} else {
			for(int i = 0; i < currentNumOfTeams; i++) {
				if(teams.get(i).getTeamId() == team_id)
					teams.get(i).addMember(s);
			}
		}
	}
}