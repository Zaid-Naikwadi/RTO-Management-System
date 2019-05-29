package TansferVehicle;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import VehicleRegistered.CertificateOfRegistrationController;
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

public class TansferOfVehicleController implements Initializable{
	@FXML public Label name;
	@FXML JFXTextField name1;
	@FXML JFXTextArea address;
	@FXML JFXTextArea address1;
	@FXML JFXDatePicker date;
	@FXML JFXTextField registrationNo;
	@FXML JFXTextField phone;
	@FXML JFXTextField email;
	@FXML CheckBox AadharCardCheck;
	@FXML CheckBox proofCheck;
	@FXML public Label sellerName;
	@FXML Label purchaserName;
	@FXML Label warning;
	@FXML Button cancelBtn;
	@FXML Button Submit;
	@FXML JFXCheckBox Agree;
	@FXML Button proofBtn;
	@FXML Button AadharCardBtn;
	
	
	public byte[] aadharContent;
	public byte[] proofContent; 

	@FXML ImageView namecross;
	@FXML ImageView name1cross;
	@FXML ImageView datecross;
	@FXML ImageView registrationcross;
	@FXML ImageView aadharcross;
	@FXML ImageView proofcross;
	@FXML ImageView phonecross;
	@FXML ImageView emailcross;
	
	File AadharFile = new File("");
	File ProofFile = new File("");
	
	String Date = "";
	int age = 0;
	LocalDate d = LocalDate.now();
	LocalDate localdate ;
	
	boolean r;
	
	TransferOfVehicleModel tvm = new TransferOfVehicleModel();
	
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
	  
	  public void Submit(ActionEvent ae) throws Exception{
	    	
	    		  if((name.getText().trim().equals("")) |(name1.getText().trim().equals("")) | (address.getText().trim().equals("")) | (address1.getText().trim().equals("")) | (Date.equals("")) | (registrationNo.getText().trim().equals("")) | (phone.getText().trim().equals("")) |(email.getText().trim().equals("")) | ((AadharCardCheck.isSelected()) && (AadharFile.toString().equals(""))) | ((proofCheck.isSelected()) && (ProofFile.toString().equals(""))) ){
	    			warning.setText("Please Fill All The Details");
	    			warning.setVisible(true);
	    			namecross.setVisible(false);
	    			datecross.setVisible(false);
	    			registrationcross.setVisible(false);
	    			name1cross.setVisible(false);
	    			aadharcross.setVisible(false);
	    			proofcross.setVisible(false);
	    			phonecross.setVisible(false);
	    			emailcross.setVisible(false);
	    			System.out.println("Condition 1");
	    		}
	    		
	    		else if(!name.getText().trim().matches("[ A-Za-z_]+")){
	    			warning.setText("Name must be in Characters");
	    			warning.setVisible(true);
	    			namecross.setVisible(true);
	    			datecross.setVisible(false);
	    			registrationcross.setVisible(false);
	    			name1cross.setVisible(false);
	    			aadharcross.setVisible(false);
	    			proofcross.setVisible(false);
	    			phonecross.setVisible(false);
	    			emailcross.setVisible(false);
	    			System.out.println("condition 2");
	    		}
	    		  
	    		else if(!name1.getText().trim().matches("[ A-Za-z_]+")){
	    			warning.setText("Name must be in Characters");
	    			warning.setVisible(true);
	    			namecross.setVisible(false);
	    			datecross.setVisible(false);
	    			registrationcross.setVisible(false);
	    			name1cross.setVisible(true);
	    			aadharcross.setVisible(false);
	    			proofcross.setVisible(false);
	    			phonecross.setVisible(false);
	    			emailcross.setVisible(false);
	    			System.out.println("condition 3");
	    		}
	    		  
	    		else if(!registrationNo.getText().trim().matches("^[0-9]*$")){
	    			warning.setText("Registration No must be in Digits");
	    			warning.setVisible(true);
	    			namecross.setVisible(false);
	    			datecross.setVisible(false);
	    			registrationcross.setVisible(true);
	    			aadharcross.setVisible(false);
	    			proofcross.setVisible(false);
	    			name1cross.setVisible(false);
	    			phonecross.setVisible(false);
	    			emailcross.setVisible(false);
	    			System.out.println("condition 5");
	    		}
	    		  
	    		else if(age <= 14){		
	    			warning.setText("Date is Invalid");
	    			warning.setVisible(true);
	    			datecross.setVisible(true);
	    			namecross.setVisible(false);
	    			registrationcross.setVisible(false);
	    			aadharcross.setVisible(false);
	    			proofcross.setVisible(false);
	    			name1cross.setVisible(false);
	    			phonecross.setVisible(false);
	    			emailcross.setVisible(false);
	    			System.out.println("condition 4");
	    		}
	    		  
	    		else if(!phone.getText().trim().matches("^[0-9]*$")){
	    			warning.setText("Phone no must be in Digits");
	    			warning.setVisible(true);
	    			phonecross.setVisible(true);
	    			datecross.setVisible(false);
	    			namecross.setVisible(false);
	    			registrationcross.setVisible(false);
	    			aadharcross.setVisible(false);
	    			proofcross.setVisible(false);
	    			name1cross.setVisible(false);
	    			emailcross.setVisible(false);	    
	    			System.out.println("condition 5");
	    		}
	    		  
	    		else if(!phone.getText().trim().matches("^[0-9]{10}$")){
	    			warning.setText("Phone no must be atleast 10 Digits long");
	    			warning.setVisible(true);
	    			phonecross.setVisible(true);
	    			datecross.setVisible(false);
	    			namecross.setVisible(false);
	    			registrationcross.setVisible(false);
	    			aadharcross.setVisible(false);
	    			proofcross.setVisible(false);
	    			name1cross.setVisible(false);
	    			emailcross.setVisible(false);	  
	    			System.out.println("condition 6");
	    		}
	    		  
	    		else if(!email.getText().trim().matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$")){
	    			warning.setText("Email ID is not Valid");
	    			warning.setVisible(true);
	    			emailcross.setVisible(true);	
	    			phonecross.setVisible(false);
	    			datecross.setVisible(false);
	    			namecross.setVisible(false);
	    			registrationcross.setVisible(false);
	    			aadharcross.setVisible(false);
	    			proofcross.setVisible(false);
	    			name1cross.setVisible(false); 
	    			System.out.println("condition 8");
	    		}
	    		  
	    		
	    		else if(!AadharCardCheck.isSelected()){
	    			warning.setText("Please Fill All The Details");
	    			warning.setVisible(true);
	    			aadharcross.setVisible(true);
	    			namecross.setVisible(false);
	    			datecross.setVisible(false);
	    			registrationcross.setVisible(false);
	    			proofcross.setVisible(false);
	    			name1cross.setVisible(false);
	    			phonecross.setVisible(false);
	    			emailcross.setVisible(false);
	    		}
	    		
	    		else if(!proofCheck.isSelected()){
	       			warning.setText("Please Fill All The Details");
	    			warning.setVisible(true);
	    			proofcross.setVisible(true);
	    			aadharcross.setVisible(false);
	    			namecross.setVisible(false);
	    			datecross.setVisible(false);
	    			registrationcross.setVisible(false);
	    			name1cross.setVisible(false);
	    			phonecross.setVisible(false);
	    			emailcross.setVisible(false);
	    		}
	    		  
	    		else{
	    			r =	tvm.submit(name.getText().trim(),address.getText().trim(),name1.getText().trim(),address1.getText().trim(),Date,Long.parseLong(phone.getText().trim()),email.getText().trim(),Integer.parseInt(registrationNo.getText().trim()),aadharContent,proofContent);
	    			if(r){
	    				FXMLLoader loader = new FXMLLoader(getClass().getResource("/VehicleRegistered/CertificateOfRegistration.fxml"));
	    				Stage primaryStage = new Stage();
	    				Parent root = loader.load();
	    				Scene scene = new Scene(root);
	    				CertificateOfRegistrationController c =loader.<CertificateOfRegistrationController>getController();
	    				c.setDetails(name1.getText().trim());
	    				primaryStage.getIcons().add(new Image("RtoIcon.png"));
	    				primaryStage.setScene(scene);
	    				primaryStage.show();
	    				closeForm();
	    			}
	    		else{
	    			warning.setText("Please Enter Valid Registraion No");
					warning.setVisible(true);
	    		}
	    	}
 }    	
	  
	  public void name1Typed(){
			purchaserName.setText(name1.getText());
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
			proofBtn.setGraphic(new ImageView(image));
		}
		
		
		public void AadharSelected(ActionEvent ae){
			if(AadharCardCheck.isSelected()){
				AadharCardBtn.setVisible(true);
				aadharcross.setVisible(false);
			}	
			if(!AadharCardCheck.isSelected())
					AadharCardBtn.setVisible(false);	
		}
		
		
		public void ProofSelected(ActionEvent ae){
			if(proofCheck.isSelected()){
				proofBtn.setVisible(true);
				proofcross.setVisible(false);
			}	
				if(!proofCheck.isSelected())
					proofBtn.setVisible(false);
			
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
		
		public void ProofAttached() throws IOException{
			Stage stage = new Stage();
			stage= (Stage) cancelBtn.getScene().getWindow();
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Open Resource File");
			configureFileChooser(fileChooser);
			ProofFile = fileChooser.showOpenDialog(stage);
			proofContent = Files.readAllBytes(ProofFile.toPath());
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

}
