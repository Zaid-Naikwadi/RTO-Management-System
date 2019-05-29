package adminMainWindow;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
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

	    @FXML
	    private JFXHamburger hamburger;
	    
	    @FXML
	    private AnchorPane root;

	    public static AnchorPane rootP;
	    @Override
	    public void initialize(URL url, ResourceBundle rb) {
	        rootP = root;
	        
	        try {
	        	VBox box = FXMLLoader.load(getClass().getResource("SidePanelContent.fxml"));
	            drawer.setSidePane(box);
	        } catch (IOException ex) {
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
			Parent root = FXMLLoader.load(getClass().getResource("/adminLearningLicense/Learning.fxml"));
			Scene scene = new Scene(root);
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
			Parent root = FXMLLoader.load(getClass().getResource("/adminPermanentLicense/Permanent.fxml"));
			Scene scene = new Scene(root);
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
			Parent root = FXMLLoader.load(getClass().getResource("/adminAboutUs/AboutUs.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("RTO Management System");
			primaryStage.getIcons().add(new Image("RtoIcon.png"));
			primaryStage.setFullScreen(true);
			primaryStage.setFullScreenExitHint("");
			primaryStage.setScene(scene);
			primaryStage.show();
			closeMain();
        }

		private void closeMain() {
			Stage stage = new Stage();
			stage= (Stage) btn1.getScene().getWindow();
			stage.close();	
		}
        
		public void faq() throws IOException{
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/adminFAQ/FAQ.fxml"));
			Scene scene = new Scene(root);
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
	        	FXMLLoader loader = new FXMLLoader(getClass().getResource("/adminRules/Rules.fxml"));
	        	Parent root = loader.load();
	        	Scene scene = new Scene(root);
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
	        	FXMLLoader loader = new FXMLLoader(getClass().getResource("/adminVehicleFares/Fares.fxml"));
	        	Parent root = loader.load();
	        	Scene scene = new Scene(root);
	        	primaryStage.setFullScreen(true);
	        	primaryStage.setFullScreenExitHint("");
	        	primaryStage.setScene(scene);
	        	primaryStage.setTitle("RTO Management System");
				primaryStage.getIcons().add(new Image("RtoIcon.png"));
				primaryStage.show();
				closeMain();
	        	
	        }

	}


