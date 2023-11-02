package com.example.gestorjuegos.domain;

import lombok.extern.java.Log;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Log
public class HibernateUtil {//Lo voy a usar para el session factory

   private static SessionFactory sf = null;

    static{
        try{
            Configuration cfg = new Configuration();//Seleccionamos el COnfiguration() de hibernate. Para comprobar la conexion -> new Configuration()).configure();
            cfg.configure();
            sf = cfg.buildSessionFactory();
            log.info("SessionFactory creado!");
        }catch (Exception ex){
            log.severe("Error al crear SessionFactory()");
        }
    }

    public static  SessionFactory getSessionFactory(){
        return sf;
    }
}
