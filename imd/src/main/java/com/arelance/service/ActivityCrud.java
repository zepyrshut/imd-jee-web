package com.arelance.service;

import com.arelance.dao.facade.local.ActivityFacadeLocal;
import com.arelance.domain.Activity;
import com.arelance.qualifiers.ActivityCrudQ;
import com.arelance.qualifiers.ActivityFacadeQ;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Pedro
 */
@ActivityCrudQ

public class ActivityCrud implements ActivityFacadeLocal {

    @Inject
    @ActivityFacadeQ
    private ActivityFacadeLocal facade;

    @Override
    public void createEntity(Activity activity) {
        facade.createEntity(activity);
    }

    @Override
    public void updateEntity(Activity activity) {
        facade.updateEntity(activity);
    }

    @Override
    public void deleteEntity(Activity activity) {
        facade.deleteEntity(activity);
    }

    @Override
    public Activity findById(Object id) {
        return facade.findById(id);
    }

    @Override
    public List<Activity> readAllEntities() {
        return facade.readAllEntities();
    }

    @Override
    public Activity refreshEntity(Activity activity) {
        return facade.refreshEntity(activity);
    }    

}
