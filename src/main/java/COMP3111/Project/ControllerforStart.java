package COMP3111.Project;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;


/**
 *Controller for the user to select his/her role
 */
public class ControllerforStart extends MyApplication{

    @FXML
    private Button instructor_role_button;

    @FXML
    private Button student_role_button;
        
    /**
     * This method change the scene that select the role to the interface for the instructor role to indicate a specific function he/she wants to perform
     * @param event event indicates that the instructor_role_button is clicked
     * @throws IOException Handle exception type IOExceptio which might be caused when loading the fxml file 
     */
    @FXML
    void switch_scene_to_instructor_function(ActionEvent event) throws IOException {   	
    	set_fxmlPath("/ui_for_instructor_functions.fxml");
    	Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	switch_scene(stage, get_fxmlPath() );
    }

    /**
     * This method change the scene that select the role to the interface for getting the student's input for team checking
     * @param event event indicates that the student_role_button is clicked
     * @throws IOException Handle exception type IOExceptio which might be caused when loading the fxml file 
     */
    @FXML
    void swith_scene_to_student_input_from_start(ActionEvent event) throws IOException {
    	set_fxmlPath("/ui_for_student_input.fxml");
    	Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	switch_scene(stage, get_fxmlPath() );
    }
}