package com.arelance.dao.facade;

import com.arelance.dao.facade.local.TrainerFacadeLocal;
import com.arelance.domain.Trainer;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Pedro
 */
public class TrainerFacade extends AbstractFacade<Trainer> implements Serializable, TrainerFacadeLocal {

    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "imdPU")
    EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TrainerFacade() {
        super(Trainer.class);
    }

}
