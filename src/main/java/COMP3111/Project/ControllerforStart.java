package COMP3111.Project;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import COMP3111.Project.*;

public class ControllerforStart extends Library {
	private Stage stage_input;
	private Scene scene_input;
	private Parent root_input;
	
	private Stage stage_chart;
	private Scene scene_chart;
	private Parent root_chart;
	
    @FXML
    private Button instructor_role_button;

    @FXML
    private Button student_role_button;
    
    @FXML
    private Button student_info_button;
    
    @FXML
    void show_input_table_scene(ActionEvent event) {
		Scene scene_stat = new Scene(new Group());
		Stage stage_stat = new Stage();
		stage_stat.setTitle("Table of students' personal data");
		stage_stat.setWidth(450);
		stage_stat.setHeight(500);
	
		final Label label_stat = new Label("Statistics");
		label_stat.setFont(new Font("Arial", 20));
	
		get_stat_table().setEditable(true);
	
		TableColumn entry_column = new TableColumn("Entry");
		entry_column.setMinWidth(100);
		entry_column.setCellValueFactory(new PropertyValueFactory<Statistics, String>("entry"));
	
		TableColumn value_column = new TableColumn("Value");
		value_column.setMinWidth(100);
		value_column.setCellValueFactory(new PropertyValueFactory<Statistics, String>("value"));
	
		get_stat_table().setItems(get_stat_data());
		get_stat_table().getColumns().addAll(entry_column, value_column);
		get_stat_table().setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		final VBox vbox_stat = new VBox();
		vbox_stat.setSpacing(5);
		vbox_stat.setPadding(new Insets(10, 0, 0, 10));
		vbox_stat.getChildren().addAll(label_stat, get_stat_table());
	
		((Group) scene_stat.getRoot()).getChildren().addAll(vbox_stat);
	
		stage_stat.setScene(scene_stat);
		stage_stat.show();
	
		Stage stage_person = new Stage();
		Scene scene_person = new Scene(new Group());
		stage_person.setTitle("Table of statistics data");
		stage_person.setWidth(450);
		stage_person.setHeight(500);
	
		final Label label_person = new Label("Person");
		label_person.setFont(new Font("Arial", 20));
	
		get_person_table().setEditable(true);
		
		TableColumn rowid_column = new TableColumn("Row_ID");
		rowid_column.setMinWidth(100);
		rowid_column.setCellValueFactory(new PropertyValueFactory<Statistics, String>("rowid"));
		
		TableColumn studentid_column = new TableColumn("Student_ID");
		studentid_column.setMinWidth(100);
		studentid_column.setCellValueFactory(new PropertyValueFactory<Statistics, String>("studentid"));
	
		TableColumn studentname_column = new TableColumn("Student_Name");
		studentname_column.setMinWidth(100);
		studentname_column.setCellValueFactory(new PropertyValueFactory<Statistics, String>("studentname"));
	
		TableColumn k1energy_column = new TableColumn("K1_Energy");
		k1energy_column.setMinWidth(100);
		k1energy_column.setCellValueFactory(new PropertyValueFactory<Statistics, String>("k1energy"));
	
		TableColumn k2energy_column = new TableColumn("k2_Energy");
		k2energy_column.setMinWidth(100);
		k2energy_column.setCellValueFactory(new PropertyValueFactory<Statistics, String>("k2energy"));
	
		TableColumn k3trick1_column = new TableColumn("K3_Trick1");
		k3trick1_column.setMinWidth(100);
		k3trick1_column.setCellValueFactory(new PropertyValueFactory<Statistics, String>("k3trick1"));
	
		TableColumn k3trick2_column = new TableColumn("K3_Trick2");
		k3trick2_column.setMinWidth(100);
		k3trick2_column.setCellValueFactory(new PropertyValueFactory<Statistics, String>("k3trick2"));
	
		TableColumn mypreference_column = new TableColumn("My_Preference");
		mypreference_column.setMinWidth(100);
		mypreference_column.setCellValueFactory(new PropertyValueFactory<Statistics, String>("mypreference"));
	
		TableColumn concerns_column = new TableColumn("Concerns");
		concerns_column.setMinWidth(100);
		concerns_column.setCellValueFactory(new PropertyValueFactory<Statistics, String>("concerns"));
	
		get_person_table().setItems(get_person_data());
		get_person_table().getColumns().addAll(rowid_column, studentid_column, studentname_column, k1energy_column, k2energy_column,
				k3trick1_column, k3trick2_column, mypreference_column, concerns_column);
		get_person_table().setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		final VBox vbox_person = new VBox();
		vbox_person.setSpacing(5);
		vbox_person.setPadding(new Insets(10, 0, 0, 10));
		vbox_person.getChildren().addAll(label_person, get_person_table());
	
		((Group) scene_person.getRoot()).getChildren().addAll(vbox_person);
	
		stage_person.setScene(scene_person);
		stage_person.show();
    }
    
    @FXML
    void switch_scene_to_chart(ActionEvent event) throws IOException {   	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui_for_chart.fxml"));
    	root_chart = loader.load();
    	
    	ControllerforChart controllerforchart = loader.getController();
    	controllerforchart.initialize_chart();
    	
    	stage_chart = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene_chart = new Scene(root_chart);
    	stage_chart.setScene(scene_chart);
    	stage_chart.show();
    }

    @FXML
    void swith_scene_to_student_input_from_start(ActionEvent event) throws IOException {
    	root_input = FXMLLoader.load(getClass().getResource("/ui_for_student_input.fxml"));
    	stage_input = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene_input = new Scene(root_input);
    	stage_input.setScene(scene_input);
    	stage_input.show();
    }

}