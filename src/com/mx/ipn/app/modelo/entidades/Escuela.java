
package com.mx.ipn.app.modelo.entidades;

import java.io.Serializable;

public class Escuela implements Serializable{
    
    private int idEscuela;
    private String nombre;

    public Escuela() {
    }

    public Escuela(int idEscuela) {
        this.idEscuela = idEscuela;
    }

    public Escuela(String nombre) {
        this.nombre = nombre;
    }

    public Escuela(int idEscuela, String nombre) {
        this.idEscuela = idEscuela;
        this.nombre = nombre;
    }

    public int getIdEscuela() {
        return idEscuela;
    }

    public void setIdEscuela(int idEscuela) {
        this.idEscuela = idEscuela;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Escuela{" + "idEscuela=" + idEscuela + ", nombre=" + nombre + '}';
    }
    
    
    
}
