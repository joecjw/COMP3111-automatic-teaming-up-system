package COMP3111.Project;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
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
    
    public LineChart<String, Number> get_linechart() {
    	return linechart;
    }
    
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
    void initialize_chart(ArrayList<Team> teamData) {
        XYChart.Series<String, Number> series_k1 = new XYChart.Series<String, Number>();
        XYChart.Series<String, Number> series_k2 = new XYChart.Series<String, Number>();
        XYChart.Series<String, Number> series_k1_k2 = new XYChart.Series<String, Number>();
	    for(int i = 1; i < get_team_data().size() + 1; i++) {
    		Integer index = i;
    		int team_average_k1 = 0;
    		int team_average_k2 = 0;
    		int team_average_k1_k2 = 0;
    		for(int j = 0; j < get_team_data().get(i-1).getNumOfMembers(); j++) {
    			team_average_k1 = team_average_k1 + Integer.parseInt(get_team_data().get(i-1).getMembersList().get(j).getK1energy());
    			team_average_k2 = team_average_k2 + Integer.parseInt(get_team_data().get(i-1).getMembersList().get(j).getK2energy());
    			team_average_k1_k2 = team_average_k1_k2 + Integer.parseInt(get_team_data().get(i-1).getMembersList().get(j).getK2energy() 
    					+ Integer.parseInt(teamData.get(i-1).getMembersList().get(j).getK2energy()));

    		}
    		series_k1.getData().add(new XYChart.Data<String,Number>(index.toString(),team_average_k1/get_team_data().get(i-1).getNumOfMembers()));
    		series_k2.getData().add(new XYChart.Data<String,Number>(index.toString(),team_average_k2/get_team_data().get(i-1).getNumOfMembers()));
    		series_k1_k2.getData().add(new XYChart.Data<String,Number>(index.toString(),team_average_k1_k2/get_team_data().get(i-1).getNumOfMembers()));
    	}
    	series_k1.setName("K1");
    	series_k2.setName("K2");
    	series_k1_k2.setName("K1+K2");
   	    		    	
    	linechart.getData().add(series_k1);
    	linechart.getData().add(series_k2);
    	linechart.getData().add(series_k1_k2);
    }

}

