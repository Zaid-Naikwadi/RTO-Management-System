package Registered;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;

public class LearningLicenseController implements Initializable {
	@FXML ImageView imgview;
	@FXML Label l1;
Connection conection;
//LearningLicenseModel llm = new LearningLicenseModel();
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			//llm.submit(19);
			conection = SqliteConnection.connector();
			PreparedStatement preparedstatement = null;
			ResultSet resultset = null;
			String query = "Select * from Learning where ID = '"+19+"'";
			preparedstatement = conection.prepareStatement(query);
			resultset = preparedstatement.executeQuery();
			if(resultset.next()){ 
				String name = resultset.getString("Name");
				byte[] img = resultset.getBytes("PhotoImage");
				 Image convertToJavaFXImage = convertToJavaFXImage(img, 109, 104);
			     imgview.setImage(convertToJavaFXImage);
			     l1.setText(name);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
    private static Image convertToJavaFXImage(byte[] raw, final int width, final int height) {
        WritableImage image = new WritableImage(width, height);
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(raw);
            BufferedImage read = ImageIO.read(bis);
            image = SwingFXUtils.toFXImage(read, null);
        } catch (IOException ex) {
          //  Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        return image;
    }

}
