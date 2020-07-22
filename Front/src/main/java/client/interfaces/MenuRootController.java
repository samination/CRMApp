package client.interfaces;

import java.util.List;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import tn.esprit.CRmapp.entities.Admin;
import tn.esprit.CRmapp.entities.Client;
import tn.esprit.CRmapp.services.adminServiceRemote;
import tn.esprit.CRmapp.services.userServiceRemote;
import javafx.scene.control.TableColumn;

public class MenuRootController implements Initializable 	 {
	
	
	@FXML
    private TableView<Admin> table1;
    @FXML
    private TableColumn<Admin, Integer> c1;
    @FXML
    private TableColumn<Admin, String> c2;
    @FXML
    private TableColumn<Admin, String> c3;
    @FXML
    private TableColumn<Admin, String> c4;
    @FXML
    private TableColumn<Admin,  String> c5;
    @FXML
    private TableColumn<Admin, Integer> c6;
    
	@FXML
	private Button suprimer_client;
	@FXML
	private Button modifier_client;
	@FXML
	private Button actualiser_client;
	List<Admin> liste_commentaire;
	static  String mail;
	

	  
	    public void initialize(URL url, ResourceBundle rb) {
	    	
	    	
	    	
        
	    	ObservableList<Admin> data=FXCollections.observableArrayList();
		
			 String jndiName="CRmapp-ear/CRmapp-ejb/adminService!tn.esprit.CRmapp.services.adminServiceRemote";
	 	    	
				Context context;
				try {
					context = new InitialContext();
					 adminServiceRemote proxy;
					 proxy = (adminServiceRemote) context.lookup(jndiName);
					 
					     
					        List<Admin> listeCompagnie=proxy.findAllAdmins();
					       
					       for(int i=0;i<listeCompagnie.size();i++){
		                    Admin c =listeCompagnie.get(i);           
					       data.add(c);
					       }
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			 
			

				c1.setCellValueFactory(
		                new PropertyValueFactory<>("idUser"));  
			       c2.setCellValueFactory(
			                new PropertyValueFactory<>("email"));
			       c3.setCellValueFactory(
			                new PropertyValueFactory<>("address"));
			       c4.setCellValueFactory(
			                new PropertyValueFactory<>("password"));  
			       
			       c5.setCellValueFactory(
			                new PropertyValueFactory<>("phoneNumber"));
			       c6.setCellValueFactory(
			                new PropertyValueFactory<>("cin"));
			         table1.setItems(data); 
			         
	    	
	    	modifier_client.setOnAction(new EventHandler<ActionEvent>() {
	            
	            @Override
	            public void handle(ActionEvent event) {
	         if (table1.getSelectionModel().getSelectedItem() != null) {

	            
	               
	         Admin a = table1.getSelectionModel().getSelectedItem();
	      
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminUpdate.fxml"));
	        Parent root;
			try {
				root = loader.load();
				
				AdminUpdateController hc = loader.getController();
		       hc.setAdmin(a);
		       
		        
		        Stage stage= new Stage();
		        Scene scene=new Scene(root);
		        stage.setScene(scene);
		        stage.showAndWait();
		        
		        
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	       /* rafrechir();*/
	        
	                   } else {
	            Alert alert = new Alert(Alert.AlertType.ERROR);
	            alert.setTitle("information Dialog");
	            alert.setHeaderText(null);
	            alert.setContentText("Vous devez selectionner un voyage organise!!");
	            alert.show();
	        }
	    }
	            
	         });
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	 suprimer_client.setOnAction(new EventHandler<ActionEvent>() {
		            
		            
		            public void handle(ActionEvent event) {
		                if (table1.getSelectionModel().getSelectedItem() != null) {
		            
		                int id = table1.getSelectionModel().getSelectedItem().getIdUser();
		                String jndiName="CRmapp-ear/CRmapp-ejb/adminService!tn.esprit.CRmapp.services.adminServiceRemote";
		                Context context;
		                try {
							context = new InitialContext();
							 adminServiceRemote proxy = (adminServiceRemote) context.lookup(jndiName);
							 proxy.removeAdmin(id);
						} catch (NamingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						 adminServiceRemote proxy;
						
		           
		            /*rafrechir();*/
		        } else {
		            Alert alert = new Alert(Alert.AlertType.ERROR);
		            alert.setTitle("information Dialog");
		            alert.setHeaderText(null);
		            alert.setContentText("Vous devez selectionner un voyage organise");
		            alert.show();
		        }
		            }
		         });
			   
			   
			   
			   actualiser_client.setOnAction((ActionEvent event)  ->  { 
				   ObservableList<Admin> data1=FXCollections.observableArrayList();
					
					 String jndiName1="CRmapp-ear/CRmapp-ejb/adminService!tn.esprit.CRmapp.services.adminServiceRemote";
				
						Context context1;
			 	    	
						
						try {
							context1 = new InitialContext();
							 adminServiceRemote proxy1;
							 proxy1 = (adminServiceRemote) context1.lookup(jndiName1);
							 
								
								
								
								
						
							
							
							
							 proxy1= (adminServiceRemote) context1.lookup(jndiName1);
							 
							     
							        List<Admin> listeCompagnie1=proxy1.findAllAdmins();
							       
							       for(int i=0;i<listeCompagnie1.size();i++){
							           Admin c =listeCompagnie1.get(i);           
							       data1.add(c);
							      
							       }

							       c1.setCellValueFactory(
							                new PropertyValueFactory<>("idUser")); 
							       c2.setCellValueFactory(
							                new PropertyValueFactory<>("email"));
							       c3.setCellValueFactory(
							                new PropertyValueFactory<>("address"));
							       c4.setCellValueFactory(
							                new PropertyValueFactory<>("password"));
							       c5.setCellValueFactory(
							                new PropertyValueFactory<>("phoneNumber"));
							       c6.setCellValueFactory(
							                new PropertyValueFactory<>("cin"));
							        
							      
							   table1.setItems(data1);
								
							
							

						} catch (NamingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					 
					
				   System.out.println("yemchi");
				   
			   });
			   
			   
			  
			   }
	   
	  }
	
	
	    

