package com.arelance.dao.facade;

import com.arelance.dao.AbstractFacade;
import com.arelance.domain.UserImd;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Pedro
 */
public class UserFacade extends AbstractFacade<UserImd> implements Serializable {

    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "imdPU")
    EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(UserImd.class);
    }

}
