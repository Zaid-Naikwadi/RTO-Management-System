package adminLearningLicense;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXListView;
import LearningLicense.SqliteConnection;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LearningController implements Initializable {
	
	Connection conection;
	
	@FXML JFXListView<String> list;
	@FXML Button cancelBtn;
	@FXML JFXDrawer drawer;
	
	
	ObservableList<String> data = FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		conection = SqliteConnection.connector();
		try {
			ResultSet rs = conection.createStatement().executeQuery("select Name from Learning where Accepted = 0 AND Rejected = 0");
			
			while(rs.next()){
				for(int i=1; i<=rs.getMetaData().getColumnCount(); i++){
					data.add(rs.getString(1));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	list.setItems(data);
	
	
	list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
		public void changed(ObservableValue<? extends String> observable,String oldValue,String newValue){
			
			System.out.println("Selected Item" +newValue);
			PreparedStatement preparedStatement = null;
			try {
				
				preparedStatement = conection.prepareStatement("select * from Learning where name = ?");
				preparedStatement.setString(1, newValue);
			
				ResultSet rs = preparedStatement.executeQuery();
				
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/adminLearningLicense/LearningCheck.fxml"));
				Stage stage = new Stage(StageStyle.DECORATED);
				stage.setTitle("RTO Management System");
				stage.setFullScreen(true);
				stage.setFullScreenExitHint("");
				stage.getIcons().add(new Image("RtoIcon.png"));
				stage.setScene(new Scene(
						(Parent) loader.load()
						)
					);
				LearningCheckController c = loader.<LearningCheckController>getController();
				c.setResult(rs);
				stage.show();
				closeForm();
				conection.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
	}
	});
	}
	
	public void selectName() throws IOException{
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/adminLearningLicense/LearningCheck.fxml"));
		Scene scene = new Scene(root);
		primaryStage.getIcons().add(new Image("RtoIcon.png"));
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private void closeForm() {
		Stage stage = new Stage();
		stage= (Stage) cancelBtn.getScene().getWindow();
		stage.close();
	}
	
    public void CancelBtn() throws Exception{
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("/adminMainWindow/Usr.fxml").openStream());
		Scene scene = new Scene(root);		
		primaryStage.getIcons().add(new Image("RtoIcon.png"));
		primaryStage.setTitle("RTO Management System");
		primaryStage.setFullScreen(true);
		primaryStage.setFullScreenExitHint("");
		primaryStage.setScene(scene);	
		primaryStage.show();
		closeForm();
    }

}
