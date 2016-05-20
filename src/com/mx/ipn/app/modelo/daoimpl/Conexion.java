
package com.mx.ipn.app.modelo.daoimpl;

import com.mx.ipn.app.modelo.squirrel.Alumno;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


public class Conexion {

    private Connection con;
    private Statement statement;
    private ResultSet resultado;
    
    public void hacerConexion() {
        String driver = "com.mysql.jdbc.Driver";
        String usuario = "root";
        String clave = "avecias";
        String urlBD = "jdbc:mysql://localhost:3306/EscuelaBox";
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(urlBD, usuario, clave);
            System.out.println("Conectado");
        } catch (ClassNotFoundException ex) {
            System.err.println("Clase no encontrada " + ex);
        } catch (SQLException ex) {
            System.err.println("Error al crear conexion " + ex);
        }
    }
    
    public ResultSet obtenerResultSet(String Consulta){
        try{
            statement = con.createStatement();
            resultado = statement.executeQuery(Consulta);
            return resultado;
        } catch (SQLException ex) {
            System.err.println("No se pudo ejecutar la consulta " + ex);
            return null;
        }
    }

    public Connection obtenerConexion() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public static void main(String[] args) throws SQLException {
        Conexion conexion = new Conexion();
        conexion.hacerConexion();
        AlumnoDAOImpl aOImpl = new AlumnoDAOImpl();
        List<Alumno> alumnos = aOImpl.getResults(conexion.obtenerResultSet("select * from Alumno"));
        for (Alumno alumno : alumnos) {
            System.out.println(alumno.toString());
        }
    }
}
