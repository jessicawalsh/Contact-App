/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contact_app;

import javafx.scene.image.Image;

public class Contact {
    
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
    private String homeAddress;
    private Image image;
        
    //constructor
    public Contact(String firstName, String lastName, String emailAddress, String phoneNumber, String homeAddress, Image image)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.homeAddress = homeAddress;
        this.image = image;           
    }

  
    //Getter and setter methods
    public String getFirstName(){
        return firstName;
    }
        
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
        
    public String getLastName(){
        return lastName;
    }
        
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getEmailAddress(){
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress){
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getHomeAddress(){
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress){
        this.homeAddress = homeAddress;
    }

    public void setImage(Image image){
        this.image = image;
    }

    public Image getThumbImage(){
        return image;
    }

    public void setThumbImage(Image image){
        this.image = image;
    }

    @Override
    public String toString(){
        return this.firstName + " " + this.lastName;
    }

}
