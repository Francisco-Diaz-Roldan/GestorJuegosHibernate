package com.example.gestorjuegos.domain.usuario;

import com.example.gestorjuegos.domain.juego.Game;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity//Todas las anotaciones son de jakarta, los metodos, de hibernate
@Table(name = "user")
public class User implements Serializable {//Inicializable es en javaFX, Serializable en Hibernate
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//No hace falta poner un ; porque es una anotacion
    private Long id;

    @Column(name="usuario")
    private String username;

    @Column(name="contraseña")
    private String password;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)//mapped by es el atributo de la otra clase, EAGER hace que lo inicialice en cuanto pueda
    private List<Game> games = new ArrayList<>(0);//Lacy hace que la lista esté en estado de no inicializada, el error es de hibernate
}
