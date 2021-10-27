package com.arelance.dao.facade.local;

import com.arelance.domain.Activity;
import javax.ejb.Local;

/**
 *
 * @author Pedro
 */
@Local
public interface ActivityFacadeLocal {

    public void createEntity(Activity activity);

    public void updateEntity(Activity activity);

    public void deleteEntity(Activity activity);
    
    public List<Activity> readAllEntity();

    public Activity readEntity(Object id);

    public Activity refreshEntity(Activity activity);

}
