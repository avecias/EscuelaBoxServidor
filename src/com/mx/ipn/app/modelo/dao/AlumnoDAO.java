package com.mx.ipn.app.modelo.dao;

import com.mx.ipn.app.modelo.entidades.Alumno;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDAO {

    private static final String SQL_INSERT = "insert into Alumno (nombre,paterno,materno,boleta,idEscuela,idCategoria) values (?,?,?,?,?,?)";
    private static final String SQL_SELECT = "select * from Alumno where idAlumno = ?";
    private static final String SQL_SELECT_ALL = "select * from Alumno";
    private static final String SQL_UPDATE = "update Alumno set nombre = ? , paterno = ?, materno = ?, boleta = ?, idEscuela = ?, idCategoria = ? where idAlumno = ?";
    private static final String SQL_DELETE = "delete from Alumno where idAlumno = ?";
    private Connection con;
    private ResultSet resultado;
    private PreparedStatement ps;

    public boolean create(Alumno alumno) {
        obtenerConexion();
        boolean res = false;
        try {
            ps = con.prepareStatement(SQL_INSERT);
            ps.setString(1, alumno.getNombre());
            ps.setString(2, alumno.getPaterno());
            ps.setString(3, alumno.getMaterno());
            ps.setString(4, alumno.getBoleta());
            ps.setInt(5, alumno.getIdEscuela());
            ps.setInt(6, alumno.getIdCategoria());
            System.out.println("Esperando...");
            res = ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.err.println("Error al crear statement " + ex);
        }
        liberarRecursos();
        return res;
    }

    public boolean update(Alumno alumno) {
        obtenerConexion();
        boolean res = false;
        try {
            ps = con.prepareStatement(SQL_UPDATE);
            ps.setString(1, alumno.getNombre());
            ps.setString(2, alumno.getPaterno());
            ps.setString(3, alumno.getMaterno());
            ps.setString(4, alumno.getBoleta());
            ps.setInt(5, alumno.getIdEscuela());
            ps.setInt(6, alumno.getIdCategoria());
            ps.setInt(7, alumno.getIdAlumno());
            res = ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.err.println("Error al crear statement " + ex);
        }
        liberarRecursos();
        return res;
    }

    public boolean delete(Alumno alumno) {
        obtenerConexion();
        boolean res = false;
        try {
            ps = con.prepareStatement(SQL_DELETE);
            ps.setInt(1, alumno.getIdAlumno());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error al crear statement " + ex);
        }
        liberarRecursos();
        return res;
    }

    public Alumno read(Alumno alumno) {
        obtenerConexion();
        try {
            ps = con.prepareStatement(SQL_SELECT);
            ps.setInt(1, alumno.getIdAlumno());
            resultado = ps.executeQuery();
            resultado.next();
            alumno.setNombre(resultado.getString("nombre"));
            alumno.setPaterno(resultado.getString("paterno"));
            alumno.setMaterno(resultado.getString("materno"));
            alumno.setBoleta(resultado.getString("boleta"));
            alumno.setIdEscuela(resultado.getInt("idEscuela"));
            alumno.setIdCategoria(resultado.getInt("idCategoria"));
        } catch (SQLException ex) {
            System.err.println("Error al crear statement o el next" + ex);
        }
        liberarRecursos();
        return alumno;
    }

    public List<Alumno> readAll() {
        List<Alumno> alumnos = new ArrayList<>();
        obtenerConexion();
        try {
            ps = con.prepareStatement(SQL_SELECT_ALL);
            resultado = ps.executeQuery();
            while (resultado.next()) {
                Alumno alumno = new Alumno();
                alumno.setIdAlumno(resultado.getInt("idAlumno"));
                alumno.setNombre(resultado.getString("nombre"));
                alumno.setPaterno(resultado.getString("paterno"));
                alumno.setMaterno(resultado.getString("materno"));
                alumno.setBoleta(resultado.getString("boleta"));
                alumno.setIdEscuela(resultado.getInt("idEscuela"));
                alumno.setIdCategoria(resultado.getInt("idCategoria"));
                alumnos.add(alumno);
            }
        } catch (SQLException ex) {
            System.err.println("Error al crear statement " + ex);
        }
        liberarRecursos();
        return alumnos;
    }

    private void obtenerConexion() {
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

    private void liberarRecursos() {
        try {
            if (resultado != null) {
                resultado.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
            System.out.println("Recursos liberados");
        } catch (SQLException ex) {
            System.err.println("Error al cerrar el recurso " + ex);
        }
    }
}
