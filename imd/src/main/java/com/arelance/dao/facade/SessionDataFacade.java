package com.arelance.dao.facade;

import com.arelance.dao.AbstractFacade;
import com.arelance.domain.SessionData;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Pedro
 */
public class SessionDataFacade extends AbstractFacade<SessionData> implements Serializable {

    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "imdPU")
    EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SessionDataFacade() {
        super(SessionData.class);
    }

    public SessionData logIn(SessionData sessionData) {
        Query query = em.createNamedQuery("SessionData.sessionValidate");
        query.setParameter("userImd", sessionData.getUser());
        query.setParameter("password", sessionData.getPassword());

        try {
            return (SessionData) query.getSingleResult();
        } catch (NoResultException e) {
            e.getMessage();
            return null;
        }

    }

}
