package com.arelance.dao.impl;

import com.arelance.dao.ActividadDAO;
import com.arelance.domain.Actividad;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jorge
 */
@Stateless
public class ActividadDAOImpl implements ActividadDAO {
      String url = "jdbc:mysql://localhost/imd";
    String user = "root";
    String password = "Fullstack.2021";
    String driverClass = "com.mysql.jdbc.Driver"; 
    Connection connection;
    Statement stmt;
     private int noOfRecords;
    @PersistenceContext(unitName = "imdPU")
    EntityManager em;

    @Override
    public List<Actividad> listarActividades() {
        return em.createNamedQuery("Actividad.findAll").getResultList();
    }

    @Override
    public Actividad findActividadById(Actividad actividad) {
        return em.find(Actividad.class, actividad.getIdActividad());
    }

    @Override
    public void addActividad(Actividad actividad) {
        em.persist(actividad);
    }

    @Override
    public void updateActividad(Actividad actividad) {
        em.merge(actividad);
    }

    @Override
    public void removeActividad(Actividad actividad) {
        em.merge(actividad);
        em.remove(actividad);
    }

    @Override
    public List<Actividad> allPaginatedActivities(int offset, int noOfRecords) {
        String query = "select * from actividad LIMIT "
                + offset + ", " + noOfRecords;
        
        String paginatedQuery = "select * from actividad LIMIT "
                + offset + ", " + noOfRecords;
        List<Actividad> list = new ArrayList<>();
        Actividad actividad = null;
        try {
            connection = getConnection();
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            PreparedStatement ps = connection.prepareStatement(paginatedQuery);
            
            while (rs.next()) {
                actividad = new Actividad();
                actividad.setIdActividad(rs.getInt("id_actividad"));
                actividad.setNombreActividad(rs.getString("nombre_actividad"));
                actividad.setDescripcionActividad(rs.getString("descripcion_actividad"));
                //actividad.setDeptName(rs.getString("dept_name"));
                list.add(actividad);
            }
            rs.close();
            
            //rs = stmt.executeQuery("SELECT FOUND_ROWS()");
            if(rs.next())
                this.noOfRecords = rs.getInt(1);
       } catch (SQLException e) {
            e.printStackTrace();
        
        }finally
        {
            try {
                if(stmt != null)
                    stmt.close();
                if(connection != null)
                    connection.close();
                } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
     public int getNoOfRecords() {
        return noOfRecords;
    }

    private Connection getConnection() throws SQLException {
       Connection connection = 
            DriverManager.getConnection(url, user, password);
        return connection;
    }

}
