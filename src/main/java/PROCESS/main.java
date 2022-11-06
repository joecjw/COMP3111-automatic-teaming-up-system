package PROCESS;

import java.util.List;

public class main {

	public static void main(String[] args) {
		fileInterpreter a = new fileInterpreter();
		studentData database = new studentData("abc");
		algorithm ATU = new algorithm();
		
		a.read(database);
		ATU.compute(database, 33);
		System.out.println("K1 student");
		print(ATU.K1);
		System.out.println("K2 student");
		print(ATU.K2);
		System.out.println("K3 student");
		print(ATU.K3);
		
		print(database);
		
		
	}
	static void print(studentData data) {
		if(data.returnData() != null) {
			for(int i = 0; i < data.returnData().size(); i++) {
				for(String s : data.returnData().get(i)) 
					System.out.print(s + " ");
				System.out.println();
			}
			System.out.println("In total " + (data.returnData().size() - 1) + " students");
		} else {
			System.out.println("The data is empty");
		}
	}
	
	static void print(List<List<String>> data) {
		if(data != null) {
			for(int i = 0; i < data.size(); i++) {
				for(String s : data.get(i)) 
					System.out.print(s + " ");
				System.out.println();
			}
			System.out.println("In total " + (data.size()) + " students");
		} else {
			System.out.println("The data is empty");
		}
	}


}
