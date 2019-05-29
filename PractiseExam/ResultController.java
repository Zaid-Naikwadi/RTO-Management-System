package PractiseExam;

import java.io.IOException;
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
	
	public void returnHome() throws IOException{
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/mainWindow/Usr.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		UsrController u = loader.<UsrController>getController();
		u.Name = name.getText();
		primaryStage.setTitle("RTO Management System");
		primaryStage.getIcons().add(new Image("RtoIcon.png"));
		primaryStage.setFullScreen(true);
		primaryStage.setFullScreenExitHint("");
		primaryStage.setScene(scene);
		primaryStage.show();
		closeForm();
		
	}
	private void closeForm() {
		Stage stage = new Stage();
		stage= (Stage) btn.getScene().getWindow();
		stage.close();
	}
}
