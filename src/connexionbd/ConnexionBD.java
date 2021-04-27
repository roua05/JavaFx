/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexionbd;

import Services.UserService;
import entites.User;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import utils.DataSource;


public class ConnexionBD extends Application {

    private Stage primaryStage;
    private Parent parentPage;
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Bienvenue");
        parentPage = FXMLLoader.load(getClass().getResource("/com/esprit/view/Accueil.fxml"));
        Scene scene = new Scene (parentPage);
        this.primaryStage.setScene(scene);
        this.primaryStage.show(); 
//        new animatefx.animation.BounceOutDown(parentPage).play();
        
        
    }
    
    public static void main(String[] args) throws SQLException {
 launch(args);
//       DataSource ds1= DataSource.getInstance();
//       DataSource ds2= DataSource.getInstance();
//       DataSource ds3= DataSource.getInstance();
   
//  
  
    UserService us= new UserService();
//  User u12 = new User ("nessrine","20","ness","fff","patient","lkjdd@gmail.com","147","sza","123","886","1","1");
//  User u13 = new User ("jlassi","10","hhh","eee","patient","mounir@gmail.com","258","azza","**","**","1","1");
//    User u14 = new User ("ikram","30","yyyy","aaa","patient","salah@gmail.com","369","cvf","**","**","1","1");
// us.ajouterUser(u12);
//
//us.ajouterUser(u13);
//  us.ajouterUser(u14);
 
//// us.UpdateUser();
//    us.DeleteUser();
  //us.RechercherUser("amin");
   
//us.readAll().forEach(e->System.out.println(e));
//Scanner myReader = new Scanner(System.in);
//       System.out.println("Enter your username");
//       String userName = myReader.nextLine();
//        System.out.println("Enter your Password");
//  //     String Password = myReader.nextLine();
////System.out.println(us.login(userName,Password));

 //us.TriUser().forEach(e->System.out.println(e));
//us.CountUser().forEach(e->System.out.println(e));
    }
    
}
