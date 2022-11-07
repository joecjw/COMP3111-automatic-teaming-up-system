package COMP3111.Project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

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
	public static ArrayList<Student> studentData = new ArrayList<Student>();
	
	private TableView<Statistics> stat_table = new TableView<Statistics>();
	private TableView<Student> person_table = new TableView<Student>();

	private final static ObservableList<Statistics> stat_data = FXCollections.observableArrayList();
	
	private static ObservableList<Student> person_data = null;

	public static final String delimiter = ",";
	
	public TableView<Statistics> get_stat_table() {
		return stat_table;
	}
	
	public TableView<Student> get_person_table () {
		return person_table;
	}
	
	public ObservableList<Statistics> get_stat_data () {
		return stat_data;
	}
	
	public ObservableList<Student> get_person_data () {
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
				Student a = new Student(String.valueOf(i), tempArr[0], tempArr[1]+tempArr[2], tempArr[3], tempArr[4], tempArr[5], tempArr[6],
						tempArr[7], tempArr[8], tempArr[9]);
				studentData.add(a);
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
			person_data = FXCollections.observableArrayList(studentData);
			br.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public static void main(String args[]) {
		UiforStart.run(args);
	}
}

