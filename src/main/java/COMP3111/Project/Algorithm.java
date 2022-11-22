package COMP3111.Project;

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
	private double standardDeviationK1;
	private double standardDeviationK2;
	private double team_K1_avg;
	private double team_K2_avg;

	public ATU_Team atu;
	
	/**
	 * Method to compute and create output
	 * @param t team class object
	 * @param Team_Size total number of teams
	 */
	void compute(Team t, int Team_Size) {
		Set_K1_Average(t);
		Set_K2_Average(t);
		Select_K1_member(t, Team_Size);
		Select_K2_member(t, Team_Size);
		Select_K3_member(t, Team_Size);
		Create_Team(t, Team_Size);
		Set_Standard_Deviation_K1();
		Set_Standard_Deviation_K2();
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
			K1.addMember(copy.getMembersList().get(0));
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
			K2.addMember(copy.getMembersList().get(0));
			copy.removeMember(K2.getMembersList().get(i));
		}
		System.out.println("Now have: " + copy.getNumOfMembers() + " students left");

	}
	
	/**
	 * Method to create K3 member list (team class object) without in K1 and K2 lists
	 * @param t team class object
	 * @param Team_Size total number of teams
	 */
	private void Select_K3_member(Team t, int Team_Size) {
		int k = 0;
		for(int i = 0; i < t.getNumOfMembers(); i++) {
			if(copy.getMembersList().contains(t.getMembersList().get(i))) {
				int index = copy.getMembersList().indexOf(t.getMembersList().get(i));
				K3.addMember(copy.getMembersList().get(index));
				copy.removeMember(K3.getMembersList().get(k));
				k++;
			}
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
			atu.append(i, "T-" + string(i,4,'0'), K1.getMembersList().get(i), false, false);
			atu.append(i, "T-" + string(i,4,'0'), K2.getMembersList().get(i), false, false);
			atu.append(i, "T-" + string(i,4,'0'), K3.getMembersList().get(i), false, false);
		}
		if(K3.getMembersList().size() == Team_Size + 1) {
			atu.append(Team_Size-1, "T-" + string(Team_Size-1,4,'0'), K3.getMembersList().get(Team_Size), false, true);
			if(K3.getMembersList().size() == Team_Size + 2) {
				atu.append(Team_Size-2, "T-" + string(Team_Size-2,4,'0'), K3.getMembersList().get(Team_Size+1), false, true);
			}
		}
	}
	
	private void Set_K1_Average(Team t) {
		double result = 0;
		for(Student s : t.getMembersList()) {
			result += Integer.parseInt(s.getK1energy());
		}
		System.out.println("K1 average is:" + result/t.getNumOfMembers());
		this.team_K1_avg = result/t.getNumOfMembers();
	}
	
	private double Get_K1_Average(Team t) {
		double result = 0;
		for(Student s : t.getMembersList()) {
			result += Integer.parseInt(s.getK1energy());
		}
		return result/t.getNumOfMembers();
	}
	
	private void Set_K2_Average(Team t) {
		double result = 0;
		for(Student s : t.getMembersList()) {
			result += Integer.parseInt(s.getK2energy());
		}
		System.out.println("K2 average is:" + result/t.getNumOfMembers());
		this.team_K2_avg = result/t.getNumOfMembers();
	}
	
	private double Get_K2_Average(Team t) {
		double result = 0;
		for(Student s : t.getMembersList()) {
			result += Integer.parseInt(s.getK1energy());
		}
		return result/t.getNumOfMembers();
	}
	
	public double Get_Standard_Deviation_K1() {
		System.out.println("Standard Devaition of K1 is:" + this.standardDeviationK1);
		return standardDeviationK1;
	}
	
	public double Get_Standard_Deviation_K2() {
		System.out.println("Standard Devaition of K2 is:" + this.standardDeviationK2);
		return standardDeviationK2;
	}
	
	private void Set_Standard_Deviation_K1() {
		double result = 0;
		for(Team t : this.atu.getTeams()) {
			result += Math.pow(this.Get_K1_Average(t) - team_K1_avg, 2);
		}
		this.standardDeviationK1 = Math.sqrt(result/atu.getTeams().size());
	}
	
	private void Set_Standard_Deviation_K2() {
		double result = 0;
		for(Team t : this.atu.getTeams()) {
			result += Math.pow(this.Get_K2_Average(t) - team_K2_avg, 2);
		}
		this.standardDeviationK2 = Math.sqrt(result/atu.getTeams().size());
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
	 * Method to get K1 arraylist<team>
	 * @return arraylist<team>
	 */
	public Team get_K1() {
		return K1; 
	}
	
	/**
	 * Method to get K2 arraylist<team>
	 * @return arraylist<team>
	 */
	public Team get_K2() {
		return K2;
	}
	
	/**
	 * Method to get K3 arraylist<team>
	 * @return arraylist<team>
	 */
	public Team get_K3() {
		return K3;
	}
}