
package com.mx.ipn.app.modelo.entidades;

import java.io.Serializable;

public class Peticion implements Serializable{
    
    private String tipo;
    private String consulta;
    private Object objecto;

    public Peticion(String tipo, String consulta, Object objecto) {
        this.tipo = tipo;
        this.consulta = consulta;
        this.objecto = objecto;
    }

    public Peticion() {
    }

    public Peticion(String tipo, String consulta) {
        this.tipo = tipo;
        this.consulta = consulta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getConsulta() {
        return consulta;
    }

    public void setConsulta(String consulta) {
        this.consulta = consulta;
    }

    public Object getObjecto() {
        return objecto;
    }

    public void setObjecto(Object objecto) {
        this.objecto = objecto;
    }
    
    
}
