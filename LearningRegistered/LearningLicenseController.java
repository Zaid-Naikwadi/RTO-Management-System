package LearningRegistered;

import javafx.fxml.FXML;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;


public class LearningLicenseController implements Initializable{

		@FXML Label llNo;
		@FXML Label date;
		@FXML Label sonOf;
		@FXML Label name;
		@FXML Label address;
		@FXML Label dob;
		@FXML Label blood;
		@FXML Label phone;
		@FXML Button print;
		@FXML ImageView imgview1;
		@FXML ImageView imgview2;
		@FXML ImageView sign;
		@FXML ImageView photo;
		@FXML Parent license;
		
		

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
			
		}
		
		public void setDetails(String name1) throws SQLException{
			Connection conection;
			conection = SqliteConnection.connector();
			PreparedStatement preparedStatement = conection.prepareStatement("select * from Learning where name = ?");
			preparedStatement.setString(1, name1);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				String Date = "";
				LocalDate d = LocalDate.now();
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				Date = dtf.format(d);
				date.setText(Date);
				llNo.setText(""+rs.getInt("ID"));
				name.setText(rs.getString("Name"));
				sonOf.setText(rs.getString("Parent"));
				address.setText(rs.getString("Address"));
				dob.setText(rs.getString("DOB"));
				blood.setText(rs.getString("Blood"));
				phone.setText(""+(rs.getLong("Phone")));
				byte[] img = rs.getBytes("PhotoImage");
				 Image convertToJavaFXImage = convertToJavaFXImage(img, 109, 104);
			     photo.setImage(convertToJavaFXImage);
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
		  
		  public void takeSnapshot() throws IOException{
				WritableImage image = license.snapshot(new SnapshotParameters(), null);
				File file = new File("C:\\java programs\\Learninglicense"+name.getText()+".png");
				ImageIO.write(SwingFXUtils.fromFXImage(image, null),"png",file);
				BufferedImage bufferedImage = SwingFXUtils.fromFXImage(image, null);
				
				PrinterJob printJob = PrinterJob.getPrinterJob();
				printJob.setPrintable(new Printable() {
				        public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
				                if (pageIndex != 0) {
				                    return NO_SUCH_PAGE;
				                }
				                graphics.drawImage(bufferedImage, 0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), null);
				                return PAGE_EXISTS;
				        }
				});     
				try {
				    printJob.print();
				} catch (PrinterException e1) {             
				    e1.printStackTrace();
				}
			}

	}



