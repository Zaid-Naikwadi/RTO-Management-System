package PractiseExam;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Random;
import com.jfoenix.controls.JFXRadioButton;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import mainWindow.UsrController;

public class LearningTestController{
	@FXML Label name;
	@FXML Label que;
	@FXML Label queNo;
	@FXML JFXRadioButton A;
	@FXML JFXRadioButton B;
	@FXML JFXRadioButton C;
	@FXML JFXRadioButton D;
	@FXML Button nextQue;
	@FXML Button cancelBtn;
	@FXML ImageView imgview;
	
	ToggleGroup group = new ToggleGroup();
	int queno = 0;
	int points = 0;
	boolean bool1;
	boolean bool2;
	boolean bool3;
	boolean bool4;
	
	int arrived1 =0;
	int arrived2 =0;
	int arrived3 =0;
	int arrived4 =0;
	int arrived5 =0;
	int arrived6 =0;
	int arrived7 =0;
	int arrived8 =0;
	int arrived9 =0;
	int arrived10 =0;
	int arrived11 =0;
	int arrived12 =0;
	int arrived13 =0;
	int arrived14 =0;
	int arrived15 =0;
	int arrived16 = 0;
	
	int id =0;
	
	public void startExam(String name1) throws IOException, SQLException{
		name.setText(name1);
		A.setToggleGroup(group);
		B.setToggleGroup(group);
		C.setToggleGroup(group);
		D.setToggleGroup(group);
		setQue();
	}
	
	public void setQue() throws IOException, SQLException{
		Random r = new Random();
		bool1 = r.nextBoolean();
		bool2 = r.nextBoolean();
		bool3 = r.nextBoolean();
		bool4 = r.nextBoolean();
		
		A.setSelected(false);
		B.setSelected(false);
		C.setSelected(false);
		D.setSelected(false);

		Image image;
		
		if(queno == 15){
			Stage stage = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/PractiseExam/Result.fxml"));
			stage.setScene(new Scene(
					(Parent) loader.load()
					)
				);
			ResultController rc = loader.<ResultController>getController();
			if(points >= 9){
				rc.lbl.setText("Congratulation!, You Have Passed Examination.Your Score "+points);
				rc.name.setText(name.getText());
			}
			else{
				rc.lbl.setText("Oops!, You Have Failed To Pass Examination.Please Reattempt.");
				rc.name.setText(name.getText());
			}
			stage.setTitle("RTO Management System");
			stage.setFullScreen(true);
			stage.setFullScreenExitHint("");
			stage.getIcons().add(new Image("RtoIcon.png"));
			stage.show();
			closeForm();
		}
		else{
			
		if(bool1 == false && bool2 == false && bool3 == false && bool4 == false){
			if(arrived1 == 0){
			queno++;
			queNo.setText(""+queno);
			que.setText("On a road designated as one way");
			imgview.setVisible(false);
			A.setText("Parking is prohibited");
			B.setText("Overtaking is prohibited");
			C.setText("Should not drive in reverse gear");
			D.setText("Driving is not allowed");
			arrived1 = 1;
			id = 1;
		}
			else{
				setQue();
			}
	}		
		else if(bool1 == false && bool2 == false && bool3 == false && bool4 == true){
			if(arrived2 == 0){
			queno++;
			queNo.setText(""+queno);
			URL url = Main.class.getResource("/LearningTest/stop.jpg");
			image = new Image(url.toString());
			imgview.setImage(image);
			imgview.setVisible(true);
			que.setText("The following sign represents");
			A.setText("Stop");
			B.setText("No Parking");
			C.setText("Hospital ahead");
			D.setText("School ahead");
			arrived2 = 1;
			id = 2;	
		}
			else{
				setQue();
			}
	}
		
		else if(bool1 == false && bool2 == false && bool3 == true && bool4 == false){
			if(arrived3 == 0){
			queno++;
			queNo.setText(""+queno);
			URL url = Main.class.getResource("/LearningTest/turnleft.jpg");
			image = new Image(url.toString());
			imgview.setImage(image);
			imgview.setVisible(true);
			que.setText("Following sign represents..");
			A.setText("Keep Left");
			B.setText("There is no Left");
			C.setText("Compulsory Left Turn");
			D.setText("Look Left");
			arrived3 = 1;
			id = 3;
		}
			else{
				setQue();
			}
	}
		
		else if(bool1 == false && bool2 == false && bool3 == true && bool4 == true){
			if(arrived4 == 0){
			queno++;
			queNo.setText(""+queno);
			que.setText("Free passage should be given to the following types of vehicles");
			imgview.setVisible(false);
			A.setText("Police Vehicle");
			B.setText("Ambulance and Fire Services");
			C.setText("Express Buses");
			D.setText("Fast Vehicles");
			arrived4 = 1;
			id = 4;
			}
			else{
				setQue();
			}
		}
		
		else if(bool1 == false && bool2 == true && bool3 == false && bool4 == false){
			if(arrived5 == 0){
			queno++;
			queNo.setText(""+queno);
			que.setText("Vehicles proceeding from opposite direction should be allowed to pass through...");
			imgview.setVisible(false);
			A.setText("Convinient Side");
			B.setText("Left Side");
			C.setText("Not Allow to Pass");
			D.setText("Your Right Side");
			arrived5 = 1;
			id = 5;
			}
			else{
				setQue();
			}
		}
		
		else if(bool1 == false && bool2 == true && bool3 == false && bool4 == true){
			if(arrived6 == 0){
			queno++;
			queNo.setText(""+queno);
			URL url = Main.class.getResource("/LearningTest/bridge.png");
			image = new Image(url.toString());
			imgview.setImage(image);
			imgview.setVisible(true);
			que.setText("Following sign represents..");
			A.setText("Roads on both sides");
			B.setText("Narrow Bridge Ahead");
			C.setText("Narrow Road Ahead");
			D.setText("No Road Ahead");
			arrived6 = 1;
			id = 6;
			}
			else{
				setQue();
			}
		}
		
		else if(bool1 == false && bool2 == true && bool3 == true && bool4 == false){
			if(arrived7 == 0){
			queno++;
			queNo.setText(""+queno);
			URL url = Main.class.getResource("/LearningTest/horn.png");
			image = new Image(url.toString());
			imgview.setImage(image);
			imgview.setVisible(true);
			que.setText("Following sign represents..");
			A.setText("Horn Prohibited");
			B.setText("Compulsory Sound Horn");
			C.setText("May Sound Horn");
			D.setText("As My Wish");
			arrived7 = 1;
			id = 7;
			}
			else{
				setQue();
			}
		}
		
		else if(bool1 == false && bool2 == true && bool3 == true && bool4 == true){
			if(arrived8 == 0){
			queno++;
			queNo.setText(""+queno);
			que.setText("Driver of Vehicle should Drive through");
			imgview.setVisible(false);
			A.setText("Convinient Side");
			B.setText("Left Side");
			C.setText("Center Of Road");
			D.setText("Right Side");
			arrived8 = 1;
			id = 8;
			}
			else{
				setQue();
			}
		}
		
		else if(bool1 == true && bool2 == false && bool3 == false && bool4 == false){
			if(arrived9 == 0){
			queno++;
			queNo.setText(""+queno);
			que.setText("When a Vehicle is parked on the road side during night");
			imgview.setVisible(false);
			A.setText("Vehicle should be Robbed");
			B.setText("Vehicle should be locked");
			C.setText("The driver should be in Vehicle");
			D.setText("The parking light shall remain Lit");
			arrived9 = 1;
			id = 9;
			}
			else{
				setQue();
			}
		}
		
		else if(bool1 == true && bool2 == false && bool3 == false && bool4 == true){
			if(arrived10 == 0){
			queno++;
			queNo.setText(""+queNo);
			URL url = Main.class.getResource("/LearningTest/end.jpg");
			image = new Image(url.toString());
			imgview.setImage(image);
			imgview.setVisible(true);
			que.setText("Following sign represents..");
			A.setText("Road Closed");
			B.setText("No Parking");
			C.setText("End Of Ristriction");
			D.setText("Not Allowed");
			arrived10 = 1;
			id = 10;
			}
			else{
				setQue();
			}
		}
		
		else if(bool1 == true && bool2 == false && bool3 == true && bool4 == false){
			if(arrived11 == 0){
			queno++;
			queNo.setText(""+queno);
			URL url = Main.class.getResource("/LearningTest/overtaking.jpg");
			image = new Image(url.toString());
			imgview.setImage(image);
			imgview.setVisible(true);
			que.setText("Following sign represents..");
			A.setText("Entry Right Side Prohibited");
			B.setText("Entry Left Side Prohibited");
			C.setText("Overtaking Prohibited");
			D.setText("Racing Prohibited");
			arrived11  =1;
			id = 11;
			}
			else{
				setQue();
			}
		}
		
		else if(bool1 == true && bool2 == false && bool3 == true && bool4 == true){
			if(arrived12 == 0){
			queno++;
			queNo.setText(""+queno);
			que.setText("Zebra Lines Means");
			imgview.setVisible(false);
			A.setText("Stopping Vehicles");
			B.setText("Predestrians Crossing");
			C.setText("Let Animals Cross First");
			D.setText("Give Preference to Vehicle");
			arrived12 = 1;
			id = 12;
			}
			else{
				setQue();
			}
		}
		
		else if(bool1 == true && bool2 == true && bool3 == false && bool4 == false){
			if(arrived13 == 0){
			queno++;
			queNo.setText(""+queno);
			que.setText("Red Traffic Light Indicated");
			imgview.setVisible(false);
			A.setText("Stop The Vehicle");
			B.setText("Proceed With Caution");
			C.setText("Drive Fast");
			D.setText("Slow Down");
			arrived13 = 1;
			id = 13;
			}
			else{
				setQue();
			}
		}
		
		else if(bool1 == true && bool2 == true && bool3 == false && bool4 == true){
			if(arrived14 == 0){
			queno++;
			queNo.setText(""+queno);
			que.setText("Drink And Drive");
			imgview.setVisible(false);
			A.setText("Allowed In Private Vehicles");
			B.setText("Allowed In Public Vehicles");
			C.setText("Allowed During Night Time");
			D.setText("Prohibited In All Vehicles");
			arrived14 = 1;
			id = 14;
			}
			else{
				setQue();
			}
		}
		
		else if(bool1 == true && bool2 == true && bool3 == true && bool4 == false){
			if(arrived15 == 0){
			queno++;
			queNo.setText(""+queno);
			URL url = Main.class.getResource("/LearningTest/noentry.jpeg");
			image = new Image(url.toString());
			imgview.setImage(image);
			imgview.setVisible(true);
			que.setText("Following sign represents..");
			A.setText("Ristriction Ends");
			B.setText("No Entry");
			C.setText("No Overtaking");
			D.setText("No Crossing");
			arrived15 = 1;
			id = 15;
			}
			else{
				setQue();
			}
		}
		
		else if(bool1 == true && bool2 == true && bool3 == true && bool4 == true){
			if(arrived16 == 0){
			queno++;
			queNo.setText(""+queno);
			URL url = Main.class.getResource("/LearningTest/50.jpg");
			image = new Image(url.toString());
			imgview.setImage(image);
			imgview.setVisible(true);
			que.setText("Following sign represents..");
			A.setText("Do not exceed 50km/hr");
			B.setText("Exceed 50km/hr");
			C.setText("Do not exceed 50km/m");
			D.setText("Drive At 50km/m");
			arrived16 = 1;
			id = 16;
			}
			else{
				setQue();
			}
		}
		
		if(queno == 15){
			nextQue.setText("End Exam");
		}
	}	
		
	}
	
	public void Cselected(){
		if(id == 1 | id == 3 | id == 10 | id == 11){
			points++;
		}
	}
	
	public void Aselected(){
		if(id == 2 | id == 7 | id == 13 | id == 16){
			points++;
		}
	}
	
	public void Bselected(){
		if(id == 4 | id == 6 | id == 8 | id == 12 | id == 15){
			points++;
		}
	}
	
	public void Dselected(){
		if(id == 5 | id == 9 | id == 14){
			points++;
		}
	}

	 public void CancelBtn() throws Exception{
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root = loader.load(getClass().getResource("/mainWindow/Usr.fxml").openStream());
			UsrController usrController = (UsrController)loader.getController();
			usrController.Name = name.getText();
			Scene scene = new Scene(root);		
			scene.getStylesheets().add(getClass().getResource("/mainWindow/mainWindow.css").toExternalForm());
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
	
	
	

}
