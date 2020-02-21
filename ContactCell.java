/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contact_app;

/**
 *
 * @author jessw
 */

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

   
public class ContactCell extends ListCell <Contact> {
   private final VBox vbox = new VBox(8.0);
   private final ImageView thumbImageView = new ImageView();
   private final Label label = new Label();

   
   public ContactCell() {
      vbox.setAlignment(Pos.CENTER); 

      thumbImageView.setPreserveRatio(true);
      thumbImageView.setFitHeight(100.0); 
      vbox.getChildren().add(thumbImageView);

      label.setWrapText(true); 
      label.setTextAlignment(TextAlignment.CENTER); 
      vbox.getChildren().add(label); 

      setPrefWidth(USE_PREF_SIZE); 
   }

   
   @Override 
   protected void updateItem(Contact item, boolean empty) {
      super.updateItem(item, empty);

      if (empty || item == null) {
         setGraphic(null);
      }
      else {       
         thumbImageView.setImage((item.getThumbImage()));
         label.setText(item.getFirstName()); 
         setGraphic(vbox); 
      }
   }
}
