package PROCESS;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class fileInterpreter {
	void read(studentData data) {
		String delimiter = ",";
		String line = "";
//		String tmp;
		
		try {
			BufferedReader b = new BufferedReader(new FileReader("/Users/wang/Desktop/2022fall/3111/workspace/PROCESS/src/main/java/PROCESS/Sample Student Data File.CSV"));
			while((line = b.readLine()) != null) {
				String[] rows = line.split(delimiter);
				data.returnData().add(Arrays.asList(rows));
			}
			b.close();
		} catch (IOException e){
			e.printStackTrace();
			return;
		} 	
//		System.out.println("File is read and stored!");
	}
	
	void print(studentData data) {
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
}
