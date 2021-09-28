package com.arelance.dao.impl;

import com.arelance.domain.UsuarioTieneActividad;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.arelance.dao.UsuarioTieneActividadPKDAO;
import com.arelance.domain.UsuarioTieneActividadPK;

/**
 *
 * @author Pedro
 */
@Stateless
public class UsuarioTieneActividadPKDAOImpl implements UsuarioTieneActividadPKDAO {

    @PersistenceContext(unitName = "imdPU")
    EntityManager em;

    @Override
    public void addUsuarioTieneActividadPK(UsuarioTieneActividadPK usuarioTieneActividadPK) {
        em.persist(usuarioTieneActividadPK);
    }

}
