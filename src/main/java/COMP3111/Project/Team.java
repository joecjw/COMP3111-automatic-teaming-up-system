package COMP3111.Project;

import java.util.ArrayList;
/**
 * Team class
 * Consists of ArrayList of students and other param
 * @author Team 9 
 * @version 1.0
 */
public class Team {
	private ArrayList<Student> members;
	private Integer numOfMembers;
	private Integer team_id;
	private String team_name;
	
	/**
	 * Constructor with no input arguments, initializes ArrayList and attributes of a Team object 
	 */
	public Team() {
		
		members = new ArrayList<Student>();
		numOfMembers = 0;
		team_id = 0;
		team_name = "";
	}
	
	/**
	 * Copy Constructor, initializes {@code members} and {@code numOfMembers} from input Team object
	 * @param t This is the Team object to be copied
	 */
	public Team(Team t) {
		members = new ArrayList<Student>(t.getMembersList());
		numOfMembers = t.getNumOfMembers();
		team_id = 0;
		team_name = "";
	}
	
	/**
	 * Conversion constructor, initializes {@code members} from input {@code ArrayList}
	 * @param s This is the {@code ArrayList} to be copied
	 */
	public Team(ArrayList<Student> s) {
		members = (ArrayList<Student>) s.clone();
		numOfMembers = s.size();
		team_id = 0;
		team_name = "";
	}
	
	/**
	 * Another Conversion constructor with more input arguments
	 * @param team_id The id of the Team object
	 * @param team_name The name of the Team object
	 * @param s Student object to be inserted as the first member in this team
	 * @param is_team_Leader Indicate whether it is the team leader (not Implemented)
	 */
	public Team(int team_id, String team_name, Student s, boolean is_team_Leader) {
		this.team_id = team_id;
		this.team_name = new String(team_name);
		members = new ArrayList<Student>();
		members.add(s);
		numOfMembers = 1;
	}
	
	/**
	 * Method to add a student into a team
	 * @param student {@code Student} object to be added
	 */
	public void addMember(Student student) {
		members.add(student);
		numOfMembers++;
	}
	
	/**
	 * Method to remove a student in a team
	 * @param student {@code Student} object to be removed
	 */
	public void removeMember(Student student) {
		members.remove(student);
		numOfMembers--;
	}
	
	/**
	 * Method to get member ArrayList
	 * @return {@code ArrayList} containing Team Members (Students)
	 */
	public ArrayList<Student> getMembersList(){
		return members;
	}
	
	/**
	 * Method to get number of team members
	 * @return {@code int} number of team members
	 */
	public int getNumOfMembers() {
		return numOfMembers;
	}
	
	/**
	 * Method to get id of the team
	 * @return {@code int} team id
	 */
	public int getTeamId() {
		return team_id;
	}

	/**
	 * Method to get team name
	 * @return {@code String} team name
	 */
	public String getName() {
		return team_name;
	}
	
	/**
	 * Method to check if team is empty
	 * @return {@code boolean} T if team is empty, F if team has members already
	 */
	public boolean isEmptyMemberList() {
		if(members.isEmpty())
			return true;
		return false;
	}
}
