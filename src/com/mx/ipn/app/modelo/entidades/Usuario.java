
package com.mx.ipn.app.modelo.entidades;

public class Usuario {
    
    private Integer idUsuario;
    private String nombre;
    private String clave;

    public Usuario() {
    }

    public Usuario(Integer idUsuario, String nombre, String clave) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.clave = clave;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "Usuario; id: " + idUsuario + ", nombre: " + nombre + ", clave: " + clave;
    }
    
}
