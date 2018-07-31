//************************************************************************
//  DisplayFile.java       Author: Lewis/Loftus
//
//  Demonstrates the use of a file chooser dialog box and a text area.
//************************************************************************
//  CLASS:    	OBJECT-ORIENTED PROGRAMMING I  
//	GROUP:	  	GROUP 3
//  MEMBERS:	CHRIS / DOUA / SAMUEL
//	PROJECT:	CHAPTER 11; PROGRAMMING PROJECT 11.7
//************************************************************************
/*
	Write a JavaFX application based on the DisplayFile program from
	Chapter 9.  In addition to opening and displaying a file, allow the 
	user to modify the text in the text area.  Provide a Save button that,
	when pressed, displays a dialog box that lets the user save the 
	modifications to a file.  Hint: use the showSaveDialog method of the 
	FileChooser class and use a try-catch statement to handle any exceptions
	that occur during the process of writing the file.
*/

package displayfile;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author dyaj
 */
public class DisplayFile extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
