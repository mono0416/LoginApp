package com.example.loginapp.controladores;

import com.example.loginapp.modelos.Libro;

import java.util.List;

public interface ILibroBD {


    Libro elemento(int id); //devuelve el elemento dado su id
    Libro elemento(String title); // devuelve el elemento dado su titulo exacto

    List<Libro> lista(); //devuelve una lista con todos los elementos registrados

    void agregar(Libro book); //añade el elemento indicado
    void actualizar(int id, Libro book); // actualiza datos del elemento dado su id

    void borrar(int id); //elimina el elemento indicado con el id


}
