package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import mainWindow.UsrController;

public class LoginController  {
	LoginModel loginModel = new LoginModel();
	
	@FXML
	private ImageView blankUser;
	
	@FXML
	private ImageView blankPass;
	
	@FXML
	private AnchorPane anchor;
	
	@FXML
	private Pane anchor2;
	
	@FXML
	private Label isConnected;
	
	@FXML
	private JFXTextField txtuser;
	
	@FXML
	private JFXPasswordField txtpass;
	
	@FXML
	private Label lbl;

	@FXML
	private Button btn;
	
	@FXML
	private Hyperlink hplink;
	
	
	public void createAccount(ActionEvent e) throws Exception
	{
	
		Stage window=new Stage();
		Parent root=FXMLLoader.load(getClass().getResource("/CreateNewAccount/NewUser.fxml"));
		Scene scene = new Scene(root);
		window.setTitle("Create New Account");
		window.getIcons().add(new Image("RtoIcon.png"));
		window.setScene(scene);
		window.show();
		closeLogin();
	
	} 
 

		
	
		public  void Login(ActionEvent e) throws Exception{
			try{
				
				if(loginModel.isLogin(txtuser.getText().trim(), txtpass.getText().trim())== 10)
				{
					Stage primaryStage = new Stage();
					FXMLLoader loader = new FXMLLoader();
					Pane root = loader.load(getClass().getResource("/adminMainWindow/Usr.fxml").openStream());
					Scene scene = new Scene(root);		
					scene.getStylesheets().add(getClass().getResource("/mainWindow/mainWindow.css").toExternalForm());
					primaryStage.getIcons().add(new Image("RtoIcon.png"));
					primaryStage.setFullScreen(true);
					primaryStage.setFullScreenExitHint("");
					primaryStage.setTitle("RTO Management System");
					primaryStage.setScene(scene);	
					primaryStage.show();
					closeLogin();
				}

			else if(loginModel.isLogin(txtuser.getText().trim(), txtpass.getText().trim())==1)
			{
				blankUser.setVisible(true);
				blankPass.setVisible(false);
			}
			
			else if(loginModel.isLogin(txtuser.getText().trim(), txtpass.getText().trim())==2)
			{
				blankUser.setVisible(false);
				blankPass.setVisible(true);
			}
			
			else if(loginModel.isLogin(txtuser.getText().trim(), txtpass.getText().trim())== 3)
			{
				Connection conection;
				conection = SqliteConnection.connector();
				PreparedStatement preparedStatement = conection.prepareStatement("select name from Emp where Username = ?");
				preparedStatement.setString(1, txtuser.getText().trim());
				ResultSet rs = preparedStatement.executeQuery();
				
				Stage primaryStage = new Stage();
				FXMLLoader loader = new FXMLLoader();
				Pane root = loader.load(getClass().getResource("/mainWindow/Usr.fxml").openStream());
				UsrController usrController = (UsrController)loader.getController();
				while(rs.next()){
					usrController.setMessage(rs.getString("Name"));
				}
				Scene scene = new Scene(root);		
				scene.getStylesheets().add(getClass().getResource("/mainWindow/mainWindow.css").toExternalForm());
				primaryStage.getIcons().add(new Image("RtoIcon.png"));
				primaryStage.setFullScreen(true);
				primaryStage.setFullScreenExitHint("");
				primaryStage.setTitle("RTO Management System");
				primaryStage.setScene(scene);	
				primaryStage.show();
				
				
				closeLogin();
			}
			
			else
			{
				blankUser.setVisible(true);
				blankPass.setVisible(true);
			}
		}
			catch (SQLException ex){
				//isConnected.setText("Exception");
				ex.printStackTrace();
			}
	}
		
		private void closeLogin() {
			Stage stage = new Stage();
			stage= (Stage) btn.getScene().getWindow();
			stage.close();		
		}
		
	}		