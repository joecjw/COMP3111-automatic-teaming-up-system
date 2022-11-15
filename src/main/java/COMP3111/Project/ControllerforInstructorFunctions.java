package COMP3111.Project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *Controller for the instructor role to indicate a specific function he/she wants to perform
 */
public class ControllerforInstructorFunctions extends MyApplication {

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
    
    public Button get_review_button(){
    	return review_class_statistics_button;
    }
    
    /**
     * This method will change the scene that indicate instructor'choice to the interface for importing the file
     * @param event event indicates that the start_import_button is clicked
     * @throws IOException Handle exception type IOExceptio which might be caused when loading the fxml file 
     */
    @FXML
    void switch_scene_to_import_file(ActionEvent event) throws IOException {
    	//if(get_isFileimported() != true) {
	    	set_fxmlPath("/ui_for_import_file.fxml");
	    	Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	    	switch_scene(stage, get_fxmlPath() );
    	//}
    	
    	/*else {
    		Alert alert =  new Alert(AlertType.WARNING);
    		alert.setHeaderText("File Has Already Been Imported! No Need To Imported Again!");
    		Button warningButton = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
    		warningButton.setId("importFileError");
    		alert.showAndWait();
    	}*/
    }
    
    /**
     * This method create new Team instances with processed data
     * @param event event indicates that the start_processing_button is clicked
     */
    @FXML
    void form_teams(ActionEvent event) {
    	if(get_isFileimported() == true) {//Prerequisite to create new Team instances
    		process_team_data(get_student_data(), get_team_data());
    		set_isTeamsFormed(true);
    		Alert alert =  new Alert(AlertType.INFORMATION);
    		alert.setHeaderText("Teams Have Been Successfully Formed");
    		alert.showAndWait();
    	}
    	
    	else {
    		Alert alert =  new Alert(AlertType.ERROR);
    		alert.setHeaderText("No File Found! Please Import A File First!");
    		Button errorButton = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
            errorButton.setId("formTeamsError");
    		alert.showAndWait();
    	}
    }
    
    /**
     * This method will change the scene that indicate instructor'choice to the interface for choosing the role
     * @param event event indicates that the back_to_start_button is clicked
     * @throws IOException Handle exception type IOExceptio which might be caused when loading the fxml file 
     */
    @FXML
    void switch_scene_to_start_from_instructor(ActionEvent event) throws IOException {
    	set_fxmlPath("/ui_for_start.fxml");
    	Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	switch_scene(stage, get_fxmlPath() );
    }
    
    /**
     * This method will change the scene that indicate instructor'choice to the interface for generating the chart
     * @param event event indicates that the review_class_statistics_button is clicked
     * @throws IOException Handle exception type IOExceptio which might be caused when loading the fxml file 
     */
    @FXML
    void switch_scene_to_chart(ActionEvent event) throws IOException {  
    	if(get_isFileimported() == true) {//Prerequisite to generate chart
    		if(get_isTeamsFormed() == true) {//Prerequisite to generate chart
    			FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui_for_chart.fxml"));
    			Parent root =  loader.load();
    			ControllerforChart controllerforchart = loader.getController();
    			controllerforchart.initialize_chart(get_team_data());
    	    	Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	    	Scene scene = new Scene(root);
    	    	stage.setScene(scene);
    	    	stage.setTitle("COMP3111 Project - Group 09");
    	    	stage.show();
    		}
    		else {
        		Alert alert =  new Alert(AlertType.ERROR);
        		alert.setHeaderText("Teams Not Found! Please Form Teams First!");
        		Button errorButton = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
                errorButton.setId("reviewWithoutTeamsError");
        		alert.showAndWait();
    		}
    	}    	
    	else {		
    		Alert alert =  new Alert(AlertType.ERROR);
    		alert.setHeaderText("No File Found! Please Import A File First!");
       		Button errorButton = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
            errorButton.setId("reviewWithoutImportError");
    		alert.showAndWait();
    	}
    }

	void process_team_data(ArrayList<Student> studentData,  ArrayList<Team> teamData) {
		//can implement the process part here, the parameters are for reference only.
		
		set_isTeamsFormed(true);
	}
}
