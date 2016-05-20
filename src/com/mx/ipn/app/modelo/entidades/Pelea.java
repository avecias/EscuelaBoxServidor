
package com.mx.ipn.app.modelo.entidades;

import java.io.Serializable;

public class Pelea implements Serializable{
    
    int IdPelea, idCometidorA, idCompetidorB;

    public Pelea() {
    }

    public Pelea(int IdPelea) {
        this.IdPelea = IdPelea;
    }

    public Pelea(int idCometidorA, int idCompetidorB) {
        this.idCometidorA = idCometidorA;
        this.idCompetidorB = idCompetidorB;
    }

    public Pelea(int IdPelea, int idCometidorA, int idCompetidorB) {
        this.IdPelea = IdPelea;
        this.idCometidorA = idCometidorA;
        this.idCompetidorB = idCompetidorB;
    }

    public int getIdPelea() {
        return IdPelea;
    }

    public void setIdPelea(int IdPelea) {
        this.IdPelea = IdPelea;
    }

    public int getIdCometidorA() {
        return idCometidorA;
    }

    public void setIdCometidorA(int idCometidorA) {
        this.idCometidorA = idCometidorA;
    }

    public int getIdCompetidorB() {
        return idCompetidorB;
    }

    public void setIdCompetidorB(int idCompetidorB) {
        this.idCompetidorB = idCompetidorB;
    }

    @Override
    public String toString() {
        return "Pelea{" + "IdPelea=" + IdPelea + ", idCometidorA=" + idCometidorA + ", idCompetidorB=" + idCompetidorB + '}';
    }
    
    
}
