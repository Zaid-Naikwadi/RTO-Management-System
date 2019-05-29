package LearningTest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import LearningRegistered.LearningLicenseController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import mainWindow.UsrController;

public class ResultController {
	@FXML Label lbl;
	@FXML Button btn;
	Label name = new Label();
	
	public void displayLicense() throws IOException, SQLException{
		if(btn.getText().equals("Print License")){
			Stage stage = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/LearningRegistered/LearningLicense.fxml"));
			stage.setScene(new Scene(
					(Parent) loader.load()
					)
				);
			LearningLicenseController llc = loader.<LearningLicenseController>getController();
			llc.setDetails(name.getText());
			stage.getIcons().add(new Image("RtoIcon.png"));
			stage.show();
			closeForm();
			
		}
		if(btn.getText().equals("Home")){
			Connection conection;
			conection = SqliteConnection.connector();
			PreparedStatement preparedStatement = conection.prepareStatement("delete from Learning where name = ?");
			preparedStatement.setString(1, name.getText());
			preparedStatement.executeUpdate();
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/mainWindow/Usr.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			UsrController u = loader.<UsrController>getController();
			u.Name = name.getText();
			primaryStage.setFullScreen(true);
			primaryStage.setFullScreenExitHint("");
			primaryStage.getIcons().add(new Image("RtoIcon.png"));
			primaryStage.setTitle("RTO Management System");
			primaryStage.setScene(scene);
			primaryStage.show();
			closeForm();
		}
	}
	
	public void closeForm(){
		Stage stage = new Stage();
		stage = (Stage) btn.getScene().getWindow();
		stage.close();
	}

}
