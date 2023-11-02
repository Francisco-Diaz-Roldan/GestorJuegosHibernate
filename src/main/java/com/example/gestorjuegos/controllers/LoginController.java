package com.example.gestorjuegos.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Button btnLogin;
    @FXML
    private Button btnCancel;
    @FXML
    private Label info;
    @FXML
    private TextField txtUser;
    @FXML
    private PasswordField txtPassword;

    @FXML
    public void login(ActionEvent actionEvent) {
        String user = txtUser.getText();
        String pass = txtPassword.getText();

        if(user.length()<4 || pass.length()<4){
            info.setText("Introduce los datos");
            info.setStyle("-fx-background-color: red; -fx-text-fill: white;");

        }else{

            /*ACCESO A BASE DE DATOS PARA LA VALIDACION*/

            info.setText("Usuario " + user + "(" + pass + ") correcto");
            info.setStyle("-fx-background-color: green;");
        }


    }

    @FXML
    public void cancel(ActionEvent actionEvent) {
        txtPassword.setText("");
        txtUser.setText("");

        info.setText("");
        info.setStyle("-fx-background-color: transparent;");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Configuration cfg = new Configuration();//Seleccionamos el COnfiguration() de hibernate. Para comprobar la conexion -> new Configuration()).configure();
        cfg.configure();

        SessionFactory sf = cfg.buildSessionFactory();
    }
}