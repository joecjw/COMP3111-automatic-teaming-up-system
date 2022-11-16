package COMP3111.Project;

import static org.junit.Assert.assertEquals;
import java.util.Locale;
import org.junit.Test;
import org.testfx.api.FxAssert;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UiTester extends ApplicationTest{
	
	Parent mainroot;
    Stage mainstage;
    Scene scene;
    MyApplication controller;
	
	@Override
	public void start(Stage stage) throws Exception {
		Locale.setDefault(Locale.ENGLISH);
		this.mainstage = stage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui_for_start.fxml"));
        this.mainroot = loader.load();
        this.controller = loader.getController();
        this.scene = new Scene(mainroot);
        stage.setScene(scene);
        stage.show();
	}
	
	@Test
	public void check_mainFlow_and_subFlows() throws Exception {
		//import csv file not performed and form teams not performed
		//check formTeams error dialog
		sleep(100);
		clickOn("Instructor");
		sleep(100);
		clickOn("Start Processing");
		sleep(100);
		FxAssert.verifyThat("#formTeamsError", NodeMatchers.isVisible());
	    clickOn("#formTeamsError");
	    sleep(100);
	    
		//check reviewWithoutImport error dialog
		clickOn("Review class statistics");
		sleep(100);
		FxAssert.verifyThat("#reviewWithoutImportError", NodeMatchers.isVisible());
	    clickOn("#reviewWithoutImportError");
	    sleep(100);
	    
	    //check reviewStatisticsWithoutImport error dialog
	    clickOn("Start Import");
	    sleep(100);
	    clickOn("Review Import Result");
	    sleep(100);
	    FxAssert.verifyThat("#reviewStatisticsWithoutImportError", NodeMatchers.isVisible());
	    clickOn("#reviewStatisticsWithoutImportError");
	    sleep(100);
	    
	    ////////////////////////////////////////////////////////
	    /*//check importCancel dialog
	    clickOn("Select File");
	    sleep(100);
	    clickOn("È¡Ïû");
	    sleep(100);
	    FxAssert.verifyThat("#importCancelDialog", NodeMatchers.isVisible());
	    clickOn("#importCancelDialog");
	    sleep(100);
	    
	    
	    //check importError dialog
	    clickOn("Select File");
	    sleep(100);
	    write("/COMP3111 Project/src/test/resources/testFileForImport.txt");
	    clickOn("Open");
	    sleep(100);
	    FxAssert.verifyThat("#importErrorDialog", NodeMatchers.isVisible());
	    clickOn("#importErrorDialog");
	    sleep(100);
	    
	    
	    //check importSuccess dialog
	    clickOn("Select File");
	    sleep(100);
	    write("Sample Student Data File.CSV");
	    clickOn("Open");
	    sleep(100);
	    FxAssert.verifyThat("#importConfirmDialog", NodeMatchers.isVisible());
	    clickOn("#importConfirmDialog");
	    sleep(100);
	    
	    //////////////////////////////////////////////////////
	    */
	    
	    //check reviewWithoutTeams error dialog
	    //import csv file performed
	    clickOn("Back");
	    controller.set_fxmlPath("C:\\Users\\s2015\\git\\COMP3111-Project\\src\\main\\resources\\Sample Student Data File.CSV");
	    controller.read(controller.get_fxmlPath());
		controller.set_isFileimported(true);
		
		clickOn("Review class statistics");
		sleep(100);
		FxAssert.verifyThat("#reviewWithoutTeamsError", NodeMatchers.isVisible());
	    clickOn("#reviewWithoutTeamsError");
	    sleep(100);
	    
	    //check teamTableWithoutTeams error dialog
	    clickOn("Back");
	    sleep(100);
	    clickOn("Student");
	    sleep(100);
	    clickOn("Confirm");
	    sleep(100);
	    FxAssert.verifyThat("#teamTableWithoutTeamsError", NodeMatchers.isVisible());
	    clickOn("#teamTableWithoutTeamsError");
		sleep(100);
		
		//form teams performed
		clickOn("Back");
		sleep(100);
		clickOn("Instructor");
		sleep(100);
		clickOn("Start Processing");
		sleep(100);
		clickOn("OK");
		
		//check TeamsExist error dialog
		sleep(100);
		clickOn("Start Processing");
		sleep(100);
	    FxAssert.verifyThat("#TeamsExistError", NodeMatchers.isVisible());
	    clickOn("#TeamsExistError");
		sleep(100);

		//Test on output chart
		clickOn("Review class statistics");
		sleep(100);
		FxAssert.verifyThat("#linechart", NodeMatchers.isNotNull());
		FxAssert.verifyThat("#linechart", NodeMatchers.isVisible());
		
		//Test on output table
		//empty input
		clickOn("Back");
		sleep(100);
		clickOn("Back");
		sleep(100);
		clickOn("Student");
		sleep(100);
		clickOn("Confirm");
		sleep(100);
		Label guide_label = (Label) mainstage.getScene().lookup("#input_guide_label");
		assertEquals("Invalid input! Please check and enter again!", guide_label.getText());
		sleep(100);
		
		//invalid input
		clickOn("#input_text").write("213432");
		sleep(100);
		clickOn("Confirm");
		sleep(100);
		assertEquals("Invalid input! Please check and enter again!", guide_label.getText());
		sleep(100);
		
		//valid input
		clickOn("#input_text").write("20556367");
		sleep(100);
		clickOn("Confirm");
		sleep(100);
		
		TextField id = (TextField) mainstage.getScene().lookup("#student_id");
		TextField name = (TextField) mainstage.getScene().lookup("#student_name");
		TextField t_number = (TextField) mainstage.getScene().lookup("#team_number");
		TextField t_1 = (TextField) mainstage.getScene().lookup("#teammate_1");
		TextField t_2 = (TextField) mainstage.getScene().lookup("#teammate_2");
		TextField t_3 = (TextField) mainstage.getScene().lookup("#teammate_3");
		TextField t_4 = (TextField) mainstage.getScene().lookup("#teammate_4");
		TextField k1 = (TextField) mainstage.getScene().lookup("#k1_average");
		TextField k2 = (TextField) mainstage.getScene().lookup("#k2_average");
		
		assertEquals("20556367", id.getText());
		assertEquals("ANAHEIM James", name.getText());
		assertEquals("6", t_number.getText());
		assertEquals("ANAHEIM James", t_1.getText());
		assertEquals("ANGELICA Cat", t_2.getText());
		assertEquals("MARJORAM Coral", t_3.getText());
		assertEquals(true, t_4.getText().isEmpty());
		assertEquals("70", k1.getText());
		assertEquals("65", k2.getText());
	}
}
