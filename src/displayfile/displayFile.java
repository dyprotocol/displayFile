package displayfile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

//************************************************************************
//  CLASS:    	OBJECT-ORIENTED PROGRAMMING I  
//  GROUP:	GROUP 3
//  MEMBERS:	CHRIS / DOUA / SAMUEL
//  PROJECT:	CHAPTER 11; PROGRAMMING PROJECT 11.7
//************************************************************************
public class DisplayFile extends Application {
//-------------------------------------------------------------------- 
// Presents a file chooser dialog, reads the selected file and  
// loads it into a text area. 
    //-------------------------------------------------------------------- 

    private Button SAVE;

    public void start(Stage primaryStage) throws IOException {

        FileChooser chooser = new FileChooser();
        File selectedFile = chooser.showOpenDialog(primaryStage);
        
        Label saveLabel = new Label();
        saveLabel.setText("Changes hve been saved.");
        saveLabel.setFont(new Font("Courier", 14));
        saveLabel.setTextFill(Color.GREEN);
        saveLabel.setAlignment(Pos.CENTER);
        saveLabel.setVisible(false);
        
        TextArea content = new TextArea();
        content.setFont(new Font("Courier", 12));
        content.setEditable(true);
        content.setWrapText(true);
        
        content.addEventHandler(KeyEvent.KEY_RELEASED, new EventHandler<
                KeyEvent>() {
                    @Override
                    public void handle(KeyEvent event){
                        saveLabel.setVisible(false);
                    }
                });

        if (selectedFile == null) {
            content.setText("No file chosen.");
        } else {
            Scanner scan = new Scanner(selectedFile);

            String info = "";
            while (scan.hasNext()) {
                info += scan.nextLine() + "\n";
            }

            content.setText(info);
        }
        
        SAVE = new Button("Save");

        SAVE.setOnAction((ActionEvent event) -> {
            SaveFile(content.getText(), selectedFile);
            saveLabel.setVisible(true);
        });

        HBox pickers = new HBox(SAVE);
        pickers.setSpacing(15);
        pickers.setAlignment(Pos.CENTER);

        VBox root = new VBox();
        root.setStyle("-fx-background-color: skyblue");
        root.setSpacing(20);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(saveLabel, content, pickers);

        Scene scene = new Scene(root, 500, 500);

        primaryStage.setTitle("Display File");

        primaryStage.setScene(scene);

        primaryStage.show();

    }

    private void SaveFile(String content, File file) {
        try {
            FileWriter fileWriter;

            fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(DisplayFile.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
}
