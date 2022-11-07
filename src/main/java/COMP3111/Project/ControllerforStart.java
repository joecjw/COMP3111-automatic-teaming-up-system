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
	
	private Stage stage_instructor;
	private Scene scene_instructor;
	private Parent root_instructor;
	
    @FXML
    private Button instructor_role_button;

    @FXML
    private Button student_role_button;
        
    @FXML
    void switch_scene_to_instructor_function(ActionEvent event) throws IOException {   	
    	root_instructor = FXMLLoader.load(getClass().getResource("/ui_for_instructor_functions.fxml"));
    	stage_instructor = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene_instructor = new Scene(root_instructor);
    	stage_instructor.setScene(scene_instructor);
    	stage_instructor.show();
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