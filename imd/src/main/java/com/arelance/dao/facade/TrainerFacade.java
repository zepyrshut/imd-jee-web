package com.arelance.dao.facade;

import com.arelance.dao.TrainerFacadeLocal;
import com.arelance.domain.Trainer;
import java.io.Serializable;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Pedro
 */
@Stateless
public class TrainerFacade extends AbstractFacade<Trainer> implements Serializable, TrainerFacadeLocal {

    private static final long serialVersionUID = 1L;

    public TrainerFacade() {
        super(Trainer.class);
    }
    
    
    @PersistenceContext(unitName = "imdPU")
    EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
