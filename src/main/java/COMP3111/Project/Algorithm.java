package COMP3111.Project;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The core algorithm of ATU
 * @author Team 9
 * @version 1.0
 *
 */
public class Algorithm {
	private Team K1 = new Team();
	private Team K2 = new Team();
	private Team K3 = new Team();
	private Team copy;
	private HashMap<Double, Integer> map;
	private double standardDeviationK1;
	private double standardDeviationK2;
	private double standardDeviationK1K2;
	private double team_K1_avg;
	private double team_K2_avg;

	public ATU_Team atu;
	
	/**
	 * Method to compute and create output
	 * @param t team class object
	 * @param Team_Size total number of teams
	 */
	public void compute(Team t, int Team_Size) {
		Set_K1_Average(t);
		Set_K2_Average(t);
		Select_K1_member(t, Team_Size);
		Select_K2_member(t, Team_Size);
		Select_K3_member(t, Team_Size);
		Create_Map(Team_Size);
		Create_Team(t, Team_Size);
		Select_remain_member(Team_Size);
		Set_Standard_Deviation_K1();
		Set_Standard_Deviation_K2();
		Set_Standard_Deviation_K1K2();
	}
	
	/**
	 * Method to create K1 member list (team class object) in descending order
	 * @param t team class object
	 * @param Team_Size total number of teams
	 */
	private void Select_K1_member(Team t, int Team_Size) {
		if(K1.isEmptyMemberList() && K2.isEmptyMemberList() && K3.isEmptyMemberList())
			copy = new Team (t);
		
		for(int i = 0; i < copy.getNumOfMembers()-1; i++) {
			for(int j = 1; j < copy.getNumOfMembers(); j++) {
				if(Integer.parseInt(copy.getMembersList().get(j-1).getK1energy()) 
						< Integer.parseInt(copy.getMembersList().get(j).getK1energy())) {
					Student s = copy.getMembersList().get(j);
					copy.getMembersList().remove(j);
					copy.getMembersList().add(j-1, s);
				} 
			}
		}
		for(int i = 0; i < Team_Size; i++) {
			if(!copy.isEmptyMemberList()) K1.addMember(copy.getMembersList().get(0));
			copy.removeMember(K1.getMembersList().get(i));
		}
		System.out.println("Now have: " + copy.getNumOfMembers() + " students left");

	}
	
	/**
	 * Method to create K2 member list (team class object) in ascending order, without in K1 list
	 * @param t team class object
	 * @param Team_Size total number of teams
	 */
	private void Select_K2_member(Team t, int Team_Size) {
		if(K1.isEmptyMemberList() && K2.isEmptyMemberList() && K3.isEmptyMemberList())
			copy = new Team (t);
		
		for(int i = 0; i < copy.getNumOfMembers()-1; i++) {
			for(int j = 1; j < copy.getNumOfMembers(); j++) {
				if(Integer.parseInt(copy.getMembersList().get(j-1).getK2energy()) 
						> Integer.parseInt(copy.getMembersList().get(j).getK2energy())) {
					Student s = copy.getMembersList().get(j);
					copy.getMembersList().remove(j);
					copy.getMembersList().add(j-1, s);
				} 
			}
		}
		
		for(int i = 0; i < Team_Size; i++) {
			if(!copy.isEmptyMemberList()) K2.addMember(copy.getMembersList().get(0));
			copy.removeMember(K2.getMembersList().get(i));
		}
		System.out.println("Now have: " + copy.getNumOfMembers() + " students left");

	}
	
	/**
	 * Method to create K3 member list in ascending order of K1+K2 energy, without members in K1 and K2 lists
	 * @param t team class object
	 * @param Team_Size total number of teams
	 */
	private void Select_K3_member(Team t, int Team_Size) {
		if(K1.isEmptyMemberList() && K2.isEmptyMemberList() && K3.isEmptyMemberList())
			copy = new Team (t);
		for(int i = 0; i < copy.getNumOfMembers()-1; i++) {
			for(int j = 1; j < copy.getNumOfMembers(); j++) {
				if((Integer.parseInt(copy.getMembersList().get(j-1).getK1energy())
					+ Integer.parseInt(copy.getMembersList().get(j-1).getK2energy()))
					> (Integer.parseInt(copy.getMembersList().get(j).getK1energy())
					+ Integer.parseInt(copy.getMembersList().get(j).getK2energy()))) {
				Student s = copy.getMembersList().get(j);
				copy.getMembersList().remove(j);
				copy.getMembersList().add(j-1, s);
				} 
			}
		}
	
		for(int i = 0; i < Team_Size; i++) {
			if(!copy.isEmptyMemberList()) K3.addMember(copy.getMembersList().get(0));
			copy.removeMember(K3.getMembersList().get(i));
		}
		System.out.println("Now have: " + copy.getNumOfMembers() + " students left");
	}
	
	/**
	 * Method to handle remaining students
	 * @param Team_Size total number of teams
	 */
	private void Select_remain_member(int Team_Size) {
		int i = 0;
		Student s;
		while(copy.getNumOfMembers() > 0) {
			s = copy.getMembersList().get(i++);
			atu.getTeams().get(Team_Size - copy.getNumOfMembers()).addMember(s);
			copy.removeMember(s);
		}
	}
	
	/**
	 * Method to create hashmap for indicating which member in K3 should be appended to which teams
	 * @param Team_Size total number of teams
	 */
	private void Create_Map(int Team_Size) {
		ArrayList<Team> pre = new ArrayList<Team>();
		map = new HashMap<Double, Integer>();
		double avg = 0;
		for(int i = 0; i < Team_Size; i++) {
			Team K1K2 = new Team();
			K1K2.addMember(K1.getMembersList().get(i));
			K1K2.addMember(K2.getMembersList().get(i));
			pre.add(K1K2);
		}
		
		for(int i = 0; i < Team_Size-1; i++) {
			for(int j = 1; j < Team_Size; j++) {
				double avg1 = Get_K1_Average(pre.get(j-1)) + Get_K2_Average(pre.get(j-1));
				double avg2 = Get_K1_Average(pre.get(j)) + Get_K2_Average(pre.get(j));
				Team tmp;
				if(avg1 < avg2) {
					tmp = new Team(pre.get(j));
					pre.remove(j);
					pre.add(j-1, tmp);
				}
			}
		}
		
		int k = 0;
		for(Team K1K2 : pre) {
			avg = Get_K1_Average(K1K2) + Get_K2_Average(K1K2);
			System.out.println("avg is:" + avg);
			map.put(avg, k++);
		}

	}
	/**
	 * Method to create list of team (ATU_Team class object) 
	 * @param t team class object
	 * @param Team_Size total number of teams
	 */
	private void Create_Team(Team t, int Team_Size) {
		atu = new ATU_Team(t.getNumOfMembers(), Team_Size);
		for(int i = 0; i < Team_Size; i++) {
			if(!K1.isEmptyMemberList()) atu.append(i, "T-" + string(i,4,'0'), K1.getMembersList().get(i), false, false);
			if(!K2.isEmptyMemberList()) atu.append(i, "T-" + string(i,4,'0'), K2.getMembersList().get(i), false, false);
			if(!K3.isEmptyMemberList()) atu.append(i, "T-" + string(i,4,'0'), 
					K3.getMembersList().get(map.get(Get_K1_Average(atu.getTeams().get(i)) + Get_K2_Average(atu.getTeams().get(i))))
					, false, false);
		}
//		if(K3.getMembersList().size() == Team_Size + 1) {
//			atu.append(Team_Size-1, "T-" + string(Team_Size-1,4,'0'), K3.getMembersList().get(Team_Size), false, true);
//			if(K3.getMembersList().size() == Team_Size + 2) {
//				atu.append(Team_Size-2, "T-" + string(Team_Size-2,4,'0'), K3.getMembersList().get(Team_Size+1), false, true);
//			}
//		}
	}
	
	/**
	 * Method to calculate team's averag K1 energy
	 * @param t team object
	 */
	
	private void Set_K1_Average(Team t) {
		double result = 0;
		for(Student s : t.getMembersList()) {
			result += Integer.parseInt(s.getK1energy());
		}
		System.out.println("K1 average is:" + result/t.getNumOfMembers());
		this.team_K1_avg = result/t.getNumOfMembers();
	}
	
	/**
	 * Method to get team's averag K1 energy
	 * @param t team object
	 */
	
	public double Get_K1_Average(Team t) {
		double result = 0;
		for(Student s : t.getMembersList()) {
			result += Integer.parseInt(s.getK1energy());
		}
		return result/t.getNumOfMembers();
	}
	
	/**
	 * Method to calculate team's averag K2 energy
	 * @param t team object
	 */
	
	private void Set_K2_Average(Team t) {
		double result = 0;
		for(Student s : t.getMembersList()) {
			result += Integer.parseInt(s.getK2energy());
		}
		System.out.println("K2 average is:" + result/t.getNumOfMembers());
		this.team_K2_avg = result/t.getNumOfMembers();
	}
	
	/**
	 * Method to get team's averag K2 energy
	 * @param t team object
	 */
	public double Get_K2_Average(Team t) {
		double result = 0;
		for(Student s : t.getMembersList()) {
			result += Integer.parseInt(s.getK1energy());
		}
		return result/t.getNumOfMembers();
	}
	/**
	 * Method to get totol s.d. of teams' K1 energy
	 * @return s.d. of K1 energy
	 */
	
	public double Get_Standard_Deviation_K1() {
		System.out.println("Standard Devaition of K1 is:" + this.standardDeviationK1);
		return standardDeviationK1;
	}
	
	/**
	 * Method to get totol s.d. of teams' K2 energy
	 * @return s.d. of K2 energy
	 */
	
	public double Get_Standard_Deviation_K2() {
		System.out.println("Standard Devaition of K2 is:" + this.standardDeviationK2);
		return standardDeviationK2;
	}
	
	/**
	 * Method to get totol s.d. of teams' K1+k2 energy
	 * @return s.d. of K1+K2 energy
	 */
	
	public double Get_Standard_Deviation_K1K2() {
		System.out.println("Standard Devaition of K1K2 is:" + this.standardDeviationK1K2);
		return standardDeviationK1K2;
	}
	
	/**
	 * Method to calculate totol s.d. of teams' K1 energy
	 * @return void
	 */
	private void Set_Standard_Deviation_K1() {
		double result = 0;
		for(Team t : this.atu.getTeams()) {
			result += Math.pow(this.Get_K1_Average(t) - team_K1_avg, 2);
		}
		this.standardDeviationK1 = Math.sqrt(result/atu.getTeams().size());
	}
	
	/**
	 * Method to calculate totol s.d. of teams' K2 energy
	 * @return void
	 */
	private void Set_Standard_Deviation_K2() {
		double result = 0;
		for(Team t : this.atu.getTeams()) {
			result += Math.pow(this.Get_K2_Average(t) - team_K2_avg, 2);
		}
		this.standardDeviationK2 = Math.sqrt(result/atu.getTeams().size());
	}
	
	/**
	 * Method to calculate totol s.d. of teams' K1+k2 energy
	 * @return void
	 */
	
	private void Set_Standard_Deviation_K1K2() {
		double result = 0;
		for(Team t : this.atu.getTeams()) {
			result += Math.pow((this.Get_K1_Average(t) + this.Get_K2_Average(t))/2 - (team_K1_avg + team_K2_avg)/2, 2);
		}
		this.standardDeviationK1K2 = Math.sqrt(result/atu.getTeams().size());
	}
		
	/**
	 * Method to append integers and char into string
	 * @param i int
	 * @param j int
	 * @param c char
	 * @return String
	 */
	private String string(int i, int j, char c) {
		return new String(Integer.toString(i) + Integer.toString(j) + Character.toString(c));
	}
	
	/**
	 * Method to get K1 arraylist
	 * @return arraylist
	 */
	public Team get_K1() {
		return K1; 
	}
	
	/**
	 * Method to get K2 arraylist
	 * @return arraylist
	 */
	public Team get_K2() {
		return K2;
	}
	
	/**
	 * Method to get K3 arraylist
	 * @return arraylist
	 */
	public Team get_K3() {
		return K3;
	}
}