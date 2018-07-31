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

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class DisplayFile extends Application
{
    //--------------------------------------------------------------------
    //  Presents a file chooser dialog, reads the selected file and
    //  loads it into a text area.
    //--------------------------------------------------------------------
    public void start(Stage primaryStage) throws IOException
    {
        FileChooser chooser = new FileChooser();
        File selectedFile = chooser.showOpenDialog(primaryStage);
        
        TextArea content = new TextArea();
        content.setFont(new Font("Courier", 12));
        content.setEditable(false);
        
        if (selectedFile == null)
            content.setText("No file chosen.");
        else
        {
            Scanner scan = new Scanner(selectedFile);
            
            String info = "";
            while (scan.hasNext())
                info += scan.nextLine() + "\n";
            
            content.setText(info);
        }
        
        Scene scene = new Scene(content, 500, 500);
        
        primaryStage.setTitle("Display File");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
}