package com.example.gestorjuegos.domain.usuario;

import com.example.gestorjuegos.domain.DAO;
import com.example.gestorjuegos.domain.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class UserDAO implements DAO<User> {//Le implemento la interfaz DAO y le paso <User>

    @Override
    public ArrayList<User> getAll() {
        return null;
    }

    @Override
    public User get(Long id) {
        return null;
    }

    @Override
    public User save(User data) {
        return null;
    }

    @Override
    public void update(User data) {

    }

    @Override
    public void delete(User data) {

    }

    public User validateUser(String username, String password) {//Hacemos como un get, si existe, devuelve el usuario, si no, un null
        User result = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {//HAcemos un Query, query es para hacer consultas
                Query<User> q = session.createQuery("from User where username=:u and password=:p", User.class);//Esto es una consulta a las entidades, no a las tablas, diferenciarlo de cara al examen
                q.setParameter("u", username);
                q.setParameter("p", password);

                try {
                    result = q.getSingleResult();
                } catch (Exception e) {//También vale catch (Exception ignore)
                }
        }
            return result;

            /*HibernateUtil.getSessionFactory().inSession(//Desde una lambda no puedo escribir sobre una variable
             externa. Todas las variables del método pasan a la lambda como constantes

                    (session) -> {

                    }
            );     */

    }
}