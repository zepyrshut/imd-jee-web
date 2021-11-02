package com.arelance.dao.facade;

import com.arelance.dao.SessionDataFacadeLocal;
import com.arelance.domain.SessionData;
import com.arelance.qualifiers.SessionDataFacadeQ;
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
@SessionDataFacadeQ
public class SessionDataFacade extends AbstractFacade<SessionData> implements Serializable, SessionDataFacadeLocal {

    private static final long serialVersionUID = 1L;

    public SessionDataFacade() {
        super(SessionData.class);
    }
    
    
    @PersistenceContext(unitName = "imdPU")
    EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
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

    @Override
    public SessionData findSessionDataByUser(SessionData sessionData) {
        Query query = em.createNamedQuery("SessionData.findByUser");
        query.setParameter("userImd", sessionData.getUser());
        try {
            return (SessionData) query.getSingleResult();
        } catch (NoResultException e) {
            e.getMessage();
            return null;
        }
    }

}
