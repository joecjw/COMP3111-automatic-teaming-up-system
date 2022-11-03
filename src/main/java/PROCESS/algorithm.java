package PROCESS;

import java.util.List;

public class algorithm {
	void compute(studentData data) {
		int Team_Size = data.returnNumOfStudent();
		K1_Descending(data);
	}
	private int K1_Position(studentData data) {
		String k1 = "k1_energy";
		int i = 0;
		while(!k1.equals(data.returnData().get(0).get(i))) i++;
		System.out.println("K1 is at" + i);
		return i;
	}
	
	private void K1_Descending(studentData data) {
//		int Column_Size = data.returnData().get(0).size();
		int K1_Position = K1_Position(data) + 1;
//		System.out.println("data size is :" + data.returnSize());
		for(int i = 1; i < data.returnData().size()-1; i++) {
			for(int j = 2; j < data.returnData().size(); j++) {
				if(Integer.parseInt(data.returnData().get(j-1).get(K1_Position)) < Integer.parseInt(data.returnData().get(j).get(K1_Position))) {
					List<String> s = data.returnData().get(j);
					data.returnData().remove(j);
					data.returnData().add(j-1, s);
				} 
			}
		}
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
