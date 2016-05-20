package com.mx.ipn.app.modelo.dao;

import com.mx.ipn.app.modelo.entidades.Alumno;
import com.mx.ipn.app.modelo.entidades.Categoria;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    private static final String SQL_INSERT = "insert into Categoria (nombre,rango) values (?,?)";
    private static final String SQL_SELECT = "select * from Categoria where idCategoria = ?";
    private static final String SQL_SELECT_ALL = "select * from Categoria";
    private static final String SQL_UPDATE = "update Categoria set nombre = ? , rango = ? where idCategoria = ?";
    private static final String SQL_DELETE = "delete from Categoria where idCategoria = ?";
    private Connection con;
    private ResultSet resultado;
    private PreparedStatement ps;

    public boolean create(Categoria categoria) {
        obtenerConexion();
        boolean res = false;
        try {
            ps = con.prepareStatement(SQL_INSERT);
            ps.setString(1, categoria.getNombre());
            ps.setString(2, categoria.getRango());
            res = ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.err.println("Error al crear statement " + ex);
        }
        liberarRecursos();
        return res;
    }

    public boolean update(Categoria categoria) {
        obtenerConexion();
        boolean res = false;
        try {
            ps = con.prepareStatement(SQL_UPDATE);
            ps.setString(1, categoria.getNombre());
            ps.setString(2, categoria.getRango());
            ps.setInt(3, categoria.getIdCategoria());
            res = ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.err.println("Error al crear statement " + ex);
        }
        liberarRecursos();
        return res;
    }

    public boolean delete(Categoria categoria) {
        obtenerConexion();
        boolean res = false;
        try {
            ps = con.prepareStatement(SQL_DELETE);
            ps.setInt(1, categoria.getIdCategoria());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error al crear statement " + ex);
        }
        liberarRecursos();
        return res;
    }

    public Categoria read(Categoria categoria) {
        obtenerConexion();
        try {
            ps = con.prepareStatement(SQL_SELECT);
            ps.setInt(1, categoria.getIdCategoria());
            resultado = ps.executeQuery();
            resultado.next();
            categoria.setNombre(resultado.getString("nombre"));
            categoria.setRango(resultado.getString("rango"));
        } catch (SQLException ex) {
            System.err.println("Error al crear statement " + ex);
        }
        liberarRecursos();
        return categoria;
    }

    public List<Categoria> readAll() {
        List<Categoria> categorias = new ArrayList<>();
        obtenerConexion();
        try {
            ps = con.prepareStatement(SQL_SELECT_ALL);
            resultado = ps.executeQuery();
            while (resultado.next()) {
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(resultado.getInt("idCategoria"));
                categoria.setNombre(resultado.getString("nombre"));
                categoria.setRango(resultado.getString("rango"));
                categorias.add(categoria);
            }
        } catch (SQLException ex) {
            System.err.println("Error al crear statement " + ex);
        }
        liberarRecursos();
        return categorias;
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

    public static void main(String[] args) {
        if(new AlumnoDAO().update(new Alumno(3,1, 3, "Jose", "Lopez", "Lopez", "2013419933"))){
            System.out.println("Exito");
        }
        else System.err.println("Error");
    }
}
