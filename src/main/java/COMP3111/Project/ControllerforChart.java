package COMP3111.Project;

import java.io.IOException;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControllerforChart extends Library{
	private Stage stage;
	private Scene scene;
	private Parent root;

    @FXML
    private Button back_to_instructor_buttton;
    
    @FXML
    private LineChart<String, Number> linechart;

    @FXML
    void switch_scene_to_instructor_form_chart(ActionEvent event) throws IOException {
    	root = FXMLLoader.load(getClass().getResource("/ui_for_instructor_functions.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }
    
    void initialize_chart() {
    	XYChart.Series<String, Number> series_k1 = new XYChart.Series<String, Number>();
    	for(int i = 1; i < Library.studentData.size(); i++) {
    		Integer temp = i;
    		series_k1.getData().add(new XYChart.Data<String,Number>(temp.toString(),Integer.parseInt(Library.studentData.get(i-1).getK1energy())));
    	}
    	series_k1.setName("K1");
    	
    	XYChart.Series<String, Number> series_k2 = new XYChart.Series<String, Number>();
    	for(int i = 1; i < Library.studentData.size(); i++) {
    		Integer temp = i;
    		series_k2.getData().add(new XYChart.Data<String,Number>(temp.toString(),Integer.parseInt(Library.studentData.get(i-1).getK2energy())));
    	}
    	series_k2.setName("K2");
    	
    	XYChart.Series<String, Number> series_k1_k2 = new XYChart.Series<String, Number>();
    	for(int i = 1; i < Library.studentData.size(); i++) {
    		Integer temp = i;
    		series_k1.getData().add(new XYChart.Data<String,Number>(temp.toString(),
    				Integer.parseInt(Library.studentData.get(i-1).getK1energy())*0.5 + Integer.parseInt(Library.studentData.get(i-1).getK2energy())*0.5));
    	}
    	series_k1_k2.setName("K1+K2");
    	
    	linechart.getData().add(series_k1);
    	linechart.getData().add(series_k2);
    	linechart.getData().add(series_k1_k2);
    	
    }

}

