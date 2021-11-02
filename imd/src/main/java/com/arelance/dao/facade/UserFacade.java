package com.arelance.dao.facade;

import com.arelance.dao.UserFacadeLocal;
import com.arelance.domain.UserImd;
import com.arelance.qualifiers.UserFacadeQ;
import java.io.Serializable;
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
@UserFacadeQ
public class UserFacade extends AbstractFacade<UserImd> implements Serializable, UserFacadeLocal {

    private static final long serialVersionUID = 1L;

    public UserFacade() {
        super(UserImd.class);
    }

    @PersistenceContext(unitName = "imdPU")
    EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
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
