package mainWindow;

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
	
	UsrController usr = new UsrController();

    @FXML
    private JFXButton b1;
    @FXML JFXButton b2;
    @FXML JFXButton b3;
    @FXML
    private JFXButton exit;
    
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

    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }
    
    private void closeForm() {
		Stage stage = new Stage();
		stage= (Stage) b1.getScene().getWindow();
		stage.close();
	}
    
}
