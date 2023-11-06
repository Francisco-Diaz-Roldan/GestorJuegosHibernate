package com.example.gestorjuegos.domain.juego;


import com.example.gestorjuegos.domain.usuario.User;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;


@Data
@Entity
@Table(name = "coleccionjuegos")
public class Game implements Serializable {

  @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column (name = "nombre")
  private String name;

  @Column (name = "anio")
  private Long year;

  @Column (name = "num_jugadores")
  private Long players;

  @Column (name = "categoria")
  private String category;

  @Column (name = "plataforma")
  private String plataform;

  @Column (name = "estudio")
  private String studio;

  @Column (name = "empresa")
  private String enterprise;

  @Column (name = "formato")
  private String format;

  @Column (name = "estado_juego")
  private String gameStatus;

  @Column (name = "estado_caja")
  private String boxStatus;

//  @Column (name = "usuario_id")
//  private Long usuarioId;

  @ManyToOne
  @JoinColumn(name = "usuario_id")//La columna que une a las tablas, la clave foranea
  private User user;//Establecemos una relacion muchos a uno con un usuario, de modo que un usuario puede tener muchos juegos

  @Override
  public String toString() {
    return "Game{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", year=" + year +
            ", players=" + players +
            ", category='" + category + '\'' +
            ", plataform='" + plataform + '\'' +
            ", studio='" + studio + '\'' +
            ", enterprise='" + enterprise + '\'' +
            ", format='" + format + '\'' +
            ", gameStatus='" + gameStatus + '\'' +
            ", boxStatus='" + boxStatus + '\'' +
            ", user=" + user.getUsername() + //Añado esto a mano para que no me imprima en bucle sino que se pare aquí con el nombre del usuario
            '}';
  }
}
