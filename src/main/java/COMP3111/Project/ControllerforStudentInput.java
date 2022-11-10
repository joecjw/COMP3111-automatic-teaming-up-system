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


/**
 *Controller for the OUTPUT Task: Generate Table with a particular student's team information 
 */
public class ControllerforStudentInput extends MyApplication{
	
    @FXML
    private Label input_guide_label;
	
    @FXML
    private TextField input_text;
    
    @FXML
    private Button back_to_start_button;
    
    @FXML
    private Button confirm_button;
    
    /**
     * This method will change the scene that get student's input for checking team information back to the interface for choosing the role
     * @param event event indicates that the back_to_start_button is clicked
     * @throws IOException Handle exception type IOExceptio which might be caused when loading the fxml file 
     */
    @FXML
    void switch_scene_to_start_from_input(ActionEvent event) throws IOException {
    	set_fxmlPath("/ui_for_start.fxml");
    	Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	switch_scene(stage, get_fxmlPath() );
    }
    
    /**
     * This method change the scene that get student's input for checking team information to the interface that showing the table
     * @param event event indicates that the confirm_button is clicked
     * @param student indicates the student who wants to check his/her team information
     * @throws IOException Handle exception type IOExceptio which might be caused when loading the fxml file 
     */
    void switch_scene_to_table(ActionEvent event, Student student) throws IOException {
    	set_fxmlPath("/ui_for_table.fxml");
    	FXMLLoader loader = new FXMLLoader(getClass().getResource(get_fxmlPath()));
    	Parent root =  loader.load();
    	ControllerforTable controllerfortable = loader.getController();
    	controllerfortable.initialize_table(student);
    	Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	Scene scene = new Scene(root);
    	stage.setScene(scene);
    	stage.setTitle("COMP3111 Project - Group 09");
    	stage.show();
    }
    
    /**
     * This method check the if the id or name entered corresponds to a student in database and invoke the 'switch_scene_to_table' function upon valid input
     * @param event event indicates that the confirm_button is clicked
     * @throws Exception Handle exception which might be caused when calling the 'switch_scene_to_table' function 
     */
    @FXML
    void check_input(ActionEvent event) throws Exception {
    	if(get_isTeamsFormed() == true) {//prerequisite for generating table
    		Boolean valid_input = false;
        	String key = input_text.getText();
        	Student target = null;
        	for(Student student: get_student_data()) {//look up for the student in data that is the same as the input
        		if(key.equalsIgnoreCase(student.getStudentid()) == true || key.equalsIgnoreCase(student.getStudentname()) == true) {
        			valid_input = true;
        			target = student;
        		}
        	}
        	
        	if(valid_input == true && target != null) {//display table only with valid input and existing data
        		switch_scene_to_table(event, target);
        	}
        	
        	else {//inform user with invalid input message
        		input_guide_label.setText("Invalid input! Please check and enter again!");
        		input_text.clear();
        	}
    	}
    	
    	else {//inform user with error message
      		Alert alert =  new Alert(AlertType.ERROR);
    		alert.setHeaderText("Teams Not Formed Yet! Please Wait For Instructor To Form Teams ");
    		alert.showAndWait();
    	}
    	
    }
}
