package adminPermanentLicense;

import javafx.fxml.FXML;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXListView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PermanentController implements Initializable {
		
		Connection conection;
		
		@FXML JFXListView<String> list;
		@FXML JFXListView<String> acceptedList;
		@FXML Button cancelBtn;
		@FXML JFXDrawer drawer;
		
		
		ObservableList<String> data = FXCollections.observableArrayList();
		ObservableList<String> data1 = FXCollections.observableArrayList();
		
		
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			conection = SqliteConnection.connector();
			try {
				ResultSet rs = conection.createStatement().executeQuery("select Name from Permanent where Accepted = 0 AND Rejected = 0");
				
				while(rs.next()){
					for(int i=1; i<=rs.getMetaData().getColumnCount(); i++){
						data.add(rs.getString(1));
					}
				}
				conection.close();
				
				conection = SqliteConnection.connector();
				ResultSet rs1 = conection.createStatement().executeQuery("select Name from Permanent where Accepted = 1 AND Pass = 0 AND Fail = 0");
				
				while(rs1.next()){
					for(int i=1; i<=rs1.getMetaData().getColumnCount(); i++){
						data1.add(rs1.getString(1));
					}
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		list.setItems(data);
		acceptedList.setItems(data1);
		
		
		list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
			public void changed(ObservableValue<? extends String> observable,String oldValue,String newValue){
				PreparedStatement preparedStatement = null;
				try {
					preparedStatement = conection.prepareStatement("select * from Permanent where name = ?");
					preparedStatement.setString(1, newValue);
				
					ResultSet rs = preparedStatement.executeQuery();
					
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/adminPermanentLicense/PermanentCheck.fxml"));
					Stage primarystage = new Stage(StageStyle.DECORATED);
					primarystage.setTitle("RTO Management System");
					primarystage.setFullScreen(true);
					primarystage.setFullScreenExitHint("");
					primarystage.getIcons().add(new Image("RtoIcon.png"));
					primarystage.setScene(new Scene(
							(Parent) loader.load()
							)
						);
					PermanentCheckController p = loader.<PermanentCheckController>getController();
					p.accept.setText("Accept");
					p.cancelBtn.setText("Reject");
					p.setResult(rs);
					primarystage.show();
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
		
		acceptedList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
			public void changed(ObservableValue<? extends String> observable,String oldValue,String newValue){
				PreparedStatement preparedStatement = null;
				try {
					preparedStatement = conection.prepareStatement("select * from Permanent where name = ?");
					preparedStatement.setString(1, newValue);
				
					ResultSet rs = preparedStatement.executeQuery();
					
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/adminPermanentLicense/PermanentCheck.fxml"));
					Stage stage = new Stage(StageStyle.DECORATED);
					stage.setTitle("RTO Management System");
					stage.setFullScreen(true);
					stage.setFullScreenExitHint("");
					stage.getIcons().add(new Image("RtoIcon.png"));
					stage.setScene(new Scene(
							(Parent) loader.load()
							)
						);
					PermanentCheckController p = loader.<PermanentCheckController>getController();
					p.accept.setText("Pass");
					p.cancelBtn.setText("Fail");
					p.setResult(rs);
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
			Parent root = FXMLLoader.load(getClass().getResource("/adminPermanentLicense/PermanentCheck.fxml"));
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
