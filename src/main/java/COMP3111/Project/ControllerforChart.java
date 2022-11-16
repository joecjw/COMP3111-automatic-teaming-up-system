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
import javafx.util.Pair;

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
    void initialize_chart(algorithm a) {
    	//initialize three series for linechart
        XYChart.Series<String, Number> series_k1 = new XYChart.Series<String, Number>();
        XYChart.Series<String, Number> series_k2 = new XYChart.Series<String, Number>();
        XYChart.Series<String, Number> series_k1_k2 = new XYChart.Series<String, Number>();
    	series_k1.setName("K1");
    	series_k2.setName("K2");
    	series_k1_k2.setName("K1+K2");
    	
    	//initialize and compute team statistics for each team, store in a TeamAverage class array
    	TeamAverage[] teamStat = new TeamAverage[a.atu.getTeams().size()];
        for(int i = 0; i < teamStat.length; i++) {
        	teamStat[i] = new TeamAverage(0.0, 0.0, 0.0, i);
    		for(int j = 0; j < a.atu.getTeams().get(i).getNumOfMembers(); j++) {
    			teamStat[i].avg_k1 = teamStat[i].avg_k1 + Integer.parseInt(a.atu.getTeams().get(i).getMembersList().get(j).getK1energy());
    			teamStat[i].avg_k2 = teamStat[i].avg_k2 + Integer.parseInt(a.atu.getTeams().get(i).getMembersList().get(j).getK2energy());
    			teamStat[i].avg_k1_k2 = teamStat[i].avg_k1_k2 + teamStat[i].avg_k1 + teamStat[i].avg_k2;
    		}
    		teamStat[i].avg_k1 = teamStat[i].avg_k1/(a.atu.getTeams().get(i).getNumOfMembers());
    		teamStat[i].avg_k2 = teamStat[i].avg_k2/(a.atu.getTeams().get(i).getNumOfMembers());
    		teamStat[i].avg_k1_k2 = (teamStat[i].avg_k1 + teamStat[i].avg_k2)/2;
    	}
        
        //sort the TeamAverage class array in descending order of average k1 energy
        for(int i = 0; i < teamStat.length - 1; i++) {
    		for(int j = 1; j < teamStat.length; j++) {
				if(teamStat[j-1].avg_k1 < teamStat[j].avg_k1) {
					TeamAverage tmp = teamStat[j];
					teamStat[j] = teamStat[j-1];
					teamStat[j-1] = tmp;
				} 
			}
		}
        
        //add the value of statistics to corresponding series 
        for(int i = 0; i < teamStat.length; i++) {
        	series_k1.getData().add(new XYChart.Data<String,Number>(String.valueOf(i+1),teamStat[i].avg_k1));
    		series_k2.getData().add(new XYChart.Data<String,Number>(String.valueOf(i+1),teamStat[i].avg_k2));
    		series_k1_k2.getData().add(new XYChart.Data<String,Number>(String.valueOf(i+1),teamStat[i].avg_k1_k2));	
        }
        	    	
        //add series to the linechart
    	linechart.getData().add(series_k1);
    	linechart.getData().add(series_k2);
    	linechart.getData().add(series_k1_k2);
    }
    
    public class TeamAverage{//class used to store a team's average statistics
    	Double avg_k1;
    	Double avg_k2;
    	Double avg_k1_k2;
    	Integer team_id;
    	
    	TeamAverage(Double avg_k1, Double avg_k2, Double avg_k1_k2, Integer team_id){
    		this.avg_k1 = avg_k1;
    		this.avg_k2 = avg_k2;
    		this.avg_k1_k2 = avg_k1_k2;
    		this.team_id = team_id;
    	}
    }
}

