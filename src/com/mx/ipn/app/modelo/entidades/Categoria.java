
package com.mx.ipn.app.modelo.entidades;

import java.io.Serializable;

public class Categoria implements Serializable{
    
    private int idCategoria;
    private String nombre, rango;

    public Categoria() {
    }

    public Categoria(int idCategoria, String nombre, String rango) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.rango = rango;
    }

    public Categoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Categoria(String nombre, String rango) {
        this.nombre = nombre;
        this.rango = rango;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    @Override
    public String toString() {
        return "id: " + idCategoria + ", nombre: " + nombre + ", rango: " + rango;
    }
    
}
