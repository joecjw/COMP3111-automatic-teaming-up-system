package COMP3111.Project;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ControllerforInstructorFunctions extends Library {
	
	protected static boolean isFileimported = false;
	protected static boolean isTeamsFormed = false;
	
	private Stage stage_instructor_func;
	private Scene scene_instructor_func;
	private Parent root_instructor_func;

	private Stage stage_import;
	private Scene scene_import;
	private Parent root_import;
	
	private Stage stage_chart;
	private Scene scene_chart;
	private Parent root_chart;

    @FXML
    private Button back_to_start_button;

    @FXML
    private Label instructor_guide_label;

    @FXML
    private Button review_class_statistics_button;

    @FXML
    private Button start_import_button;

    @FXML
    private Button start_processing_button;
    
    @FXML
    void switch_scene_to_import_file(ActionEvent event) throws IOException {
    	root_import = FXMLLoader.load(getClass().getResource("/ui_for_import_file.fxml"));
    	stage_import = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene_import = new Scene(root_import);
    	stage_import.setScene(scene_import);
    	stage_import.show();
    }
    
    @FXML
    void process_and_form_teams(ActionEvent event) {
    	if(isFileimported == true) {
    		isTeamsFormed = true;
    		Alert alert =  new Alert(AlertType.INFORMATION);
    		alert.setHeaderText("Teams Have Been Successfully Formed");
    		alert.showAndWait();
    	}
    	
    	else {
    		Alert alert =  new Alert(AlertType.ERROR);
    		alert.setHeaderText("No File Found! Please Import A File First!");
    		alert.showAndWait();
    	}
    }
    
    @FXML
    void switch_scene_to_start_from_instructor(ActionEvent event) throws IOException {
    	root_instructor_func = FXMLLoader.load(getClass().getResource("/ui_for_start.fxml"));
    	stage_instructor_func = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene_instructor_func = new Scene(root_instructor_func);
    	stage_instructor_func.setScene(scene_instructor_func);
    	stage_instructor_func.show();
    }
    
    @FXML
    void switch_scene_to_chart(ActionEvent event) throws IOException {  
    	if(isFileimported == true) {
    		if(isTeamsFormed == true) {
    			FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui_for_chart.fxml"));
    			root_chart = loader.load();
    			
    			ControllerforChart controllerforchart = loader.getController();
    			controllerforchart.initialize_chart();
    			
    			stage_chart = (Stage)((Node)event.getSource()).getScene().getWindow();
    			scene_chart = new Scene(root_chart);
    			stage_chart.setScene(scene_chart);
    			stage_chart.show();
    		}
    		else {
        		Alert alert =  new Alert(AlertType.ERROR);
        		alert.setHeaderText("Teams Not Found! Please Form Teams First! ");
        		alert.showAndWait();
    		}
    	}    	
    	else {
    		Alert alert =  new Alert(AlertType.ERROR);
    		alert.setHeaderText("No File Found! Please Import A File First!");
    		alert.showAndWait();
    	}
    }

	

}
