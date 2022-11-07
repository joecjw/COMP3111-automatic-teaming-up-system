package COMP3111.Project;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ControllerforStudentInput extends ControllerforInstructorFunctions{
	private Stage stage_start;
	private Scene scene_start;
	private Parent root_start;
	
	private Stage stage_table;
	private Scene scene_table;
	private Parent root_table;
	
    @FXML
    private Label input_guide_label;
	
    @FXML
    private TextField input_text;
    
    @FXML
    private Button back_to_start_button;
    
    @FXML
    private Button confirm_button;
    
    @FXML
    void switch_scene_to_start_from_input(ActionEvent event) throws IOException {
    	root_start = FXMLLoader.load(getClass().getResource("/ui_for_start.fxml"));
    	stage_start = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene_start = new Scene(root_start);
    	stage_start.setScene(scene_start);
    	stage_start.show();
    }
    
    void switch_scene_to_table(ActionEvent event, Student student) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui_for_table.fxml"));
    	root_table = loader.load();
    	
    	ControllerforTable controllerfortable = loader.getController();
    	controllerfortable.initialize_table(student);
    	
    	stage_table = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene_table = new Scene(root_table);
    	stage_table.setScene(scene_table);
    	stage_table.show();
    }
    
    @FXML
    void check_input(ActionEvent event) throws IOException, InterruptedException {
    	if(ControllerforInstructorFunctions.isTeamsFormed == true) {
    		Boolean valid_input = false;
        	String key = input_text.getText();
        	Student target = null;
        	for(Student student: Library.studentData) {
        		if(key.equalsIgnoreCase(student.getStudentid()) == true || key.equalsIgnoreCase(student.getStudentname()) == true) {
        			valid_input = true;
        			target = student;
        		}
        	}
        	
        	if(valid_input == true && target != null) {
        		switch_scene_to_table(event, target);
        	}
        	
        	else {
        		input_guide_label.setText("Invalid input! Please check and enter again!");
        		input_text.clear();
        	}
    	}
    	
    	else {
      		Alert alert =  new Alert(AlertType.ERROR);
    		alert.setHeaderText("Teams Not Formed Yet! Please Wait For Instructor To Form Teams ");
    		alert.showAndWait();
    	}
    	
    }
}
