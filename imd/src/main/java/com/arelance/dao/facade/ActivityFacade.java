package com.arelance.dao.facade;

import com.arelance.dao.AbstractFacade;
import com.arelance.domain.Activity;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Pedro
 */
public class ActivityFacade extends AbstractFacade<Activity> implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "imdPU")
    EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ActivityFacade() {
        super(Activity.class);
    }
    
}
