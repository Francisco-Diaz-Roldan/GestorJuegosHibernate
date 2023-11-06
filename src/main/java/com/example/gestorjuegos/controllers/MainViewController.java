package com.example.gestorjuegos.controllers;

import com.example.gestorjuegos.App;
import com.example.gestorjuegos.Session;
import com.example.gestorjuegos.domain.juego.Game;
import com.example.gestorjuegos.domain.juego.GameDAO;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable
{
    @javafx.fxml.FXML
    private Label info;
    @javafx.fxml.FXML
    private TableColumn <Game, String> cNombre;
    @javafx.fxml.FXML
    private TableColumn <Game, String> cPlataforma;
    @javafx.fxml.FXML
    private TableColumn <Game, String>cCategoria;
    @javafx.fxml.FXML
    private TableColumn <Game, String> cAno;
    @javafx.fxml.FXML
    private TableColumn <Game, String>cEstudio;
    @javafx.fxml.FXML
    private TableColumn <Game, String> cFormato;
    @javafx.fxml.FXML
    private TableView<Game> tvTabla;
    @javafx.fxml.FXML
    private Label lTotal;
    @javafx.fxml.FXML
    private MenuItem mSalir;

    @javafx.fxml.FXML
    public void salir(ActionEvent actionEvent) {
        Session.setCurrentUser(null);
        try{
            App.changeScene("login-view.fxml", "login");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        cAno.setCellValueFactory((fila)->{
            return new SimpleStringProperty(fila.getValue().getYear()+"");//Casteamos a String concatenando ""
        } );

        cNombre.setCellValueFactory((fila)->{
            return new SimpleStringProperty(fila.getValue().getName());
        } );

        cPlataforma.setCellValueFactory((fila)->{
            return new SimpleStringProperty(fila.getValue().getPlataform());
        } );

        cCategoria.setCellValueFactory((fila)->{
            return new SimpleStringProperty(fila.getValue().getCategory());
        } );

        cEstudio.setCellValueFactory((fila)->{
            return new SimpleStringProperty(fila.getValue().getStudio());
        } );

        cFormato.setCellValueFactory((fila)->{
            return new SimpleStringProperty(fila.getValue().getFormat());
        } );

        lTotal.setText( Session.getCurrentUser().getGames().size()+ " juegos");

        tvTabla.getItems().addAll(Session.getCurrentUser().getGames());
        info.setText("Bienvenido " + Session.getCurrentUser().getUsername());

        //En caso de que no hiiciera la relacion ->(new GameDAO()).getAllFromUser(Session.getCurrentUser()).forEach(System.out::println);//Veo todos los juegos de ese usuario en sesion
        //(Session.getCurrentUser()).getGames().forEach(System.out::println);//Veo todos los juegos de ese usuario en sesion
    }
}