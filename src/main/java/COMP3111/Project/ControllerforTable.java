package COMP3111.Project;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerforTable{
	private Stage stage;
	private Scene scene;
	private Parent root;

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
    
    
    @FXML
    void switch_scene_to_student_input_from_table(ActionEvent event) throws IOException {
    	root = FXMLLoader.load(getClass().getResource("/ui_for_student_input.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }

    
    void initialize_table(String key) {
    	this.student_id.setText(key);
    	this.student_name.setText(key);
    	this.team_number.setText(key);
    	this.teammate_1.setText(key);
    	this.teammate_2.setText(key);
    	this.teammate_3.setText(key);
    	this.teammate_4.setText(key);
    	this.k1_average.setText(key);
    	this.k2_average.setText(key);
    }
}
