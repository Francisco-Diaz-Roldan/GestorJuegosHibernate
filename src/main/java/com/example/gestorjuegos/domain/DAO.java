package com.example.gestorjuegos.domain;

import java.util.ArrayList;

public interface DAO <T> {//Hago un interfaz generico, <T> se puede cabiar por cualquier clase
//Le añado lo básico para cualquier DAO
    public ArrayList<T> getAll();
    public T get(Long id);
    public T save(T data);
    public void update(T data);
    public void delete(T data);

}
