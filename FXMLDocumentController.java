/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contact_app;

import java.io.File;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.util.Callback;

public class FXMLDocumentController {   
    
    //GUI components
    @FXML
    private ImageView contactImageView;
    
    private final ObservableList<Contact> contacts =FXCollections.observableArrayList();
    
    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField emailAddressTextField;

    @FXML
    private TextField phoneNumberTextField;

    @FXML
    private TextField homeAddressTextField;

    @FXML
    private TextField lastNameTextField;
    
    @FXML
    private ListView<Contact> contactListView;
    
    //when add button is pressed the text fields are cleared 
    @FXML
    void Add(ActionEvent event){
        lastNameTextField.setText("");
        firstNameTextField.setText("");
        emailAddressTextField.setText("");
        phoneNumberTextField.setText("");
        homeAddressTextField.setText("");
        contactImageView.setImage(null);
    }
    
    //when the imageview is clicked on an image is added
    @FXML
    void addImage(MouseEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File f = fileChooser.showOpenDialog(null);
        
        contactImageView.setImage(new Image(f.toURI().toString()));    
    }
    
    //deletes the selected contact
    @FXML
    void Delete(ActionEvent event){
        contacts.remove(contactListView.getSelectionModel().getSelectedItem());
        contactListView.getSelectionModel().clearSelection();
        lastNameTextField.setText("");
        firstNameTextField.setText("");
        emailAddressTextField.setText("");
        phoneNumberTextField.setText("");
        homeAddressTextField.setText("");
        contactImageView.setImage(null);       
        
    }
    
    //saves the current contact to the list view
    @FXML
    void Save(ActionEvent event){
        String newFirstName = firstNameTextField.getText();
        String newLastName = lastNameTextField.getText();
        
        if (newLastName.equals("") || newFirstName.equals("")){
            return;     
        }
        
        boolean editContact = false;
        
        for (Contact x : contacts){
            if (x.getFirstName().equals(newFirstName) && x.getLastName().equals(newLastName)){
                x.setEmailAddress(emailAddressTextField.getText());
                x.setPhoneNumber(phoneNumberTextField.getText());
                x.setHomeAddress(homeAddressTextField.getText());
                x.setImage(contactImageView.getImage());
                
                editContact = true;
            }
        }
        
        if (!editContact){
            contacts.add(new Contact(firstNameTextField.getText(), lastNameTextField.getText(), emailAddressTextField.getText(), phoneNumberTextField.getText(), homeAddressTextField.getText(), contactImageView.getImage()));
        }        
        initialize();  
    }
   
    @FXML
    public void initialize() {
        // TODO
        assert contactListView != null : "fx:id=\"contactListView\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert lastNameTextField != null : "fx:id=\"lastNameTextField\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert firstNameTextField != null : "fx:id=\"firstNameTextField\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert emailAddressTextField != null : "fx:id=\"emailAddressTextField\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert phoneNumberTextField != null : "fx:id=\"phoneNumberTextField\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert homeAddressTextField != null : "fx:id=\"homeAddressTextField\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert contactImageView != null : "fx:id=\"contactImageView\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        
        contactListView.setItems(contacts.sorted());
        
        contactListView.setCellFactory(
        new Callback<ListView<Contact>,ListCell<Contact>>(){
            @Override
            public ListCell<Contact> call(ListView<Contact> listView){
                return new ContactCell();
            }
        });
    }     
}

/**
 *
 * @author jessw
 */    
    