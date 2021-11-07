package com.arelance.dao.facade;

import com.arelance.dao.ActivityFacadeLocal;
import com.arelance.domain.Activity;
import com.arelance.qualifiers.ActivityFacadeQ;
import java.io.Serializable;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Pedro
 */
@Stateful
@ActivityFacadeQ
public class ActivityFacade extends AbstractFacade<Activity> implements Serializable, ActivityFacadeLocal {

    private static final long serialVersionUID = 1L;

    public ActivityFacade() {
        super(Activity.class);
    }

    @PersistenceContext(unitName = "imdPU")
    EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
