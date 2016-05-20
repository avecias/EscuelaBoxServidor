/*
 * This java source file is generated by DAO4J v1.19
 * Generated on Thu Apr 07 13:42:43 CDT 2016
 * For more information, please contact b-i-d@163.com
 * Please check http://sourceforge.net/projects/dao4j/ for the latest version.
 */

package com.mx.ipn.app.modelo.daoimpl;

import com.mx.ipn.app.modelo.squirrel.Pelea;
import com.mx.ipn.app.modelo.squirrel.PeleaKey;
import com.mx.ipn.app.modelo.squirrel.dao.PeleaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.ArrayList;

/**
 * This class provides methods to populate DB Table of Pelea
 */
public class PeleaDAOImpl implements PeleaDAO {
    /* SQL to insert data */
    private static final String SQL_INSERT =
        "INSERT INTO Pelea ("
        + "idPelea, idCompetidorA, idCompetidorB"
        + ") VALUES (?, ?, ?)";

    /* SQL to select data */
    private static final String SQL_SELECT =
        "SELECT "
        + "idPelea, idCompetidorA, idCompetidorB "
        + "FROM Pelea WHERE "
        + "idPelea = ?";

    /* SQL to update data */
    private static final String SQL_UPDATE =
        "UPDATE Pelea SET "
        + "idCompetidorA = ?, idCompetidorB = ? "
        + "WHERE "
        + "idPelea = ?";

    /* SQL to delete data */
    private static final String SQL_DELETE =
        "DELETE FROM Pelea WHERE "
        + "idPelea = ?";

    /**
     * Create a new record in Database.
     * @param bean   The Object to be inserted.
     * @param conn   JDBC Connection.
     * @exception    SQLException if something is wrong.
     */
    public void create(Pelea bean, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setInt(1, bean.getIdpelea());
            ps.setInt(2, bean.getIdcompetidora());
            ps.setInt(3, bean.getIdcompetidorb());
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
    public Pelea load(PeleaKey key, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(SQL_SELECT);
            ps.setInt(1, key.getIdpelea());
            rs = ps.executeQuery();
            List results = getResults(rs);
            if (results.size() > 0)
                return (Pelea) results.get(0);
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
    public void update(Pelea bean, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setInt(1, bean.getIdcompetidora());
            ps.setInt(2, bean.getIdcompetidorb());
            ps.setInt(3, bean.getIdpelea());
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
    public void delete(PeleaKey key, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setInt(1, key.getIdpelea());
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
    protected List<Pelea> getResults(ResultSet rs) throws SQLException {
        List results = new ArrayList<Pelea>();
        while (rs.next()) {
            Pelea bean = new Pelea();
            bean.setIdpelea(rs.getInt("idPelea"));
            bean.setIdcompetidora(rs.getInt("idCompetidorA"));
            bean.setIdcompetidorb(rs.getInt("idCompetidorB"));
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