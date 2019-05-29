package adminMainWindow;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SidePanelContentController{

    @FXML
    private JFXButton b1;
    @FXML
    private JFXButton b2;
    @FXML
    private JFXButton b3;
    @FXML
    private JFXButton exit;
   

    @FXML
    private void changeColor(ActionEvent event) {
        JFXButton btn = (JFXButton) event.getSource();
        System.out.println(btn.getText());
        switch(btn.getText())
        {
            case "Color 1":UsrController.rootP.setStyle("-fx-background-color:#00FF00");
                break;
            case "Color 2":UsrController.rootP.setStyle("-fx-background-color:#0000FF");
                break;
            case "Color 3":UsrController.rootP.setStyle("-fx-background-color:#FF0000");
                break;
        }
    }

    public void Logout() throws IOException{
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/LoginPrac.fxml"));
		Stage stage = new Stage(StageStyle.DECORATED);
		stage.setScene(new Scene(
				(Parent) loader.load()
				)
			);
		stage.getIcons().add(new Image("RtoIcon.png"));
		stage.setTitle("Welcome");
		stage.show();
		closeForm();
    }
    
    private void closeForm() {
		Stage stage = new Stage();
		stage= (Stage) b1.getScene().getWindow();
		stage.close();
	}
    
    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }
    
}
