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
    	Integer team_index = null;
    	Integer team_average_k1 = 0;
		Integer team_average_k2 = 0;
    	for(int i = 1; i < get_team_data().size()+1; i++) {
    		for(int j = 0; j < get_team_data().get(i-1).getNumOfMembers(); j++) {
    			if(get_team_data().get(i-1).getMembersList().get(j).getStudentid() == target.getStudentid()) {
    				team_index = i;
    				for(int k = 0; k < get_team_data().get(team_index-1).getNumOfMembers(); k++) {
						team_average_k1 = team_average_k1 + Integer.parseInt(get_team_data().get(team_index-1).getMembersList().get(k).getK1energy());
						team_average_k2 = team_average_k2 + Integer.parseInt(get_team_data().get(team_index-1).getMembersList().get(k).getK2energy());
    				}
    				team_average_k1 = team_average_k1 / get_team_data().get(team_index-1).getNumOfMembers();
    				team_average_k2 = team_average_k2 / get_team_data().get(team_index-1).getNumOfMembers();
    				break;
    			}
    		}
    	}
    	this.student_id.setText(target.getStudentid());
    	this.student_name.setText(target.getStudentname());
    	this.team_number.setText(team_index.toString());
    	this.teammate_1.setText(get_team_data().get(team_index-1).getMembersList().get(0).getStudentname());
    	this.teammate_2.setText(get_team_data().get(team_index-1).getMembersList().get(1).getStudentname());
    	this.teammate_3.setText(get_team_data().get(team_index-1).getMembersList().get(2).getStudentname());
    	if(get_team_data().get(team_index-1).getNumOfMembers() == 4) {
    		this.teammate_4.setText(get_team_data().get(team_index-1).getMembersList().get(3).getStudentname());
    	}
    	else {
    		this.teammate_4.setText("");
    	}
    	
    	this.k1_average.setText(team_average_k1.toString());
    	this.k2_average.setText(team_average_k2.toString());
    }
}
