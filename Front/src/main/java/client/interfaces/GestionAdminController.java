package client.interfaces;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GestionAdminController implements Initializable {
	@FXML
	private Button Add_Admin;
	@FXML
	private Button Handle_Admin;

	
	
	public void initialize(URL url, ResourceBundle rb)  {
		Add_Admin.setOnAction((ActionEvent event)  ->  { 
			Stage primaryStage=new Stage();
			Parent root;
			try {
				root = FXMLLoader.load(getClass().getResource("SignupAdmin.fxml"));
				 Scene scene = new Scene(root);
			        
			        primaryStage.setTitle("Ajouter un Article");
			        primaryStage.setScene(scene);
			        primaryStage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       
			
			
		 });
		
		
		Handle_Admin.setOnAction((ActionEvent event)  ->  { 
			Stage primaryStage=new Stage();
			Parent root;
			try {
				root = FXMLLoader.load(getClass().getResource("MenuRoot.fxml"));
				 Scene scene = new Scene(root);
			        
			        primaryStage.setTitle("Ajouter un Article!!!!");
			        primaryStage.setScene(scene);
			        primaryStage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       
			
			
		 });
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	}

