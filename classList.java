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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.ObjectInputStream;
import javax.naming.NameAlreadyBoundException;
import javax.naming.NameNotFoundException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.ObservableList;

class Student{
	
	String studentnumber;
	String grade;
	String lastname;
	String firstname;
	String gender;
	
	public Student(String studentnumber, String grade, String lastname, String firstname, String gender){
		this.studentnumber = studentnumber;
		this.grade     = grade;
		this.lastname  = lastname;
		this.firstname = firstname;
		this.gender    = gender;
	}
}

class classList{
	String fileName;
	ObservableList<String> obsListStudents; // = FXCollections.observableArrayList(studentList.StringArrayList);
	ArrayList<Student> StudentArrayList = new ArrayList<Student>();
	ArrayList<String> StringArrayList = new ArrayList<String>();
	public ObservableList<String> getObsList(){
		return this.obsListStudents;
	}
	public ArrayList<Student> getStudentArrayList(){
		return this.StudentArrayList;
	}
	public ArrayList<String> getStringArrayList(){
		return this.StringArrayList;
	}
	public void makeObsList(){
		System.out.println("CHUG " + StringArrayList.get(2));
		this.obsListStudents = FXCollections.observableArrayList(StringArrayList);
	}
	public void add(String newStu){
		this.obsListStudents.add(newStu);
	}
	public classList(String fileName){
		System.out.println("in classlist creation");
		String listRead;
		ArrayList<Student> tempStudentArrayList = new ArrayList<Student>();
		ArrayList<String> tempStringArrayList = new ArrayList<String>();
		try{
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			
			listRead = reader.readLine();
			while(listRead != null){
				//System.out.println(listRead);
				tempStringArrayList.add(listRead);
				String[] oneStudent = listRead.split(" ");
				Student newStudent = new Student(oneStudent[0], oneStudent[1], oneStudent[2], oneStudent[3], oneStudent[4]);
				
				tempStudentArrayList.add(newStudent);
				
				listRead = reader.readLine();
			}
			reader.close();
			
		} catch (IOException e) { 
			System.out.println("BOGUS"); 
		}
		
		this.StudentArrayList = tempStudentArrayList;
		this.StringArrayList = tempStringArrayList;
		makeObsList();
		
		
	}
	
	
	
	
}

