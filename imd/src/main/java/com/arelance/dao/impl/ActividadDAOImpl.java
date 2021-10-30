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
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Jorge
 */
@Stateless
public class ActividadDAOImpl implements ActividadDAO {

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

}
