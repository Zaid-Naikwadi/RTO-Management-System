package adminPermanentLicense;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javax.imageio.ImageIO;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;

public class PhotoController implements Initializable{

		@FXML ImageView imgview;
		
		Connection conection;
		
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
				conection = SqliteConnection.connector();			 
		}
		
		public void setImage(ResultSet resultset,int id) throws SQLException{
			byte[] img = null;
			if(resultset.next()){ 
				if(id == 1){
				img = resultset.getBytes("PhotoImage");
				}
				
				else if(id == 2){
					img = resultset.getBytes("AadharImage");
				}
				
				else if(id == 3){
					img = resultset.getBytes("LCImage");
				}
				
				else if(id == 4){
					img = resultset.getBytes("RationImage");
				}
				
				else if(id == 5){
					img = resultset.getBytes("PanImage");
					
				}
				
				 Image convertToJavaFXImage = convertToJavaFXImage(img, 109, 104);
			     imgview.setImage(convertToJavaFXImage);
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
