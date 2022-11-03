package PROCESS;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class studentData {
	private List<List<String>> data;
	private String name;
	
	public studentData(String name){
		this.name = name;
		this.data = new ArrayList<List<String>>();
	}
	
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
