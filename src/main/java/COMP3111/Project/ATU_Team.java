package COMP3111.Project;

import java.util.ArrayList;

/**
 * ATU_Team class for the output
 * @author Team 9
 * @version 1.0
 */
public class ATU_Team{
	private ArrayList<Team> teams;
	private Integer numOfStudentsPerTeam;
	private Integer currentNumOfTeams;
	private Integer currentNumOfStudentsPerTeam;

/**
 * Constructor of ATU_Team object
 * @param numOfStudents total number of stduents
 * @param Team_Size total number of teams
 */
	ATU_Team(int numOfStudents, int Team_Size){
		teams = new ArrayList<Team>();
		this.numOfStudentsPerTeam = numOfStudents/Team_Size;
		this.currentNumOfStudentsPerTeam = 0;
		this.currentNumOfTeams = 0;
	}
	
	/**
	 * method to return arraylist saved in atu object
	 * @return arraylist team objects
	 */
	public ArrayList<Team> getTeams(){
		return teams;
	}
	
	/**
	 * method to append student into a team
	 * @param team_id team's id
	 * @param team_name team's name
	 * @param s student class object
	 * @param is_team_Leader whether the student is teamleader
	 * @param remainderFlag whether it has remaining students
	 */
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