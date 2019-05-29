package adminLearningLicense;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import LearningLicense.SqliteConnection;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class LearningCheckController implements Initializable {
	@FXML Label name;
	@FXML Label parentname;
	@FXML Label address;
	@FXML Label date;
	@FXML Label place;
	@FXML Label qualification;
	@FXML Label blood;
	@FXML Label phone;
	@FXML Label email;
	@FXML Hyperlink PassportPhotoCheck;
	@FXML Hyperlink AadharCardCheck;
	@FXML Hyperlink LCCheck;
	@FXML Hyperlink RationCardCheck;
	@FXML Hyperlink PANCheck;
	
	@FXML Button cancelBtn;
	@FXML Button accept;
	Connection conection;

	public void accepted() throws IOException, SQLException{
		conection = SqliteConnection.connector();
		PreparedStatement prepareStatement = conection.prepareStatement("update Learning set Accepted = 1 where name = ?");
		prepareStatement.setString(1, name.getText());
		prepareStatement.executeUpdate();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/adminLearningLicense/Learning.fxml"));
		Stage stage = new Stage(StageStyle.DECORATED);
		stage.setScene(new Scene(
				(Parent) loader.load()
				)
			);
		LearningController c = loader.<LearningController>getController();
		
		FXMLLoader loader1 = new FXMLLoader(getClass().getResource("RequestAcceptedPane.fxml"));
        AnchorPane pane =  loader1.load();
        c. drawer.setSidePane(pane);
        
        Timeline timeline1 = new Timeline(new KeyFrame(
				 Duration.millis(2500),
			        ae -> c.drawer.close()));
		timeline1.play();
		
		 Timeline timeline2 = new Timeline(new KeyFrame(
				 Duration.millis(1000),
			        ae -> c.drawer.open()));
		timeline2.play();
		stage.setFullScreen(true);
		stage.getIcons().add(new Image("RtoIcon.png"));
		stage.setTitle("RTO Management System");
		stage.setFullScreenExitHint("");
		stage.show();
		closeForm();
		conection.close();		
	}
	
	public void CancelBtn() throws IOException, SQLException{
		conection = SqliteConnection.connector();
		PreparedStatement prepareStatement = conection.prepareStatement("update Learning set Rejected = 1 where name = ?");
		prepareStatement.setString(1, name.getText());
		prepareStatement.executeUpdate();
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Parent root = loader.load(getClass().getResource("/adminLearningLicense/Learning.fxml").openStream());
			Scene scene = new Scene(root);		
			primaryStage.getIcons().add(new Image("RtoIcon.png"));
			primaryStage.setTitle("RTO Management System");
			primaryStage.setFullScreen(true);
			primaryStage.setFullScreenExitHint("");
			primaryStage.setScene(scene);	
			primaryStage.show();
			closeForm();
	    }
		
	private void closeForm() {
		Stage stage = new Stage();
		stage= (Stage) cancelBtn.getScene().getWindow();
		stage.close();
	}
	
	public void PhotoCheck(ActionEvent ae) throws IOException, SQLException{	
		conection = SqliteConnection.connector();
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/adminLearningLicense/Photo.fxml"));
		Stage stage = new Stage(StageStyle.DECORATED);
		stage.setScene(new Scene(
				(Parent) loader.load()
				)
			);
		
		PhotoController c = loader.<PhotoController>getController();
		
		PreparedStatement preparedStatement = conection.prepareStatement("Select * from Learning where name = ?");
		preparedStatement.setString(1, name.getText());
		ResultSet rs = preparedStatement.executeQuery();
		
		if(ae.getSource() == PassportPhotoCheck){
			c.setImage(rs,1);
		}
		
		if(ae.getSource() == AadharCardCheck){
			c.setImage(rs,2);
		}
		
		if(ae.getSource() == LCCheck){
			c.setImage(rs,3);
		}
		
		if(ae.getSource() == RationCardCheck){
			c.setImage(rs, 4);
		}
		
		if(ae.getSource() == PANCheck){
			c.setImage(rs, 5);
		}
		
		
		
		
		stage.getIcons().add(new Image("RtoIcon.png"));
		stage.setTitle("RTO Management System");
		stage.show();
		
		conection.close();
	
    }


	
	public void setResult(ResultSet rs) throws SQLException{
	
		name.setText(rs.getString(2));
		parentname.setText(rs.getString(3));
		address.setText(rs.getString(4));
		date.setText(rs.getString(13));
		place.setText(rs.getString(7));
		qualification.setText(rs.getString(8));
		blood.setText(rs.getString(14));
		phone.setText(rs.getString(15));
		email.setText(rs.getString(5));
		
		setRationPanImage();
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		conection =  SqliteConnection.connector();
	}
	
	public void setRationPanImage(){
		try {
			PreparedStatement preparedStatement = conection.prepareStatement("select * from Learning where name = ?");
			 preparedStatement.setString(1, name.getText());
			 ResultSet rs = preparedStatement.executeQuery();
			 
			if(rs.next()){
				if(rs.getBytes("RationImage") == null){
					RationCardCheck.setDisable(true);
				}
				
				else if(rs.getBytes("PanImage") == null){
					PANCheck.setDisable(true);
				}
			}
			conection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

