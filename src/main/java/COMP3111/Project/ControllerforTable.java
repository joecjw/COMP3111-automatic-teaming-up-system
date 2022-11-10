package COMP3111.Project;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *Controller for the OUTPUT Task: Generate Table with a particular student's team information 
 */
public class ControllerforTable extends MyApplication{

    @FXML
    private Button back_to_input_button;

    @FXML
    private TextField k1_average;

    @FXML
    private TextField k2_average;

    @FXML
    private TextField student_id;

    @FXML
    private TextField student_name;

    @FXML
    private TextField team_number;

    @FXML
    private TextField teammate_1;

    @FXML
    private TextField teammate_2;

    @FXML
    private TextField teammate_3;

    @FXML
    private TextField teammate_4;
    
    /**
     * This method will change the scene from table view back to interface that get student's input for checking team information
     * @param event event indicates that the back_to_input_button is clicked
     * @throws IOException Handle exception type IOExceptio which might be caused when loading the fxml file 
     */
    @FXML
    void switch_scene_to_student_input_from_table(ActionEvent event) throws IOException {
    	set_fxmlPath("/ui_for_student_input.fxml");
    	Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	switch_scene(stage, get_fxmlPath() );
    }
    
    /**
     * This method initialize the table with processed team data
     * @param target indicates the student to be looked up for filling table data
     */
    void initialize_table(Student target) {
    	this.student_id.setText(target.getStudentid());
    	this.student_name.setText(target.getStudentname());
    	this.team_number.setText("??");
    	this.teammate_1.setText("??");
    	this.teammate_2.setText("??");
    	this.teammate_3.setText("??");
    	this.teammate_4.setText("??");
    	this.k1_average.setText("??");
    	this.k2_average.setText("??");
    }
}
