package COMP3111.Project;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *Controller for the OUTPUT Task: Generate Chart with skill energy of the teams
 */
public class ControllerforChart extends MyApplication{

    @FXML
    private Button back_to_instructor_buttton;
    
    @FXML
    private LineChart<String, Number> linechart;
    

    /**
     * This method will change the scene from chart view back to interface that indicates instructor's choice of functions
     * @param event event indicates that the back_to_instructor_buttton is clicked
     * @throws IOException Handle exception type IOExceptio which might be caused when loading the fxml file 
     */
    @FXML
    void switch_scene_to_instructor_form_chart(ActionEvent event) throws IOException    {
    	set_fxmlPath("/ui_for_instructor_functions.fxml");
    	Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	switch_scene(stage, get_fxmlPath() );
    }
    
    /**
     * This method initialize the linechart with processed team data
     */
    void initialize_chart() {
    	if(get_isFileimported() == true && get_isTeamsFormed() == true) {//Prerequisite to initialize the chart
	    	XYChart.Series<String, Number> series_k1 = new XYChart.Series<String, Number>();
	    	for(int i = 1; i < get_student_data().size(); i++) {
	    		Integer temp = i;
	    		series_k1.getData().add(new XYChart.Data<String,Number>(temp.toString(),Integer.parseInt(get_student_data().get(i-1).getK1energy())));
	    	}
	    	series_k1.setName("K1");
	    	
	    	XYChart.Series<String, Number> series_k2 = new XYChart.Series<String, Number>();
	    	for(int i = 1; i < get_student_data().size(); i++) {
	    		Integer temp = i;
	    		series_k2.getData().add(new XYChart.Data<String,Number>(temp.toString(),Integer.parseInt(get_student_data().get(i-1).getK2energy())));
	    	}
	    	series_k2.setName("K2");
	    	
	    	XYChart.Series<String, Number> series_k1_k2 = new XYChart.Series<String, Number>();
	    	for(int i = 1; i < get_student_data().size(); i++) {
	    		Integer temp = i;
	    		series_k1.getData().add(new XYChart.Data<String,Number>(temp.toString(),
	    				Integer.parseInt(get_student_data().get(i-1).getK1energy())*0.5 + Integer.parseInt(get_student_data().get(i-1).getK2energy())*0.5));
	    	}
	    	series_k1_k2.setName("K1+K2");
	    	
	    	linechart.getData().add(series_k1);
	    	linechart.getData().add(series_k2);
	    	linechart.getData().add(series_k1_k2);
    	}
    }

}

