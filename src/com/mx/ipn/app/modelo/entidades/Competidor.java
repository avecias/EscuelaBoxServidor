
package com.mx.ipn.app.modelo.entidades;

import java.io.Serializable;

public class Competidor implements Serializable{
    
    int idCompetidor, idAlumno;

    public Competidor() {
    }

    public Competidor(int idCompetidor, int idAlumno) {
        this.idCompetidor = idCompetidor;
        this.idAlumno = idAlumno;
    }

    public Competidor(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getIdCompetidor() {
        return idCompetidor;
    }

    public void setIdCompetidor(int idCompetidor) {
        this.idCompetidor = idCompetidor;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    @Override
    public String toString() {
        return "Competidor{" + "idCompetidor=" + idCompetidor + ", idAlumno=" + idAlumno + '}';
    }
    
}
