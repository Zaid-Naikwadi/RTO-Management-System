package adminFAQ;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class FAQController {
@FXML Button OkBtn;	
	
	public void onOK(ActionEvent ae) throws Exception{
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/adminMainWindow/Usr.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		primaryStage.setTitle("RTO Management System");
		primaryStage.getIcons().add(new Image("RtoIcon.png"));
		primaryStage.setFullScreen(true);
		primaryStage.setFullScreenExitHint("");
		primaryStage.setScene(scene);
		primaryStage.show();
		Stage stage = new Stage();
		stage= (Stage) OkBtn.getScene().getWindow();
		stage.close();
	}
}
