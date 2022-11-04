package COMP3111.Project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import COMP3111.Project.*;

public class Library {
	public static class Statistics {

		private final SimpleStringProperty entry;
		private final SimpleStringProperty value;

		private Statistics(String fName, String lName) {
			this.entry = new SimpleStringProperty(fName);
			this.value = new SimpleStringProperty(lName);
		}

		public String getEntry() {
			return entry.get();
		}

		public void setEntry(String val) {
			entry.set(val);
		}

		public String getValue() {
			return value.get();
		}

		public void setValue(String val) {
			value.set(val);
		}

	}
	
	public static class Person {
		
		private final String rowid;
		private final String studentid;
		private final String studentname;
		private final String email;
		private final String k1energy;
		private final String k2energy;
		private final String k3trick1;
		private final String k3trick2;
		private final String mypreference;
		private final String concerns;

		private Person(String row_id, String student_id, String student_name, String student_email, String k1_energy, String k2_energy, String k3_trick1,
				String k3_trick2, String my_preference, String concerns) {
			this.rowid = new String(row_id);
			this.studentid = new String(student_id);
			this.studentname = new String(student_name);
			this.email = new String(student_email);
			this.k1energy = new String(k1_energy);
			this.k2energy = new String(k2_energy);
			this.k3trick1 = new String(k3_trick1);
			this.k3trick2 = new String(k3_trick1);
			this.mypreference = new String(my_preference);
			this.concerns = new String(concerns);
		}
	
		public String getRowid() {
			return rowid;
		}
		
		public String getStudentid() {
			return studentid;
		}

//		public void setStudentid(String val) {
//			studentid.set(val);
//		}

		public String getStudentname() {
			return studentname;
		}
		
		public String getEmail() {
			return email;
		}

//		public void setStudentname(String val) {
//			studentname.set(val);
//		}

		public String getK1energy() {
			return k1energy;
		}

//		public void setK1energy(String val) {
//			k1energy.set(val);
//		}

		public String getK2energy() {
			return k2energy;
		}

//		public void setK2energy(String val) {
//			k2energy.set(val);
//		}
		
		public String getK3trick1() {
			return k3trick1;
		}

//		public void setK3trick1(String val) {
//			k3trick1.set(val);
//		}

		public String getK3trick2() {
			return k3trick2;
		}

//		public void setK3trick2(String val) {
//			k3trick2.set(val);
//		}

		public String getMypreference() {
			return mypreference;
		}

//		public void setMypreference(String val) {
//			mypreference.set(val);
//		}

		public String getConcerns() {
			return concerns;
		}

//		public void setConcerns(String val) {
//			concerns.set(val);
//		}

	}
	
	private TableView<Statistics> stat_table = new TableView<Statistics>();
	private TableView<Person> person_table = new TableView<Person>();

	private final static ObservableList<Statistics> stat_data = FXCollections.observableArrayList();
	
	private final static ObservableList<Person> person_data = FXCollections.observableArrayList();

	public static final String delimiter = ",";
	
	public TableView<Statistics> get_stat_table() {
		return stat_table;
	}
	
	public TableView<Person> get_person_table () {
		return person_table;
	}
	
	public ObservableList<Statistics> get_stat_data () {
		return stat_data;
	}
	
	public ObservableList<Person> get_person_data () {
		return person_data;
	}
	
	public static void read(String csvFile) {

		System.out.print("\n");
		try {
			File file = new File(csvFile);
			InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			String line = " ";
			String[] tempArr;
			Integer i = 0;
			float[] k1 = new float[]{0, 100, 0};
			float[] k2 = new float[]{0, 100, 0};
			Integer k3_tick1 = 0;
			Integer k3_tick2 = 0;
			Integer pref_cnt = 0;
			br.readLine(); // skip the first line
			while ((line = br.readLine()) != null) {
				tempArr = line.split(delimiter);
				Person a = new Person(String.valueOf(i), tempArr[0], tempArr[1]+tempArr[2], tempArr[3], tempArr[4], tempArr[5], tempArr[6],
						tempArr[7], tempArr[8], tempArr[9]);
				person_data.add(a);
				if (tempArr[6].equals("1")) {
					k3_tick1 += 1;
				}
				else if (tempArr[7].equals("1")) {
					k3_tick2 += 1;
				}
				k1[0] += Float.parseFloat(tempArr[4]);
				k1[1] = Float.min(k1[1], Integer.parseInt(tempArr[4]));
				k1[2] = Float.max(k1[2], Integer.parseInt(tempArr[4]));
				k2[0] += Float.parseFloat(tempArr[5]);
				k2[1] = Float.min(k2[1], Integer.parseInt(tempArr[5]));
				k2[2] = Float.max(k2[2], Integer.parseInt(tempArr[5]));
				i += 1;
			}
			Integer sum = i;
			k1[0] /= sum; k2[0] /= sum;
			String k1result = "(" + k1[0] + ", " + k1[1] + ", " + k1[2] + ")";
			String k2result = "(" + k2[0] + ", " + k2[1] + ", " + k2[2] + ")";
			stat_data.add(new Statistics("Total Number of Students", String.valueOf(sum)));
			stat_data.add(new Statistics("K1_Energy(Average, Min, Max)", k1result));
			stat_data.add(new Statistics("K2_Energy(Average, Min, Max)", k2result));
			stat_data.add(new Statistics("K3_Tick1 = 1", String.valueOf(k3_tick1)));
			stat_data.add(new Statistics("K3_Tick2 = 1", String.valueOf(k3_tick2)));
			stat_data.add(new Statistics("My_Preference = 1", "19"));
			br.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public static void main(String args[]) {
		String csvFile = "C:\\Users\\oscar\\git\\COMP3111-Project\\src\\main\\resources\\Sample Student Data File.CSV";
		Library.read(csvFile);
		UiforStart.run(args);
	}
}

