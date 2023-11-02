package com.example.gestorjuegos.domain.usuario;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

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
}
