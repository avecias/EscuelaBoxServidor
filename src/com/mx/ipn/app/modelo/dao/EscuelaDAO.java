
package com.mx.ipn.app.modelo.dao;

import com.mx.ipn.app.modelo.entidades.Escuela;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EscuelaDAO {
    
    private static final String SQL_INSERT = "insert into Escuela (nombre) values (?)";
    private static final String SQL_SELECT = "select * from Escuela where idEscuela = ?";
    private static final String SQL_SELECT_ALL = "select * from Escuela";
    private static final String SQL_UPDATE = "update Escuela set nombre = ? where idEscuela = ?";
    private static final String SQL_DELETE = "delete from Escuela where idEscuela = ?";
    private Connection con;
    private ResultSet resultado;
    private PreparedStatement ps;
    
    public boolean create(Escuela escuela){
        obtenerConexion();
        boolean res = false;
        try{
            ps = con.prepareStatement(SQL_INSERT);
            ps.setString(1, escuela.getNombre());
            res = ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.err.println("Error al crear statement " + ex);
        }
        liberarRecursos();
        return res;
    }
    
    public boolean update(Escuela escuela){
        obtenerConexion();
        boolean res = false;
        try{
            ps = con.prepareStatement(SQL_UPDATE);
            ps.setString(1, escuela.getNombre());
            ps.setInt(2, escuela.getIdEscuela());
            res = ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.err.println("Error al crear statement " + ex);
        }
        liberarRecursos();
        return res;
    }
    
    public boolean delete(Escuela escuela){
        obtenerConexion();
        boolean res = false;
        try{
            ps = con.prepareStatement(SQL_DELETE);
            ps.setInt(1, escuela.getIdEscuela());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error al crear statement " + ex);
        }
        liberarRecursos();
        return res;
    }
    
    public Escuela read(Escuela escuela){
        obtenerConexion();
        try{
            ps = con.prepareStatement(SQL_SELECT);
            ps.setInt(1, escuela.getIdEscuela());
            resultado = ps.executeQuery();
            resultado.next();
            escuela.setNombre(resultado.getString("nombre"));
        } catch (SQLException ex) {
            System.err.println("Error al crear statement " + ex);
        }
        liberarRecursos();
        return escuela;
    }
    
    public List<Escuela> readAll(){
        List<Escuela> escuelas = new ArrayList<>();
        obtenerConexion();
        try{
            ps = con.prepareStatement(SQL_SELECT_ALL);
            resultado = ps.executeQuery();
            while(resultado.next()){
                Escuela escuela = new Escuela();
                escuela.setIdEscuela(resultado.getInt("idEscuela"));
                escuela.setNombre(resultado.getString("nombre"));
                escuelas.add(escuela);
            }
        } catch (SQLException ex) {
            System.err.println("Error al crear statement " + ex);
        }
        liberarRecursos();
        return escuelas;
    }

    private void obtenerConexion() {
        String driver = "com.mysql.jdbc.Driver";
        String usuario = "root";
        String clave = "avecias";
        String urlBD = "jdbc:mysql://localhost:3306/EscuelaBox";
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(urlBD, usuario,clave);
            System.out.println("Conectado");
        } catch (ClassNotFoundException ex) {
            System.err.println("Clase no encontrada " + ex);
        } catch (SQLException ex) {
            System.err.println("Error al crear conexion " + ex);
        }
    }
    
    private void liberarRecursos() {
        try {
            if (resultado != null) {
                resultado.close();
            }
            if(ps != null){
                ps.close();
            }
            if(con != null){
                con.close();
            }
            System.out.println("Recursos liberados");
        } catch (SQLException ex) {
            System.err.println("Error al cerrar el recurso " + ex);
        }
    }
}
