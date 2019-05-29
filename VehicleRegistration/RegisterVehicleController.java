package VehicleRegistration;

import javafx.fxml.FXML;
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

import VehicleRegistered.CertificateOfRegistrationController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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

public class RegisterVehicleController implements Initializable {
	
		@FXML Button cancelBtn;
		@FXML public Label name;
		@FXML JFXTextArea address;
		@FXML JFXTextField dealer;
		@FXML JFXTextArea address1;
		@FXML JFXTextField enNo;
		@FXML JFXTextField chNo;
		@FXML JFXComboBox<String> typeOfVehicle;
		@FXML JFXComboBox<String> classOfVehicle;
		@FXML JFXComboBox<String> companyName;
		@FXML JFXComboBox<String> modelName;
		ObservableList<String> typeOfVehicleList = FXCollections.observableArrayList("2 Wheeler","3 Wheeler","4 Wheeler");
		
		ObservableList<String> classOfVehicleList = FXCollections.observableArrayList("With Gear","Without Gear");
		ObservableList<String> classOfVehicleList1 = FXCollections.observableArrayList("With Gear");
		ObservableList<String> classOfVehicleList2 = FXCollections.observableArrayList("With Gear");

		ObservableList<String> companyNameList1 = FXCollections.observableArrayList("Hero","TVS","Honda","Yamaha");
		ObservableList<String> companyNameList2 = FXCollections.observableArrayList("Hero","TVS","Honda","Bajaj","Yamaha");
		ObservableList<String> companyNameList3 = FXCollections.observableArrayList("Rickshaw");
		ObservableList<String> companyNameList4 = FXCollections.observableArrayList("Maruti","Mahindra","Mercedes","Ford","TataMotors","Truck");
		
		ObservableList<String> modelNameListHero = FXCollections.observableArrayList("Splendor","HF Delux","Passion","Ignitor","Karizma");
		ObservableList<String> modelNameListTVS = FXCollections.observableArrayList("Apache","Sport","Star City Plus","Phoenix");
		ObservableList<String> modelNameListHonda = FXCollections.observableArrayList("Hornet","Livo","Shine","Unicorn","Dream Yuga");
		ObservableList<String> modelNameListBajaj = FXCollections.observableArrayList("Pulsar","Dominar","Discover","Platina");
		ObservableList<String> modelNameListYamaha = FXCollections.observableArrayList("R15","FZ","R3","Saluto","Fazer");

		ObservableList<String> modelNameListHerowg = FXCollections.observableArrayList("Duet","Maestro","Pleasure","Dare","Leap Hybrid");
		ObservableList<String> modelNameListTVSwg = FXCollections.observableArrayList("Jupiter","Pept","Zest","Wego","Streak");
		ObservableList<String> modelNameListHondawg = FXCollections.observableArrayList("Activa","Dio","Aviator");
		ObservableList<String> modelNameListYamahawg = FXCollections.observableArrayList("Fascino","Cynus Ray","Alpha","Ray Z");
		
		ObservableList<String> modelNameListRick = FXCollections.observableArrayList("Rickshaw");
		
		ObservableList<String> modelNameListMaruti = FXCollections.observableArrayList("Alto","Swift","Wagon R","Baleno","Celerio");
		ObservableList<String> modelNameListMahindra = FXCollections.observableArrayList("Scropio","Bolero","Xylo","Verito","e20 Plus");
		ObservableList<String> modelNameListMercedes = FXCollections.observableArrayList("1955 300 SLR Racer","1970 C111","1954 Gullwing","2010 E63 AMG","1937 540K Special");
		ObservableList<String> modelNameListFord = FXCollections.observableArrayList("Polo","Vento","Mustang","Figo","Apsire");
		ObservableList<String> modelNameListTataMotors = FXCollections.observableArrayList("Nano","Indica","Tiago","Zest","Bolt");
		ObservableList<String> modelNameListTruck = FXCollections.observableArrayList("Truck");


		
		@FXML JFXTextField phone;
		@FXML JFXTextField email;
		@FXML Button AadharCardBtn;
		@FXML Button insuranceCertificateBtn;
		@FXML Button vehicleRecieptBtn;
		@FXML Button residenceProofBtn;
		@FXML Button Submit;
		@FXML Label warning;
		@FXML CheckBox AadharCardCheck;
		@FXML CheckBox insuranceCheck;
		@FXML CheckBox recieptCheck;
		@FXML CheckBox proofCheck;
		@FXML JFXCheckBox assure;
		public byte[] aadharContent; 
		public byte[] insuranceContent; 
		public byte[] recieptContent; 
		public byte[] proofContent; 

		@FXML ImageView namecross;
		@FXML ImageView datecross;
		@FXML ImageView dealercross;
		@FXML ImageView phonecross;
		@FXML ImageView emailcross;
		@FXML ImageView recieptcross;
		@FXML ImageView aadharcross;
		@FXML ImageView insurancecross;
		@FXML ImageView residencecross;


		@FXML JFXDatePicker date;

		String Date = "";
		int age = 0;
		LocalDate d = LocalDate.now();
		LocalDate localdate ;
		
		RegisterVehicleModel rvm = new RegisterVehicleModel();

		File AadharFile = new File("");
		File insuranceFile = new File("");
		File recieptFile = new File("");
		File proofFile = new File("");
	
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
		    	try {
		    		  if((name.getText().trim().equals("")) | (address.getText().trim().equals(""))| (address1.getText().trim().equals("")) | (Date.equals("")) | (dealer.getText().trim().equals("")) | (typeOfVehicle.getValue().equals("Select Type Of Vehicle"))| (classOfVehicle.getValue().equals("Select Class Of Vehicle"))| (companyName.getValue().equals("Select Company Name"))| (modelName.getValue().equals("Select Model Name")) | (chNo.getText().trim().equals("")) | (enNo.getText().trim().equals("")) | (phone.getText().trim().equals("")) |(email.getText().trim().equals("")) | ((AadharCardCheck.isSelected()) && (AadharFile.toString().equals(""))) | ((insuranceCheck.isSelected()) && (insuranceFile.toString().equals(""))) | ((recieptCheck.isSelected()) && (recieptFile.toString().equals("")))| ((proofCheck.isSelected()) && (proofFile.toString().equals(""))) ){
		    			warning.setText("Please Fill All The Details");
		    			warning.setVisible(true);
		    			namecross.setVisible(false);
		    			datecross.setVisible(false);
		    			dealercross.setVisible(false);
		    			phonecross.setVisible(false);
		    			emailcross.setVisible(false);
		    			recieptcross.setVisible(false);
		    			aadharcross.setVisible(false);
		    			insurancecross.setVisible(false);
		    			residencecross.setVisible(false);
		    			System.out.println("Condition 1");
		    		}
		    		
		    		else if(!name.getText().trim().matches("[ A-Za-z_]+")){
		    			warning.setText("Name must be in Characters");
		    			warning.setVisible(true);
		    			namecross.setVisible(true);
		    			datecross.setVisible(false);
		    			dealercross.setVisible(false);
		    			phonecross.setVisible(false);
		    			emailcross.setVisible(false);
		    			recieptcross.setVisible(false);
		    			aadharcross.setVisible(false);
		    			insurancecross.setVisible(false);
		    			residencecross.setVisible(false);
		    			System.out.println("condition 2");
		    		}
		    		
			    	else if(age <= 14){		
			    		warning.setText("Date is Invalid");
			   			warning.setVisible(true);
			   			datecross.setVisible(true);
			   			namecross.setVisible(false);
			   			dealercross.setVisible(false);
		    			phonecross.setVisible(false);
		    			emailcross.setVisible(false);		    	
		    			recieptcross.setVisible(false);
			    		aadharcross.setVisible(false);
			   			insurancecross.setVisible(false);
			   			residencecross.setVisible(false);
			   			System.out.println("condition 3");
			    		}
		    		  
		    		else if(!dealer.getText().trim().matches("[ A-Za-z_]+")){
		    			warning.setText("Name must be in Characters");
		    			warning.setVisible(true);
		    			namecross.setVisible(false);
		    			datecross.setVisible(false);
		    			dealercross.setVisible(true);
		    			phonecross.setVisible(false);
		    			emailcross.setVisible(false);
		    			recieptcross.setVisible(false);
		    			aadharcross.setVisible(false);
		    			insurancecross.setVisible(false);
		    			residencecross.setVisible(false);
		    			System.out.println("condition 4");
		    		}
		    		
		    		else if(!phone.getText().trim().matches("^[0-9]*$")){
		    			warning.setText("Phone no must be in Digits");
		    			warning.setVisible(true);
		    			namecross.setVisible(false);
		    			datecross.setVisible(false);
		    			dealercross.setVisible(false);
		    			phonecross.setVisible(true);
		    			emailcross.setVisible(false);
		    			recieptcross.setVisible(false);
		    			aadharcross.setVisible(false);
		    			insurancecross.setVisible(false);
		    			residencecross.setVisible(false);
		    			System.out.println("condition 5");
		    		}
		    		
		    		else if(!phone.getText().trim().matches("^[0-9]{10}$")){
		    			warning.setText("Phone no must be atleast 10 Digits long");
		    			warning.setVisible(true);
		    			namecross.setVisible(false);
		    			datecross.setVisible(false);
		    			dealercross.setVisible(false);
		    			phonecross.setVisible(true);
		    			emailcross.setVisible(false);
		    			recieptcross.setVisible(false);
		    			aadharcross.setVisible(false);
		    			insurancecross.setVisible(false);
		    			residencecross.setVisible(false);
		    			System.out.println("condition 6");
		    		}
		    		
		    		else if(!email.getText().trim().matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$")){
		    			warning.setText("Email ID is not Valid");
		    			warning.setVisible(true);
		    			namecross.setVisible(false);
		    			datecross.setVisible(false);
		    			dealercross.setVisible(false);
		    			phonecross.setVisible(false);
		    			emailcross.setVisible(true);
		    			recieptcross.setVisible(false);
		    			aadharcross.setVisible(false);
		    			insurancecross.setVisible(false);
		    			residencecross.setVisible(false);
		    			System.out.println("condition 8");
		    		}
		    		
		    		else if(!AadharCardCheck.isSelected()){
		    			warning.setText("Please Fill All The Details");
		    			warning.setVisible(true);
		    			aadharcross.setVisible(true);
		    			recieptcross.setVisible(false);
		    			namecross.setVisible(false);
		    			datecross.setVisible(false);
		    			dealercross.setVisible(false);
		    			phonecross.setVisible(false);
		    			emailcross.setVisible(false);
		    			recieptcross.setVisible(false);
		    			insurancecross.setVisible(false);
		    			residencecross.setVisible(false);
		    		}
		    		
		    		else if(!recieptCheck.isSelected()){
		       			warning.setText("Please Fill All The Details");
		    			warning.setVisible(true);
		    			insurancecross.setVisible(false);
		    			aadharcross.setVisible(false);
		    			recieptcross.setVisible(true);
		    			namecross.setVisible(false);
		    			datecross.setVisible(false);
		    			dealercross.setVisible(false);
		    			phonecross.setVisible(false);
		    			emailcross.setVisible(false);
		    			residencecross.setVisible(false);
		    		}
		    		
		    		else if(!insuranceCheck.isSelected()){
		    			warning.setText("Please Fill All The Details");
		    			warning.setVisible(true);
		    			insurancecross.setVisible(true);
		    			aadharcross.setVisible(false);
		    			recieptcross.setVisible(false);
		    			namecross.setVisible(false);
		    			datecross.setVisible(false);
		    			dealercross.setVisible(false);
		    			phonecross.setVisible(false);
		    			emailcross.setVisible(false);
		    			residencecross.setVisible(false);
		    		}
		    		else if(!proofCheck.isSelected()){
		    			warning.setText("Please Fill All The Details");
		    			warning.setVisible(true);
		    			residencecross.setVisible(true);
		    			insurancecross.setVisible(false);
		    			aadharcross.setVisible(false);
		    			recieptcross.setVisible(false);
		    			namecross.setVisible(false);
		    			datecross.setVisible(false);
		    			dealercross.setVisible(false);
		    			phonecross.setVisible(false);
		    			emailcross.setVisible(false);
		    		}

		    		else{
		    			 rvm.submit(name.getText().trim(),address.getText().trim(),Date,dealer.getText().trim(),address1.getText().trim(),typeOfVehicle.getValue().trim(),classOfVehicle.getValue().trim(),companyName.getValue().trim(),modelName.getValue().trim(),chNo.getText().trim(),enNo.getText().trim(),Long.parseLong(phone.getText().trim()),email.getText().trim(),aadharContent,insuranceContent,recieptContent,proofContent);
		    					Stage primaryStage = new Stage();
		    					FXMLLoader loader = new FXMLLoader(getClass().getResource("/VehicleRegistered/CertificateOfRegistration.fxml"));
			    				Parent root = loader.load();
			    				Scene scene = new Scene(root);
			    				CertificateOfRegistrationController c = loader.<CertificateOfRegistrationController>getController();
			    				c.setDetails(name.getText().trim());
			    				primaryStage.getIcons().add(new Image("RtoIcon.png"));
			    				primaryStage.setScene(scene);
			    				primaryStage.show();
		    				}
				}		 
		    	
		    catch (SQLException e) {
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
				insuranceCertificateBtn.setGraphic(new ImageView(image));
				vehicleRecieptBtn.setGraphic(new ImageView(image));
				residenceProofBtn.setGraphic(new ImageView(image));
				typeOfVehicle.setValue("Select Type Of Vehicle");
				classOfVehicle.setValue("Select Class Of Vehicle");
				companyName.setValue("Select Company Name");
				modelName.setValue("Select Model Name");
				typeOfVehicle.setItems(typeOfVehicleList);
			}	
			
			public void typeSelected(){
				if( typeOfVehicle.getValue().equals("2 Wheeler")){
					classOfVehicle.setItems(classOfVehicleList);
				}
				else if(typeOfVehicle.getValue().equals("3 Wheeler")){
					classOfVehicle.setItems(classOfVehicleList1);
				}
				
				else if(typeOfVehicle.getValue().equals("4 Wheeler")){
					classOfVehicle.setItems(classOfVehicleList2);
				}
				
			}
			
			public void classSelected(){
				if(classOfVehicle.getValue().equals("With Gear") && typeOfVehicle.getValue().equals("2 Wheeler")){
					companyName.setItems(companyNameList2);
				}
				else if(classOfVehicle.getValue().equals("Without Gear") && typeOfVehicle.getValue().equals("2 Wheeler")){
					companyName.setItems(companyNameList1);
				}
				
				else if(classOfVehicle.getValue().equals("With Gear") && typeOfVehicle.getValue().equals("3 Wheeler")){
					companyName.setItems(companyNameList3);
				}
				
				else if(classOfVehicle.getValue().equals("With Gear") && typeOfVehicle.getValue().equals("4 Wheeler")){
					companyName.setItems(companyNameList4);
				}
			}
			
			public void companySelected(){
				if(companyName.getValue().equals("Hero") && classOfVehicle.getValue().equals("With Gear")){
					modelName.setItems(modelNameListHero);
				}
				else if(companyName.getValue().equals("TVS") && classOfVehicle.getValue().equals("With Gear")){
					modelName.setItems(modelNameListTVS);
				}
				
				else if(companyName.getValue().equals("Honda") && classOfVehicle.getValue().equals("With Gear")){
					modelName.setItems(modelNameListHonda);
				}
	
				else if(companyName.getValue().equals("Bajaj") && classOfVehicle.getValue().equals("With Gear")){
					modelName.setItems(modelNameListBajaj);
				}
				
				else if(companyName.getValue().equals("Yamaha") && classOfVehicle.getValue().equals("With Gear")){
					modelName.setItems(modelNameListYamaha);
				}
				
				else if(companyName.getValue().equals("Hero") && classOfVehicle.getValue().equals("Without Gear")){
					modelName.setItems(modelNameListHerowg);
				}
				else if(companyName.getValue().equals("TVS") && classOfVehicle.getValue().equals("Without Gear")){
					modelName.setItems(modelNameListTVSwg);
				}
				
				else if(companyName.getValue().equals("Honda") && classOfVehicle.getValue().equals("Without Gear")){
					modelName.setItems(modelNameListHondawg);
				}
	
				
				else if(companyName.getValue().equals("Yamaha") && classOfVehicle.getValue().equals("Without Gear")){
					modelName.setItems(modelNameListYamahawg);
				}
				
				else if(companyName.getValue().equals("Rickshaw") && classOfVehicle.getValue().equals("With Gear")){
					modelName.setItems(modelNameListRick);
				}
				
				else if(companyName.getValue().equals("Maruti") && classOfVehicle.getValue().equals("With Gear")){
					modelName.setItems(modelNameListMaruti);
				}
				
				else if(companyName.getValue().equals("Mahindra") && classOfVehicle.getValue().equals("With Gear")){
					modelName.setItems(modelNameListMahindra);
				}
				
				else if(companyName.getValue().equals("Mercedes") && classOfVehicle.getValue().equals("With Gear")){
					modelName.setItems(modelNameListMercedes);
				}
				
				else if(companyName.getValue().equals("Ford") && classOfVehicle.getValue().equals("With Gear")){
					modelName.setItems(modelNameListFord);
				}
				
				else if(companyName.getValue().equals("TataMotors") && classOfVehicle.getValue().equals("With Gear")){
					modelName.setItems(modelNameListTataMotors);
				}
				
				else if(companyName.getValue().equals("Truck") && classOfVehicle.getValue().equals("With Gear")){
					modelName.setItems(modelNameListTruck);
				}
			}
			
			public void AadharSelected(ActionEvent ae){
				if(AadharCardCheck.isSelected()){
					AadharCardBtn.setVisible(true);
					aadharcross.setVisible(false);
				}	
				if(!AadharCardCheck.isSelected())
						AadharCardBtn.setVisible(false);	
			}
			
			public void insuranceSelected(ActionEvent ae){
				if(insuranceCheck.isSelected()){
					insuranceCertificateBtn.setVisible(true);
					insurancecross.setVisible(false);
				} 
				if(!insuranceCheck.isSelected())
					insuranceCertificateBtn.setVisible(false);	
			}
			
			public void vehicleRecieptSelected(ActionEvent ae){
				if(recieptCheck.isSelected()){
					vehicleRecieptBtn.setVisible(true);
					recieptcross.setVisible(false);
				}	
					if(!recieptCheck.isSelected())
						vehicleRecieptBtn.setVisible(false);
				
			}
			
			public void proofSelected(ActionEvent ae){
				if(proofCheck.isSelected()){
					residenceProofBtn.setVisible(true);
				    residencecross.setVisible(false);
				} 
				if(!proofCheck.isSelected())
					residenceProofBtn.setVisible(false);
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
			
			public void insuranceCertificateAttached() throws IOException{
				Stage stage = new Stage();
				stage= (Stage) cancelBtn.getScene().getWindow();
				FileChooser fileChooser = new FileChooser();
				fileChooser.setTitle("Open Resource File");
				configureFileChooser(fileChooser);
				insuranceFile = fileChooser.showOpenDialog(stage);
				insuranceContent = Files.readAllBytes(insuranceFile.toPath());
			}	
			
			public void vehicleRecieptAttached() throws IOException{
				Stage stage = new Stage();
				stage= (Stage) cancelBtn.getScene().getWindow();
				FileChooser fileChooser = new FileChooser();
				fileChooser.setTitle("Open Resource File");
				configureFileChooser(fileChooser);
				recieptFile = fileChooser.showOpenDialog(stage);
				recieptContent = Files.readAllBytes(recieptFile.toPath());
			}
			public void residenceProofAttached() throws IOException{
				Stage stage = new Stage();
				stage= (Stage) cancelBtn.getScene().getWindow();
				FileChooser fileChooser = new FileChooser();
				fileChooser.setTitle("Open Resource File");
				configureFileChooser(fileChooser);
				proofFile = fileChooser.showOpenDialog(stage);
				proofContent = Files.readAllBytes(proofFile.toPath());
			}
			
			public void assured(){
				if(assure.isSelected())
					Submit.setDisable(false);
				if(!assure.isSelected())
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
