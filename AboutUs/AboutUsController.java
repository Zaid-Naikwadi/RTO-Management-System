package AboutUs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import mainWindow.UsrController;

public class AboutUsController{
	@FXML Button OkBtn;
	public Label name = new Label();

public void onOK(ActionEvent ae) throws Exception{
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
	Stage stage = new Stage();
	stage= (Stage) OkBtn.getScene().getWindow();
	stage.close();
}

}
