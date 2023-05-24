/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class Register extends Application {
    
    
    public TextField username;
    public TextField password;
     @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("CompanyX System Login");
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(30);
        grid.setVgap(30);
        
        
        Label UsernameLabel = new Label("User Name");
        grid.add(UsernameLabel, 0, 0);
        username = new TextField();
        grid.add(username, 1, 0);
        Label PasswordLabel = new Label("Password");
        grid.add(PasswordLabel, 0, 1);
        password = new TextField();
        grid.add(password, 1, 1);
         
 //Buttons
       Button login_btn=new Button("Login");
       grid.add(login_btn, 0, 3);
       try{
          Class.forName("com.mysql.cj.jdbc.Driver"); //step one
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "");//Establishing connection
          Statement st_object=con.createStatement();   //step three
          String statement =  "INSERT INTO `users` (`username`, `password`) VALUES ('"+username+"', '"+password+"')";
          st_object.executeUpdate(statement);
           Alert al = new Alert(Alert.AlertType.CONFIRMATION);
           al.setContentText("User Successfuly Registered");
           al.show();
            //You can add the code to open HomePage (after successful login)          
          con.close();
           
        }
        catch(Exception ee){System.out.println(ee);System.out.println("Connection error");
          System.out.println("Buda fom");
         Alert a = new Alert(Alert.AlertType.WARNING);
                    a.setContentText("User NOT Successfuly Registered");
                    a.show();
        }
       Button register_btn=new Button("Register");
        grid.add(register_btn, 1, 3);
          try{
          Class.forName("com.mysql.cj.jdbc.Driver"); //step one
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "");//Establishing connection
          Statement st_object=con.createStatement();   //step three
          String statement =  "INSERT INTO `users` (`username`, `password`) VALUES ('"+username+"', '"+password+"')";
          st_object.executeUpdate(statement);
           Alert al = new Alert(Alert.AlertType.CONFIRMATION);
           al.setContentText("User Successfuly Registered");
           al.show();
            //You can add the code to open HomePage (after successful login)          
          con.close();
           
        }
        catch(Exception ee){System.out.println(ee);System.out.println("Connection error");
          System.out.println("Buda fom");
         Alert a = new Alert(Alert.AlertType.WARNING);
                    a.setContentText("User NOT Successfuly Registered");
                    a.show();
        }
    
       
       primaryStage.setTitle("CompanyX System Login");
       //create the scene
       Scene myscene=new Scene(grid, 500, 400);
       //adding the scene to the stage
       primaryStage.setScene(myscene);       
       //showing the stage
       primaryStage.show();
       
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
