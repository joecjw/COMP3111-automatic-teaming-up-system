package PROCESS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class algorithm {
	public Team K1 = new Team();
	public Team K2 = new Team();
	public Team K3 = new Team();
	private Team copy;
	
	void compute(Team t, int Team_Size) {
		Select_K1_member(t, Team_Size);
		Select_K2_member(t, Team_Size);
		Select_K3_member(t, Team_Size);
	}
//	private int K1_Position(Team t) {
//		String k1 = "k1_energy";
//		int i = 0;
//		while(!k1.equals(t.get(0).get(i))) i++;
//		return i;
//	}
//	private int K2_Position(Team Team) {
//		String k2 = "k2_energy";
//		int i = 0;
//		while(!k2.equals(Team.returnTeam().get(0).get(i))) i++;
//		return i;
//	}
	
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
	
	private void Select_K3_member(Team Team, int Team_Size) {
		int k = copy.getNumOfMembers();
		for(int i = 0; i < k; i++) {
			K3.addMember(copy.getMembersList().get(0));
			copy.removeMember(K3.getMembersList().get(i));
		}
	}
	
//	private int K1_Average(Team Team) {
//		try {
//			int K1_Position = K1_Position(Team) + 1;
//			int sum = 0;
//			for(int i = 1; i < Team.returnTeam().size()-1; i++) 
//				sum += Integer.parseInt(Team.returnTeam().get(i).get(K1_Position));
//			
//			return (sum/(Team.returnNumOf()));
//		} catch (Exception e) {
//			System.out.println("No !");
//			return 0;
//		}
//	}
	
	
	
	
}
