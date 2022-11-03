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
		
		private final SimpleStringProperty rowid;
		private final SimpleStringProperty studentid;
		private final SimpleStringProperty studentname;
		private final SimpleStringProperty k1energy;
		private final SimpleStringProperty k2energy;
		private final SimpleStringProperty k3trick1;
		private final SimpleStringProperty k3trick2;
		private final SimpleStringProperty mypreference;
		private final SimpleStringProperty concerns;

		private Person(String row_id, String student_id, String student_name, String k1_energy, String k2_energy, String k3_trick1,
				String k3_trick2, String my_preference, String concerns) {
			this.rowid = new SimpleStringProperty(row_id);
			this.studentid = new SimpleStringProperty(student_id);
			this.studentname = new SimpleStringProperty(student_name);
			this.k1energy = new SimpleStringProperty(k1_energy);
			this.k2energy = new SimpleStringProperty(k2_energy);
			this.k3trick1 = new SimpleStringProperty(k3_trick1);
			this.k3trick2 = new SimpleStringProperty(k3_trick2);
			this.mypreference = new SimpleStringProperty(my_preference);
			this.concerns = new SimpleStringProperty(concerns);
		}
		
		public String getRowid() {
			return rowid.get();
		}
		
		public String getStudentid() {
			return studentid.get();
		}

		public void setStudentid(String val) {
			studentid.set(val);
		}

		public String getStudentname() {
			return studentname.get();
		}

		public void setStudentname(String val) {
			studentname.set(val);
		}

		public String getK1energy() {
			return k1energy.get();
		}

		public void setK1energy(String val) {
			k1energy.set(val);
		}

		public String getK2energy() {
			return k2energy.get();
		}

		public void setK2energy(String val) {
			k2energy.set(val);
		}

		public String getK3trick1() {
			return k3trick1.get();
		}

		public void setK3trick1(String val) {
			k3trick1.set(val);
		}

		public String getK3trick2() {
			return k3trick2.get();
		}

		public void setK3trick2(String val) {
			k3trick2.set(val);
		}

		public String getMypreference() {
			return mypreference.get();
		}

		public void setMypreference(String val) {
			mypreference.set(val);
		}

		public String getConcerns() {
			return concerns.get();
		}

		public void setConcerns(String val) {
			concerns.set(val);
		}

	}
	
	private TableView<Statistics> stat_table = new TableView<Statistics>();
	private TableView<Person> person_table = new TableView<Person>();

	private final ObservableList<Statistics> stat_data = FXCollections.observableArrayList(
			new Statistics("Total Number of Students", "100"),
			new Statistics("K1_Energy(Average, Min, Max)", "(59.8, 10, 80)"),
			new Statistics("K2_Energy(Average, Min, Max)", "(62.3, 40, 85)"), new Statistics("K3_Tick1 = 1", "12"),
			new Statistics("K3_Tick2 = 1", "3"), new Statistics("My_Preference = 1", "19"));
	
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
			int i = 0;
			br.readLine(); // skip the first line
			while ((line = br.readLine()) != null) {
				tempArr = line.split(delimiter);
				Person a = new Person(String.valueOf(i), tempArr[0], tempArr[1]+tempArr[2], tempArr[4], tempArr[5], tempArr[6],
						tempArr[7], tempArr[8], tempArr[9]);
				person_data.add(a);
				i += 1;
			}
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

