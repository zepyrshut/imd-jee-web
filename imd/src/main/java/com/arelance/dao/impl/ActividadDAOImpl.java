/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.dao.impl;

import com.arelance.dao.ActividadDAO;
import com.arelance.domain.Actividad;
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

    @PersistenceContext(unitName = "imdPU")
    EntityManager em;

    @Override
    public List<Actividad> listarActividades() {
        return em.createNamedQuery("Actividad.findAll").getResultList();
    }

    @Override
    public Actividad findEntrenadorByID(Actividad actividad) {
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
