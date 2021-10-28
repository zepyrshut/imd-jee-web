package com.arelance.dao.facade;

import com.arelance.dao.facade.local.UserFacadeLocal;
import com.arelance.domain.UserImd;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Pedro
 */
public class UserFacade extends AbstractFacade<UserImd> implements Serializable, UserFacadeLocal {

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

    @Override
    public UserImd findUserByEmail(UserImd userImd) {
        Query query = em.createNamedQuery("User.findByEmail");
        query.setParameter("email", userImd.getEmail());
        try {
            return (UserImd) query.getSingleResult();
        } catch (NoResultException e) {
            e.getMessage();
            return null;
        }
    }
}
