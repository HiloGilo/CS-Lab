import java.io.*;
import java.util.*;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList.*;
import javafx.application.*;
import javafx.application.Application;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ListView.EditEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.event.*;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.beans.value.*;
import javafx.collections.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.text.*;

public class Gonzalez_H_Lab1 extends Application{
	
	public static void main(String[] args){
		launch(args);
	}
	
	public void init(){
		//this is the initializing method. It is empty right now.
	}
	public void start(Stage myStage){
		FlowPane rootNode = new FlowPane(10, 10);
		rootNode.setAlignment(Pos.CENTER);
		rootNode.setPadding(new Insets(0, 0, 0, 0));
		
		classList studentList = new classList("classlist.txt");
		
		ListView<String> lvStudents = createListView(studentList);
		lvStudents.setPrefSize(300, 100);
		Button btnAdd = new Button("Add");
		
		TextField filePath = new TextField("File Path");
		
		for (int i=0; i < studentList.StringArrayList.size(); i++){
			String test;
			
			System.out.println(studentList.StringArrayList.get(i));
		}
		
		
		
		btnAdd.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				Stage stAdd = new Stage();
				
				GridPane grid = new GridPane();
                Label firstName = new Label("First Name:");
                Label lastName = new Label("Last Name:");
				grid.add(firstName, 0, 1);
                Label grade = new Label("Grade:");
                Label studentID = new Label("Student ID:");
				Label gender = new Label("Gender:");
				TextField fTextField = new TextField("Hilario");
				TextField lTextField = new TextField("Gonzalez");
				TextField grTextField = new TextField("12");
				TextField sTextField = new TextField("615523");
				TextField geTextField = new TextField("Male");
				Button submitButton = new Button("Add");
				Scene newStFields = new Scene(grid, 300, 200);
				
				grid.add(lastName, 0, 2);
                grid.add(grade, 0, 3);
                grid.add(studentID, 0, 4);
                grid.add(gender, 0, 5);
                grid.add(fTextField, 1, 1);
                grid.add(lTextField, 1, 2);
                grid.add(grTextField, 1, 3);
                grid.add(sTextField, 1, 4);
                grid.add(geTextField, 1, 5);
                grid.add(submitButton, 3, 6);
				
                submitButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
						String newStu = (sTextField.getText() + " " + grTextField.getText() + " " + lTextField.getText() + " " + fTextField.getText() + " " + geTextField.getText());
						
						//classList.obsListStudents.add(newStu); <- this gave error message 
						
                        stAdd.close();
					}
				});
				stAdd.setScene(newStFields);
                stAdd.show();
			}
		});
		
		
		
		rootNode.getChildren().addAll(filePath, lvStudents, btnAdd);
		Scene stView = new Scene(rootNode, 400, 400);
		myStage.setScene(stView);
		myStage.show();
	}
	public void stop() {
		//stop method is empty right now
	}
	
	public ListView<String> createListView(classList studentList){
		ListView<String> classListView = new ListView<String>();
		
		classListView.setEditable(true);
		
		classListView.setItems(studentList.getObsList());
		return classListView;
	}
}