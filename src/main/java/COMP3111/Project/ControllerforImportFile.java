package COMP3111.Project;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *Controller for importing the file
 */
public class ControllerforImportFile extends MyApplication{
	
    @FXML
    private Button back_to_instructor_button;

    @FXML
    private Button review_import_result_button;

    @FXML
    private Button select_file_button;

    /**
     * This method import a selected csv file and processing the data inside
     * @param event event indicates that the select_file_button is clicked 
     */
    @FXML
    void select_csv_file(ActionEvent event) {
    	FileChooser fileChooser = new FileChooser();
    	File selectedFile = fileChooser.showOpenDialog((Stage)((Node)event.getSource()).getScene().getWindow());
    	if(selectedFile != null) {
	    	if(selectedFile.toString().endsWith(".CSV")) {
				read(selectedFile.toString());
				set_isFileimported(true);
	    		Alert alert =  new Alert(AlertType.INFORMATION);
	    		alert.setHeaderText("Selected File Has Been Imported");
	    		Button infoButton = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
	    		infoButton.setId("importConfirmDialog");
	    		alert.showAndWait();
			}
			else {
	    		Alert alert =  new Alert(AlertType.ERROR);
	    		alert.setHeaderText("Wrong Type! Please Select a CSV File!");
	    		Button errorButton = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
	    		errorButton.setId("importErrorDialog");
	    		alert.showAndWait();
			}
    	}	
	    else {
    		Alert alert =  new Alert(AlertType.INFORMATION);
    		alert.setHeaderText("Import Cancelled");
    		Button infoButton = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
    		infoButton.setId("importCancelDialog");
    		alert.showAndWait();
	    }
    }

    /**
     * This method change the scene that import the file back to the interface for the instructor role to indicate a specific function he/she wants to perform
     * @param event event indicates that the back_to_instructor_button is clicked
     */
    @FXML
    void switch_scene_to_instructor(ActionEvent event) throws IOException {
    	set_fxmlPath("/ui_for_instructor_functions.fxml");
    	Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	switch_scene(stage, get_fxmlPath() );
    }

    /**
     * This method change the scene that import the file to the interface for displaying the calculated statistics of the imported file
     * @param event event indicates that the review_import_result_button is clicked
     * @throws IOException Handle exception type IOExceptio which might be caused when loading the fxml file 
     */
    @FXML
    void switch_scene_to_statistics(ActionEvent event){
    	if(get_isFileimported()  == true) {//Prerequisite to display calculated statistics of selected file
			Scene scene_stat = new Scene(new Group());
			Stage stage_stat = new Stage();
			stage_stat.setTitle("Table of students' personal data");
			stage_stat.setWidth(450);
			stage_stat.setHeight(500);
		
			final Label label_stat = new Label("Statistics");
			label_stat.setFont(new Font("Arial", 20));
		
			get_stat_table().setEditable(false);
		
			TableColumn entry_column = new TableColumn("Entry");
			entry_column.setMinWidth(200);
			entry_column.setCellValueFactory(new PropertyValueFactory<Statistics, String>("entry"));
		
			TableColumn value_column = new TableColumn("Value");
			value_column.setMinWidth(150);
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
			stage_person.setWidth(900);
			stage_person.setHeight(500);
		
			final Label label_person = new Label("Person");
			label_person.setFont(new Font("Arial", 20));
		
			get_person_table().setEditable(true);
			
			TableColumn rowid_column = new TableColumn("Row_Index");
			rowid_column.setMinWidth(80);
			 rowid_column.setCellValueFactory(new PropertyValueFactory<Statistics, String>("rowid"));
			
			TableColumn studentid_column = new TableColumn("Student_ID");
			studentid_column.setMinWidth(80);
			studentid_column.setCellValueFactory(new PropertyValueFactory<Statistics, String>("studentid"));
		
			TableColumn studentname_column = new TableColumn("Student_Name");
			studentname_column.setMinWidth(180);
			studentname_column.setCellValueFactory(new PropertyValueFactory<Statistics, String>("studentname"));
		
			TableColumn k1energy_column = new TableColumn("K1_Energy");
			k1energy_column.setMinWidth(80);
			k1energy_column.setCellValueFactory(new PropertyValueFactory<Statistics, String>("k1energy"));
		
			TableColumn k2energy_column = new TableColumn("k2_Energy");
			k2energy_column.setMinWidth(80);
			k2energy_column.setCellValueFactory(new PropertyValueFactory<Statistics, String>("k2energy"));
		
			TableColumn k3trick1_column = new TableColumn("K3_Trick1");
			k3trick1_column.setMinWidth(80);
			k3trick1_column.setCellValueFactory(new PropertyValueFactory<Statistics, String>("k3trick1"));
		
			TableColumn k3trick2_column = new TableColumn("K3_Trick2");
			k3trick2_column.setMinWidth(80);
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
			//get_person_table().prefHeightProperty().bind(scene_person.heightProperty());
			//get_person_table().prefWidthProperty().bind(scene_person.widthProperty());
			((Group) scene_person.getRoot()).getChildren().addAll(vbox_person);
			stage_person.setScene(scene_person);
			stage_person.show();
    	}
    	
    	else {
    		Alert alert =  new Alert(AlertType.ERROR);
    		alert.setHeaderText("No File Found! Please Import A File First!");
    		Button errorButton = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
    		errorButton.setId("reviewStatisticsWithoutImportError");
    		alert.showAndWait();
    	}
    }
}
