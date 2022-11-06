package PROCESS;
import java.util.*;

public class studentData {
	private List<List<String>> data;
	private String name;
	
	public studentData(String name){
		this.name = name;
		this.data = new ArrayList<List<String>>();
	}
	
//	public studentData(studentData old) {
//		this.data = new ArrayList<List<String>>(old.returnData());
//		this.name = new String(old.returnName());
//	}

	public List<List<String>> returnData(){
		return data;
	}
	public String returnName() {
		return name;
	}
	public int returnNumOfStudent() {
		return data.size()-1;
	}
}
