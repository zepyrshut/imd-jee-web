package com.arelance.dao;

import com.arelance.domain.Activity;
import java.util.List;
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

    public Activity findById(Object id);

    public List<Activity> readAllEntities();

    public Activity refreshEntity(Activity activity);

}
