package COMP3111.Project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Locale;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class MyApplication extends Application{

	private final static String delimiter = ",";
	
	private static String fxmlPath = null;
	
	private static boolean isFileimported = false;
	
	private static boolean isTeamsFormed = false;
	
	private Algorithm ATU = new Algorithm();
	
	private static ArrayList<Student> studentData = new ArrayList<Student>();
	
	//can change to other data structure (for output testing)
	//private static ArrayList<Team> teamData = new ArrayList<Team>();
	private static Team teamDatacopy = new Team();
	
	private final static ObservableList<Statistics> stat_data = FXCollections.observableArrayList();

	private TableView<Statistics> stat_table = new TableView<Statistics>();
	
	private static ObservableList<Student> person_data = null;
	
	private TableView<Student> person_table = new TableView<Student>();
	
	public Algorithm get_algorithm() {
		return ATU;
	}

	public static ArrayList<Student> get_student_data() {
		return studentData;
	}
	
	public Team get_teamDataCopy() {
		return teamDatacopy;
	}
	
	//use to get the team data (for output testing)
	//public static ArrayList<Team> get_team_data() {
		//return teamData;
	//}
	
	public TableView<Statistics> get_stat_table() {
		return stat_table;
	}

	public TableView<Student> get_person_table () {
		return person_table;
	}

	public static ObservableList<Statistics> get_stat_data () {
		return stat_data;
	}

	public ObservableList<Student> get_person_data () {
		return person_data;
	}
	
	public String get_fxmlPath() {
		return fxmlPath;
	}
	
	public void set_fxmlPath(String path) {
		MyApplication.fxmlPath = path;
	}
	
	public boolean get_isFileimported() {
		return isFileimported;
	}
	
	public void set_isFileimported(boolean result) {
		MyApplication.isFileimported = result;
	}
	
	public boolean get_isTeamsFormed() {
		return isTeamsFormed;
	}
	
	public void set_isTeamsFormed(boolean result) {
		MyApplication.isTeamsFormed = result;
	}
	
	public void read(String csvFile) {
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
				tempArr[1] = tempArr[1].replace("\"", "");
				tempArr[2] = tempArr[2].replace("\"", "");
				Student a = new Student(String.valueOf(i), tempArr[0], tempArr[1]+tempArr[2], tempArr[3], tempArr[4], tempArr[5], tempArr[6],
						tempArr[7], tempArr[8], tempArr[9]);
				studentData.add(a);
				if (tempArr[6].equals("1")) {
					k3_tick1 += 1;
				}
				else if (tempArr[7].equals("1")) {
					k3_tick2 += 1;
				}
				else if (tempArr[8].equals("1")) {
					pref_cnt += 1;
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
			stat_data.add(new Statistics("My_Preference = 1", String.valueOf(pref_cnt)));
			person_data = FXCollections.observableArrayList(studentData);
			br.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	/**
	 * This method changes the scene from current scene to another scene
	 * @param stage stage that contains the current scene
	 * @param fxmlPath .fxml file path to the file that contains the destination scene
	 * @throws IOException IOException Handle exception type IOExceptio which might be caused when loading the fxml file
	 */
   public void switch_scene(Stage stage, String fxmlPath) throws IOException{   	
    	Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
    	Scene scene = new Scene(root);
    	stage.setTitle("COMP3111 Project - Group 09");
    	stage.setScene(scene);
    	stage.show();
    }
    
    /**
     * This method set up the initial UI interface
     */
    @Override
	public void start(Stage stage) throws Exception{
    	fxmlPath = "/ui_for_start.fxml";
    	switch_scene(stage, fxmlPath);
	}
	/**
	 * Entry point of the Application
	 */
	public static void main(String args[]) {
		/*
		 * This part is for process debug only, if you wanna make it work, 
		 * manually add algorithm class from dev/process branch
		algorithm alg = new algorithm();
		Team t = new Team(studentData);
		System.out.println("total have: " + t.getNumOfMembers() + " students");
		alg.compute(t, 33);
		print(alg.K1);
		print(alg.K2);
		print(alg.K3);
		

		for(int i = 0; i < 33; i++) {
			print(alg.atu.getTeams().get(i));
		}
		*/
		
		Locale.setDefault(Locale.ENGLISH);
		Application.launch(args);
		
	}
}
