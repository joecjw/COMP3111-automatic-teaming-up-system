package PROCESS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class algorithm {
	public List<List<String>> K1;
	public List<List<String>> K2;
	public List<List<String>> K3;
	
	void compute(studentData data, int Team_Size) {
		Select_K1_member(data, Team_Size);
		Select_K2_member(data, Team_Size);
		Select_K3_member(data, Team_Size);
	}
	private int K1_Position(studentData data) {
		String k1 = "k1_energy";
		int i = 0;
		while(!k1.equals(data.returnData().get(0).get(i))) i++;
		return i;
	}
	private int K2_Position(studentData data) {
		String k2 = "k2_energy";
		int i = 0;
		while(!k2.equals(data.returnData().get(0).get(i))) i++;
		return i;
	}
	
	private void Select_K1_member(studentData data, int Team_Size) {
		ArrayList<List<String>> copy = new ArrayList<List<String>>(data.returnData());
		int K1_Position = K1_Position(data) + 1;
		for(int i = 1; i < copy.size()-1; i++) {
			for(int j = 2; j < copy.size(); j++) {
				if(Integer.parseInt(copy.get(j-1).get(K1_Position)) < Integer.parseInt(copy.get(j).get(K1_Position))) {
					List<String> s = copy.get(j);
					copy.remove(j);
					copy.add(j-1, s);
				} 
			}
		}
		K1 = new ArrayList<List<String>>(copy.subList(0, Team_Size));
	}
	private void Select_K2_member(studentData data, int Team_Size) {
		ArrayList<List<String>> copy = new ArrayList<List<String>>(data.returnData());
		int K2_Position = K2_Position(data) + 1;
		for(int i = 1; i < copy.size()-1; i++) {
			for(int j = 2; j < copy.size(); j++) {
				if(Integer.parseInt(copy.get(j-1).get(K2_Position)) > Integer.parseInt(copy.get(j).get(K2_Position))) {
					List<String> s = copy.get(j);
					copy.remove(j);
					copy.add(j-1, s);
				} 
			}
		}
		K2 = new ArrayList<List<String>>();
		int j = 0;
		for(int i = copy.size()-1; i > -1; i--) {
			if(!K1.contains(copy.get(i))) {
				K2.add(copy.get(i));
				j++;
			}
			if(j == Team_Size) break;
		}
	}
	
	private void Select_K3_member(studentData data, int Team_Size) {
		ArrayList<List<String>> copy = new ArrayList<List<String>>(data.returnData());
		K3 = new ArrayList<List<String>>();
		for(int i = 1; i < copy.size()-1; i++) 
			if(!(K1.contains(copy.get(i)) || K2.contains(copy.get(i)))) 
				K3.add(copy.get(i));
	}
	
	private int K1_Average(studentData data) {
		try {
			int K1_Position = K1_Position(data) + 1;
			int sum = 0;
			for(int i = 1; i < data.returnData().size()-1; i++) 
				sum += Integer.parseInt(data.returnData().get(i).get(K1_Position));
			
			return (sum/(data.returnNumOfStudent()));
		} catch (Exception e) {
			System.out.println("No student!");
			return 0;
		}
	}
	
	
	
	
}
