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
import javafx.scene.control.ButtonType;
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
    void switch_scene_to_table(ActionEvent event, Student student, Team team, String k1_avg, String k2_avg) throws IOException {
    	set_fxmlPath("/ui_for_table.fxml");
    	FXMLLoader loader = new FXMLLoader(getClass().getResource(get_fxmlPath()));
    	Parent root =  loader.load();
    	ControllerforTable controllerfortable = loader.getController();
    	controllerfortable.initialize_table(student, team, k1_avg, k2_avg);
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
        	Team targetTeam = null;
        	Student targetStudent = null;
        	
        	Integer team_average_k1 = 0;
    		Integer team_average_k2 = 0;
    		for(int i = 0; i < get_algorithm().atu.getTeams().size(); i++) {//look up for the student in teamData that is the same as the input
        		for(int j = 0; j < get_algorithm().atu.getTeams().get(i).getNumOfMembers(); j++) {
        			if(key.equalsIgnoreCase(get_algorithm().atu.getTeams().get(i).getMembersList().get(j).getStudentid()) || 
        				key.equalsIgnoreCase(get_algorithm().atu.getTeams().get(i).getMembersList().get(j).getStudentname())) {

        				valid_input = true;
            			targetTeam = get_algorithm().atu.getTeams().get(i);
            			targetStudent = get_algorithm().atu.getTeams().get(i).getMembersList().get(j);
            			
        				for(int k = 0; k < get_algorithm().atu.getTeams().get(i).getNumOfMembers(); k++) {
    						team_average_k1 = team_average_k1 + Integer.parseInt(get_algorithm().atu.getTeams().get(i).getMembersList().get(k).getK1energy());
    						team_average_k2 = team_average_k2 + Integer.parseInt(get_algorithm().atu.getTeams().get(i).getMembersList().get(k).getK2energy());
        				}
        				team_average_k1 = team_average_k1 / get_algorithm().atu.getTeams().get(i).getNumOfMembers();
        				team_average_k2 = team_average_k2 / get_algorithm().atu.getTeams().get(i).getNumOfMembers();
        				break;
        			}
        		}
        	}

        	if(valid_input == true && targetTeam != null && targetStudent != null) {//display table only with valid input and existing data
        		switch_scene_to_table(event,targetStudent, targetTeam, team_average_k1.toString(), team_average_k2.toString());
        	}
        	
        	else {//inform user with invalid input message
        		input_guide_label.setText("Invalid input! Please check and enter again!");
        		input_text.clear();
        	}
    	}
    	
    	else {//inform user with error message   		
      		Alert alert =  new Alert(AlertType.ERROR);
    		alert.setHeaderText("Teams Not Formed Yet! Please Wait For Instructor To Form Teams ");
    		Button errorButton = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
    		errorButton.setId("teamTableWithoutTeamsError");
    		alert.showAndWait();
    	}
    	
    }
}
