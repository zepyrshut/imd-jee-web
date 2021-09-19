/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.dao.impl;

import com.arelance.dao.DatosSesionDAO;
import com.arelance.domain.DatosSesion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
        return em.find(DatosSesion.class, datosSesion.getIdUsuario());
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

}
