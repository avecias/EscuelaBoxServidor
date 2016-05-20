
package com.mx.ipn.app.modelo.entidades;

import java.io.Serializable;

public class Alumno implements Serializable{
    
    private int idAlumno, idEscuela,idCategoria;
    String nombre, paterno, materno;
    String boleta;

    public Alumno() {
    }

    public Alumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Alumno(int idEscuela, int idCategoria, String nombre, String paterno, String materno, String boleta) {
        this.idEscuela = idEscuela;
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.boleta = boleta;
    }

    public Alumno(int idAlumno, int idEscuela, int idCategoria, String nombre, String paterno, String materno, String boleta) {
        this.idAlumno = idAlumno;
        this.idEscuela = idEscuela;
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.boleta = boleta;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getIdEscuela() {
        return idEscuela;
    }

    public void setIdEscuela(int idEscuela) {
        this.idEscuela = idEscuela;
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

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getBoleta() {
        return boleta;
    }

    public void setBoleta(String boleta) {
        this.boleta = boleta;
    }

    @Override
    public String toString() {
        return "Alumno{" + "idAlumno=" + idAlumno + ", idEscuela=" + idEscuela + ", idCategoria=" + idCategoria + ", nombre=" + nombre + ", paterno=" + paterno + ", materno=" + materno + ", boleta=" + boleta + '}';
    }
    
    
}
