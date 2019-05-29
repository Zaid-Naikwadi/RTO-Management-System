package RequestAccepted;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import mainWindow.UsrController;

public class RequestAcceptedController {
	@FXML Button btn;
	public String Name;
	
	public void home() throws IOException{
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/mainWindow/Usr.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		UsrController u = loader.<UsrController>getController();
		u.Name = Name;
		primaryStage.setTitle("RTO Management System");
		primaryStage.getIcons().add(new Image("RtoIcon.png"));
		primaryStage.setFullScreen(true);
		primaryStage.setFullScreenExitHint("");
		primaryStage.setScene(scene);
		primaryStage.show();
		closeForm();
		
	}
	
	public void closeForm(){
		Stage stage = new Stage();
		stage = (Stage) btn.getScene().getWindow();
		stage.close();
	}

}
