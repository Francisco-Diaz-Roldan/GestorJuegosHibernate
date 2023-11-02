module com.example.gestorjuegos {
    requires javafx.controls;
    requires javafx.fxml;

    //Requires de lombok
    requires lombok;//Hay que añadir esto a mano como en el maven las 3 ultimas dependencias

    //Requires de hibernate
    requires jakarta.persistence;//Hay que añadir esto a mano
    requires org.hibernate.orm.core;
    requires java.naming;
    requires java.sql;//Este es por si trabajamos con fechas

    opens com.example.gestorjuegos.domain.usuario;
    opens com.example.gestorjuegos.domain.juego;//Añado esto tras añadir la clase Juego

    opens com.example.gestorjuegos to javafx.fxml;
    opens com.example.gestorjuegos.controllers to javafx.fxml;

    exports com.example.gestorjuegos;
    exports com.example.gestorjuegos.controllers;
}