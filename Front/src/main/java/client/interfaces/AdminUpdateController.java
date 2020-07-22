package client.interfaces;

import java.net.URL;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import tn.esprit.CRmapp.entities.Admin;
import tn.esprit.CRmapp.entities.Client;
import tn.esprit.CRmapp.services.adminServiceRemote;
import tn.esprit.CRmapp.services.userServiceRemote;

public class AdminUpdateController {
	@FXML
	private TextField entry1;
	@FXML
	private TextField entry11;
	@FXML
	private TextField entry12;
	@FXML
	private TextField entry13;
	@FXML
	private TextField entry14;
	@FXML
	private TextField entry15;
	@FXML
	private Button update_button;
	
	
	static     Admin he;

	
	public void setAdmin(Admin h){
	     
	     int t=0;
		                
	      he=h;          
	                
	    
	      
	      this.entry1.setText(String.valueOf(he.getIdUser()));
	      this.entry14.setText(he.getEmail());
	      
	      this.entry13.setText(he.getAddress());
	      this.entry12.setText(String.valueOf(he.getCin()));
	      this.entry15.setText(he.getPhoneNumber());
	      
	}
	
	
	public void initialize(URL url, ResourceBundle rb)  {
		
		
		update_button.setOnAction(new EventHandler<ActionEvent>() {
          
          @Override
          public void handle(ActionEvent event) {
        	  
        	  System.out.println("Test1");
        	  
            
      Admin h=new Admin();
      
      h.setEmail(entry14.getText());
      h.setAddress(entry13.getText());
     
      h.setPhoneNumber(entry15.getText());
      h.setCin(Integer.parseInt(entry12.getText()));
     
      
      
     
         if  (entry12.getText().length() != 0&&entry13.getText().length() != 0&&entry14.getText().length() != 0&&entry15.getText().length() != 0) {
       	  String jndiName="CRmapp-ear/CRmapp-ejb/adminService!tn.esprit.CRmapp.services.adminServiceRemote";
     		Context context;
     		try {
				context = new InitialContext();
				adminServiceRemote proxy;
				proxy = (adminServiceRemote) context.lookup(jndiName);
				proxy.updateUser(h, he.getIdUser());
				System.out.println("Modif tet3adda");
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
             ((Node)event.getSource()).getScene().getWindow().hide();
         }
         else {
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
          alert.setTitle("information Dialog");
          alert.setHeaderText(null);
          alert.setContentText("fill all the fields");
          alert.show();
      }
    
          }
      });
	
	
	 
	    

}

}
