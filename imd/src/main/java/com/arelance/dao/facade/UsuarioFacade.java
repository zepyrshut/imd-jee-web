package com.arelance.dao.facade;

import com.arelance.dao.AbstractFacade;
import com.arelance.domain.Usuario;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Pedro
 */
public class UsuarioFacade extends AbstractFacade<Usuario> implements Serializable {

    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "employeeData")
    EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

}
