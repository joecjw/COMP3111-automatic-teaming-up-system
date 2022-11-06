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
}
