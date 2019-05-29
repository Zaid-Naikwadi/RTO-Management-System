package VehicleRegistered;

import javafx.fxml.FXML;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.imageio.ImageIO;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Parent;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;

public class CertificateOfRegistrationController {

			@FXML Label rNo;
			@FXML Label chNo;
			@FXML Label eNo;
			@FXML Label date;
			@FXML Label name;
			@FXML Label address;
			@FXML Label vehicleType;
			@FXML Label vehicleClass;
			@FXML Label company;
			@FXML Label model;
			@FXML Button print;
			@FXML ImageView imgview1;
			@FXML ImageView imgview2;
			@FXML ImageView sign;
			@FXML Parent license;
			
			public void setDetails(String name1) throws SQLException{
				Connection conection;
				conection = SqliteConnection.connector();
				PreparedStatement preparedStatement = conection.prepareStatement("select * from Registration1 where name = ?");
				preparedStatement.setString(1, name1);
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()){
					String Date = "";
					LocalDate d = LocalDate.now();
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					Date = dtf.format(d);
					date.setText(Date);
					rNo.setText(""+rs.getInt("Rno"));
					chNo.setText(rs.getString("ChasisNo"));
					eNo.setText(rs.getString("EngineNo"));
					name.setText(rs.getString("Name"));
					address.setText(rs.getString("Address"));
					vehicleType.setText(rs.getString("VehicleType"));
					vehicleClass.setText(rs.getString("VehicleClass"));
					company.setText(rs.getString("Company"));
					model.setText("Model");
					
				}
				
			}
			  
			  public void takeSnapshot() throws IOException{
					WritableImage image = license.snapshot(new SnapshotParameters(), null);
					File file = new File("C:\\java programs\\VechileRegistered"+name.getText()+".png");
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
