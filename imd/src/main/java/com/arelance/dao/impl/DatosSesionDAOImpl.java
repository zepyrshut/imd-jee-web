package com.arelance.dao.impl;

import com.arelance.dao.DatosSesionDAO;
import com.arelance.domain.DatosSesion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Pedro
 */
@Stateless
public class DatosSesionDAOImpl implements DatosSesionDAO {

    @PersistenceContext(unitName = "imdPU")
    EntityManager em;

    @Override
    public DatosSesion findDatosSesionByID(DatosSesion datosSesion) {
        return em.find(DatosSesion.class, datosSesion.getIdDatosSesion());
    }

    @Override
    public void addDatosSesion(DatosSesion datosSesion) {
        em.persist(datosSesion);
    }

    @Override
    public void updatePersona(DatosSesion datosSesion) {
        em.merge(datosSesion);
    }

    @Override
    public void removePersona(DatosSesion datosSesion) {
        em.merge(datosSesion);
        em.remove(datosSesion);
    }

    @Override
    public DatosSesion inicioSesion(DatosSesion datosSesion) {
        Query query = em.createNamedQuery("DatosSesion.validarSesion");
        query.setParameter("usuario", datosSesion.getUsuario());
        query.setParameter("contrasena",  datosSesion.getContrasena());
        
        
        
        try {
            return (DatosSesion) query.getSingleResult();
        } catch (NoResultException e) {
            e.getMessage();
            return null;
        }       
       
    }
    
}
