package mainWindow;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;

import AboutUs.AboutUsController;
import FAQ.FAQController;
import LearningLicense.LearningController;
import PermanentLicense.PermanentController;
import PractiseExam.LearningTestController;
import Rules.RulesController;
import TansferVehicle.TansferOfVehicleController;
import VehicleFares.FaresController;
import VehicleRegistration.RegisterVehicleController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UsrController implements Initializable {
	
	@FXML
	private JFXButton btn1;
	@FXML
	private JFXButton btn2;
	@FXML
	private JFXButton btn3;
	@FXML
	private JFXButton btn4;
	@FXML
	private JFXButton btn5;
	@FXML
	private JFXButton btn6;
	@FXML
	private JFXButton btn7;
	@FXML
	private JFXButton btn8;
	@FXML
	private JFXButton btn9;
	
	@FXML ImageView newMessage;
	
	@FXML Label lbl;
	
	public String Name;
	
	Connection conection;
	
	FXMLLoader loader = new FXMLLoader((getClass().getResource("SidePanelContent.fxml")));
	
	public void changeColor(MouseEvent event)
	{
	
		//SetColor to button if it is entered
		if(event.getSource().equals(btn1))
			btn1.setStyle("-fx-background-color:rgba(250,0,0,0.4);");
		if(event.getSource().equals(btn2))
			btn2.setStyle("-fx-background-color:rgba(250,0,0,0.4);");
		if(event.getSource().equals(btn3))
			btn3.setStyle("-fx-background-color:rgba(250,0,0,0.4);");
		if(event.getSource().equals(btn4))
			btn4.setStyle("-fx-background-color:rgba(250,0,0,0.4);");
		if(event.getSource().equals(btn5))
			btn5.setStyle("-fx-background-color:rgba(250,0,0,0.4);");
		if(event.getSource().equals(btn6))
			btn6.setStyle("-fx-background-color:rgba(250,0,0,0.4);");
		if(event.getSource().equals(btn7))
			btn7.setStyle("-fx-background-color:rgba(250,0,0,0.4);");
		if(event.getSource().equals(btn8))
			btn8.setStyle("-fx-background-color:rgba(250,0,0,0.4);");
		if(event.getSource().equals(btn9))
			btn9.setStyle("-fx-background-color:rgba(250,0,0,0.4);");
			
	}
	
	public void changeNormal(MouseEvent event2)
	{
		
		if(event2.getSource().equals(btn1))
			btn1.setStyle("-fx-background-color:rgba(0,100,255,0.4);");
		if(event2.getSource().equals(btn2))
			btn2.setStyle("-fx-background-color:rgba(10,255,100,0.4);");
		if(event2.getSource().equals(btn3))
			btn3.setStyle("-fx-background-color:rgba(0,100,255,0.4);");
		if(event2.getSource().equals(btn4))
			btn4.setStyle("-fx-background-color:rgba(0,100,255,0.4);");
		if(event2.getSource().equals(btn5))
			btn5.setStyle("-fx-background-color:rgba(10,255,100,0.4);");
		if(event2.getSource().equals(btn6))
			btn6.setStyle("-fx-background-color:rgba(0,100,255,0.4);");
		if(event2.getSource().equals(btn7))
			btn7.setStyle("-fx-background-color:rgba(0,100,255,0.4);");
		if(event2.getSource().equals(btn8))
			btn8.setStyle("-fx-background-color:rgba(10,255,100,0.4);");
		if(event2.getSource().equals(btn9))
			btn9.setStyle("-fx-background-color:rgba(0,100,255,0.4);");
		
	}



	    @FXML
	    private JFXDrawer drawer;
	    
	    @FXML JFXDrawer drawer1;

	    @FXML
	    private JFXHamburger hamburger;
	    
	    @FXML
	    private AnchorPane root;

	    public static AnchorPane rootP;
	    @Override
	    public void initialize(URL url, ResourceBundle rb) {
	        rootP = root;
	        
	        try {
	        	
	           VBox box =  loader.load();
	            drawer.setSidePane(box);	
	        } 
	        catch (IOException ex) {
	            Logger.getLogger(UsrController.class.getName()).log(Level.SEVERE, null, ex);
	        } 
	        
	        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(hamburger);
	        transition.setRate(-1);
	        hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED,(e)->{
	            transition.setRate(transition.getRate()*-1);
	            transition.play();
	     
	            if(drawer.isShown())
	            {
	                drawer.close();
	                drawer1.setVisible(false);
	            }else
	                drawer.open();
	        });
	        
	    }
        public void drawerClose()
        {
        	drawer.close();
        }
        
        public void LearningLicense() throws Exception{
        	Stage primaryStage = new Stage();
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("/LearningLicense/Learning.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			LearningController lc = loader.<LearningController>getController();
			lc.setName(Name);
			primaryStage.setTitle("RTO Management System");
			primaryStage.getIcons().add(new Image("RtoIcon.png"));
			primaryStage.setFullScreen(true);
			primaryStage.setFullScreenExitHint("");
			primaryStage.setScene(scene);
			primaryStage.show();
			closeMain();
        }
        
        public void PermanentLicense() throws Exception{
        	Stage primaryStage = new Stage();
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("/PermanentLicense/Permanent.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			PermanentController pc = loader.<PermanentController>getController();
			pc.name.setText(Name);
			primaryStage.setTitle("RTO Management System");
			primaryStage.getIcons().add(new Image("RtoIcon.png"));
			primaryStage.setFullScreen(true);
			primaryStage.setFullScreenExitHint("");
			primaryStage.setScene(scene);
			primaryStage.show();
			closeMain();
        }
        
        public void AboutUs() throws Exception{
        	Stage primaryStage = new Stage();
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("/AboutUs/AboutUs.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			AboutUsController a = loader.<AboutUsController>getController();
			a.name.setText(Name);
			primaryStage.setTitle("RTO Management System");
			primaryStage.getIcons().add(new Image("RtoIcon.png"));
			primaryStage.setFullScreen(true);
			primaryStage.setFullScreenExitHint("");
			primaryStage.setScene(scene);
			primaryStage.show();
			closeMain();
        }

        public void VehicleRegistration() throws Exception{
        	Stage primaryStage = new Stage();
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("/VehicleRegistration/RegisterVehicle.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			RegisterVehicleController r = loader.<RegisterVehicleController>getController();
			r.name.setText(Name);
			primaryStage.setTitle("RTO Management System");
			primaryStage.getIcons().add(new Image("RtoIcon.png"));
			primaryStage.setFullScreen(true);
			primaryStage.setFullScreenExitHint("");
			primaryStage.setScene(scene);
			primaryStage.show();
			closeMain();
        }
        
        public void TransferVehicle() throws Exception{
        	Stage primaryStage = new Stage();
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("/TansferVehicle/TansferOfVehicle.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			TansferOfVehicleController t = loader.<TansferOfVehicleController>getController();
			t.name.setText(Name);
			t.sellerName.setText(Name);
			primaryStage.setTitle("RTO Management System");
			primaryStage.getIcons().add(new Image("RtoIcon.png"));
			primaryStage.setFullScreen(true);
			primaryStage.setFullScreenExitHint("");
			primaryStage.setScene(scene);
			primaryStage.show();
			closeMain();
        }
        
        public void PractiseExam() throws IOException, SQLException{
			Stage primaryStage = new Stage();
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("/PractiseExam/LearningTest.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			LearningTestController l = loader.<LearningTestController>getController();
			l.startExam(Name);
			primaryStage.setTitle("RTO Management System");
			primaryStage.getIcons().add(new Image("RtoIcon.png"));
			primaryStage.setFullScreen(true);
			primaryStage.setFullScreenExitHint("");
			primaryStage.setScene(scene);
			primaryStage.show();
			closeMain();
        	
        }
        
        public void Rules() throws IOException{
        	Stage primaryStage = new Stage();
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("/Rules/Rules.fxml"));
        	Parent root = loader.load();
        	Scene scene = new Scene(root);
        	RulesController r  = loader.<RulesController>getController();
        	r.name.setText(Name);
        	primaryStage.setFullScreen(true);
        	primaryStage.setFullScreenExitHint("");
        	primaryStage.setScene(scene);
        	primaryStage.setTitle("RTO Management System");
			primaryStage.getIcons().add(new Image("RtoIcon.png"));
			primaryStage.show();
        	closeMain();
        }
        
        public void fares() throws IOException{
        	Stage primaryStage = new Stage();
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("/VehicleFares/Fares.fxml"));
        	Parent root = loader.load();
        	Scene scene = new Scene(root);
        	FaresController f = loader.<FaresController>getController();
        	f.name.setText(Name);
        	primaryStage.setFullScreen(true);
        	primaryStage.setFullScreenExitHint("");
        	primaryStage.setScene(scene);
        	primaryStage.setTitle("RTO Management System");
			primaryStage.getIcons().add(new Image("RtoIcon.png"));
			primaryStage.show();
			closeMain();
        	
        }
        
		private void closeMain() {
			Stage stage = new Stage();
			stage= (Stage) btn1.getScene().getWindow();
			stage.close();
			
			
		}
		
		public void drawerOpen(){
			drawer1.open();
		}
        
		public void faq() throws IOException{
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/FAQ/FAQ.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			FAQController f = loader.<FAQController>getController();
			f.name.setText(Name);
			primaryStage.setTitle("RTO Management System");
			primaryStage.getIcons().add(new Image("RtoIcon.png"));
			primaryStage.setFullScreen(true);
			primaryStage.setFullScreenExitHint("");
			primaryStage.setScene(scene);
			primaryStage.show();
			closeMain();
		}

		public void setMessage(String name) throws IOException, SQLException{
			Name = name;
			conection = SqliteConnection.connector();
			PreparedStatement preparedStatement = conection.prepareStatement("select Accepted,Rejected from Learning where name  = ? AND pass = 0");
			preparedStatement.setString(1, name);
        	ResultSet rs = preparedStatement.executeQuery();
        	
        	while(rs.next()){
        	if(rs.getInt("Accepted") == 1){
        		FXMLLoader loader1 = new FXMLLoader(getClass().getResource("NewMessage.fxml"));
 			   Parent drawerroot = loader1.load();
 	            drawer1.setSidePane(drawerroot);
 	    		SidePanelContentController c = loader.<SidePanelContentController>getController();
 	    		NewMessageController n = loader1.<NewMessageController>getController();
 	    		n.lbl.setText("Your Request Has Been Accepted\nYou Can Start Exam By Clicking Below");
 	    		n.Name = name;
 	    		n.hyperlink.setVisible(true);
 	    		newMessage.setVisible(true);
 	    		c.b2.setOnAction(new EventHandler<ActionEvent>(){
 	    			public void handle(ActionEvent ae){
 	    				if(drawer1.isShown()){
 	    					drawer1.close();
 	    					drawer1.setVisible(false);
 	    				}
 	    				else{
 	    					drawer1.setVisible(true);
 	    					drawer1.open();
 	    					newMessage.setVisible(false);
 	    				}
 	    			}
 	    		});
        		
        	}
        	if(rs.getInt("Rejected") == 1){
        		FXMLLoader loader1 = new FXMLLoader(getClass().getResource("NewMessage.fxml"));
  			   Parent drawerroot = loader1.load();
  	            drawer1.setSidePane(drawerroot);
  	    		SidePanelContentController c = loader.<SidePanelContentController>getController();
  	    		NewMessageController n = loader1.<NewMessageController>getController();
  	    		n.lbl.setText("Your Request Has Been Rejected\nPlease Refill Form Correctly");
  	    		n.Name = name;
  	    		n.hyperlink.setVisible(false);
  	    		newMessage.setVisible(true);
  	    		c.b2.setOnAction(new EventHandler<ActionEvent>(){
  	    			public void handle(ActionEvent ae){
  	    				if(drawer1.isShown()){
  	    					drawer1.close();
  	    					drawer1.setVisible(false);
  	    				}
  	    				else{
  	    					drawer1.setVisible(true);
  	    					drawer1.open();
  	    					newMessage.setVisible(false);
  	    					conection = SqliteConnection.connector();
  	    					try{
  	    					PreparedStatement preparedStatement = conection.prepareStatement("delete from Learning where name  = ?");
  	    					preparedStatement.setString(1, name);
  	    					preparedStatement.executeUpdate();
  	    					}
  	    					catch(Exception e){}
  	    					
  	    				}
  	    			}
  	    		});
         		
        		
        	}
        	}	
        	setMessage1();	
		}
		
		public void setMessage1() throws SQLException, IOException{
			conection = SqliteConnection.connectorP();
			PreparedStatement preparedStatement = conection.prepareStatement("select Accepted,Rejected from Permanent where name  = ? AND Pass = 0");
			preparedStatement.setString(1, Name);
        	ResultSet rs = preparedStatement.executeQuery();
        	
        	while(rs.next()){
        	if(rs.getInt("Accepted") == 1){
        		FXMLLoader loader1 = new FXMLLoader(getClass().getResource("NewMessage.fxml"));
 			   Parent drawerroot = loader1.load();
 	            drawer1.setSidePane(drawerroot);
 	    		SidePanelContentController c = loader.<SidePanelContentController>getController();
 	    		NewMessageController n = loader1.<NewMessageController>getController();
 	    		n.lbl.setText("Your Request Has Been Accepted\nPracticle Exam is on 12.00 PM 25/04/17");
 	    		n.Name = Name;
 	    		n.hyperlink.setVisible(false);
 	    		newMessage.setVisible(true);
 	    		c.b2.setOnAction(new EventHandler<ActionEvent>(){
 	    			public void handle(ActionEvent ae){
 	    				if(drawer1.isShown()){
 	    					drawer1.close();
 	    					drawer1.setVisible(false);
 	    				}
 	    				else{
 	    					drawer1.setVisible(true);
 	    					drawer1.open();
 	    					newMessage.setVisible(false);
 	    				}
 	    			}
 	    		});
        		
        	}
        	if(rs.getInt("Rejected") == 1){
        		FXMLLoader loader1 = new FXMLLoader(getClass().getResource("NewMessage.fxml"));
  			   Parent drawerroot = loader1.load();
  	            drawer1.setSidePane(drawerroot);
  	    		SidePanelContentController c = loader.<SidePanelContentController>getController();
  	    		NewMessageController n = loader1.<NewMessageController>getController();
  	    		n.lbl.setText("Your Request Has Been Rejected\nPlease Refill Form Correctly");
  	    		n.Name = Name;
  	    		n.hyperlink.setVisible(false);
  	    		newMessage.setVisible(true);
  	    		c.b2.setOnAction(new EventHandler<ActionEvent>(){
  	    			public void handle(ActionEvent ae){
  	    				if(drawer1.isShown()){
  	    					drawer1.close();
  	    					drawer1.setVisible(false);
  	    				}
  	    				else{
  	    					drawer1.setVisible(true);
  	    					drawer1.open();
  	    					newMessage.setVisible(false);
  	    					conection = SqliteConnection.connector();
  	    					try{
  	    					PreparedStatement preparedStatement = conection.prepareStatement("delete from Permanent where name  = ?");
  	    					preparedStatement.setString(1, Name);
  	    					preparedStatement.executeUpdate();
  	    					}
  	    					catch(Exception e){}
  	    					
  	    				}
  	    			}
  	    		});
         		
        		
        	}

        	}	
			setMessage2();
		}
		
		public void setMessage2() throws SQLException, IOException{
			conection = SqliteConnection.connectorP();
			PreparedStatement preparedStatement = conection.prepareStatement("select * from Permanent where name  = ? AND LicensePrinted = 0");
			preparedStatement.setString(1, Name);
        	ResultSet rs = preparedStatement.executeQuery();
        	
        	while(rs.next()){
        		if(rs.getInt("Pass") == 1){
            		FXMLLoader loader1 = new FXMLLoader(getClass().getResource("NewMessage.fxml"));
     			   Parent drawerroot = loader1.load();
     	            drawer1.setSidePane(drawerroot);
     	    		SidePanelContentController c = loader.<SidePanelContentController>getController();
     	    		NewMessageController n = loader1.<NewMessageController>getController();
     	    		n.lbl.setText("Your Have Successfully Qualified for License\nPrint License By Clicking Below");
     	    		n.Name = Name;
     	    		n.hyperlink.setVisible(true);
     	    		n.hyperlink.setText("Display");
     	    		newMessage.setVisible(true);
     	    		c.b2.setOnAction(new EventHandler<ActionEvent>(){
     	    			public void handle(ActionEvent ae){
     	    				if(drawer1.isShown()){
     	    					drawer1.close();
     	    					drawer1.setVisible(false);
     	    				}
     	    				else{
     	    					drawer1.setVisible(true);
     	    					drawer1.open();
     	    					newMessage.setVisible(false);
     	    				}
     	    			}
     	    		});
            		
            	}
        	if(rs.getInt("Fail") == 1){
        		FXMLLoader loader1 = new FXMLLoader(getClass().getResource("NewMessage.fxml"));
  			   Parent drawerroot = loader1.load();
  	            drawer1.setSidePane(drawerroot);
  	    		SidePanelContentController c = loader.<SidePanelContentController>getController();
  	    		NewMessageController n = loader1.<NewMessageController>getController();
  	    		n.lbl.setText("You Have Failed in Practical Exam\nPlease Reattempt");
  	    		n.Name = Name;
  	    		n.hyperlink.setVisible(true);
  	    		newMessage.setVisible(false);
  	    		c.b2.setOnAction(new EventHandler<ActionEvent>(){
  	    			public void handle(ActionEvent ae){
  	    				if(drawer1.isShown()){
  	    					drawer1.close();
  	    					drawer1.setVisible(false);
  	    				}
  	    				else{
  	    					drawer1.setVisible(true);
  	    					drawer1.open();
  	    					newMessage.setVisible(false);
  	    					conection = SqliteConnection.connector();
  	    					try{
  	    					PreparedStatement preparedStatement = conection.prepareStatement("delete from Permanent where name  = ?");
  	    					preparedStatement.setString(1, Name);
  	    					preparedStatement.executeUpdate();
  	    		        	preparedStatement.executeQuery();
  	    					}
  	    					catch(Exception e){}
  	    					
  	    				}
  	    			}
  	    		});
         		
        		
        	}
        }
			
		}
        

	}


