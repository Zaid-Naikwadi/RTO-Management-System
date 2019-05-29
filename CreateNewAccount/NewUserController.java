package CreateNewAccount;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
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
import javafx.stage.Stage;

public class NewUserController{
	@FXML
	private AnchorPane mainAnchor;

	@FXML
	private Hyperlink lgn;
	
	@FXML
	private JFXTextField name;
	
	@FXML
	private JFXTextField username;
	
	@FXML
	private JFXPasswordField password;
	
	@FXML
	private JFXTextField email;
	
	@FXML
	private JFXPasswordField rePassword;
	
	@FXML
	private ImageView pass;
	
	@FXML
	private ImageView repass;
	
	@FXML
	private ImageView user;
	
	@FXML
	private ImageView emailcross;
	
	@FXML
	private ImageView namecross;
	
	@FXML
	private ImageView datecross;
	
	@FXML
	private ImageView pointdown;
	
	@FXML
	private Button register;
	
	@FXML
	private Label warning;
	
	@FXML JFXRadioButton male;
	@FXML JFXRadioButton female;
	
	@FXML JFXDatePicker date;

	NewUserModel newusr = new NewUserModel();

	int age = 0;
	String gender = "";
	String Date = "";
	LocalDate d = LocalDate.now();
	LocalDate localdate ;
	
	

	public void gotoMain(ActionEvent e) throws IOException
	{
		Stage primaryStage = new Stage(); 
		Parent root = FXMLLoader.load(getClass().getResource("/application/LoginPrac.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
		primaryStage.setTitle("Welcome");
		primaryStage.getIcons().add(new Image("RtoIcon.png"));
		primaryStage.setScene(scene);
		primaryStage.show();
		closeNewUser();
		
	}
	public void onRegister(ActionEvent e) throws Exception{
	
		if((name.getText().trim().equals("")) | (Date.equals("")) | (gender.equals("")) | (email.getText().trim().equals("")) | (username.getText().trim().equals("")) | (password.getText().equals("")) | (rePassword.getText().equals(""))){
			warning.setVisible(true);
			emailcross.setVisible(false);
			namecross.setVisible(false);
			repass.setVisible(false);
			pass.setVisible(false);
			datecross.setVisible(false);
			System.out.println("condition 1");
		}
		
		else if(!name.getText().trim().matches("[ A-Za-z_]+")){
			warning.setText("Name must be in Characters");
			warning.setVisible(true);
			namecross.setVisible(true);
			user.setVisible(false);
			repass.setVisible(false);
			pass.setVisible(false);
			System.out.println("condition 2");
		}
		
		else if(age <= 14){		
			warning.setText("Date is Invalid");
			warning.setVisible(true);
			datecross.setVisible(true);
			System.out.println("condition 3");
		}
		
		else if(!email.getText().trim().matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$")){
			emailcross.setVisible(true);
			warning.setText("Email ID is not Valid");
			warning.setVisible(true);
			user.setVisible(false);
			repass.setVisible(false);
			pass.setVisible(false);
			namecross.setVisible(false);
			datecross.setVisible(false);
			System.out.println("condition 4");
		}
		
		else if(!username.getText().trim().matches("[A-Za-z0-9_]+")){
			user.setVisible(true);
			warning.setText("Username must be in AlphaNumeric Characters");
			warning.setVisible(true);
			emailcross.setVisible(false);
			repass.setVisible(false);
			pass.setVisible(false);
			namecross.setVisible(false);
			datecross.setVisible(false);
			System.out.println("condition 5");
		}
		
		else if((!password.getText().matches((".{8,}")))){
			repass.setVisible(false);
			pass.setVisible(true);
			warning.setText("Password must be atleast 8 characters");
			warning.setVisible(true);
			user.setVisible(false);
			emailcross.setVisible(false);
			namecross.setVisible(false);
			datecross.setVisible(false);
			System.out.println("condition 10");
		}

		else if((!password.getText().equals(rePassword.getText()))){
			repass.setVisible(true);
			pass.setVisible(true);
			warning.setText("Passwords Does not match");
			warning.setVisible(true);
			user.setVisible(false);
			emailcross.setVisible(false);
			namecross.setVisible(false);
			datecross.setVisible(false);
			System.out.println("condition 11");
		}

		else{
		user.setVisible(false);
		pass.setVisible(false);
		repass.setVisible(false);
		emailcross.setVisible(false);
		namecross.setVisible(false);
		datecross.setVisible(false);
		warning.setText("Registration Successfull!");
		warning.setVisible(true);
		pointdown.setVisible(true);
	    newusr.register(name.getText().trim(),Date,age,gender,email.getText().trim(),username.getText().trim().trim(),password.getText());
	   System.out.println("condition 12");
	}	
}
	
	public void maleSelected(){
		gender = "Male";
		female.setSelected(false);
		if(!male.isSelected()){
			gender = "";
		}
	}
	
	
	public void date(){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		localdate = date.getValue();
		age  = d.getYear() - localdate.getYear();
		Date = dtf.format(localdate);
		System.out.println(Date);
		System.out.println(age);
	}
	
	public void femaleSelected(){
		gender = "Female";
		male.setSelected(false);
		if(!female.isSelected()){
			gender = "";
		}
	}

	private void closeNewUser() {
		Stage stage = new Stage();
		stage= (Stage) lgn.getScene().getWindow();
		stage.close();		
	}
}
