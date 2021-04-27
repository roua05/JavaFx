/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.view;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import utils.DataSource;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class LoginController implements Initializable {
    
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtPassword;
    @FXML
    private Button btnSignin;
    @FXML
    private Text btnforgetpass;
    @FXML
    private Button btnFB;
    @FXML
    private Label lb1_close;
    @FXML
    private Text lb1Errors;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public LoginController() {
        con = DataSource.getInstance().getCnx();
    }
    
    @FXML
    private void handleButtonAction(MouseEvent event) {
        if (event.getSource() == lb1_close) {
            System.exit(0);
        }
        if (event.getSource() == btnSignin) {
            //login here 
            if (logIn().equals("Succès")) {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.close();
               
                
                try {
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Home.fxml")));
                     stage.setScene(scene);
                     stage.show();
                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }
                
            }
        }
    }
    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    
    public String logIn() {
        
        try {
            String email = txtUsername.getText();
            String password = txtPassword.getText();

            //query
            String sql = "SELECT * FROM admins WHERE  email =? and password =?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            
            if (!resultSet.next()) {
                lb1Errors.setFill(Color.TOMATO);
                lb1Errors.setText("Entrer un mot de passe ou email corrects");
                System.err.println("Mauvaise Connection ///");
                return ("erreur");
                
            } else {
                lb1Errors.setFill(Color.GREEN);
                lb1Errors.setText("Connection avec succès...");
                System.out.println("Connection avec succès");
                return ("Succès");
                
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return ("Exception");
        }
        
    }
    
}
