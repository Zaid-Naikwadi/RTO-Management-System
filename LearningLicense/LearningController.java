package LearningLicense;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import RequestAccepted.RequestAcceptedController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import mainWindow.UsrController;

public class LearningController implements Initializable{
@FXML Button cancelBtn;
@FXML Label name;
@FXML JFXTextField parent;
@FXML JFXTextArea address;
@FXML JFXTextField place;
@FXML JFXTextField qualification;
@FXML JFXComboBox<String> blood;
ObservableList<String> list = FXCollections.observableArrayList("O+","O-","A+","A-","B+","B-","AB+","AB-");
@FXML JFXTextField phone;
@FXML JFXTextField email;
@FXML Label fullname;
@FXML Label Parentname;
@FXML Button AadharCardBtn;
@FXML Button RationCardBtn;
@FXML Button LCBtn;
@FXML Button PanBtn;
@FXML Button PassportPhotoBtn;
@FXML Button Submit;
@FXML Label warning;
@FXML CheckBox PassportPhotoCheck;
@FXML CheckBox AadharCardCheck;
@FXML CheckBox RationCardCheck;
@FXML CheckBox LCCheck;
@FXML CheckBox PANCheck;
@FXML JFXCheckBox Agree;
public byte[] aadharContent; 
public byte[] rationContent; 
public byte[] LCContent; 
public byte[] PanContent; 
public byte[] PhotoContent;

@FXML ImageView namecross;
@FXML ImageView parentnamecross;
@FXML ImageView datecross;
@FXML ImageView placecross;
@FXML ImageView phonecross;
@FXML ImageView emailcross;
@FXML ImageView photocross;
@FXML ImageView aadharcross;
@FXML ImageView lccross;
@FXML ImageView rationcross;
@FXML ImageView pancross;


@FXML JFXDatePicker date;

String Date = "";
int age = 0;
LocalDate d = LocalDate.now();
LocalDate localdate ;
LearningModel lm = new LearningModel();

File PhotoFile = new File("");
File AadharFile = new File("");
File RationFile = new File("");
File LCFile = new File("");
File PANFile = new File("");

    public void CancelBtn() throws Exception{
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("/mainWindow/Usr.fxml").openStream());
		UsrController usrController = (UsrController)loader.getController();
		usrController.Name = name.getText().trim();
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
    
    public void Submit(ActionEvent ae) throws Exception{
    	try {
    		if((name.getText().trim().equals("")) | (parent.getText().trim().equals("")) | (address.getText().trim().equals(""))| (Date.equals("")) | (place.getText().trim().equals("")) | (qualification.getText().trim().equals("")) | (blood.equals("")) | (phone.getText().trim().equals("")) |(email.getText().trim().equals("")) | ((PassportPhotoCheck.isSelected()) && (PhotoFile.toString().equals(""))) | ((AadharCardCheck.isSelected()) && (AadharFile.toString().equals(""))) | ((RationCardCheck.isSelected()) && (RationFile.toString().equals(""))) | ((LCCheck.isSelected()) && (LCFile.toString().equals("")))| ((PANCheck.isSelected()) && (PANFile.toString().equals(""))) ){
    			warning.setText("Please Fill All The Details");
    			warning.setVisible(true);
    			namecross.setVisible(false);
    			parentnamecross.setVisible(false);
    			datecross.setVisible(false);
    			placecross.setVisible(false);
    			phonecross.setVisible(false);
    			emailcross.setVisible(false);
    			photocross.setVisible(false);
    			aadharcross.setVisible(false);
    			lccross.setVisible(false);
    			rationcross.setVisible(false);
    			pancross.setVisible(false);
    			System.out.println("Condition 1");
    		}
    		
    		else if(!name.getText().trim().matches("[ A-Za-z_]+")){
    			warning.setText("Name must be in Characters");
    			warning.setVisible(true);
    			namecross.setVisible(true);
    			parentnamecross.setVisible(false);
    			datecross.setVisible(false);
    			placecross.setVisible(false);
    			phonecross.setVisible(false);
    			emailcross.setVisible(false);
    			photocross.setVisible(false);
    			aadharcross.setVisible(false);
    			lccross.setVisible(false);
    			rationcross.setVisible(false);
    			pancross.setVisible(false);
    			System.out.println("condition 2");
    		}
    		
    		else if(!parent.getText().trim().matches("[ A-Za-z_]+")){
    			warning.setText("Parent Name must be in Characters");
    			warning.setVisible(true);
    			namecross.setVisible(false);
    			parentnamecross.setVisible(true);
    			datecross.setVisible(false);
    			placecross.setVisible(false);
    			phonecross.setVisible(false);
    			emailcross.setVisible(false);
    			photocross.setVisible(false);
    			aadharcross.setVisible(false);
    			lccross.setVisible(false);
    			rationcross.setVisible(false);
    			pancross.setVisible(false);
    			System.out.println("condition 3");
    		}
    		
    		else if(age <= 14){		
    			warning.setText("Date is Invalid");
    			warning.setVisible(true);
    			datecross.setVisible(true);
    			namecross.setVisible(false);
    			parentnamecross.setVisible(false);
    			placecross.setVisible(false);
    			phonecross.setVisible(false);
    			emailcross.setVisible(false);
    			photocross.setVisible(false);
    			aadharcross.setVisible(false);
    			lccross.setVisible(false);
    			rationcross.setVisible(false);
    			pancross.setVisible(false);
    			System.out.println("condition 4");
    		}
    		
    		else if(!place.getText().trim().matches("[ A-Za-z_]+")){
    			warning.setText("Place must be in Characters");
    			warning.setVisible(true);
    			namecross.setVisible(false);
    			parentnamecross.setVisible(false);
    			datecross.setVisible(false);
    			placecross.setVisible(true);
    			phonecross.setVisible(false);
    			emailcross.setVisible(false);
    			photocross.setVisible(false);
    			aadharcross.setVisible(false);
    			lccross.setVisible(false);
    			rationcross.setVisible(false);
    			pancross.setVisible(false);
    			System.out.println("condition 5");
    		}
    		
    		else if(!phone.getText().trim().matches("^[0-9]*$")){
    			warning.setText("Phone no must be in Digits");
    			warning.setVisible(true);
    			namecross.setVisible(false);
    			parentnamecross.setVisible(false);
    			datecross.setVisible(false);
    			placecross.setVisible(false);
    			phonecross.setVisible(true);
    			emailcross.setVisible(false);
    			photocross.setVisible(false);
    			aadharcross.setVisible(false);
    			lccross.setVisible(false);
    			rationcross.setVisible(false);
    			pancross.setVisible(false);
    			System.out.println("condition 6");
    		}
    		
    		else if(!phone.getText().trim().matches("^[0-9]{10}$")){
    			warning.setText("Phone no must be atleast 10 Digits long");
    			warning.setVisible(true);
    			namecross.setVisible(false);
    			parentnamecross.setVisible(false);
    			datecross.setVisible(false);
    			placecross.setVisible(false);
    			phonecross.setVisible(true);
    			emailcross.setVisible(false);
    			photocross.setVisible(false);
    			aadharcross.setVisible(false);
    			lccross.setVisible(false);
    			rationcross.setVisible(false);
    			pancross.setVisible(false);
    			System.out.println("condition 7");
    		}
    		
    		else if(!email.getText().trim().matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$")){
    			warning.setText("Email ID is not Valid");
    			warning.setVisible(true);
    			namecross.setVisible(false);
    			parentnamecross.setVisible(false);
    			datecross.setVisible(false);
    			placecross.setVisible(false);
    			phonecross.setVisible(false);
    			emailcross.setVisible(true);
    			photocross.setVisible(false);
    			aadharcross.setVisible(false);
    			lccross.setVisible(false);
    			rationcross.setVisible(false);
    			pancross.setVisible(false);
    			System.out.println("condition 8");
    		}
    		
    		else if(!PassportPhotoCheck.isSelected()){
    			warning.setText("Please Fill All The Details");
    			warning.setVisible(true);
    			photocross.setVisible(true);
    			namecross.setVisible(false);
    			parentnamecross.setVisible(false);
    			datecross.setVisible(false);
    			placecross.setVisible(false);
    			phonecross.setVisible(false);
    			emailcross.setVisible(false);
    			aadharcross.setVisible(false);
    			lccross.setVisible(false);
    			rationcross.setVisible(false);
    			pancross.setVisible(false);
    		}
    		
    		else if(!AadharCardCheck.isSelected()){
    			warning.setText("Please Fill All The Details");
    			warning.setVisible(true);
    			aadharcross.setVisible(true);
    			photocross.setVisible(false);
    			namecross.setVisible(false);
    			parentnamecross.setVisible(false);
    			datecross.setVisible(false);
    			placecross.setVisible(false);
    			phonecross.setVisible(false);
    			emailcross.setVisible(false);
    			photocross.setVisible(false);
    			lccross.setVisible(false);
    			rationcross.setVisible(false);
    			pancross.setVisible(false);
    		}
    		
    		else if(!LCCheck.isSelected()){
       			warning.setText("Please Fill All The Details");
    			warning.setVisible(true);
    			lccross.setVisible(true);
    			aadharcross.setVisible(false);
    			photocross.setVisible(false);
    			namecross.setVisible(false);
    			parentnamecross.setVisible(false);
    			datecross.setVisible(false);
    			placecross.setVisible(false);
    			phonecross.setVisible(false);
    			emailcross.setVisible(false);
    			rationcross.setVisible(false);
    			pancross.setVisible(false);
    		}
    		
    		else if(!RationCardCheck.isSelected() && !PANCheck.isSelected()){
    			warning.setText("Please Fill All The Details");
    			warning.setVisible(true);
    			rationcross.setVisible(true);
    			lccross.setVisible(false);
    			aadharcross.setVisible(false);
    			photocross.setVisible(false);
    			namecross.setVisible(false);
    			parentnamecross.setVisible(false);
    			datecross.setVisible(false);
    			placecross.setVisible(false);
    			phonecross.setVisible(false);
    			emailcross.setVisible(false);
    			pancross.setVisible(false);
    		}
    		else if(!PANCheck.isSelected() && !RationCardCheck.isSelected()){
    			warning.setText("Please Fill All The Details");
    			warning.setVisible(true);
    			pancross.setVisible(true);
    			rationcross.setVisible(false);
    			lccross.setVisible(false);
    			aadharcross.setVisible(false);
    			photocross.setVisible(false);
    			namecross.setVisible(false);
    			parentnamecross.setVisible(false);
    			datecross.setVisible(false);
    			placecross.setVisible(false);
    			phonecross.setVisible(false);
    			emailcross.setVisible(false);
    		}

    		else{
    			if(!RationFile.toString().equals("") && PANFile.toString().equals("")){
    				lm.submit(name.getText().trim(),parent.getText().trim(),address.getText().trim(),Date,place.getText().trim(),qualification.getText().trim(),blood.getValue().trim(),Long.parseLong(phone.getText().trim()),email.getText().trim(),aadharContent,rationContent,LCContent,PhotoContent);
    				Stage primaryStage = new Stage();
    				FXMLLoader loader = new FXMLLoader(getClass().getResource("/RequestAccepted/RequestAccepted.fxml"));
    				Parent root = loader.load();
    				RequestAcceptedController r = loader.<RequestAcceptedController>getController();
    				r.Name = name.getText().trim();
    				Scene scene = new Scene(root);
    				primaryStage.setFullScreen(true);
    				primaryStage.setFullScreenExitHint("");
    				primaryStage.getIcons().add(new Image("RtoIcon.png"));
    				primaryStage.setScene(scene);
    				primaryStage.show();
    				closeForm();
    			}
    			
    		else if(!PANFile.toString().equals("") && RationFile.toString().equals("")){
    				lm.submit1(name.getText().trim(),parent.getText().trim(),address.getText().trim(),Date,place.getText().trim(),qualification.getText().trim(),blood.getValue().trim(),Long.parseLong(phone.getText().trim()),email.getText().trim(),aadharContent,PanContent,LCContent,PhotoContent);
    				Stage primaryStage = new Stage();
    				FXMLLoader loader = new FXMLLoader(getClass().getResource("/RequestAccepted/RequestAccepted.fxml"));
    				Parent root = loader.load();
    				RequestAcceptedController r = loader.<RequestAcceptedController>getController();
    				r.Name = name.getText().trim();
    				Scene scene = new Scene(root);
    				primaryStage.setFullScreen(true);
    				primaryStage.setFullScreenExitHint("");
    				primaryStage.getIcons().add(new Image("RtoIcon.png"));
    				primaryStage.setScene(scene);
    				primaryStage.show();
    				closeForm();
    			}
    	 }		
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    }
	private void closeForm() {
		Stage stage = new Stage();
		stage= (Stage) cancelBtn.getScene().getWindow();
		stage.close();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Image image = new Image(getClass().getResourceAsStream("/LearningLicense/Attach.png"));
		AadharCardBtn.setGraphic(new ImageView(image));
		PassportPhotoBtn.setGraphic(new ImageView(image));
		RationCardBtn.setGraphic(new ImageView(image));
		LCBtn.setGraphic(new ImageView(image));
		PanBtn.setGraphic(new ImageView(image));
		blood.setItems(list);
	}	

	public void parentTyped(){
		Parentname.setText(parent.getText());
	}
	public void PhotoSelected(){
		if(PassportPhotoCheck.isSelected()){
			PassportPhotoBtn.setVisible(true);
			photocross.setVisible(false);
		}
		if(!PassportPhotoCheck.isSelected())
				PassportPhotoBtn.setVisible(false);	
	   }
	
	
	public void AadharSelected(ActionEvent ae){
		if(AadharCardCheck.isSelected()){
			AadharCardBtn.setVisible(true);
			aadharcross.setVisible(false);
		}	
		if(!AadharCardCheck.isSelected())
				AadharCardBtn.setVisible(false);	
	}
	
	public void RationSelected(ActionEvent ae){
		if(RationCardCheck.isSelected()){
			RationCardBtn.setVisible(true);
		    PANCheck.setSelected(false);
		    PanBtn.setVisible(false);
		    rationcross.setVisible(false);
		} 
		if(!RationCardCheck.isSelected())
			RationCardBtn.setVisible(false);	
	}
	
	public void LCSelected(ActionEvent ae){
		if(LCCheck.isSelected()){
			LCBtn.setVisible(true);
			lccross.setVisible(false);
		}	
			if(!LCCheck.isSelected())
				LCBtn.setVisible(false);
		
	}
	
	public void PanSelected(ActionEvent ae){
		if(PANCheck.isSelected()){
			PanBtn.setVisible(true);
		    RationCardBtn.setVisible(false);
		    RationCardCheck.setSelected(false);
		    pancross.setVisible(false);
		} 
		if(!PANCheck.isSelected())
			PanBtn.setVisible(false);
	}
	public void PhotoAttached() throws IOException{
		Stage stage = new Stage();
		stage= (Stage) cancelBtn.getScene().getWindow();
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		configureFileChooser(fileChooser);
		PhotoFile = fileChooser.showOpenDialog(stage);
		PhotoContent = Files.readAllBytes(PhotoFile.toPath());
	}
	
	public void AadharAttached() throws IOException{
		Stage stage = new Stage();
		stage= (Stage) cancelBtn.getScene().getWindow();
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		configureFileChooser(fileChooser);
		AadharFile = fileChooser.showOpenDialog(stage);
		aadharContent = Files.readAllBytes(AadharFile.toPath());
	}		
	
	public void RationAttached() throws IOException{
		Stage stage = new Stage();
		stage= (Stage) cancelBtn.getScene().getWindow();
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		configureFileChooser(fileChooser);
		RationFile = fileChooser.showOpenDialog(stage);
		rationContent = Files.readAllBytes(RationFile.toPath());
	}	
	
	public void LCAttached() throws IOException{
		Stage stage = new Stage();
		stage= (Stage) cancelBtn.getScene().getWindow();
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		configureFileChooser(fileChooser);
		LCFile = fileChooser.showOpenDialog(stage);
		LCContent = Files.readAllBytes(LCFile.toPath());
	}
	public void PanAttached() throws IOException{
		Stage stage = new Stage();
		stage= (Stage) cancelBtn.getScene().getWindow();
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		configureFileChooser(fileChooser);
		PANFile = fileChooser.showOpenDialog(stage);
		PanContent = Files.readAllBytes(PANFile.toPath());
	}
	
	public void Agreed(){
		if(Agree.isSelected())
			Submit.setDisable(false);
		if(!Agree.isSelected())
			Submit.setDisable(true);
	}
	  private static void configureFileChooser(
		        final FileChooser fileChooser) {      
		            fileChooser.setTitle("View Pictures");
		            fileChooser.setInitialDirectory(
		                new File(System.getProperty("user.home"))
		            );                 
		            fileChooser.getExtensionFilters().addAll(
		                new FileChooser.ExtensionFilter("All Images", "*.*"),
		                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
		                new FileChooser.ExtensionFilter("PNG", "*.png"),
		                new FileChooser.ExtensionFilter("JPEG", "*.jpeg")
		            );
		    }
	  
	  public void date(){
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			localdate = date.getValue();
			age  = d.getYear() - localdate.getYear();
			Date = dtf.format(localdate);
			System.out.println(Date);
			System.out.println(age);
		}
	  
	  public void setName(String Name){
		  name.setText(Name);
		  fullname.setText(Name);
	  }

	    }

