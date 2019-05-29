package mainWindow;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import LearningTest.LearningTestController;
import PremanentRegistered.PremanentLicenseController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class NewMessageController implements Initializable{
	@FXML public Label lbl;
	@FXML public Hyperlink hyperlink;
	String Name;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		  lbl.setStyle("-fx-background-color:#f1f1f1;");
		 // lbl.setText("Your Request Have Been Accepted\nYou Can Start Exam By Clicking Here");
		
	}
	
	public void exam() throws IOException, SQLException{
		if(hyperlink.getText().equals("Here")){
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/LearningTest/LearningTest.fxml"));
		Parent root = loader.load();
		LearningTestController lc = loader.<LearningTestController>getController();
		lc.startExam(Name);
		Scene scene = new Scene(root);
		primaryStage.setFullScreen(true);
		primaryStage.setFullScreenExitHint("");
		primaryStage.getIcons().add(new Image("RtoIcon.png"));
		primaryStage.setScene(scene);
		primaryStage.show();
		closeForm();
	}
	if(hyperlink.getText().equals("Display")){
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/PremanentRegistered/PremanentLicense.fxml"));
		Parent root = loader.load();
		PremanentLicenseController p = loader.<PremanentLicenseController>getController();
		p.setDetails(Name);
		Scene scene = new Scene(root);
		primaryStage.getIcons().add(new Image("RtoIcon.png"));
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}	
	
	public void closeForm(){
		Stage stage = new Stage();
		stage = (Stage) lbl.getScene().getWindow();
		stage.close();
	}
}
