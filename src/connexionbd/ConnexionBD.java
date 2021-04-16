/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexionbd;

import Services.UserService;
import entites.User;
import java.sql.SQLException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import utils.DataSource;

/**
 *
 * @author Dell
 */
public class ConnexionBD extends Application {
    
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
    public static void main(String[] args) throws SQLException {
        launch(args);
//       DataSource ds1= DataSource.getInstance();
//       DataSource ds2= DataSource.getInstance();
//       DataSource ds3= DataSource.getInstance();
   
//  
  
     UserService us= new UserService();
//  User u8 = new User ("maha","20","chedli","dokd","patient","maha@gmail.com","***","pass","**","**","1","1");
//   User u9 = new User ("mounir","10","chedli","dokd","patient","mounir@gmail.com","pwd","20","**","**","1","1");
//    User u10 = new User ("salah","30","chedli","dokd","patient","salah@gmail.com","password","30","**","**","1","1");
//  us.ajouterUser(u8);
//  us.ajouterUser(u9);
//  us.ajouterUser(u10);
  
  //  us.UpdateUser();
   //  us.DeleteUser();
//   us.RechercherUser("amin");
   // us.readAll().forEach(e->System.out.println(e));
//Scanner myReader = new Scanner(System.in);
//       System.out.println("Enter your username");
//       String userName = myReader.nextLine();
//        System.out.println("Enter your Password");
//       String Password = myReader.nextLine();
//System.out.println(us.login(userName,Password));

// us.TriUser().forEach(e->System.out.println(e));
us.CountUser().forEach(e->System.out.println(e));
    }
    
}
