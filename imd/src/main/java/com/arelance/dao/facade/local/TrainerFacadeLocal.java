package com.arelance.dao.facade.local;

import com.arelance.domain.Trainer;
import javax.ejb.Local;

/**
 *
 * @author
 */
@Local
public interface TrainerFacadeLocal {

    public void createEntity(Trainer trainer);

    public void updateEntity(Trainer trainer);

    public void deleteEntity(Trainer trainer);

    public Trainer readEntity(Object id);

    public Trainer refreshEntity(Trainer trainer);

}
