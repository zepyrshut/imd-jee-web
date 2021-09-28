package com.arelance.dao.impl;

import com.arelance.dao.UsuarioTieneActividadDAO;
import com.arelance.domain.UsuarioTieneActividad;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Pedro
 */
@Stateless
public class UsuarioTieneActividadDAOImpl implements UsuarioTieneActividadDAO {

    @PersistenceContext(unitName = "imdPU")
    EntityManager em;

    @Override
    public void addUsuarioTieneActividad(UsuarioTieneActividad usuarioTieneActividad) {
        em.persist(usuarioTieneActividad);
    }

}
