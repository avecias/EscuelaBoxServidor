/*
 * This java source file is generated by DAO4J v1.19
 * Generated on Thu Apr 07 13:42:43 CDT 2016
 * For more information, please contact b-i-d@163.com
 * Please check http://sourceforge.net/projects/dao4j/ for the latest version.
 */

package com.mx.ipn.app.modelo.daoimpl;

import com.mx.ipn.app.modelo.squirrel.Competidor;
import com.mx.ipn.app.modelo.squirrel.CompetidorKey;
import com.mx.ipn.app.modelo.squirrel.dao.CompetidorDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.ArrayList;

/**
 * This class provides methods to populate DB Table of Competidor
 */
public class CompetidorDAOImpl implements CompetidorDAO {
    /* SQL to insert data */
    private static final String SQL_INSERT =
        "INSERT INTO Competidor ("
        + "idCompetidor, idAlumno"
        + ") VALUES (?, ?)";

    /* SQL to select data */
    private static final String SQL_SELECT =
        "SELECT "
        + "idCompetidor, idAlumno "
        + "FROM Competidor WHERE "
        + "idCompetidor = ?";

    /* SQL to update data */
    private static final String SQL_UPDATE =
        "UPDATE Competidor SET "
        + "idAlumno = ? "
        + "WHERE "
        + "idCompetidor = ?";

    /* SQL to delete data */
    private static final String SQL_DELETE =
        "DELETE FROM Competidor WHERE "
        + "idCompetidor = ?";

    /**
     * Create a new record in Database.
     * @param bean   The Object to be inserted.
     * @param conn   JDBC Connection.
     * @exception    SQLException if something is wrong.
     */
    public void create(Competidor bean, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setInt(1, bean.getIdcompetidor());
            ps.setInt(2, bean.getIdalumno());
            ps.executeUpdate();
        }finally {
            close(ps);
        }
    }

    /**
     * Retrive a record from Database.
     * @param beanKey   The PK Object to be retrived.
     * @param conn      JDBC Connection.
     * @exception       SQLException if something is wrong.
     */
    public Competidor load(CompetidorKey key, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(SQL_SELECT);
            ps.setInt(1, key.getIdcompetidor());
            rs = ps.executeQuery();
            List results = getResults(rs);
            if (results.size() > 0)
                return (Competidor) results.get(0);
            else
                return null;
        }finally {
            close(rs);
            close(ps);
        }
    }

    /**
     * Update a record in Database.
     * @param bean   The Object to be saved.
     * @param conn   JDBC Connection.
     * @exception    SQLException if something is wrong.
     */
    public void update(Competidor bean, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setInt(1, bean.getIdalumno());
            ps.setInt(2, bean.getIdcompetidor());
            ps.executeUpdate();
        }finally {
            close(ps);
        }
    }

    /**
     * Create a new record in Database.
     * @param bean   The PK Object to be deleted.
     * @param conn   JDBC Connection.
     * @exception    SQLException if something is wrong.
     */
    public void delete(CompetidorKey key, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setInt(1, key.getIdcompetidor());
            ps.executeUpdate();
        }finally {
            close(ps);
        }
    }
    
    /**
     * Populate the ResultSet.
     * @param rs     The ResultSet.
     * @return       The Object to retrieve from DB.
     * @exception    SQLException if something is wrong.
     */
    protected List<Competidor> getResults(ResultSet rs) throws SQLException {
        List results = new ArrayList<Competidor>();
        while (rs.next()) {
            Competidor bean = new Competidor();
            bean.setIdcompetidor(rs.getInt("idCompetidor"));
            bean.setIdalumno(rs.getInt("idAlumno"));
            results.add(bean);
        }
        return results;
    }

    /**
     * Close JDBC Statement.
     * @param stmt  Statement to be closed.
     */
    protected void close(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            }catch(SQLException e){}
        }
    }

    /**
     * Close JDBC ResultSet.
     * @param rs  ResultSet to be closed.
     */
    protected void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            }catch(SQLException e){}
        }
    }
}